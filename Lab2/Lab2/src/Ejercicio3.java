import javax.swing.*;

public class Ejercicio3 {

public static void main(String args[]) {
int n, cant = 1, lg = 0;
String name, td = "";

JTextArea imp = new JTextArea();

td += "NOMBRE COMPLETO\tLONG\tHISTOGRAMA\n";

cant = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de estudiantes: "));

for (n = 1; n <= cant; n++) {
name = JOptionPane.showInputDialog("Ingrese el nombre del estudiante " + n);

lg = name.length();

for (int j = 0; j < lg; j++) {
if (name.charAt(j) == ' ') {
lg = lg - 1;
}
}

td += name + "\t" + lg + "\t";

for (int i = 1; i <= lg; i++) {
td += "*";
}

td += "\n";
}

imp.setText(td);

JOptionPane.showMessageDialog(null, imp);

System.exit(0);
}
}

