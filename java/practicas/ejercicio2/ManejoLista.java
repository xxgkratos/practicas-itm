public class ManejoLista {
    private Nodo start, end;

    public  ManejoLista(){
        this.start =  null;
        this.end =  null;
    }

    public void insertarFinal(Object info){
        if(isEmpty()){
            start = new Nodo(info);
            end = start;
        }else{
            end.asignarSiguiente(new Nodo(info));
            end = end.obtenerSiguiente();
        }
    }

    public void insertarPrincipio(Object info){
        if(isEmpty()){
            end  = new Nodo(info);
            start = end;
        }else{
            Nodo auxiliar =  start;
            start =  new Nodo(info);
            start.asignarSiguiente(auxiliar);
        }
    }

    public boolean isEmpty(){
        return start == null;
    }


    public void listarNodos(){
        if(isEmpty()){
            System.out.println("La lista esta vacia");
        }else{
            Nodo actual =  start;

            while(actual!= null){
                System.out.println(actual.obtenerDato());

                actual  = actual.obtenerSiguiente();
            }
        }
    }

    public void eliminarFinal() {
        if (isEmpty()) {
            System.out.println("La lista está vacía.");
            return;
        }

        // CASO 1: Solo hay un nodo en la lista
        if (start == end) { // o start.obtenerSiguiente() == null
            start = null;
            end = null;
            System.out.println("Objeto eliminado. La lista quedó vacía.");
            return;
        }

        // CASO 2: Hay dos o más nodos
        Nodo actual = start;

        // Avanzamos hasta parar en el PENÚLTIMO nodo
        while (actual.obtenerSiguiente() != end) { 
            actual = actual.obtenerSiguiente();
        }

        // El penúltimo nodo ahora pasa a ser el final ('end')
        end = actual;
        end.asignarSiguiente(null); // Desenganchamos el último nodo
        System.out.println("Objeto eliminado del final.");
    }

    public void eliminarTop(){
        
        if(isEmpty()){
        System.out.println("La lista está vacía.");
        return;
        }
    
        start = start.obtenerSiguiente(); // Avanzamos el start al siguiente nodo

    // Si después de avanzar, start queda en null, significa que era el único elemento
        if(start == null) {
            end = null; // Actualizamos end para que la lista quede totalmente limpia
        }
    
        System.out.println("Elemento eliminado del top.");

    }
}
