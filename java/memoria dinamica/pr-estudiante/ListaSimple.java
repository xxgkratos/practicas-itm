public class ListaSimple 
{
  private Nodo start, end;

    public ListaSimple() {
        this.start = null;
        this.end = null;
    }

    public void insertarNodoPorFinal(Object info) {
        if (isEmpty()) {
            start = new Nodo(info);
            end = start;
        } else {
            end.asignarSig(new Nodo(info));
            end = end.obtenerSig();
        }
    }

    public void insertarNodoPorInicio(Object info) {
        if (isEmpty()) {
            start = new Nodo(info);
            end = start;
        } else {
            Nodo q = start;
            start = new Nodo(info);
            start.asignarSig(q);
        }
    }

    public boolean isEmpty() {
        return start == null;
    }

    public void listarNodos() 
    {
        if (isEmpty()) 
        {
            System.out.println("La lista está vacía");
        } else 
            {
              Nodo actual = start;
              while (actual != null) 
              {
                System.out.println(actual.obtenerDato());
                actual = actual.obtenerSig();
              }
            }
    }  

   public void eliminarEnd()
   {
    Nodo actual = start;
    Nodo aux;
    while(actual.obtenerSig() != null)
     {
      aux = actual.obtenerSig();
      if(aux.obtenerSig() == null)
        {
          end = actual;
          end.asignarSig(null);
          break;
        }
      actual = actual.obtenerSig();
     }
   }       
   
   public void eliminarStart()
   {
    start = start.obtenerSig();
   }
    
}