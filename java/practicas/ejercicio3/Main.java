import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        Pila miPila = new Pila();
        ManejoPila manejo = new ManejoPila();

        miPila.push("Hola mundo");
        miPila.push("Estructuras de datos");

        miPila.push(100);
        miPila.push(3.1416);

        manejo.imprimir(miPila);
        String buscado =  "Hola mundo";

        manejo.eliminarPila(miPila, buscado);
        manejo.imprimir(miPila);
        // Buscar un elemento
        //boolean existe = manejo.buscar(miPila, 100);
        //System.out.println("¿El 100 está en la pila? " + existe);






        sc.close();
    }
}
