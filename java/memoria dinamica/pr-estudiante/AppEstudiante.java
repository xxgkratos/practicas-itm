import java.util.Scanner;

public class AppEstudiante 
{

    public static void main(String[] args) 
    {
       
      Scanner sc = new Scanner(System.in);
      Estudiante e = new Estudiante();
      ListaSimple lista = new ListaSimple();
      while(true)
      {
       lista.insertarNodoPorInicio(e.leerDatos());
       System.out.println("Desea ingresar otro elemento a la lista: 1-Si 2-No");
       int op = sc.nextInt();
        if(op == 2)
        {
          break;
        }
      }   
      
      lista.listarNodos();
      sc.close();
    }
    
}