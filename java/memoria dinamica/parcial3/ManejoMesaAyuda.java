import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class ManejoMesaAyuda {
    File archivo;
    FileReader lectura;
    BufferedReader buffer;
    BufferedWriter bufferW;
    BufferedReader bufferNEW;
    FileWriter escritura;
    PrintWriter impresion;

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
        ManejoMesaAyuda auxContador = new ManejoMesaAyuda();
        int registrosActuales = auxContador.contadorLineas(ruta);
    
        System.out.println("Registros actuales en el archivo: " + registrosActuales);

        if (registrosActuales >= 50) {
            System.out.println("El archivo ya está lleno (50 registros). No se pueden atender más tickets.");
            return; 
        }
        //lo unico que cambie del pseudo del parcial fue en como se leia las lineas para saber si ya estaba llena o no
        try (FileWriter fw = new FileWriter(ruta, true); 
            PrintWriter pw = new PrintWriter(fw)) {
            
            while (!cola.isEmpty()) {
                if (registrosActuales < 50) {
                    Ticket t = (Ticket) cola.pop();
                    pw.println(t.toString()); 
                    registrosActuales++;      
                } else {
                    System.out.println("Se alcanzó el límite de 50 registros durante el proceso.");
                    break;
                }
            }
            System.out.println("Proceso de atención finalizado. Total registros acumulados: " + registrosActuales);

        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
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


    public  int contadorLineas(String ruta){
        int numLineas=0;
    
        try{
            File ManejoMesaAyuda = new File(ruta);
            if(ManejoMesaAyuda.isFile()== false){
            return 0;  
        }else{
            ManejoMesaAyuda archivo = new ManejoMesaAyuda();
            archivo.abrirModoLectura();
            lectura = new FileReader(ruta);
            BufferedReader br = new BufferedReader(lectura);
            archivo.cerrarModoLectura();
        
            while (br.readLine()!=null){
                numLineas++;
            }
            br.close();
            return numLineas;
        }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return numLineas;
    }

    private static boolean isFile() {
        throw new UnsupportedOperationException("Unimplemented method 'isFile'");
    }

    public String leerLinea() {
        
        String linea = null;
        try {
            linea = buffer.readLine();
        } catch (IOException e) {
            System.out.println("Error al leer la línea: " + e.getMessage());
        }
        return linea;
    }

    public String abrirModoLectura(){
        String mensaje = "El archivo esta en  **Modo lectura**";
        try{
            archivo = new File(ruta);
            lectura = new FileReader(archivo);
            buffer  = new BufferedReader(lectura);
        }
        catch(Exception objException)
        {
            mensaje = objException.getMessage();          
        }
        return mensaje;
    }

    public String cerrarModoLectura(){
        String mensaje="¡El archivo en Modo lectura se cierra";
        try
        {
        lectura.close();
        // buffer.close();
        }
        catch(Exception objException)
        {
            mensaje = objException.getMessage();          
        }
        return mensaje;

    }
}