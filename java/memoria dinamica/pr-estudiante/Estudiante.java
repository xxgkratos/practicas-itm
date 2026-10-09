import java.util.Scanner;

public class Estudiante {
    private String nombre;
    private int edad;

    public Estudiante() {
        this.nombre = "";
        this.edad = 0;
    }

    public String leerDatos() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese nombre: ");
        nombre = sc.nextLine();
        System.out.print("Ingrese edad: ");
        edad = sc.nextInt();
        sc.close();
        return nombre + " - " + edad;
    }

    
}
