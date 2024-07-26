import javax.swing.*;

public class Ejercicio_2main {

public static void main(String args[])
{
double radio = 0;
String tabla = "Radio\tArea\tLongitud\n";
char resp;

Ejercicio_2 mp = new Ejercicio_2();

do 
{
do 
{
radio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el radio de la circunferencia: "));

if (radio < 0)
JOptionPane.showMessageDialog(null, "Valor invalido, ingrese un numero positivo");

} while (radio <= 0);

mp.Radio(radio);

tabla += radio + "\t" + mp.GetArea() + "\t" + mp.GetLongitud() + "\n";

resp = JOptionPane.showInputDialog("Ingrese 'Y' para continuar obteniendo resultado\nCualquier otra letra para salir").charAt(0);

} while(resp == 'Y' || resp == 'y');

JTextArea imp = new JTextArea();
imp.setEditable(false);
imp.setText(tabla);

JOptionPane.showMessageDialog(null, imp);

System.exit(0);
}
}
