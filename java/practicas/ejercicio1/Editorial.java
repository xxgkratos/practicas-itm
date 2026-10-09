class Editorial {
    public int codigoEditorial;
    public String nombreEditorial;

    public Editorial() {
    }

    public Editorial(int codigoEditorial, String nombreEditorial){
        this.codigoEditorial = codigoEditorial;
        this.nombreEditorial = nombreEditorial;
    }

    public void mostrarInformacion(){
        System.out.println("El codigo de la editorial es: "+ this.codigoEditorial+ " y nombre de la editorial es: "+ this.nombreEditorial);
    }

    public String toString() {
        return "" + codigoEditorial + "," + nombreEditorial ;
    }

    public int getCodigoEditorial(){
        return codigoEditorial;
    }
}
