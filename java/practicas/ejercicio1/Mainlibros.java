import java.util.Scanner;

public class Mainlibros {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido al sistema de libros.");
        while(true){
            ManejoErrores manjErrores =  new ManejoErrores();
            System.out.println("Aqui puede ingresar la opcion que desea realizar: ");
            System.out.println("1. Opciones de libros \n2. Opciones de editoriales \n3. Salir.");
            int opcion = manjErrores.leerEntero();
            switch(opcion){
                case 1:
                    // Implementar lógica para opciones de libros
                    System.out.println("Opciones de libros seleccionadas.");
                    System.out.println("1. Ingresar libro. ");
                    System.out.println("2. Buscar libro. ");
                    System.out.println("3. Eliminar libro. ");
                    System.out.println("4. Modificar libro. ");
                    System.out.println("5. Salir. ");
                    int op = manjErrores.leerEntero();
                    switch (op) {
                        case 1:
                            LectorLibros lector = new LectorLibros();
                            Libros libro = lector.pedirLibro();
                            libro.mostrarInformacion();
                            ArchivoLibros archivo = new ArchivoLibros();
                            archivo.guardarEnCSV(libro);
                            continue;

                        case 2:
                            System.out.println("Ingrese el nombre del libro que desea consultar: ");
                            String nombreLibro = manjErrores.leerTexto();
                            ArchivoLibros archivoLibros = new ArchivoLibros();
                            Libros existe = archivoLibros.existeLibroTitulo(nombreLibro); 
                            if (existe != null) {
                                existe.mostrarInformacion();
                            } else {
                                System.out.println("Aun no existen libros en el sistema."); 
                            }
                            continue;
                        
                        case 3:
                            System.out.println("Ingrese el nombre del libro que quiere eliminar. ");
                            String nombre_titulo =  manjErrores.leerTexto();
                            CrudLibros crudLibros =  new CrudLibros();

                            if(crudLibros.DeleteLibro(nombre_titulo) != null){
                                
                            }

                            continue;
                        default:
                            System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                            continue;
                        }

                case 2:
                    // Implementar lógica para opciones de editoriales
                    System.out.println("Opciones de editoriales seleccionadas.");
                    System.out.println("1. Ingresar Editorial. ");
                    System.out.println("2. Buscar Editorial. ");
                    System.out.println("3. Eliminar Editorial. ");
                    System.out.println("4. Modificar Editorial. ");
                    System.out.println("5. Salir. ");
                    int op2 =  manjErrores.leerEntero();
                    switch (op2) {
                        case 1:
                            LeerEditorial lectorEditorial = new LeerEditorial();
                            Editorial editorial = lectorEditorial.pedirEditorial();
                            editorial.mostrarInformacion();
                            ArchivoEditorial archivoEditorial = new ArchivoEditorial();
                            archivoEditorial.guardarEnCSV(editorial);
                            
                            continue;
                        case 2: 
                            // Implementar lógica para consultar editorial
                            System.out.println("Ingrese el código de la editorial que desea consultar: ");
                            int codigoEditorial = sc.nextInt();
                            ArchivoEditorial archivoEditorialConsulta = new ArchivoEditorial();
                            Editorial existeEditorial = archivoEditorialConsulta.ExisteEditorialBuscar(codigoEditorial);
                            if (existeEditorial != null) {
                                existeEditorial.mostrarInformacion();
                            } else {
                                System.out.println("Aun no existen editoriales en el sistema."); 
                            }
                            continue;

                        default:
                            System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                            continue;
                    }
                case 3:
                    System.out.println("Saliendo del sistema, gracias por usarlo.");
                    sc.close();
                    return; 
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        }
    }
}

class LectorLibros{
    ManejoErrores manjErrores = new ManejoErrores();
    public Libros pedirLibro() {
        ArchivoLibros archivo = new ArchivoLibros();
        int codigo = 0;
        boolean manejocodigo = false; 

        while (!manejocodigo) {
            System.out.println("Ingrese el código del libro: ");
            codigo = manjErrores.leerEntero();

            if (archivo.existeLibro(codigo) == false) {
                manejocodigo = true; 
            } else {
                System.out.println("El libro con código " + codigo + " ya existe en el sistema.");
            }
        }

        System.out.println("Ingrese el título del libro: ");
        String titulo = manjErrores.leerTexto();

        System.out.println("Ingrese el año de publicación del libro: ");
        int anoPublicacion = manjErrores.leerEntero();

        System.out.println("Ingrese el género del libro: ");
        String genero = manjErrores.leerTexto();

        System.out.println("Ingrese el número de páginas del libro: ");
        int numPaginas = manjErrores.leerEntero();

        System.out.println("Ingrese el precio del libro: ");
        double precio = manjErrores.leerDouble();

        System.out.println("Ingrese el código de la editorial del libro: ");
        int codEditorial = manjErrores.leerEntero();

        
        return new Libros(codigo, titulo, anoPublicacion, genero, numPaginas, precio, codEditorial);
    }
}

class LeerEditorial{

    public Editorial pedirEditorial(){
        int codigoEditorial = 0;
        boolean manejocodigo = false;

        while(!manejocodigo){
            System.out.println("Ingrese el código de la editorial: ");
            ManejoErrores manjErrores = new ManejoErrores();
            codigoEditorial = manjErrores.leerEntero();
            ArchivoEditorial archivo =  new ArchivoEditorial();
            if(archivo.ExisteEditorial(codigoEditorial) == false){
                manejocodigo = true;
            }else{
                System.out.println("La editorial con código " + codigoEditorial + " ya existe en el sistema.");
            }
        }

        ManejoErrores manjErrores = new ManejoErrores();
        System.out.println("Ingrese el nombre de la editorial: ");
        String nombreEditorial = manjErrores.leerTexto();
        return new Editorial(codigoEditorial, nombreEditorial);
        
    }
}

class ManejoErrores{
    private Scanner sc = new Scanner(System.in);

    public int leerEntero() {
        int numero = 0;
        boolean valido = false;
        while (!valido) {
            try {
                numero = sc.nextInt();
                sc.nextLine(); 
                valido = true;
            } catch (Exception e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                sc.nextLine(); 
            }
        }
        return numero;
    }

    public double leerDouble() {
        double numero = 0.0;
        boolean valido = false;
        while (!valido) {
            try {
                numero = sc.nextDouble();
                sc.nextLine(); 
                valido = true;
            } catch (Exception e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número decimal válido.");
                sc.nextLine(); 
            }
        }
        return numero;
    }

    public String leerTexto() {
        String texto = "";
        while (texto.trim().isEmpty()) {
            texto = sc.nextLine();
            if (texto.trim().isEmpty()) {
                System.out.println("El texto no puede estar vacío.");
            }
        }
        return texto;
    }
}