import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Cola colaPersonas =  new Cola();
        ManejoCola manejo = new ManejoCola();
        while(true){
            System.out.println("1. Ingresar nombres 2. imprimir 3. eliminar primero 4. salir");
            int opciones = sc.nextInt();
            sc.nextLine();
            switch(opciones){
                case 1:
                    String nombre= sc.nextLine();
                    colaPersonas.push(nombre);
                    continue;
                case 2:
                    manejo.imprimir(colaPersonas);
                    continue;
                case 3:
                    colaPersonas.pop();
                    manejo.imprimir(colaPersonas);
                    continue;
                case 4:
                    return;

                default:
                    System.out.println("Ingresaste una opcion invalida.");
                    break;
                
            }
            sc.close();
        }
        
        
    }
}
