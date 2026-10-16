import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        ManejoLista listasimple = new ManejoLista();

        while(true){

            System.out.println("1. ingresar dato, 2 listar datos,3 eliminar final ,4 salir. ");
            int op = sc.nextInt();

            switch(op){
                case 1:

                    System.out.println("Ingrese un dato numerico el cual quiera almacenar");
                    
                    int numero = sc.nextInt();

                    listasimple.insertarPrincipio(numero);

                    continue;
                case 2:
                    listasimple.listarNodos();
                    continue;
                
                case 3:
                    listasimple.eliminarFinal();
                    continue;
                case 4:
                    return;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
            sc.close();
        }
    }
}
