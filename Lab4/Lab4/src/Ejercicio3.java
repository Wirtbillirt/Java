import javax.swing.*;

public class Ejercicio3 {

public static void main(String[] args) {
int numEstudiantes = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el número de estudiantes:", "Número de Estudiantes", JOptionPane.PLAIN_MESSAGE));
String[] nombres = new String[numEstudiantes];
int[][] notas = new int[numEstudiantes][3];
double[] promedios = new double[numEstudiantes];
String[] grados = new String[numEstudiantes];

for (int i = 0; i < numEstudiantes; i++) {
nombres[i] = JOptionPane.showInputDialog(null, "Ingrese el nombre del estudiante " + (i + 1) + ":");
for (int j = 0; j < 3; j++) {
notas[i][j] = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la nota " + (j + 1) + " de " + nombres[i] + ":"));
}
}

int[] notaMaxima = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};

for (int i = 0; i < numEstudiantes; i++) {
int sumaNotas = 0;
for (int j = 0; j < 3; j++) {
sumaNotas += notas[i][j];
if (notas[i][j] > notaMaxima[j]) {
notaMaxima[j] = notas[i][j];
}
}
promedios[i] = sumaNotas / 3.0;
if (promedios[i] > 60) {
grados[i] = "APROBADO";
} else {
grados[i] = "REPROBADO";
}
}

StringBuilder resultado = new StringBuilder();
resultado.append("NOMBRE\t\tNOTA 1\tNOTA 2\tNOTA 3\tPROMEDIO\tGRADO\n");

for (int i = 0; i < numEstudiantes; i++) {
resultado.append(nombres[i] + "\t\t" + notas[i][0] + "\t" + notas[i][1] + "\t" + notas[i][2] + "\t" + String.format("%.2f", promedios[i]) + "\t\t" + grados[i] + "\n");
}

resultado.append("\nNota máxima:\n");
JOptionPane.showMessageDialog(null, new JTextArea(resultado.toString()), "Resultados", JOptionPane.PLAIN_MESSAGE);
}
}
