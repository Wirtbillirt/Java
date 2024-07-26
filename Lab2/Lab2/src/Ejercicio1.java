import javax.swing.*;

public class Ejercicio1 {

public static void main(String args[]) {
int n = 1, numeros = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
float promedio = 0, suma = 0;

JTextArea imp = new JTextArea();

while (n <= 10) {
numeros = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero: "));

imp.append(numeros + " ");

if (numeros > max)
max = numeros;

if (numeros < min)
min = numeros;

suma += numeros;
promedio = suma / 10;

n++;
}

imp.append("\nsuma = " + suma + "\nmáximo = " + max + "\nmínimo = " + min + "\npromedio = " + promedio);

JOptionPane.showMessageDialog(null, new JScrollPane(imp));

System.exit(0);
}
}
