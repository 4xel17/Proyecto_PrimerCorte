package src.service;
import src.model.Producto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventario {
    private static Inventario instance; /*Instancia estática única de la clase lo que la hace singleton */
    private Map<Producto, Integer> stock;
    private List<String> historial; 

    private Inventario() {
        stock = new HashMap<>();
        historial = new ArrayList<>();
    }

    public static Inventario getInstance() {
        if (instance == null) {
            instance = new Inventario();
        }
        return instance;
    }

    public void agregarProducto(Producto p, int cantidad) {
        stock.put(p, stock.getOrDefault(p, 0) + cantidad);
        String evento = "Se agregaron " + cantidad + " unidades de " + p.getNombre();
        historial.add(evento);
        System.out.println(evento);
    }

    public void agregarProducto(Producto p) {
        agregarProducto(p, 1);
    }

    public void eliminarStock(Producto p, int cantidad) {
        int currentStock = stock.getOrDefault(p, 0);
        if (currentStock >= cantidad) {
            stock.put(p, currentStock - cantidad);
            String evento = "Venta realizada: " + cantidad + " unidades de " + p.getNombre();
            historial.add(evento);
            System.out.println("Stock actualizado: " + p.getNombre() + " restante: " + (currentStock - cantidad));
        } else {
            System.out.println("No hay suficiente stock de " + p.getNombre());
        }
    }

    public int consultarStock(Producto p) {
        return stock.getOrDefault(p, 0);
    }

    public Map<Producto, Integer> getStock() {
        return new HashMap<>(stock);
    }

    public List<String> getHistorial() {
        return new ArrayList<>(historial);
    }
}
