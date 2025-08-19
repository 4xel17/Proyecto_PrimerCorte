package src.model;

import src.service.Inventario;


public class Artesano extends Usuario {
    public Artesano(String nombre) {
        super(nombre);
    }

    public void agregarProducto(Producto p) {
        Inventario.getInstance().agregarProducto(p);
        System.out.println("Producto agregado por " + nombre + ": " + p.getNombre());
    }
}