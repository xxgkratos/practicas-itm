public class Persona {
    private String id;
    private String tipoDoc;
    private String nombre;
    private Ticket ticketServicio; // Objeto Ticket asignado a la persona

    public Persona(String id, String tipoDoc, String nombre, Ticket ticketServicio) {
        this.id = id;
        this.tipoDoc = tipoDoc;
        this.nombre = nombre;
        this.ticketServicio = ticketServicio;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public Ticket getTicketServicio() { return ticketServicio; }

    @Override
    public String toString() {
        if (ticketServicio == null) {
            return "Persona: " + nombre + " (" + tipoDoc + " " + id + ") -> Sin ticket";
        }
        return "Persona: " + nombre + " (" + tipoDoc + " " + id + ") -> " + ticketServicio.toString();
    }
}
