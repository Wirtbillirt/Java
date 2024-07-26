import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Ejercicio5 {

public static void main(String[] args) {
int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de empleados:"));

String[] nombres = new String[n];
int[] horasTrabajo = new int[n];
double[] salarioPorHora = new double[n];
int[] dependientes = new int[n];
double[] salariosBase = new double[n];
double[] impuestos = new double[n];
double[] pagosNetos = new double[n];

for (int i = 0; i < n; i++) {
nombres[i] = JOptionPane.showInputDialog("Empleado " + (i + 1) + ": Ingrese el nombre:");
horasTrabajo[i] = Integer.parseInt(JOptionPane.showInputDialog("Empleado " + (i + 1) + ": Ingrese las horas de trabajo:"));
salarioPorHora[i] = Double.parseDouble(JOptionPane.showInputDialog("Empleado " + (i + 1) + ": Ingrese el salario por hora:"));
dependientes[i] = Integer.parseInt(JOptionPane.showInputDialog("Empleado " + (i + 1) + ": Ingrese el número de dependientes:"));

double[] resultados = calcularSalario(horasTrabajo[i], salarioPorHora[i], dependientes[i]);
salariosBase[i] = resultados[0];
impuestos[i] = resultados[1];
pagosNetos[i] = resultados[2];
}

ordenarPorNombre(nombres, horasTrabajo, salarioPorHora, dependientes, salariosBase, impuestos, pagosNetos);

imprimirInformacion(nombres, horasTrabajo, salarioPorHora, dependientes, salariosBase, impuestos, pagosNetos, n);
}

public static double[] calcularSalario(int horasTrabajo, double salarioPorHora, int dependientes) {
double salarioBase = horasTrabajo * salarioPorHora;
double tasaImpuesto;
if (dependientes <= 3) {
tasaImpuesto = 0.20 - (dependientes * 0.01);
} else {
tasaImpuesto = 0.16 - (dependientes * 0.01);
}
double impuestos = tasaImpuesto * salarioBase;
double pagoNeto = salarioBase - impuestos;
return new double[]{salarioBase, impuestos, pagoNeto};
}

public static void ordenarPorNombre(String[] nombres, int[] horasTrabajo, double[] salarioPorHora, int[] dependientes,
double[] salariosBase, double[] impuestos, double[] pagosNetos) {
for (int i = 0; i < nombres.length - 1; i++) {
for (int j = 0; j < nombres.length - 1 - i; j++) {
if (nombres[j].compareTo(nombres[j + 1]) > 0) {
String tempNombre = nombres[j];
nombres[j] = nombres[j + 1];
nombres[j + 1] = tempNombre;
int tempHoras = horasTrabajo[j];
horasTrabajo[j] = horasTrabajo[j + 1];
horasTrabajo[j + 1] = tempHoras;
double tempSalarioPorHora = salarioPorHora[j];
salarioPorHora[j] = salarioPorHora[j + 1];
salarioPorHora[j + 1] = tempSalarioPorHora;
int tempDependientes = dependientes[j];
dependientes[j] = dependientes[j + 1];
dependientes[j + 1] = tempDependientes;
double tempSalarioBase = salariosBase[j];
salariosBase[j] = salariosBase[j + 1];
salariosBase[j + 1] = tempSalarioBase;
double tempImpuestos = impuestos[j];
impuestos[j] = impuestos[j + 1];
impuestos[j + 1] = tempImpuestos;
double tempPagoNeto = pagosNetos[j];
pagosNetos[j] = pagosNetos[j + 1];
pagosNetos[j + 1] = tempPagoNeto;
}
}
}
}

public static void imprimirInformacion(String[] nombres, int[] horasTrabajo, double[] salarioPorHora, int[] dependientes,
double[] salariosBase, double[] impuestos, double[] pagosNetos, int n) {
JTextArea imp = new JTextArea();
imp.append(String.format("%-15s %-15s %-15s %-15s %-15s %-15s\n", "Nombre", "Horas Trabajo", "Salario/Hora", "Salario Base", "Impuestos", "Pago Neto"));
for (int i = 0; i < n; i++) {
imp.append(String.format("%-15s %-15d %-15.2f %-15.2f %-15.2f %-15.2f\n",
nombres[i], horasTrabajo[i], salarioPorHora[i], salariosBase[i], impuestos[i], pagosNetos[i]));
}
imp.setRows(n + 1); 
imp.setEditable(false); 
JOptionPane.showMessageDialog(null, imp, "Información de Empleados", JOptionPane.PLAIN_MESSAGE);
}
}
