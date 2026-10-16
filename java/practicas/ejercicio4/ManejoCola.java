public class ManejoCola {
    

    public void imprimir(Cola colaPersonas) {
        if (colaPersonas.isEmpty()) {
            System.out.println("La cola está vacía.");
            return;
        }

        Cola aux = new Cola();
        System.out.println("\n--- ELEMENTOS DE LA COLA ---");

        // Recorremos la cola sacando del frente
        while (!colaPersonas.isEmpty()) {
            Object dato = colaPersonas.pop();
            System.out.println(dato);
            aux.push(dato);
        }

        // Restauramos la cola original
        restaurar(colaPersonas, aux);
    }

    public void restaurar(Cola colaOriginal, Cola colaAuxiliar) {
        while (!colaAuxiliar.isEmpty()) {
            colaOriginal.push(colaAuxiliar.pop());
        }
    }
}
