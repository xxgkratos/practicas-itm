public class ListaSimple {
    private Nodo start = null;
   private Nodo end = null;

   public ListaSimple() {
   }

   public void insertarNodoPorFinal(Object var1) {
      if (this.isEmpty()) {
         this.start = new Nodo(var1);
         this.end = this.start;
      } else {
         this.end.asignarSig(new Nodo(var1));
         this.end = this.end.obtenerSig();
      }

   }
    public boolean isEmpty() {

}
