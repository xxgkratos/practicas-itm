public class Nodo {
    public Object dato;
    public Nodo sigNodo;
    public Nodo antNodo;

    public Nodo(){
        this.dato = null;
        this.sigNodo = null;
        this.antNodo = null;
    }

    public Nodo(Object dato){
        this.dato = dato;
        this.sigNodo = null;
        this.antNodo = null;
    }


    public void asignarSiguiente(Nodo sigNodo){
        this.sigNodo =  sigNodo;
    }

}
