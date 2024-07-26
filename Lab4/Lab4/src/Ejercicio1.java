import javax.swing.*;

public class Ejercicio1 {
public static void main(String[] args) {
int n = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el tamaño de la matriz (N):", "Tamaño de la Matriz", JOptionPane.PLAIN_MESSAGE));
int[][] matrix = new int[n][n];

for (int i = 0; i < n; i++) {
for (int j = 0; j < n; j++) {
matrix[i][j] = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el valor para matrix[" + i + "][" + j + "]:", "Ingreso de Datos", JOptionPane.PLAIN_MESSAGE));
}
}

JTextArea textArea = new JTextArea();
textArea.append("Matriz ingresada:\n");
for (int i = 0; i < n; i++) {
for (int j = 0; j < n; j++) {
textArea.append(matrix[i][j] + "\t");
}
textArea.append("\n");
}
textArea.append("\n");

calcularResultados(matrix, n, textArea);

JOptionPane.showMessageDialog(null, new JScrollPane(textArea), "Resultados", JOptionPane.PLAIN_MESSAGE);
}

public static void calcularResultados(int[][] matrix, int n, JTextArea textArea) {
textArea.append("Elementos debajo de la diagonal inversa: ");
for (int i = 0; i < n; i++) {
for (int j = 0; j < n; j++) {
if (i + j >= n) {
textArea.append(matrix[i][j] + " ");
}
}
}
textArea.append("\n");

int sumAbovePrincipalDiagonal = 0;
for (int i = 0; i < n; i++) {
for (int j = 0; j < n; j++) {
if (j > i) {
sumAbovePrincipalDiagonal += matrix[i][j];
}
}
}
textArea.append("Suma de elementos encima de la diagonal principal = " + sumAbovePrincipalDiagonal + "\n");

int maxElement = matrix[0][0];
int maxI = 0, maxJ = 0;
for (int i = 0; i < n; i++) {
for (int j = 0; j < n; j++) {
if (matrix[i][j] > maxElement) {
maxElement = matrix[i][j];
maxI = i;
maxJ = j;
}
}
}
textArea.append("Elemento mayor del arreglo = " + maxElement + "\n");
textArea.append("Se encuentra en la posición: [" + maxI + "][" + maxJ + "]");
}
}
