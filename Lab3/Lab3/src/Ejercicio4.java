
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Ejercicio4 {

public static void main(String[] args) {
int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de empleados:"));

JTextArea resultadoTextArea = new JTextArea("Nombre\tP1\tP2\tEdad\tP1M\tP2M\tPromedio\tResultado\n");
int contratados = 0;

for (int i = 0; i < n; i++) {
String nombre = JOptionPane.showInputDialog("Empleado " + (i + 1) + ": Ingrese el nombre:");
int puntaje1 = Integer.parseInt(JOptionPane.showInputDialog("Empleado " + (i + 1) + ": Ingrese el puntaje 1:"));
int puntaje2 = Integer.parseInt(JOptionPane.showInputDialog("Empleado " + (i + 1) + ": Ingrese el puntaje 2:"));
int edad = Integer.parseInt(JOptionPane.showInputDialog("Empleado " + (i + 1) + ": Ingrese la edad:"));

int puntaje1Modificado, puntaje2Modificado;
if (edad >= 30) {
puntaje1Modificado = puntaje1 + 5;
puntaje2Modificado = puntaje2 + 5;
} else {
puntaje1Modificado = puntaje1 + 2;
puntaje2Modificado = puntaje2 + 2;
}

double promedio = (puntaje1Modificado + puntaje2Modificado) / 2.0;

String contratado;
if (promedio >= 75) {
contratado = "Contratado";
contratados++;
} else {
contratado = "No contratado";
}

resultadoTextArea.append(String.format("%s\t%d\t%d\t%d\t%d\t%d\t%.1f\t%s\n",
nombre, puntaje1, puntaje2, edad, puntaje1Modificado, puntaje2Modificado, promedio, contratado));
}

resultadoTextArea.append("\nSe contrataron " + contratados + " personas.");
JOptionPane.showMessageDialog(null, resultadoTextArea, "Información de Empleados", JOptionPane.PLAIN_MESSAGE);
}
}
