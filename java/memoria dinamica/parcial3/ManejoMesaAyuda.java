import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class ManejoMesaAyuda {

    String ruta = "TicketsIngresados.txt";
    String rutaAuditados = "auditados.txt";

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

                if (estado.equalsIgnoreCase("espera")) {
                    estado = "atendido"; 
                }

                Ticket t = new Ticket(id, codInc, estado, fecha);
                colaEspera.push(t); 
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        
        return colaEspera;
    }

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

    public void AtencionTickets(Cola cola) {
        try (FileWriter fw = new FileWriter(ruta, false); 
            PrintWriter pw = new PrintWriter(fw)) {

            while (!cola.isEmpty()) {
                Ticket t = (Ticket) cola.pop();
                pw.println(t.toString()); 
            }
            System.out.println("Tickets atendidos y archivo TicketsIngresados.txt actualizado.");

        } catch (IOException e) {
            System.out.println("Error al actualizar el archivo de tickets: " + e.getMessage());
        }
    }

    public Pila AuditoriaTickets(Pila pilaAtendidos) {
        Pila noCumplen = new Pila();

        try (FileWriter fw = new FileWriter(rutaAuditados, false);
            PrintWriter pw = new PrintWriter(fw)) {

            while (!pilaAtendidos.isEmpty()) {
                Ticket t = (Ticket) pilaAtendidos.pop();

                if (t.codIncidencia >= 1 && t.codIncidencia <= 50) {
                    pw.println(t.toString()); 
                } else {
                    noCumplen.push(t); 
                }
            }
            System.out.println("Auditoría finalizada. Archivo auditados.txt creado exitosamente.");

        } catch (IOException e) {
            System.out.println("Error al crear el archivo auditados.txt: " + e.getMessage());
        }

        return noCumplen; 
    }
}