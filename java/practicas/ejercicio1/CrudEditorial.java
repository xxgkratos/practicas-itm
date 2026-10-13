public class CrudEditorial {
    
    public Editorial LeerEditorialCodigo(int codigoEditorial){
        ArchivoEditorial archivo =  new ArchivoEditorial();
        int numLineas = archivo.contadorLineas(archivo.ruta);
        Editorial editorialesEncontradas[] = new Editorial[numLineas];
        archivo.abrirModoLectura();
        for(int i=0 ; i < numLineas; i++){
            String linea = archivo.leerLinea();
            String[] datos = linea.split(",");
            int cod = Integer.parseInt(datos[0]);
            String nombre = datos[1];
            editorialesEncontradas[i] = new Editorial(cod, nombre);
        }
        archivo.cerrarModoLectura();
        for(int i=0; i<numLineas; i++){
            if(editorialesEncontradas[i].getCodigoEditorial() == codigoEditorial){
                return editorialesEncontradas[i];
            }
        }
        return null;
    }

    public boolean LeerEditorialbooleano(int codigoEditorial){
        ArchivoEditorial archivo =  new ArchivoEditorial();
        int numLineas = archivo.contadorLineas(archivo.ruta);
        Editorial editorialesEncontradas[] = new Editorial[numLineas];
        archivo.abrirModoLectura();
        for(int i=0 ; i < numLineas; i++){
            String linea = archivo.leerLinea();
            String[] datos = linea.split(",");
            int cod = Integer.parseInt(datos[0]);
            String nombre = datos[1];
            editorialesEncontradas[i] = new Editorial(cod, nombre);
        }
        archivo.cerrarModoLectura();
        for(int i=0; i<numLineas; i++){
            if(editorialesEncontradas[i].getCodigoEditorial() == codigoEditorial){
                return true;
            }
        }
        return false;
    }


    public boolean eliminarEditorialCodigo(int codigoEditorialBuscar){

        ArchivoEditorial archivoEditorial =  new ArchivoEditorial();
        archivoEditorial.abrirModoLectura();
        if(archivoEditorial.ExisteEditorial(codigoEditorialBuscar) == true){
            int numeroLineas = archivoEditorial.contadorLineas(archivoEditorial.ruta);
            archivoEditorial.abrirModoLectura();
            Editorial editorial =  new Editorial();
            ManejoListas listaEditorial =  new ManejoListas();
            for(int i = 0; i < numeroLineas ; i++){
                String lineaEditorial = archivoEditorial.leerLinea();
                String [] datos = lineaEditorial.split(",");
                int codigoEditorial =  Integer.parseInt(datos[0]);
                String nombreEditorial =  datos[1];
                editorial =  new Editorial(codigoEditorial,nombreEditorial);
                listaEditorial.insertarNodoPorFinal(editorial);
            }

            if(listaEditorial.eliminarEditorialCodigo(codigoEditorialBuscar) == true){
                archivoEditorial.reescribirGuardarCSV(listaEditorial);
                return true;

            }else{
                return false;
            }
        }
        archivoEditorial.cerrarModoLectura();
        return false;
    }

    public void ListarEditorial(){
        ArchivoEditorial archivo = new ArchivoEditorial();
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

            Editorial editorial = new Editorial(cod, titulo);
            lista.insertarNodoPorFinal(editorial);
        }
        
        archivo.cerrarModoLectura();

        // La lista se encarga de imprimir todos sus nodos
        System.out.println("\n--- LISTA DE LIBROS REGISTRADOS ---");
        lista.listarNodos();
    }
}
