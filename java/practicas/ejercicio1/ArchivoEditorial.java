import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ArchivoEditorial {
    File archivo;
    FileReader lectura;
    BufferedReader buffer;
    BufferedWriter bufferW;
    BufferedReader bufferNEW;
    FileWriter escritura;
    PrintWriter impresion;

    String ruta = "editorial.csv";


    public void guardarEnCSV(Editorial editorial) {
        String guardarlibro = editorial.toString();
        try (FileWriter fw = new FileWriter(ruta, true);
            PrintWriter pw = new PrintWriter(fw)) {

            pw.println(guardarlibro); 
            System.out.println("Editorial guardada exitosamente en editorial.csv ");

        } catch (IOException e) {
            System.out.println("Error al guardar en el archivo: " + e.getMessage());
        }
    }

    public boolean ExisteEditorial(int codigoEditorial){
        ArchivoEditorial archivo =  new ArchivoEditorial();
        int tamano = archivo.contadorLineas(ruta);
        try{
            if(tamano > 0){
                CrudEditorial crudEditorial = new CrudEditorial();
                boolean existe = crudEditorial.LeerEditorialbooleano(codigoEditorial);
                if (existe==true) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("Error al verificar la existencia de la editorial: " + e.getMessage());
        }
        return false;
    }

    public Editorial ExisteEditorialBuscar(int codigoEditorial){
        ArchivoEditorial archivo =  new ArchivoEditorial();
        archivo.abrirModoLectura();
        int tamano = archivo.contadorLineas(ruta);
        archivo.cerrarModoLectura();
        try{
            if(tamano > 0){
                CrudEditorial crudEditorial = new CrudEditorial();
                Editorial editorial = crudEditorial.LeerEditorialCodigo(codigoEditorial);
                if (editorial != null) {
                    return editorial;
                }
            }
        } catch (Exception e) {
            System.out.println("Error al verificar la existencia de la editorial: " + e.getMessage());
        }
        return null;
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
        }
        catch(Exception objException)
        {
            mensaje = objException.getMessage();          
        }
        return mensaje;

    }

    public String abrirmodoEscritura(){
        String mensaje="¡El archivo se abrirá de Modo escritura!";
        try{
            archivo = new File(ruta);
            escritura= new FileWriter(archivo,true);
            impresion = new PrintWriter(escritura);
        }
        catch(Exception objException)
        {
        mensaje = objException.getMessage();          
        }
        System.out.println("mensaje método abrirModoEscritura: "+mensaje);
        return mensaje;
    }

    public String cerrarmodoEscritura(){
        String mensaje="¡El archivo en **Modo escritura** se cierra!";
        try
        {
            impresion.close();
            buffer.close();
        }
        catch(Exception objException)
        {
            mensaje = objException.getMessage();          
        }
        return mensaje;
    }
    

    public  int contadorLineas(String ruta){
        int numLineas=0;
    
        try{
            archivo = new File(ruta);
            if(archivo.isFile()== false){
            return 0;  
        }else{
            ArchivoLibros archivo = new ArchivoLibros();
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

    public String leerLinea() {
        
        String linea = null;
        try {
            linea = buffer.readLine();
        } catch (IOException e) {
            System.out.println("Error al leer la línea: " + e.getMessage());
        }
        return linea;
    }

    public boolean reescribirGuardarCSV(ManejoListas listaEditorial) {
        try(FileWriter fw = new FileWriter(this.ruta , false);
            PrintWriter bw =  new PrintWriter(fw) ){
                
                Nodo actual = listaEditorial.getStart();
                
                while(actual != null){
                    Editorial editorialGuardar = (Editorial)  actual.obtenerDato();
                    bw.println(editorialGuardar.toString());
                    actual = actual.obtenerSiguiente();
                }
            return true;
        }
        catch (Exception e) {
            System.out.println("Error al reescribir el archivo: " + e.getMessage());
        }
        return false;
    }
}
