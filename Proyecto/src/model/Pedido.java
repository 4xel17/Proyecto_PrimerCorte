package src.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pedido {
    private Producto producto;
    private int cantidad;
    private String fecha;
    private String estado;

    public Pedido(Producto p, int cantidad) {
        this.producto = p;
        this.cantidad = cantidad;
        // esto hace que la fehca se haga automatica 
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        this.fecha = LocalDateTime.now().format(formatter);
        this.estado = "pendiente";
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getFecha() {
        return fecha;
    }

    public String getEstado() {
        return estado;
    }
}
