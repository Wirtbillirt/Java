import javax.swing.*;
import java.text.DecimalFormat;

public class Ejercicio1 {

public static void main(String[] args) {
DecimalFormat f = new DecimalFormat("#.##");
DecimalFormat m = new DecimalFormat("#");

int x = 0, z = 0, t = 0, v = 0, w = 0;
float y;

boolean cancel = false;
do {
try {
String input = JOptionPane.showInputDialog("Ingrese el valor de X: ");
if (input == null) {
cancel = true;
break;
}
x = Integer.parseInt(input);
if (x < 0) {
JOptionPane.showMessageDialog(null, "Debe ingresar un valor positivo.");
continue;
}

input = JOptionPane.showInputDialog("Ingrese el valor de Z: ");
if (input == null) {
cancel = true;
break;
}
z = Integer.parseInt(input);
if (z < 0) {
JOptionPane.showMessageDialog(null, "Debe ingresar un valor positivo.");
continue;
}

input = JOptionPane.showInputDialog("Ingrese el valor de W: ");
if (input == null) {
cancel = true;
break;
}
w = Integer.parseInt(input);
if (w < 0) {
JOptionPane.showMessageDialog(null, "Debe ingresar un valor positivo.");
continue;
}

input = JOptionPane.showInputDialog("Ingrese el valor de T: ");
if (input == null) {
cancel = true;
break;
}
t = Integer.parseInt(input);
if (t < 0) {
JOptionPane.showMessageDialog(null, "Debe ingresar un valor positivo.");
continue;
}

input = JOptionPane.showInputDialog("Ingrese el valor de V: ");
if (input == null) {
cancel = true;
break;
}
v = Integer.parseInt(input);
if (v < 0) {
JOptionPane.showMessageDialog(null, "Debe ingresar un valor positivo.");
continue;
}

y = (float) (x * (z + w)) / (t - v);

JOptionPane.showMessageDialog(null, "X:" + m.format(x) + "\nZ:" + m.format(z) + "\nW:" + m.format(w) + "\nT:" + m.format(t) + "\nV:" + m.format(v) + "\nEl resultado es: " + f.format(y));
} catch (NumberFormatException e) {
JOptionPane.showMessageDialog(null, "Debe ingresar un valor numérico.");
}
} while (!cancel);

}

}

