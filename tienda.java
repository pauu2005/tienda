package tienda;

import java.util.Arrays;
import java.util.Comparator;

public class tienda {
 producto[] productos;

 public tienda() {
     productos = new producto[4];
     productos[0] = new producto("Maria Juana", "Mexico", 1.70);
     productos[1] = new producto("Hierba de los bosques", "Andorra", 4.20);
     productos[2] = new producto("La seta feliz", "Marrueco", 2.47);
     productos[3] = new producto("El oro verde", "Palestina", 1.33);
 }

 public producto[] buscarPorNombre(String nombre) {
     producto[] resultados = new producto[productos.length];
     int contador = 0;
     for (int i = 0; i < productos.length; i++) {
         if (productos[i].getNombre().toLowerCase().contains(nombre.toLowerCase())) {
             resultados[contador] = productos[i];
             contador++;
         }
     }
     return resultados;
 }

 public producto[] buscarPorOrigen(String origen) {
     producto[] resultados = new producto[productos.length];
     int contador = 0;
     for (int i = 0; i < productos.length; i++) {
         if (productos[i].getOrigen().toLowerCase().contains(origen.toLowerCase())) {
             resultados[contador] = productos[i];
             contador++;
         }
     }
     return resultados;
 }

 public void ordenarPorPrecioAscendente() {
     Arrays.sort(productos, Comparator.comparingDouble(producto::getPrecio));
 }

 public void ordenarPorPrecioDescendente() {
     Arrays.sort(productos, Comparator.comparingDouble(producto::getPrecio).reversed());
 }
}