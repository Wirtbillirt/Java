import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Ejercicio2 {

public static void main(String[] args) {
int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de profesores:"));

String[] nombres = new String[n];
char[] sexos = new char[n];
int[] edades = new int[n];

JTextArea imp = new JTextArea();
imp.append(String.format("%-20s %-10s %-5s\n", "Nombre", "Sexo", "Edad"));

for (int i = 0; i < n; i++) {
nombres[i] = JOptionPane.showInputDialog("Profesor " + (i + 1) + ": Ingrese el nombre:");
sexos[i] = JOptionPane.showInputDialog("Profesor " + (i + 1) + ": Ingrese el sexo (M/F):").toUpperCase().charAt(0);
edades[i] = Integer.parseInt(JOptionPane.showInputDialog("Profesor " + (i + 1) + ": Ingrese la edad:"));

imp.append(String.format("%-20s %-10s %-5d\n", nombres[i], sexos[i], edades[i]));
}

String resultado = realizarOperaciones(nombres, sexos, edades, n);

JOptionPane.showMessageDialog(null, imp.getText() + "\n" + resultado, "Resultados de la Encuesta", JOptionPane.PLAIN_MESSAGE);
}

public static String realizarOperaciones(String[] nombres, char[] sexos, int[] edades, int n) {

double sumaEdades = 0;
for (int edad : edades) {
sumaEdades += edad;
}
double edadPromedio;
if (n > 0) {
edadPromedio = sumaEdades / n;
} else {
edadPromedio = 0;
}

String profesorMasJoven = "";
int edadMasJoven = Integer.MAX_VALUE;
for (int i = 0; i < n; i++) {
if (edades[i] < edadMasJoven) {
edadMasJoven = edades[i];
profesorMasJoven = nombres[i];
}
}

int cantidadMayoresAlPromedio = 0;
String profesoresMayoresAlPromedio = "";
for (int i = 0; i < n; i++) {
if (edades[i] > edadPromedio) {
if (cantidadMayoresAlPromedio > 0) {
profesoresMayoresAlPromedio += "\n";
}
cantidadMayoresAlPromedio++;
profesoresMayoresAlPromedio += nombres[i];
}
}

String resultado = "Edad promedio = " + edadPromedio + "\n";
resultado += profesorMasJoven + " es el profesor más joven.\n";
resultado += cantidadMayoresAlPromedio + " profesores con edad mayor al promedio y son:\n";
resultado += profesoresMayoresAlPromedio;

return resultado;
}
}
