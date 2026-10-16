
public class Cola {
    private Nodo front; // Apunta al frente de la cola (por donde salen)
    private Nodo finalCola; // Apunta al final de la cola (por donde entran)

    public Cola() {
        this.front = null;
        this.finalCola = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    // 1. ENCOLAR (PUSH / ENQUEUE): Agregar un elemento al final de la cola
    public void push(Object dato) {
        Nodo nuevo = new Nodo(dato); // Creamos el nodo nuevo
        
        if (isEmpty()) {
            // Si la cola está vacía, el nuevo nodo es tanto el frente como el final
            front = nuevo;
            finalCola = nuevo;
        } else {
            // Si ya hay elementos, lo enganchamos al final y movemos el puntero finalCola
            finalCola.asignarSiguiente(nuevo);
            finalCola = nuevo;
        }
    }

    // 2. DESENCOLAR (POP / DEQUEUE): Sacar el elemento del frente
    public Object pop() {
        if (isEmpty()) {
            System.out.println("¡La cola está vacía (Subdesbordamiento)!");
            return null;
        }

        Object dato = front.obtenerDato(); // Guardamos el dato del frente
        front = front.obtenerSiguiente();         // El frente avanza al siguiente nodo

        // Si después de avanzar, front queda en null, la cola se vació por completo
        if (front == null) {
            finalCola = null;
        }

        return dato;
    }

    // 3. VER EL FRENTE (PEEK): Ver quién está primero sin sacarlo
    public Object peek() {
        return isEmpty() ? null : front.obtenerDato();
    }

    public Nodo obtenerFront(){
        return front;
    } 

    public void asignarFront(Nodo front){
        this.front = front;
    }

    public Nodo obtenerFinal(){
        return finalCola;
    }

    public void asignarFinal(Nodo finalCola){
        this.finalCola = finalCola;
    }

}
