import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import java.lang.Math;

public class Ejercicio3 {

public static void main(String[] args) {

float r = obtenerNumero("Ingrese el radio del cilindro:");
if (r == -1) {
JOptionPane.showMessageDialog(null, "Operación cancelada");
return;
}

float h = obtenerNumero("Ingrese la altura del cilindro:");
if (h == -1) {
JOptionPane.showMessageDialog(null, "Operación cancelada");
return;
}

DecimalFormat f = new DecimalFormat("0.000");

float al = (float) (2 * Math.PI * r * h);
float ab = (float) (Math.PI * r * r);
float at = (float) (2 * ab + al);

JOptionPane.showMessageDialog(null, "El área lateral del cilindro es: " + f.format(al) + "\nEl área total del cilindro es: " + f.format(at) + "\nEl área base del cilindro es: " + f.format(ab));

}

private static float obtenerNumero(String mensaje) {
float numero = 0;
boolean numeroValido = false;
while (!numeroValido) {
String input = JOptionPane.showInputDialog(mensaje);
if (input == null) {
return -1;
}
try {
numero = Float.parseFloat(input);
numeroValido = true;
} catch (NumberFormatException e) {
JOptionPane.showMessageDialog(null, "Error: Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
}
}
return numero;
}

}
