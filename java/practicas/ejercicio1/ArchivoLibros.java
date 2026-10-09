import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ArchivoLibros {
    File archivo;//archivo logico
    FileReader lectura;//objeto para modo lectura del archivo
    BufferedReader buffer;//objeto que reserva un espacio en memoria donde se guarda la informacion
    BufferedWriter bufferW;
    BufferedReader bufferNEW;
    FileWriter escritura;//objeto para modo escritura del archivo
    PrintWriter impresion;//objeto para grabar directamente en el texto

    public String ruta = "libros.csv";

    // Método que recibe el objeto libro y lo guarda en el CSV
    public void guardarEnCSV(Libros libro) {
        String guardarlibro = libro.toString();

        // El 'true' dentro de FileWriter permite añadir líneas al final (append)
        try (FileWriter fw = new FileWriter(this.ruta, true);
            PrintWriter pw = new PrintWriter(fw)) {

            pw.println(guardarlibro); // Escribe la línea en el archivo
            System.out.println("Libro guardado exitosamente en libros.csv ");

        } catch (IOException e) {
            System.out.println("Error al guardar en el archivo: " + e.getMessage());
        }
    }

    public boolean existeLibro(int codigo){
        ArchivoLibros archivo = new ArchivoLibros();
        int tamano = archivo.contadorLineas(ruta);
        try{
        if(tamano > 0){

            CrudLibros crudLibros = new CrudLibros();
            boolean libroConsultado = crudLibros.LeerLibroCodigo(codigo);
            if (libroConsultado == true) {
                return true;
            }
        }else if(tamano == 0){
            return false;
        }
        }catch(Exception e){
            System.out.println("Error al verificar la existencia del libro: " + e.getMessage());
            return false;
        }
        return true;
    }

    public Libros existeLibroTitulo(String nombreLibro){
        ArchivoLibros archivo = new ArchivoLibros();
        int tamano = archivo.contadorLineas(ruta);
        try{
        if(tamano > 0){
            CrudLibros crudLibros = new CrudLibros();
            Libros libroConsultado = crudLibros.LeerLibroTitulo(nombreLibro);
            if (libroConsultado != null) {
                return libroConsultado;
            }else{
                return null;
            }
        }else if(tamano == 0){
            return null;
        }
        }catch(Exception e){
            System.out.println("Error al verificar la existencia del libro: " + e.getMessage());
            return null;
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
        // buffer.close();
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
}