
public class Cola {
    private Nodo front; 
    private Nodo finalCola; 

    public Cola() {
        this.front = null;
        this.finalCola = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void push(Object dato) {
        Nodo nuevo = new Nodo(dato); 
        
        if (isEmpty()) {
            front = nuevo;
            finalCola = nuevo;
        } else {
            finalCola.asignarSiguiente(nuevo);
            finalCola = nuevo;
        }
    }

    public Object pop() {
        if (isEmpty()) {
            System.out.println("¡La cola está vacía (Subdesbordamiento)!");
            return null;
        }

        Object dato = front.obtenerDato(); 
        front = front.obtenerSiguiente();         

        if (front == null) {
            finalCola = null;
        }

        return dato;
    }

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
