package tienda;

public class carrito {
	
    producto[] productos;
    double[] cantidades;
    int contador;

    public carrito() {
        productos = new producto[10];
        cantidades = new double[10];
        contador = 0;
    }

    public void agregarProducto(producto producto, double cantidad) {
        if (contador < productos.length) {
            productos[contador] = producto;
            cantidades[contador] = cantidad;
            System.out.println("Agregado al carrito: " + producto.getNombre() + ", Cantidad: " + cantidad);
            contador++;
        } else {
            System.out.println("El carrito está lleno.");
        }
    }

    public void eliminarProducto(int index) {
        if (index >= 0 && index < contador) {
            System.out.println("Eliminado del carrito: " + productos[index].getNombre());
            for (int i = index; i < contador - 1; i++) {
                productos[i] = productos[i + 1];
                cantidades[i] = cantidades[i + 1];
            }
            
            contador--;
        } else {
            System.out.println("Índice no válido.");
        }
    }

    public double calcularTotal() {
        double total = 0;
        for (int i = 0; i < contador; i++) {
            total += productos[i].getPrecio() * cantidades[i];
        }
        return total;
    }
}
