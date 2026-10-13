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

            if(archivoEditorial.eliminarGuardarCSV(listaEditorial)== true){
                return true;
            }else{
                return false;
            }

        }

        return false;
    }
}
