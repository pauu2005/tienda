package tienda;

public class producto {
 String nombre;
 String origen;
 double precio;

 public producto(String nombreParam, String origenParam, double precioParam) {
     nombre = nombreParam;
     origen = origenParam;
     precio = precioParam;
 }

 public String getNombre() {
     return nombre;
 }

 public String getOrigen() {
     return origen;
 }

 public double getPrecio() {
     return precio;
 }

 public String obtenerInfo() {
     return nombre + " (Origen: " + origen + ", Precio: $" + precio + ")";
 }
}