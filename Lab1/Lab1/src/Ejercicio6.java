import javax.swing.JOptionPane;

public class Ejercicio6 {
public static void main(String[] args) {
String nombre = obtenerNombre("Ingrese el nombre de la candidata:");
if (nombre == null) {
return;
}

int edad = obtenerEdad("Ingrese la edad de la candidata:");
if (edad == -1) {
return;
}

double estatura = obtenerNumero("Ingrese la estatura de la candidata en metros:");
if (estatura == -1) {
return;
}

String solicitud;
if (edad >= 18 && edad <= 68 && estatura > 1.60) {
solicitud = "aceptada";
} else {
solicitud = "rechazada";
}

JOptionPane.showMessageDialog(null, String.format("Nombre: %s\nEdad: %d años\nEstatura: %.2f metros\nSolicitud: %s", nombre, edad, estatura, solicitud));
}

private static String obtenerNombre(String mensaje) {
String nombre = null;
boolean nombreValido = false;
while (!nombreValido) {
nombre = JOptionPane.showInputDialog(mensaje);
if (nombre == null) {
return null;
}
if (!nombre.matches(".\\d.")) {
nombreValido = true;
} else {
JOptionPane.showMessageDialog(null, "Error: El nombre no debe contener números.", "Error", JOptionPane.ERROR_MESSAGE);
}
}
return nombre;
}

private static int obtenerEdad(String mensaje) {
int edad = 0;
boolean edadValida = false;
while (!edadValida) {
String input = JOptionPane.showInputDialog(mensaje);
if (input == null) {
return -1;
}
try {
edad = Integer.parseInt(input);
if (edad < 18 || edad > 68) {
JOptionPane.showMessageDialog(null, "Error: Ingrese una edad válida (entre 18 y 68 años).", "Error", JOptionPane.ERROR_MESSAGE);
} else {
edadValida = true;
}
} catch (NumberFormatException e) {
JOptionPane.showMessageDialog(null, "Error: Ingrese una edad válida.", "Error", JOptionPane.ERROR_MESSAGE);
}
}
return edad;
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
}
