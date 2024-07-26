import javax.swing.JOptionPane;

public class Ejercicio2 {

public static void main(String[] args) {
float km = obtenerNumero("Ingrese la cantidad de kilómetros que desea convertir:");

if (km == -1) {
JOptionPane.showMessageDialog(null, "Operación cancelada");
return;
}

float m = km * 1000;
float cm = km * 100000;

JOptionPane.showMessageDialog(null, "El equivalente de " + km + " kilómetros en metros es: " + m + "\n"
+ "El equivalente de " + km + " kilómetros en centímetros es: " + cm);
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

