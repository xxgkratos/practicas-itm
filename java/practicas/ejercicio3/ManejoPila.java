public class ManejoPila {

    public void imprimir(Pila objPila) {
        Pila aux = new Pila();

        System.out.println("--- CONTENIDO DE LA PILA ---");
        while (!objPila.isEmpty()) {
            Object dato = objPila.pop();
            System.out.println(dato); 
            aux.push(dato);
        }

        restaurar(objPila, aux);
    }


    public boolean buscar(Pila objPila, Object elementoBuscado) {
        Pila aux = new Pila();
        boolean encontrado = false;

        while (!objPila.isEmpty()) {
            Object dato = objPila.pop();
            
            if (dato.equals(elementoBuscado)) {

                encontrado = true;
            }
            aux.push(dato);
        }

        restaurar(objPila, aux);
        return encontrado;
    }

    private void restaurar(Pila pilaOriginal, Pila pilaAuxiliar) {
        while (!pilaAuxiliar.isEmpty()) {
            pilaOriginal.push(pilaAuxiliar.pop());
        }
    }

    public Object eliminarPila(Pila objPila, Object elementoBuscado) {
        Pila aux = new Pila();
        Object eliminado = null;

        while (!objPila.isEmpty()) {
            Object dato = objPila.pop(); 

            if (dato.equals(elementoBuscado)) {
                eliminado = dato; 
                System.out.println("objeto eliminado "+ eliminado);
            } else {
                aux.push(dato); 
            }
        }

        restaurar(objPila, aux); 
        
        return eliminado; 
    }
}