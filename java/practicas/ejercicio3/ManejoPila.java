public class ManejoPila {

    // Imprimir cualquier tipo de dato almacenado
    public void imprimir(Pila objPila) {
        Pila aux = new Pila();

        System.out.println("--- CONTENIDO DE LA PILA ---");
        while (!objPila.isEmpty()) {
            Object dato = objPila.pop();
            System.out.println(dato); // Imprime automáticamente llamando al toString()
            aux.push(dato);
        }

        restaurar(objPila, aux);
    }

    // Buscar cualquier objeto dentro de la pila por coincidencia directa
    public boolean buscar(Pila objPila, Object elementoBuscado) {
        Pila aux = new Pila();
        boolean encontrado = false;

        while (!objPila.isEmpty()) {
            Object dato = objPila.pop();
            
            // Usamos .equals() para comparar de forma segura cualquier objeto o número
            if (dato.equals(elementoBuscado)) {

                encontrado = true;
            }
            aux.push(dato);
        }

        restaurar(objPila, aux);
        return encontrado;
    }

    // Método auxiliar obligatorio para no perder los datos al recorrer una pila
    private void restaurar(Pila pilaOriginal, Pila pilaAuxiliar) {
        while (!pilaAuxiliar.isEmpty()) {
            pilaOriginal.push(pilaAuxiliar.pop());
        }
    }

    public Object eliminarPila(Pila objPila, Object elementoBuscado) {
        Pila aux = new Pila();
        Object eliminado = null;

        while (!objPila.isEmpty()) {
            Object dato = objPila.pop(); // Sacamos el elemento de arriba

            // Si es el elemento que queremos borrar, lo guardamos
            if (dato.equals(elementoBuscado)) {
                eliminado = dato; 
                System.out.println("objeto eliminado "+ eliminado);
            } else {
                // Si no es, lo guardamos temporalmente en la pila auxiliar
                aux.push(dato); 
            }
        }

        // Restauramos la pila original con los elementos que quedaron
        restaurar(objPila, aux); 
        
        return eliminado; // Retorna el objeto eliminado, o null si no se encontró
    }
}