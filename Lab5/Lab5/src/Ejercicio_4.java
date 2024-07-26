import javax.swing.*;

public class Ejercicio_4 {

public static void main(String args[])
{
String name, tabla = "Nombre\tPeso en Kg\tPeso en Lb\n";
char rsp;
float Kg;

Class_4 ar = new Class_4();

do 
{
name = JOptionPane.showInputDialog("Ingrese su nombre: ");

do 
{	
Kg = Float.parseFloat(JOptionPane.showInputDialog("Ingrese su peso en Kilogramos"));

if (Kg < 0)
JOptionPane.showInputDialog("Ingrese un valor positivo");

} while (Kg <= 0);

ar.lb(Kg);

tabla += name + "\t" + Kg + "\t" + ar.GetLibras() + "\n";

rsp = JOptionPane.showInputDialog("Ingrese X si desea salir\nÓ cualquier letra para continuar").charAt(0);

} while (rsp != 'X' && rsp != 'x');

JTextArea imp = new JTextArea();
imp.setEditable(false);
imp.setText(tabla);

JOptionPane.showMessageDialog(null, imp);
System.exit(0);
}
}
