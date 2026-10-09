// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
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

   public void insertarNodoPorInicio(Object var1) {
      if (this.isEmpty()) {
         this.start = new Nodo(var1);
         this.end = this.start;
      } else {
         Nodo var2 = this.start;
         this.start = new Nodo(var1);
         this.start.asignarSig(var2);
      }

   }

   public boolean isEmpty() {
      return this.start == null;
   }

   public void listarNodos() {
      if (this.isEmpty()) {
         System.out.println("La lista está vacía");
      } else {
         for(Nodo var1 = this.start; var1 != null; var1 = var1.obtenerSig()) {
            System.out.println(var1.obtenerDato());
         }
      }

   }

   public void eliminarEnd() {
      if (this.isEmpty()) {
         return;
      }
      if (this.start == this.end) {
         this.start = null;
         this.end = null;
         return;
      }
      Nodo actual = this.start;
      while (actual.obtenerSig() != this.end) {
         actual = actual.obtenerSig();
      }
      actual.asignarSig(null);
      this.end = actual;
   }

   public void eliminarStart() {
      if (this.isEmpty()) {
         return;
      }
      this.start = this.start.obtenerSig();
      if (this.start == null) {
         this.end = null;
      }
   }
   public Nodo obtenerStart() {
    return start;
}

public Nodo obtenerEnd() {
    return end;
}

public void asignarEnd(Nodo end) {
    this.end = end;
}
}
