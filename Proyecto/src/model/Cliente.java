package src.model;

import src.service.Inventario;


public class Cliente extends Usuario {
    public Cliente(String nombre) {
        super(nombre);
    }

    public void pedirProducto(Producto p, int cantidad) {
        if (Inventario.getInstance().consultarStock(p) >= cantidad) {
            Pedido pedido = new Pedido(p, cantidad);
            Inventario.getInstance().eliminarStock(p, cantidad);
            System.out.println(nombre + " realizó un pedido de " + p.getNombre() + " x" + cantidad);
        } else {
            System.out.println("Stock insuficiente para " + p.getNombre());
        }
    }
}