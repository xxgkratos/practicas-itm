import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ArchivoLibros {
    File archivo;
    FileReader lectura;
    BufferedReader buffer;
    BufferedWriter bufferW;
    BufferedReader bufferNEW;
    FileWriter escritura;
    PrintWriter impresion;

    public String ruta = "libros.csv";

    public void guardarEnCSV(Libros libro) {
        String guardarlibro = libro.toString();

        try (FileWriter fw = new FileWriter(this.ruta, true);
            PrintWriter pw = new PrintWriter(fw)) {

            pw.println(guardarlibro); 
            System.out.println("Libro guardado exitosamente en libros.csv ");

        } catch (IOException e) {
            System.out.println("Error al guardar en el archivo: " + e.getMessage());
        }
    }
    public void reescribirCSVDesdeLista(ManejoListas lista) {
    try(FileWriter fw = new FileWriter(this.ruta, false); 
        PrintWriter pw = new PrintWriter(fw)) {

        Nodo actual = lista.getStart(); 
        
        while (actual != null) {
            Libros libro = (Libros) actual.obtenerDato();
            pw.println(libro.toString()); 
            actual = actual.obtenerSiguiente();
        }
        
    } catch (IOException e) {
        System.out.println("Error al reescribir el archivo: " + e.getMessage());
    }
    }

    public boolean existeLibro(int codigo){ 
        try{
            return new CrudLibros().LeerLibroCodigo(codigo);
        }catch(Exception e){
            System.out.println("Error al verificar la existencia del libro: " + e.getMessage());
            return false;
        }
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