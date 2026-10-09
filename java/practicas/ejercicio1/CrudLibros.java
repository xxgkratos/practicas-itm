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

    public boolean DeleteLibro(String nombreLibro){


        return true;
    }
}
