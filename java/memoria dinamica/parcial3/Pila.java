public class Pila {
    private Nodo top; 

    public Pila() {
        this.top = null; 
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(Object dato) {
        Nodo nuevo = new Nodo(dato);
        nuevo.asignarSiguiente(top);
        top = nuevo;
    }

    public Object pop() {
        if (isEmpty()) {
            System.out.println("¡La pila está vacía (Subdesbordamiento)!");
            return null;
        }
        Object dato = top.obtenerDato();
        top = top.obtenerSiguiente();
        return dato;
    }

    public Object peek() {
        return isEmpty() ? null : top.obtenerDato();
    }
}