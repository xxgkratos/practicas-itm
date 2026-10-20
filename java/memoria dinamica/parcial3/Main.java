import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ManejoMesaAyuda manejo = new ManejoMesaAyuda();
        String rutaArchivo = "TicketsIngresados.txt";

        while (true) {
            System.out.println("Ingrese alguna opcion. ");
            System.out.println("1. Ingresar un nuevo Ticket.");
            System.out.println("2. Ejecutar proceso de Colas, Estados y Auditoría.");
            System.out.println("3. Salir del sistema.");
            System.out.print("Seleccione una opción: ");
            
            int op = sc.nextInt();
            sc.nextLine(); 

            switch (op) {
                case 1:
                    System.out.print("Ingrese el ID del Ticket: ");
                    int idTicket = sc.nextInt();
                    
                    System.out.print("Ingrese el Código de Incidencia: ");
                    int codIncidencia = sc.nextInt();
                    sc.nextLine(); 
                
                    String estado = "espera";
                    
                    System.out.print("Ingrese la Fecha de Reporte. ");
                    int fechReporte = sc.nextInt();

                    Ticket nuevoTicket = new Ticket(idTicket, codIncidencia, estado, fechReporte);

                    try (FileWriter fw = new FileWriter(rutaArchivo, true);
                        PrintWriter pw = new PrintWriter(fw)) {
                        
                        pw.println(nuevoTicket.toString());
                        System.out.println("¡Ticket registrado exitosamente en " + rutaArchivo + "!");

                    } catch (IOException e) {
                        System.out.println("Error al guardar el ticket en el archivo: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println("\n--- EJECUTANDO PROCESAMIENTO ---");
                    
                    Cola colaEspera = manejo.extracciónInformaciónTicketsEspera();

                    manejo.AtencionTickets(colaEspera);

                    Pila pilaAtendidos = manejo.extracciónInformaciónTicketsAtendidos();

                    Pila pilaRestantes = manejo.AuditoriaTickets(pilaAtendidos);

                    System.out.println("codigo finalizado");
                    break;

                case 3:
                    System.out.println("Saliendo del sistema. ");
                    sc.close();
                    return;

                default:
                    System.out.println("Opción inválida. ");
                    break;
            }
        }
    }
}