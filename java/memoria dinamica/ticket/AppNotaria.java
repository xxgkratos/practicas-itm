import java.util.Scanner;

public class AppNotaria {

    public static int leerEntero(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = sc.nextLine().trim();
            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println(" Error: Debe ingresar un número entero.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaSimple listaPersonas = new ListaSimple();
        ManejoTicket manejo = new ManejoTicket();
        int opcion = 0;

        while (opcion != 5) {
            System.out.println("\n--- SISTEMA DE GESTIÓN NOTARÍA ---");
            System.out.println("1. Registrar nueva persona y ticket");
            System.out.println("2. Consultar recaudo por servicio");
            System.out.println("3. Eliminar un ticket existente");
            System.out.println("4. Calcular total recaudado general");
            System.out.println("5. Salir");
            opcion = leerEntero(sc, "Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese ID/Cédula de la persona: ");
                    String id = sc.nextLine();
                    System.out.print("Tipo de documento (CC, TI, CE, PAS): ");
                    String tipoDoc = sc.nextLine();
                    System.out.print("Nombre completo: ");
                    String nombre = sc.nextLine();

                    System.out.println("\nServicios Disponibles:");
                    System.out.println("1. Autenticaciones ($15.000) [Inicial: A]");
                    System.out.println("2. Registro Civil ($70.000) [Inicial: R]");
                    System.out.println("3. Inmuebles ($350.000) [Inicial: I]");
                    System.out.println("4. Matrimonio ($700.000) [Inicial: M]");
                    System.out.println("5. Escrituración ($150.000) [Inicial: E]");
                    System.out.println("6. Poderes ($25.000) [Inicial: P]");
                    int opcServicio = leerEntero(sc, "Seleccione el servicio (1-6): ");

                    String nombreServicio = "";
                    double valor = 0;
                    char inicial = ' ';

                    switch (opcServicio) {
                        case 1: nombreServicio = "Autenticaciones"; valor = 15000; inicial = 'A'; break;
                        case 2: nombreServicio = "Registro Civil"; valor = 70000; inicial = 'R'; break;
                        case 3: nombreServicio = "Inmuebles"; valor = 350000; inicial = 'I'; break;
                        case 4: nombreServicio = "Matrimonio"; valor = 700000; inicial = 'M'; break;
                        case 5: nombreServicio = "Escrituración"; valor = 150000; inicial = 'E'; break;
                        case 6: nombreServicio = "Poderes"; valor = 25000; inicial = 'P'; break;
                        default:
                            System.out.println(" Opción de servicio no válida.");
                            continue;
                    }

                    // Validación del Ticket
                    String idTicket = "";
                    boolean ticketValido = false;

                    while (!ticketValido) {
                        System.out.print("Ingrese el código del ticket (Ej: " + inicial + "01 a " + inicial + "99): ");
                        idTicket = sc.nextLine().trim();

                        if (!manejo.validarFormatoTicket(idTicket, inicial)) {
                            System.out.println(" Formato inválido. Debe empezar con '" + inicial + "' seguido de un número del 00 al 99.");
                        } else if (manejo.existeTicket(listaPersonas, idTicket)) {
                            System.out.println(" El ticket '" + idTicket + "' ya existe en la lista. Ingrese otro diferente.");
                        } else {
                            ticketValido = true;
                        }
                    }

                    Ticket t = new Ticket(idTicket, nombreServicio, valor);
                    Persona p = new Persona(id, tipoDoc, nombre, t);
                    listaPersonas.insertarNodoPorFinal(p); // Se agrega a la lista[cite: 3]
                    System.out.println(" Registro completado con éxito.");
                    break;

                case 2:
                    System.out.println("\nSeleccione el servicio a consultar:");
                    System.out.println("1. Autenticaciones\n2. Registro Civil\n3. Inmuebles\n4. Matrimonio\n5. Escrituración\n6. Poderes");
                    int servConsulta = leerEntero(sc, "Seleccione el servicio a consultar: ");
                    String[] servicios = {"Autenticaciones", "Registro Civil", "Inmuebles", "Matrimonio", "Escrituración", "Poderes"};
                    
                    if (servConsulta >= 1 && servConsulta <= 6) {
                        String sNom = servicios[servConsulta - 1];
                        double recaudo = manejo.consultarRecaudoPorServicio(listaPersonas, sNom);
                        System.out.println("Total recaudado por " + sNom + ": $" + recaudo);
                    } else {
                        System.out.println("Opción incorrecta.");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el código del ticket a eliminar: ");
                    String tEliminar = sc.nextLine().trim();
                    if (manejo.eliminarTicket(listaPersonas, tEliminar)) {
                        System.out.println(" Ticket " + tEliminar + " eliminado correctamente.");
                    } else {
                        System.out.println(" No se encontró ningún ticket registrado con el código: " + tEliminar);
                    }
                    break;

                case 4:
                    double totalGen = manejo.calcularTotalRecaudado(listaPersonas);
                    System.out.println("\n--- TOTAL RECAUDADO POR TODOS LOS SERVICIOS ---");
                    System.out.println("Monto total: $" + totalGen);
                    break;

                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}