public class ManejoListas {
    private Nodo start, end;

    public ManejoListas() {
        this.start = null;
        this.end = null;
    }
    
    public Nodo  getStart(){
        return start;
    }

    public void insertarNodoPorFinal(Object info) {
        Nodo nuevo = new Nodo(info); // 1. Creamos el nodo nuevo
        
        if (isEmpty()) {
            start = nuevo; // Si está vacía, start y end apuntan al nuevo nodo
            end = nuevo;
        } else {
            end.asignarSiguiente(nuevo); // 2. El último nodo actual apunta al nuevo como SIGUIENTE
            end = nuevo;                 // 3. El nuevo pasa a ser el nuevo 'end'
        }
    }

    public void insertarNodoPorInicio(Object info) {
        if (isEmpty()) {
            Nodo start = new Nodo(info);
            end = start;
        } else {
            Nodo q = start;
            start = new Nodo(info);
            start.asignarAnt(q);
        }
    }

    public boolean isEmpty() {
        return start == null;
    }

    public void listarNodos() 
    {
        if (isEmpty()){
            System.out.println("La lista está vacía");
        }else{
            Nodo actual = start;
            while (actual != null){
                System.out.println(actual.obtenerDato());
                actual = actual.obtenerSig();
            }
        }
    }  

    public void eliminarEnd(){
    Nodo actual = start;
    Nodo aux;
    while(actual.obtenerSig() != null){
        aux = actual.obtenerSig();
        if(aux.obtenerSig() == null){
            end = actual;
            end.asignarAnt(null);
            break;
        }
        actual = actual.obtenerSig();
        }
    }       

    public void eliminarStart(){
        start = start.obtenerSig();
    }


    public boolean eliminarLibroTitulo(String nombreLibro) {
    if (isEmpty()) {
        return false; // Si está vacía, no hay nada que eliminar 📭
    }

    Nodo actual = start;
    Nodo anterior = null;

    while (actual != null) {
        Libros libro = (Libros) actual.obtenerDato(); // Casteo desde Object

        // Comparamos los títulos sin importar mayúsculas/minúsculas
        if (libro.getTitulo().equalsIgnoreCase(nombreLibro)) {
            
            // CASO A: El libro a eliminar es el PRIMERO de la lista
            if (actual == start) {
                start = start.obtenerSig(); // 'start' salta al segundo nodo
                if (start == null) { 
                    end = null; // Si era el único nodo, la lista queda vacía
                }
            } 
            // CASO B: El libro está en el MEDIO o al FINAL
            else {
                anterior.asignarSiguiente(actual.obtenerSig()); // 'anterior' se salta a 'actual'
                
                // Si eliminamos el último nodo, actualizamos 'end'
                if (actual == end) {
                    end = anterior;
                }
            }

            return true; // Libro encontrado y eliminado con éxito 🎯
        }

        // Avanzamos los dos punteros un paso hacia adelante 🚶‍♂️
        anterior = actual;
        actual = actual.obtenerSig();
    }

    return false; // No se encontró el libro en la lista
    }


    public boolean eliminarEditorialCodigo(int codigoEliminarEditorial){
        if(isEmpty()){
            return false;
        }

        Nodo actual =  start;
        Nodo anterior =  null;

        while(actual != null){
            Editorial editorial =  (Editorial) actual.obtenerDato();
        
            if (editorial.getCodigoEditorial() == codigoEliminarEditorial) {
                
                // CASO A: El libro a eliminar es el PRIMERO de la lista
                if (actual == start) {
                    start = start.obtenerSig(); // 'start' salta al segundo nodo
                    if (start == null) { 
                        end = null; // Si era el único nodo, la lista queda vacía
                    }
                } 
                // CASO B: El libro está en el MEDIO o al FINAL
                else {
                    anterior.asignarSiguiente(actual.obtenerSig()); // 'anterior' se salta a 'actual'
                    
                    // Si eliminamos el último nodo, actualizamos 'end'
                    if (actual == end) {
                        end = anterior;
                    }
                }

                return true; // Libro encontrado y eliminado con éxito 🎯
            }

            // Avanzamos los dos punteros un paso hacia adelante 🚶‍♂️
            anterior = actual;
            actual = actual.obtenerSig();
        }
        return false;
    }
}
