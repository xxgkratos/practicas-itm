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

}
