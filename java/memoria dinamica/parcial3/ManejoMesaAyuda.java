import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class ManejoMesaAyuda {

    String ruta = "TicketsIngresados.txt";
    String rutaAuditados = "auditados.txt";

    // 1. Extracción de información a una Cola (cambiando estado "en espera" a "atendido" o "en proceso")
    public Cola extracciónInformaciónTicketsEspera() {
        Cola colaEspera = new Cola();
        
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                int id = Integer.parseInt(datos[0]);
                int codInc = Integer.parseInt(datos[1]);
                String estado = datos[2].trim();
                int fecha = Integer.parseInt(datos[3]);

                // Si está en espera, actualizamos el estado de una vez según pide el ejercicio
                if (estado.equalsIgnoreCase("en espera")) {
                    estado = "atendido"; // O "en proceso" según lo que solicite tu enunciado
                }

                Ticket t = new Ticket(id, codInc, estado, fecha);
                colaEspera.push(t); // Lo pasamos a la cola
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        
        return colaEspera;
    }

    // 2. Extracción de información de tickets atendidos que retorna una Pila
    public Pila extracciónInformaciónTicketsAtendidos() {
        Pila pilaAtendidos = new Pila();
        
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                int id = Integer.parseInt(datos[0]);
                int codInc = Integer.parseInt(datos[1]);
                String estado = datos[2].trim();
                int fecha = Integer.parseInt(datos[3]);

                // Si el estado es atendido, lo cargamos a la Pila
                if (estado.equalsIgnoreCase("atendido")) {
                    Ticket t = new Ticket(id, codInc, estado, fecha);
                    pilaAtendidos.push(t);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer los tickets atendidos: " + e.getMessage());
        }
        
        return pilaAtendidos;
    }

    // 3. AtencionTickets: Recibe la cola, atiende y actualiza el archivo TicketsIngresados.txt
    public void AtencionTickets(Cola cola) {
        // Para actualizar el archivo completo con los nuevos estados, reescribimos el archivo con lo que tiene la cola
        try (FileWriter fw = new FileWriter(ruta, false); // false para sobrescribir limpio
             PrintWriter pw = new PrintWriter(fw)) {

            while (!cola.isEmpty()) {
                Ticket t = (Ticket) cola.pop();
                pw.println(t.toString()); // Escribe el ticket con su estado ya actualizado
            }
            System.out.println("Tickets atendidos y archivo TicketsIngresados.txt actualizado.");

        } catch (IOException e) {
            System.out.println("Error al actualizar el archivo de tickets: " + e.getMessage());
        }
    }

    // 4. AuditoriaTickets: Recibe la pila, crea 'auditados.txt' y retorna una Pila con los que NO cumplen
    public Pila AuditoriaTickets(Pila pilaAtendidos) {
        Pila noCumplen = new Pila();

        // Creamos o escribimos en auditados.txt los tickets cuyo idTicket esté entre 1 y 50
        try (FileWriter fw = new FileWriter(rutaAuditados, false);
            PrintWriter pw = new PrintWriter(fw)) {

            while (!pilaAtendidos.isEmpty()) {
                Ticket t = (Ticket) pilaAtendidos.pop();

                // Condición del ejercicio: idTicket entre 1 y 50 para auditoría
                if (t.idTicket >= 1 && t.idTicket <= 50) {
                    pw.println(t.toString()); // Cumple: va al archivo auditados.txt
                } else {
                    noCumplen.push(t); // No cumple: se guarda en la pila de retorno para revisiones posteriores
                }
            }
            System.out.println("Auditoría finalizada. Archivo auditados.txt creado exitosamente.");

        } catch (IOException e) {
            System.out.println("Error al crear el archivo auditados.txt: " + e.getMessage());
        }

        return noCumplen; // Retorna la pila con los tickets que no cumplieron la condición
    }
}