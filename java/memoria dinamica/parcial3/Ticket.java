public class Ticket {
    public int idTicket;
    public int codIncidencia;
    public String estado;
    public int fech_reporte;


    public Ticket(){
        this.idTicket = 0;
        this.codIncidencia = 0;
        this.estado = "";
        this.fech_reporte = 0;
    }

    public Ticket(int idTicket, int codIncidencia, String estado, int fech_reporte){
        this.idTicket = idTicket;
        this.codIncidencia = codIncidencia;
        this.estado = estado;
        this.fech_reporte = fech_reporte;
    }

    public String toString() {
        return idTicket + "," + codIncidencia + "," + estado + "," + fech_reporte;
    }

}
