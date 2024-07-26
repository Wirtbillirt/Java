import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Ejercicio3 {
static String[] nombres;
static int[] numerosCuenta;
static double[] saldos;
static int N;

public static void main(String[] args) {
N = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de clientes:"));

nombres = new String[N];
numerosCuenta = new int[N];
saldos = new double[N];

for (int i = 0; i < N; i++) {
nombres[i] = JOptionPane.showInputDialog("Ingrese el nombre del cliente " + (i + 1) + ":");
numerosCuenta[i] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de cuenta del cliente " + (i + 1) + ":"));
saldos[i] = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el saldo del cliente " + (i + 1) + ":"));
}

int opcion;
do {
opcion = Integer.parseInt(JOptionPane.showInputDialog(
"Transacciones\n" +
"1. Imprimir todos los registros.\n" +
"2. Dado el número de cuenta, imprimir los datos de la persona.\n" +
"3. Realizar un depósito en base al número de cuenta.\n" +
"4. Realizar un retiro en base al número de cuenta.\n" +
"5. Salir.\n" +
"Seleccione una opción:"
));

switch (opcion) {
case 1:
imprimirRegistros();
break;
case 2:
imprimirDatosPorCuenta();
break;
case 3:
realizarDeposito();
break;
case 4:
realizarRetiro();
break;
case 5:
JOptionPane.showMessageDialog(null, "Saliendo del programa...");
break;
default:
JOptionPane.showMessageDialog(null, "Opción inválida. Por favor, seleccione una opción válida.");
}
} while (opcion != 5);
}

public static void imprimirRegistros() {
JTextArea imp = new JTextArea();
imp.append(String.format("%-20s %-20s %-20s\n", "NOMBRE", "NUMERO DE CUENTA", "SALDO"));
for (int i = 0; i < N; i++) {
imp.append(String.format("%-20s %-20d %-20.2f\n", nombres[i], numerosCuenta[i], saldos[i]));
}
JOptionPane.showMessageDialog(null, imp, "Registros de Clientes", JOptionPane.PLAIN_MESSAGE);
}

public static void imprimirDatosPorCuenta() {
int cuenta = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de cuenta:"));
for (int i = 0; i < N; i++) {
if (numerosCuenta[i] == cuenta) {
JTextArea imp = new JTextArea();
imp.append(String.format("%-20s %-20d %-20.2f\n", "NOMBRE", "NUMERO DE CUENTA", "SALDO"));
imp.append(String.format("%-20s %-20d %-20.2f\n", nombres[i], numerosCuenta[i], saldos[i]));
JOptionPane.showMessageDialog(null, imp, "Datos del Cliente", JOptionPane.PLAIN_MESSAGE);
return;
}
}
JOptionPane.showMessageDialog(null, "No se encontró el número de cuenta.");
}

public static void realizarDeposito() {
int cuenta = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de cuenta:"));
for (int i = 0; i < N; i++) {
if (numerosCuenta[i] == cuenta) {
double deposito = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el monto del depósito:"));
saldos[i] += deposito;
JOptionPane.showMessageDialog(null, "Depósito realizado. Nuevo saldo = " + saldos[i]);
return;
}
}
JOptionPane.showMessageDialog(null, "No se encontró el número de cuenta.");
}

public static void realizarRetiro() {
int cuenta = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de cuenta:"));
for (int i = 0; i < N; i++) {
if (numerosCuenta[i] == cuenta) {
double retiro = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el monto del retiro:"));
if (saldos[i] - retiro >= 1000) {
saldos[i] -= retiro;
JOptionPane.showMessageDialog(null, "Retiro realizado. Nuevo saldo = " + saldos[i]);
} else {
JOptionPane.showMessageDialog(null, "Saldo insuficiente para realizar el retiro.");
}
return;
}
}
JOptionPane.showMessageDialog(null, "No se encontró el número de cuenta.");
}
}
