import javax.swing.*;

public class Ejercicio4 {

public static void main(String[] args) {
JTextArea imp = new JTextArea();
int consonantes = 0;
int espacios = 0;
int i = 0;
String output = "";
String cadena = JOptionPane.showInputDialog("Ingrese una cadena de caracteres:");
cadena = cadena.toLowerCase();

while (i < cadena.length()) {
char caracter = cadena.charAt(i);
if (caracter != ' ' && (caracter < 'a' || caracter > 'z')) {
i++;
continue;
}
if (caracter == ' ') {
espacios++;
} else if (caracter != 'a' && caracter != 'e' && caracter != 'i' && caracter != 'o' && caracter != 'u') {
consonantes++;
}
i++;
}

output += cadena + "\nConsonantes = " + consonantes + "\nEspacios en blanco = " + espacios;
imp.setText(output);

JOptionPane.showMessageDialog(null, new JScrollPane(imp), "Resultado", JOptionPane.INFORMATION_MESSAGE);
}
}
