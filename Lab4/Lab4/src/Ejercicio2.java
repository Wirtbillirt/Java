import javax.swing.*;

public class Ejercicio2 {

public static void main(String[] args) {
int n = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el tamaño de la matriz (N):", "Tamaño de la Matriz", JOptionPane.PLAIN_MESSAGE));
int[][] matriz = new int[n][n];

for (int i = 0; i < n; i++) {
for (int j = 0; j < n; j++) {
int valor = -1;
while (valor < 0 || valor > 5) {
valor = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el valor para matriz[" + i + "][" + j + "] (0-5):", "Ingreso de Datos", JOptionPane.PLAIN_MESSAGE));
}
matriz[i][j] = valor;
}
}

JTextArea textArea = new JTextArea();

textArea.append("Matriz ingresada:\n");
for (int i = 0; i < n; i++) {
for (int j = 0; j < n; j++) {
textArea.append(matriz[i][j] + "\t");
}
textArea.append("\n");
}
textArea.append("\n");

textArea.append("Totales por fila:\n");
for (int i = 0; i < n; i++) {
int sumaFila = 0;
for (int j = 0; j < n; j++) {
sumaFila += matriz[i][j];
}
textArea.append("Fila " + (i + 1) + ": " + sumaFila + "\n");
}
textArea.append("\n");

textArea.append("Totales por columna:\n");
for (int j = 0; j < n; j++) {
int sumaColumna = 0;
for (int i = 0; i < n; i++) {
sumaColumna += matriz[i][j];
}
textArea.append("Columna " + (j + 1) + ": " + sumaColumna + "\n");
}
textArea.append("\n");

int cuentaCeros = contarCeros(matriz);
textArea.append("Número de ceros en la matriz: " + cuentaCeros + "\n");

JOptionPane.showMessageDialog(null, new JScrollPane(textArea), "Resultados", JOptionPane.PLAIN_MESSAGE);
}

public static int contarCeros(int[][] matriz) {
int cuenta = 0;
for (int[] fila : matriz) {
for (int valor : fila) {
if (valor == 0) {
cuenta++;
}
}
}
return cuenta;
}
}
