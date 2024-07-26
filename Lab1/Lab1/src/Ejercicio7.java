import javax.swing.JOptionPane;

public class Ejercicio7 {
public static void main(String[] args) {
int libras = obtenerEntero("Ingrese la cantidad de libras:");
if (libras == -1) {
return;
}

int onzas = obtenerEntero("Ingrese la cantidad de onzas:");
if (onzas == -1) {
return;
}

int totalOnzas = libras * 16 + onzas;

JOptionPane.showMessageDialog(null, String.format("%d libras y %d onzas son %d onzas en total.", libras, onzas, totalOnzas));
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
if (numero < 0) {
JOptionPane.showMessageDialog(null, "Error: Ingrese un número positivo.", "Error", JOptionPane.ERROR_MESSAGE);
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
