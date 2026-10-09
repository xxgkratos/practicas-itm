public class Ticket {
    private String idServicio;     // Código del ticket (Ej: A15, M05)
    private String nombreServicio; // Nombre del servicio notaríal
    private double valorServicio;  // Precio del servicio

    public Ticket(String idServicio, String nombreServicio, double valorServicio) {
        this.idServicio = idServicio;
        this.nombreServicio = nombreServicio;
        this.valorServicio = valorServicio;
    }

    public String getIdServicio() { return idServicio; }
    public String getNombreServicio() { return nombreServicio; }
    public double getValorServicio() { return valorServicio; }

    @Override
    public String toString() {
        return "Ticket: " + idServicio + " | Servicio: " + nombreServicio + " | Valor: $" + valorServicio;
    }
}