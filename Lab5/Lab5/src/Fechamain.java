import javax.swing.*;	
public class Fechamain {
public static void main(String[] args) {
Fecha fechaNacimiento = new Fecha();

int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de personas: "));

String sal = "NOMBRE COMPLETO FECHA DE NACIMIENTO\n";

for (int i = 0; i < n; i++) {
String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la persona " + (i + 1) + ": ");
String apellido = JOptionPane.showInputDialog("Ingrese el apellido de la persona " + (i + 1) + ": ");
int dia = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el día de nacimiento de " + nombre + " " + apellido + ": "));
int mes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el mes de nacimiento (en número) de " + nombre + " " + apellido + ": "));
int año = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año de nacimiento de " + nombre + " " + apellido + ": "));

if (Fecha.validarFecha(dia, mes, año)) {
fechaNacimiento.setFecha(dia, mes, año);
sal += nombre + " " + apellido + " " + fechaNacimiento.getFechaFormateada() + "\n";
} else {
JOptionPane.showMessageDialog(null, "Fecha no válida. La entrada se omitirá.", "Error", JOptionPane.ERROR_MESSAGE);
}
}

JTextArea imp = new JTextArea();
imp.setEditable(false);
imp.setText(sal);
JOptionPane.showMessageDialog(null, new JScrollPane(imp), "Tabla de Nacimientos", JOptionPane.PLAIN_MESSAGE);
System.exit(0);
}
}
