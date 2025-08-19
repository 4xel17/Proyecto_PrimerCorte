package src.app;


import src.service.Reporte;
import src.service.Inventario;
import src.model.Artesano;
import src.model.Cliente;
import src.model.Producto;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        /*aca se edita el nombre del Artesano O del Cliente se espera que un futuro esto se haga por un login */
        Artesano artesano = new Artesano("Juan");
        Cliente cliente = new Cliente("Maria");

        boolean salir = false;
        while (!salir) {
            System.out.println("\nMenú:");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Realizar Pedido");
            System.out.println("3. Generar Reporte");
            System.out.println("4. Salir");
            System.out.print("Opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del producto: ");
                    String prodNombre = scanner.nextLine();

                    System.out.print("Cantidad a agregar: ");
                    int cantidadAgregar = scanner.nextInt();
                    scanner.nextLine(); 

                    Producto p = new Producto(prodNombre);
                    // 🔥 Nuevo método con cantidad
                    Inventario.getInstance().agregarProducto(p, cantidadAgregar);
                    System.out.println("Producto agregado por " + artesano.getNombre());
                    break;

                case 2:
                    System.out.print("Nombre del producto a pedir: ");
                    String prodPedir = scanner.nextLine();

                    System.out.print("Cantidad: ");
                    int cantidad = scanner.nextInt();
                    scanner.nextLine();

                    Producto pPedir = new Producto(prodPedir);
                    cliente.pedirProducto(pPedir, cantidad);
                    break;

                case 3:
                    new Reporte().generarReporte();
                    break;

                case 4:
                    salir = true;
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }
        scanner.close();
    }
}
