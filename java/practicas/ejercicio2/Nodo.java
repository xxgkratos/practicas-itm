
public class Nodo {
    public Nodo siguiente;
    public Nodo anterior;
    public Object dato;


    public Nodo(){
        this.dato = null;
        this.anterior = null;
        this.siguiente =  null;
    }

    public Nodo(Object dato){
        this.dato = dato;
        this.siguiente =  null;
        this.anterior =  null;
    }
    

    public Nodo(Object dato, Nodo sigNodo, Nodo antNodo){
        this.dato = dato;
        this.anterior =  antNodo;
        this.siguiente =  sigNodo;
    }


    public Object obtenerDato(){
        return this.dato;
    }

    public Nodo obtenerSiguiente(){
        return siguiente;
    }

    public void asignarDato(Object dato){
        this.dato =  dato;
    }

    public void  asignarSiguiente(Nodo sigDato){
        this.siguiente = sigDato;
    }

    public void asignarAnterior(Nodo antNodo){
        this.anterior =  antNodo;
    }
}
