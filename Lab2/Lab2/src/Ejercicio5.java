import javax.swing.*;

public class Ejercicio5 {

public static void main(String[] args) {
JTextArea imp = new JTextArea();
String cadena = JOptionPane.showInputDialog(null, "Ingrese una cadena de caracteres:");

String mayuscula = cadena.toUpperCase();
int longitud = cadena.length();
char primerCaracter = cadena.charAt(0);

int posicionA = -1;
for (int i = 0; i < longitud; i++) {
if (cadena.charAt(i) == 'A' || cadena.charAt(i) == 'a') {
posicionA = i;
break;
}
}

String reemplazada = cadena.replace('e', '.');

String resultado = "Cadena ingresada: " + cadena +
"\nCadena en mayúscula: " + mayuscula +
"\nLongitud de la cadena: " + longitud +
"\nPrimer carácter: " + primerCaracter +
(posicionA != -1 ? "\nPosición de la primera letra 'A': " + posicionA : "\nLa cadena no contiene la letra 'A'.") +
"\nCadena con 'e' reemplazada por punto: " + reemplazada;

imp.setText(resultado);
imp.setEditable(false);

JOptionPane.showMessageDialog(null, new JScrollPane(imp), "Resultado", JOptionPane.PLAIN_MESSAGE);
}
}
