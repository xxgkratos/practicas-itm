import java.util.Scanner;

public class ManejoTicket {

    // Validar formato del ticket: Inicial en Mayúscula + Número entre 00 y 99 (Ej: A05, R99, M00)
    public boolean validarFormatoTicket(String ticket, char inicialServicio) {
        if (ticket == null || ticket.length() < 2 || ticket.length() > 3) {
            return false;
        }

        // Verifica que la inicial sea la correcta en mayúscula
        if (ticket.charAt(0) != inicialServicio) {
            return false;
        }

        // Verifica que la parte numérica esté entre 0 y 99
        try {
            int numero = Integer.parseInt(ticket.substring(1));
            return numero >= 0 && numero <= 99;
        } catch (NumberFormatException e) {
            return false; // No era un número válido
        }
    }

    // Verificar si el ticket ya existe en la lista para NO repetirlo
    public boolean existeTicket(ListaSimple lista, String idTicket) {
        if (lista == null || lista.isEmpty() || idTicket == null) {
            return false;
        }

        Nodo actual = lista.obtenerStart();
        while (actual != null) {
            Persona p = (Persona) actual.obtenerDato();
            if (p != null && p.getTicketServicio() != null && p.getTicketServicio().getIdServicio() != null
                    && p.getTicketServicio().getIdServicio().equalsIgnoreCase(idTicket)) {
                return true;
            }
            actual = actual.obtenerSig();
        }
        return false;
    }

    // Accion 1: Consultar la cantidad de recaudo por un servicio específico
    public double consultarRecaudoPorServicio(ListaSimple lista, String nombreServicio) {
        double recaudoTotal = 0;
        if (lista == null || lista.isEmpty() || nombreServicio == null) return 0;

        Nodo actual = lista.obtenerStart();
        while (actual != null) {
            Persona p = (Persona) actual.obtenerDato();
            if (p != null && p.getTicketServicio() != null && p.getTicketServicio().getNombreServicio() != null
                    && p.getTicketServicio().getNombreServicio().equalsIgnoreCase(nombreServicio)) {
                recaudoTotal += p.getTicketServicio().getValorServicio();
            }
            actual = actual.obtenerSig();
        }
        return recaudoTotal;
    }

    // Accion 2: Eliminar un ticket existente de la lista simple
    public boolean eliminarTicket(ListaSimple lista, String idTicket) {
        if (lista == null || lista.isEmpty() || idTicket == null) return false;

        Nodo actual = lista.obtenerStart();
        Nodo anterior = null;

        while (actual != null) {
            Persona p = (Persona) actual.obtenerDato();

            if (p != null && p.getTicketServicio() != null && p.getTicketServicio().getIdServicio() != null
                    && p.getTicketServicio().getIdServicio().equalsIgnoreCase(idTicket)) {
                if (actual == lista.obtenerStart()) {
                    lista.eliminarStart();
                    if (lista.isEmpty()) {
                        lista.asignarEnd(null);
                    }
                } else {
                    anterior.asignarSig(actual.obtenerSig());
                    if (actual == lista.obtenerEnd()) {
                        lista.asignarEnd(anterior);
                    }
                }
                return true;
            }
            anterior = actual;
            actual = actual.obtenerSig();
        }
        return false;
    }

    // Accion 3: Calcular el total recaudado por TODOS los servicios
    public double calcularTotalRecaudado(ListaSimple lista) {
        double total = 0;
        if (lista == null || lista.isEmpty()) return 0;

        Nodo actual = lista.obtenerStart();
        while (actual != null) {
            Persona p = (Persona) actual.obtenerDato();
            if (p != null && p.getTicketServicio() != null) {
                total += p.getTicketServicio().getValorServicio();
            }
            actual = actual.obtenerSig();
        }
        return total;
    }
}