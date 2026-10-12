public class CrudLibros {
    

    public Libros LeerLibroTitulo(String nombreLibro){
        ArchivoLibros archivoLibros = new ArchivoLibros();
        archivoLibros.abrirModoLectura();
        int numLineas = archivoLibros.contadorLineas(archivoLibros.ruta);
        Libros librosEcnontrados[] = new Libros[numLineas];
        archivoLibros.cerrarModoLectura();
        for(int i=0; i<numLineas; i++){
            String linea = archivoLibros.leerLinea();
            String[] datos = linea.split(",");
            int codigo = Integer.parseInt(datos[0]);
            String titulo = datos[1];
            int anoPublicacion = Integer.parseInt(datos[2]);
            String genero = datos[3];
            int numPaginas = Integer.parseInt(datos[4]);
            double precio = Double.parseDouble(datos[5]);
            int codEditorial = Integer.parseInt(datos[6]);
            librosEcnontrados[i] = new Libros(codigo, titulo, anoPublicacion, genero, numPaginas, precio, codEditorial);
        }

        for(int i=0; i<numLineas; i++){
            if(librosEcnontrados[i].getTitulo().equals(nombreLibro)){
                return librosEcnontrados[i];
            }
        }
        return null;
    }

    // En CrudLibros.java

    public void ListarLibros() {
        ArchivoLibros archivo = new ArchivoLibros();
        int numeroLineas = archivo.contadorLineas(archivo.ruta);

        if (numeroLineas == 0) {
            System.out.println("No hay libros registrados en el archivo CSV.");
            return;
        }

        ManejoListas lista = new ManejoListas();
        archivo.abrirModoLectura();

        for (int i = 0; i < numeroLineas; i++) {
            String linea = archivo.leerLinea();
            String[] datos = linea.split(",");
            int cod = Integer.parseInt(datos[0]);
            String titulo = datos[1];
            int anoPublicacion = Integer.parseInt(datos[2]);
            String genero = datos[3];
            int numPaginas = Integer.parseInt(datos[4]);
            double precio = Double.parseDouble(datos[5]);
            int codEditorial = Integer.parseInt(datos[6]);

            Libros libro = new Libros(cod, titulo, anoPublicacion, genero, numPaginas, precio, codEditorial);
            lista.insertarNodoPorFinal(libro);
        }
        
        archivo.cerrarModoLectura();

        // La lista se encarga de imprimir todos sus nodos
        System.out.println("\n--- LISTA DE LIBROS REGISTRADOS ---");
        lista.listarNodos(); 
    }

    public boolean LeerLibroCodigo(int codigo){
        ArchivoLibros archivoLibros = new ArchivoLibros();
        archivoLibros.abrirModoLectura();
        int numLineas = archivoLibros.contadorLineas(archivoLibros.ruta);
        Libros librosEcnontrados[] = new Libros[numLineas];
        archivoLibros.abrirModoLectura();
        for(int i=0; i<numLineas; i++){
            String linea = archivoLibros.leerLinea();
            String[] datos = linea.split(",");
            int cod = Integer.parseInt(datos[0]);
            String titulo = datos[1];
            int anoPublicacion = Integer.parseInt(datos[2]);
            String genero = datos[3];
            int numPaginas = Integer.parseInt(datos[4]);
            double precio = Double.parseDouble(datos[5]);
            int codEditorial = Integer.parseInt(datos[6]);
            librosEcnontrados[i] = new Libros(cod, titulo, anoPublicacion, genero, numPaginas, precio, codEditorial);
        }

        for(int i=0; i<numLineas; i++){
            if(librosEcnontrados[i].getCodigo() == codigo){
                return true;
            }
        }
        return false;
    }

    public void UpdateLibro(){

    }

    public String DeleteLibro(String nombreLibro){
        
        ManejoListas lista =  new ManejoListas();
        ArchivoLibros archivo =  new ArchivoLibros();
        int numeroLineas =  archivo.contadorLineas(archivo.ruta);
        archivo.abrirModoLectura();
        String mensaje =  "El libro no pudo ser eliminado ";
        if(archivo.existeLibroTitulo(nombreLibro)!= null){

            for(int i=0; i < numeroLineas ; i++){
            String linea = archivo.leerLinea();
            String[] datos = linea.split(",");
            int cod = Integer.parseInt(datos[0]);
            String titulo = datos[1];
            int anoPublicacion = Integer.parseInt(datos[2]);
            String genero = datos[3];
            int numPaginas = Integer.parseInt(datos[4]);
            double precio = Double.parseDouble(datos[5]);
            int codEditorial = Integer.parseInt(datos[6]);
            Libros libros =  new Libros(cod, titulo, anoPublicacion, genero, numPaginas, precio, codEditorial);
            lista.insertarNodoPorFinal(libros);
            }

            if(lista.eliminarLibroTitulo(nombreLibro) == true){
                archivo.reescribirCSVDesdeLista(lista);
                mensaje = "El libro fue eliminado con exito";
                return mensaje;
            }else{
                return mensaje;
            }
        }else{
            return mensaje;
        }
    }
}
