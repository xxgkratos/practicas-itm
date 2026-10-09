public class Libros {
    

    public int codigo;
    public String titulo;
    public int anoPublicacion;
    public String genero;
    public int numPaginas;
    public double precio;
    public int codEditorial;

    public void libros(){
    }

    public Libros(int codigo, String titulo, int anoPublicacion, String genero, int numPaginas, double precio, int codEditorial) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.anoPublicacion = anoPublicacion;
        this.genero = genero;
        this.numPaginas = numPaginas;
        this.precio = precio;
        this.codEditorial = codEditorial;
    }


    public void mostrarInformacion(){
        System.out.println("código: "+ this.codigo+ " título: "+ this.titulo+ " Año de publicación: "+ this.anoPublicacion+ " género: "+ this.genero+ " Número de páginas: "+ this.numPaginas+ " Precio: "+ this.precio+ " Código de editorial: "+ this.codEditorial);
    }

    public String toString() {
        return "" + codigo + "," + titulo + "," + anoPublicacion + "," + genero + "," + numPaginas + "," + precio + "," + codEditorial;
    }

    public String getTitulo(){
        return titulo;
    }

    public int getCodigo(){
        return codigo;
    }
}
