public class Pila {
    private Nodo top; // Apunta al elemento superior de la pila

    public Pila() {
        this.top = null; // Inicia vacía
    }

    public boolean isEmpty() {
        return top == null;
    }

    // Apilar: Funciona para String, Integer, Libros, Estudiantes, etc.
    public void push(Object dato) {
        Nodo nuevo = new Nodo(dato);
        nuevo.asignarSiguiente(top);
        top = nuevo;
    }

    // Desapilar: Retorna el Object genérico
    public Object pop() {
        if (isEmpty()) {
            System.out.println("¡La pila está vacía (Subdesbordamiento)!");
            return null;
        }
        Object dato = top.obtenerDato();
        top = top.obtenerSiguiente();
        return dato;
    }

    // Ver el tope sin sacarlo
    public Object peek() {
        return isEmpty() ? null : top.obtenerDato();
    }
}