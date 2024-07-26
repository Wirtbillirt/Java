import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Ejercicio7 {

public static void main(String[] args) {
int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de empleados:"));

String[] nombres = new String[n];
int[] puntajes1 = new int[n];
int[] puntajes2 = new int[n];
int[] edades = new int[n];
int[] puntajes1Modificados = new int[n];
int[] puntajes2Modificados = new int[n];
double[] promedios = new double[n];
String[] resultados = new String[n];

int contratados = 0;

for (int i = 0; i < n; i++) {
nombres[i] = JOptionPane.showInputDialog("Empleado " + (i + 1) + ": Ingrese el nombre:");
puntajes1[i] = Integer.parseInt(JOptionPane.showInputDialog("Empleado " + (i + 1) + ": Ingrese el puntaje 1:"));
puntajes2[i] = Integer.parseInt(JOptionPane.showInputDialog("Empleado " + (i + 1) + ": Ingrese el puntaje 2:"));
edades[i] = Integer.parseInt(JOptionPane.showInputDialog("Empleado " + (i + 1) + ": Ingrese la edad:"));

double promedio = calcularPromedioYResultado(puntajes1[i], puntajes2[i], edades[i], puntajes1Modificados, puntajes2Modificados, i);

if (promedio >= 75) {
resultados[i] = "Contratado";
contratados++;
} else {
resultados[i] = "No contratado";
}

promedios[i] = promedio;
}

ordenarPorNombre(nombres, puntajes1, puntajes2, edades, puntajes1Modificados, puntajes2Modificados, promedios, resultados);

JTextArea resultadoTextArea = new JTextArea("Nombre\tP1\tP2\tEdad\tP1M\tP2M\tPromedio\tResultado\n");
for (int i = 0; i < n; i++) {
resultadoTextArea.append(String.format("%s\t%d\t%d\t%d\t%d\t%d\t%.1f\t%s\n",
nombres[i], puntajes1[i], puntajes2[i], edades[i], puntajes1Modificados[i], puntajes2Modificados[i], promedios[i], resultados[i]));
}
resultadoTextArea.append("\nSe contrataron " + contratados + " personas.");

JOptionPane.showMessageDialog(null, resultadoTextArea, "Información de Empleados", JOptionPane.PLAIN_MESSAGE);
}

public static double calcularPromedioYResultado(int puntaje1, int puntaje2, int edad, int[] puntajes1Modificados, int[] puntajes2Modificados, int index) {
int puntaje1Modificado;
int puntaje2Modificado;
if (edad >= 30) {
puntaje1Modificado = puntaje1 + 5;
puntaje2Modificado = puntaje2 + 5;
} else {
puntaje1Modificado = puntaje1 + 2;
puntaje2Modificado = puntaje2 + 2;
}

puntajes1Modificados[index] = puntaje1Modificado;
puntajes2Modificados[index] = puntaje2Modificado;

return (puntaje1Modificado + puntaje2Modificado) / 2.0;
}

public static void ordenarPorNombre(String[] nombres, int[] puntajes1, int[] puntajes2, int[] edades,
int[] puntajes1Modificados, int[] puntajes2Modificados, double[] promedios, String[] resultados) {
for (int i = 0; i < nombres.length - 1; i++) {
for (int j = i + 1; j < nombres.length; j++) {
if (nombres[i].compareTo(nombres[j]) > 0) {
String tempNombre = nombres[i];
nombres[i] = nombres[j];
nombres[j] = tempNombre;

int tempPuntaje1 = puntajes1[i];
puntajes1[i] = puntajes1[j];
puntajes1[j] = tempPuntaje1;

int tempPuntaje2 = puntajes2[i];
puntajes2[i] = puntajes2[j];
puntajes2[j] = tempPuntaje2;

int tempEdad = edades[i];
edades[i] = edades[j];
edades[j] = tempEdad;

int tempPuntaje1Modificado = puntajes1Modificados[i];
puntajes1Modificados[i] = puntajes1Modificados[j];
puntajes1Modificados[j] = tempPuntaje1Modificado;

int tempPuntaje2Modificado = puntajes2Modificados[i];
puntajes2Modificados[i] = puntajes2Modificados[j];
puntajes2Modificados[j] = tempPuntaje2Modificado;

double tempPromedio = promedios[i];
promedios[i] = promedios[j];
promedios[j] = tempPromedio;

String tempResultado = resultados[i];
resultados[i] = resultados[j];
resultados[j] = tempResultado;
}
}
}
}
}
