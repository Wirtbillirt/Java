import javax.swing.*;

public class Ejercicio6 {

public static void main(String[] args) {
JTextArea imp = new JTextArea();
String palabra = JOptionPane.showInputDialog(null, "Ingrese una palabra:");

int longitud = palabra.length();
int indice = longitud;

String resultado = "Palabra = " + palabra + "\n";
imp.setText(resultado);

while (indice > 0) {
resultado += palabra.substring(0, indice) + "\n";
indice--;
}

imp.setText(resultado);

JOptionPane.showMessageDialog(null, new JScrollPane(imp), "Palabra Descendente", JOptionPane.PLAIN_MESSAGE);
}
}
