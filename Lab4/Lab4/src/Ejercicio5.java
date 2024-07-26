import javax.swing.*;

public class Ejercicio5 {

public static void main(String args[])
{
int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de empresas: "));

double ventas[][] = new double[n][3];
String name[] = new String[n];
String tabla = "";

for (int i = 0; i < n; i++)
{
name[i] = JOptionPane.showInputDialog("Ingrese el nombre de la empresa " + (i+1));

ventas[i][0] = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la venta del mes 1 de " + name[i]));
ventas[i][1] = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la venta del mes 2 de " + name[i]));
ventas[i][2] = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la venta del mes 3 de " + name[i]));
}

tabla += metodo(name, ventas, n, tabla);

JTextArea imp = new JTextArea();
imp.setText(tabla);
JOptionPane.showMessageDialog(null, imp);
}

public static String metodo(String name[], double ventas[][], int n, String tabla)
{
int m = 3;
double min = Double.MAX_VALUE;

tabla += "N: " + n + "\nEmpresa\t\tVentas\n";

for (int i = 0; i < n; i++)
{
tabla += name[i] + "\t";
for (int j = 0; j < m; j++)
{
tabla += ventas[i][j] + "\t";
}
tabla += "\n";
}

tabla += "\nVentas minimas: \t";

for (int j = 0; j < m; j++) 
{
min = Double.MAX_VALUE;
for (int i = 0; i < n; i++) 
{
if (ventas[i][j] < min) 
{
min = ventas[i][j];
}
}
tabla += min + "\t";
}

return tabla;
}
}
