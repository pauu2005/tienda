package tienda;

import java.util.Scanner;

public class main {
 public static void main(String[] args) {
     tienda tienda = new tienda();
     carrito carrito = new carrito();
     Scanner scanner = new Scanner(System.in);
     int opcion = -1;

     while (opcion != 0) {
         System.out.println("\n--- Menú de la Tienda ---");
         System.out.println("1. Buscar producto por nombre");
         System.out.println("2. Buscar producto por origen");
         System.out.println("3. Agregar producto al carrito");
         System.out.println("4. Eliminar producto del carrito");
         System.out.println("5. Calcular total de la compra");
         System.out.println("6. Mostrar productos ordenados por precio (ascendente)");
         System.out.println("7. Mostrar productos ordenados por precio (descendente)");
         System.out.println("0. Salir");
         System.out.print("Seleccione una opción: ");
         opcion = scanner.nextInt();
         scanner.nextLine(); // Limpiar el buffer

         if (opcion == 1) {
             System.out.print("Ingrese el nombre del producto a buscar: ");
             String nombre = scanner.nextLine();
             producto[] resultadosNombre = tienda.buscarPorNombre(nombre);
             System.out.println("Resultados de búsqueda por nombre:");
             for (producto producto : resultadosNombre) {
                 if (producto != null) {
                     System.out.println(producto.obtenerInfo());
                 }
             }
         } else if (opcion == 2) {
             System.out.print("Ingrese el origen del producto a buscar: ");
             String origen = scanner.nextLine();
             producto[] resultadosOrigen = tienda.buscarPorOrigen(origen);
             System.out.println("Resultados de búsqueda por origen:");
             for (producto producto : resultadosOrigen) {
                 if (producto != null) {
                     System.out.println(producto.obtenerInfo());
                 }
             }
         } else if (opcion == 3) {
             System.out.print("Ingrese el nombre del producto a agregar al carrito: ");
             String nombreAgregar = scanner.nextLine();
             producto[] productosDisponibles = tienda.buscarPorNombre(nombreAgregar);
             if (productosDisponibles.length > 0) {
                 System.out.print("Ingrese la cantidad: ");
                 double cantidad = scanner.nextDouble();
                 carrito.agregarProducto(productosDisponibles[0], cantidad);
             } else {
                 System.out.println("Producto no encontrado.");
             }
         } else if (opcion == 4) {
             System.out.print("Ingrese el índice del producto a eliminar del carrito (0 a " + (carrito.contador - 1) + "): ");
             int index = scanner.nextInt();
             carrito.eliminarProducto(index);
         } else if (opcion == 5) {
             System.out.printf("Total de la compra: $%.2f\n", carrito.calcularTotal());
         } else if (opcion == 6) {
             System.out.println("Productos ordenados por precio (ascendente):");
             tienda.ordenarPorPrecioAscendente();
             for (producto p : tienda.productos) {
                 if (p != null) {
                     System.out.println(p.obtenerInfo());
                 }
             }
         } else if (opcion == 7) {
             System.out.println("Productos ordenados por precio (descendente):");
             tienda.ordenarPorPrecioDescendente();
             for (producto p : tienda.productos) {
                 if (p != null) {
                     System.out.println(p.obtenerInfo());
                 }
             }
         } else if (opcion == 0) {
             System.out.println("Saliendo de la tienda...");
         } else {
             System.out.println("Opción no válida. Intente de nuevo.");
         }
     }

     scanner.close();
 }
}