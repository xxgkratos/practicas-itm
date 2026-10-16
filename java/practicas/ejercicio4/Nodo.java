

public class Nodo {
    public Object dato;
    public Nodo ant;
    public Nodo sig;



    public Nodo(){
        this.dato = null;
        this.sig = null;
        this.ant = null;
    }

    public Nodo(Object dato){
        this.dato = dato;
        this.sig = null;
        this.ant = null;
    }

    public Nodo(Object dato, Nodo sig, Nodo ant){
        this.dato = dato;
        this.sig = sig;
        this.ant = ant;
    }

    public Object obtenerDato(){
        return dato;
    }

    public Nodo obtenerSiguiente(){
        return sig;
    }

    public void asignarDato(Object dato){
        this.dato  = dato;
    }

    public void asignarSiguiente(Nodo sig){
        this.sig= sig;
    }
}
