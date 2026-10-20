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

    public Nodo(Object dato, Nodo sigNodo, Nodo antNodo){
        this.dato = dato;
        this.antNodo =  antNodo;
        this.sigNodo = sigNodo;
    }



    public void asignarSiguiente(Nodo sigNodo){
        this.sigNodo =  sigNodo;
    }

    public Nodo obtenerSig() {
        return sigNodo;
    }

    public Nodo obtenerAnt() {
        return antNodo;
    }

    public void asignarAnterior(Nodo antNodo) {
        this.antNodo = antNodo;
    }

    public Object obtenerDato() {
        return dato;
    }
    
}
