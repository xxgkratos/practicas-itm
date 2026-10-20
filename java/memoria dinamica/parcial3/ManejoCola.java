public class ManejoCola {
    

    public void imprimir(Cola colaPersonas) {
        if (colaPersonas.isEmpty()) {
            System.out.println("La cola está vacía.");
            return;
        }

        Cola aux = new Cola();
        System.out.println("\n--- ELEMENTOS DE LA COLA ---");

        while (!colaPersonas.isEmpty()) {
            Object dato = colaPersonas.pop();
            System.out.println(dato);
            aux.push(dato);
        }
        restaurar(colaPersonas, aux);
    }

    public void restaurar(Cola colaOriginal, Cola colaAuxiliar) {
        while (!colaAuxiliar.isEmpty()) {
            colaOriginal.push(colaAuxiliar.pop());
        }
    }
}
