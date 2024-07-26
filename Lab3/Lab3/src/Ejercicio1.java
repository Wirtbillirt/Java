import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Ejercicio1 {

public static void main(String[] args) {
int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de personas:"));

int[] edades = new int[n];
char[] sexos = new char[n];
char[] estadosCiviles = new char[n];

JTextArea imp = new JTextArea();
imp.append("Edad\tSexo\tEstado Civil\n");

for (int i = 0; i < n; i++) {
edades[i] = Integer.parseInt(JOptionPane.showInputDialog("Persona " + (i + 1) + ": Ingrese la edad:"));
sexos[i] = JOptionPane.showInputDialog("Persona " + (i + 1) + ": Ingrese el sexo (M/F):").toUpperCase().charAt(0);
estadosCiviles[i] = JOptionPane.showInputDialog("Persona " + (i + 1) + ": Ingrese el estado civil (S/C):").toUpperCase().charAt(0);

while (sexos[i] != 'M' && sexos[i] != 'F') {
sexos[i] = JOptionPane.showInputDialog("Sexo inválido. Ingrese el sexo (M/F):").toUpperCase().charAt(0);
}

while (estadosCiviles[i] != 'S' && estadosCiviles[i] != 'C') {
estadosCiviles[i] = JOptionPane.showInputDialog("Estado civil inválido. Ingrese el estado civil (S/C):").toUpperCase().charAt(0);
}
}

imp.append(realizarEncuesta(edades, sexos, estadosCiviles, n));

JOptionPane.showMessageDialog(null, imp, "Resultados de la Encuesta", JOptionPane.PLAIN_MESSAGE);
}

public static String realizarEncuesta(int[] edades, char[] sexos, char[] estadosCiviles, int n) {
String resultados = "Edad\tSexo\tEstado Civil\n";
double sumaEdadesHombres = 0;
double sumaEdadesMujeres = 0;
int countHombres = 0;
int countMujeres = 0;
int hombresMayores30 = 0;
int mujeresMayores30 = 0;

for (int i = 0; i < n; i++) {
if (sexos[i] == 'M') {
sumaEdadesHombres += edades[i];
countHombres++;
} else {
sumaEdadesMujeres += edades[i];
countMujeres++;
}

if (edades[i] > 30 && estadosCiviles[i] == 'C') {
if (sexos[i] == 'M') {
hombresMayores30++;
} else {
mujeresMayores30++;
}
}

String estadoCivilTexto = "Soltero";
if (estadosCiviles[i] == 'C') {
if (sexos[i] == 'M') {
estadoCivilTexto = "Casado";
} else {
estadoCivilTexto = "Casada";
}
}

resultados += edades[i] + "\t" + sexos[i] + "\t" + estadoCivilTexto + "\n";
}

double edadPromedioHombres = 0;
double edadPromedioMujeres = 0;

if (countHombres > 0) {
edadPromedioHombres = sumaEdadesHombres / countHombres;
}

if (countMujeres > 0) {
edadPromedioMujeres = sumaEdadesMujeres / countMujeres;
}

resultados += "\nEdad promedio de hombres = " + String.format("%.2f", edadPromedioHombres) + "\n";
resultados += "Edad promedio de mujeres = " + String.format("%.2f", edadPromedioMujeres) + "\n";
resultados += "Hombres mayores de 30 años y casados = " + hombresMayores30 + "\n";
resultados += "Mujeres mayores de 30 años y casadas = " + mujeresMayores30;

return resultados;
}
}
