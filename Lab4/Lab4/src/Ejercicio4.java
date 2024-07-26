import javax.swing.*;

public class Ejercicio4 {

public static void main(String args[]) {

int n = 3;

double ventas[][] = new double[n][n];
String name[] = new String[n];
String tabla = "";

for (int i = 0; i < n; i++)
{
name[i] = JOptionPane.showInputDialog("Ingrese el nombre de la empresa numero: " + (i+1) + "\t");
for (int j = 0; j < n; j++)
{
ventas[i][j] = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la venta del mes: " + (j+1)));
}
}

tabla += calcular(n, ventas, tabla, name);

JTextArea imp = new JTextArea();
imp.setText(tabla);
JOptionPane.showMessageDialog(null, imp);

}

public static String calcular(int n, double ventas[][], String tabla, String name[])
{
double vTotal[] = new double[n];
double ventasM[] = new double[n];
double ventasP[] = new double[n];
tabla += "Empresa\t Ventas\tVentas Totales\n\tM1 M2 M3\n";

for (int i = 0; i < n; i++)
{
tabla += name[i] + "\t";

for (int j = 0; j < n; j++)
{
tabla += ventas[i][j] + " ";
vTotal[i] = vTotal[i] + ventas[i][j];
}
tabla += "\t\t" + vTotal[i] + "\n";
}

tabla += "\nVentas Mensuales: \t";
for (int i = 0; i < n; i++)
{
int count = 0;

for (int j = 0; j < n; j++)
{
ventasM[i] += ventas[j][i];
}
count = count + 1;
tabla += ventasM[i] + " ";
}

tabla += "\nVentas promedio: \t";
for (int i = 0; i < n; i++)
{
ventasP[i] = ventasM[i] / 3;
tabla += ventasP[i] + " ";
}

return tabla;
}
}
