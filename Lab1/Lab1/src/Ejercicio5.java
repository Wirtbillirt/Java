import javax.swing.JOptionPane;

public class Ejercicio5 {
public static void main(String[] args) {
double precioDocena = obtenerNumero("Ingrese el precio por docena de naranjas:");
if (precioDocena == -1) {
return;
}

int cantidadDocenas;
do {
cantidadDocenas = obtenerEntero("Ingrese la cantidad de docenas a comprar:");
if (cantidadDocenas == -1) {
return;
}
} while (cantidadDocenas <= 0);

double montoCompra = precioDocena * cantidadDocenas;
double descuento;
if (cantidadDocenas > 3) {
descuento = 0.15 * montoCompra;
} else {
descuento = 0.10 * montoCompra;
}
double montoPagar = montoCompra - descuento;

JOptionPane.showMessageDialog(null, String.format("Precio de las naranjas (doc.): C$ %.2f\nCantidad de docenas a comprar: %d\nMonto de la compra = C$ %.2f\nDescuento= C$ %.2f\nMonto a pagar=C$ %.2f", precioDocena, cantidadDocenas, montoCompra, descuento, montoPagar));
}

private static double obtenerNumero(String mensaje) {
double numero = 0;
boolean numeroValido = false;
while (!numeroValido) {
String input = JOptionPane.showInputDialog(mensaje);
if (input == null) {
return -1;
}
try {
numero = Double.parseDouble(input);
if (numero <= 0) {
JOptionPane.showMessageDialog(null, "Error: Ingrese un número positivo mayor a cero.", "Error", JOptionPane.ERROR_MESSAGE);
} else {
numeroValido = true;
}
} catch (NumberFormatException e) {
JOptionPane.showMessageDialog(null, "Error: Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
}
}
return numero;
}

private static int obtenerEntero(String mensaje) {
int numero = 0;
boolean numeroValido = false;
while (!numeroValido) {
String input = JOptionPane.showInputDialog(mensaje);
if (input == null) {
return -1;
}
try {
numero = Integer.parseInt(input);
if (numero <= 0) {
JOptionPane.showMessageDialog(null, "Error: Ingrese un número positivo mayor a cero.", "Error", JOptionPane.ERROR_MESSAGE);
} else {
numeroValido = true;
}
} catch (NumberFormatException e) {
JOptionPane.showMessageDialog(null, "Error: Ingrese un número entero válido.", "Error", JOptionPane.ERROR_MESSAGE);
}
}
return numero;
}
}

