import javax.swing.*;
public class main_rectangulo {
public static void main(String[] args) {
int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de rectángulos: "));

JTextArea textArea = new JTextArea("Base\tAltura\tPerímetro\tÁrea\n");
textArea.setEditable(false);

Rectangulo rectangulo = new Rectangulo(); 

for (int i = 0; i < n; i++) {
int base = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la base del rectángulo " + (i + 1) + ": "));
int altura = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la altura del rectángulo " + (i + 1) + ": "));

rectangulo.setBase(base); 
rectangulo.setAltura(altura); 
textArea.append(rectangulo.getBase() + "\t" +
rectangulo.getAltura() + "\t" +
rectangulo.calcularPerimetro() + "\t" +
rectangulo.calcularArea() + "\n");
}

JOptionPane.showMessageDialog(null, textArea, "Resultados de Rectángulos", JOptionPane.PLAIN_MESSAGE);
}
}
