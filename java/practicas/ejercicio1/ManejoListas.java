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
        Nodo nuevo = new Nodo(info); 
        
        if (isEmpty()) {
            start = nuevo; 
            end = nuevo;
        } else {
            end.asignarSiguiente(nuevo); 
            end = nuevo;                 
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
        return false; 
    }

    Nodo actual = start;
    Nodo anterior = null;

    while (actual != null) {
        Libros libro = (Libros) actual.obtenerDato(); 

        if (libro.getTitulo().equalsIgnoreCase(nombreLibro)) {
            
            if (actual == start) {
                start = start.obtenerSig(); 
                if (start == null) { 
                    end = null; 
                }
            } 
            else {
                anterior.asignarSiguiente(actual.obtenerSig()); 

                if (actual == end) {
                    end = anterior;
                }
            }

            return true; 
        }

        anterior = actual;
        actual = actual.obtenerSig();
    }

    return false; 
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
                
                if (actual == start) {
                    start = start.obtenerSig(); 
                    if (start == null) { 
                        end = null; 
                    }
                } 

                else {
                    anterior.asignarSiguiente(actual.obtenerSig()); 
                
                    if (actual == end) {
                        end = anterior;
                    }
                }

                return true; 
            }

            anterior = actual;
            actual = actual.obtenerSig();
        }
        return false;
    }
}
