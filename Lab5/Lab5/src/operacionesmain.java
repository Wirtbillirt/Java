import javax.swing.*;

public class operacionesmain {
public static void main(String[] args) {
Operaciones op = new Operaciones(); 

int numCases = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de casos a probar: "));

JTextArea textArea = new JTextArea();
textArea.setEditable(false);
textArea.append("NUM1\tNUM2\tSUMA\tRESTA\tMULTIP.\tDIV.\n");

for (int i = 0; i < numCases; i++) {
int num1 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de NUM1 para el caso " + (i + 1) + ": "));
int num2 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de NUM2 para el caso " + (i + 1) + ": "));

op.setNum1(num1); 
op.setNum2(num2);

textArea.append(num1 + "\t" + num2 + "\t" + op.suma() + "\t" + op.resta() + "\t" + op.multiplicacion() + "\t" + op.division() + "\n");
}

JOptionPane.showMessageDialog(null, textArea, "Resultados de Operaciones", JOptionPane.PLAIN_MESSAGE);
}
}
