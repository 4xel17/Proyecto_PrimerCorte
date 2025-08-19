package src.service;

import src.model.Producto;

import java.time.LocalDateTime;
import java.util.Map;

public class Reporte {
    public void generarReporte() {
        Inventario inv = Inventario.getInstance();

        System.out.println("\n===== REPORTE GENERAL =====");
        System.out.println("Generado el: " + LocalDateTime.now());

        System.out.println("\n Stock actual:");
        for (Map.Entry<Producto, Integer> entry : inv.getStock().entrySet()) {
            System.out.println("- " + entry.getKey().getNombre() + ": " + entry.getValue() + " unidades");
        }

        System.out.println("\n Historial de movimientos:");
        for (String evento : inv.getHistorial()) {
            System.out.println("- " + evento);
        }

        System.out.println("============================\n");
    }
}
