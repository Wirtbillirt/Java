import javax.swing.*;

public class Ejercicio2 {

public static void main(String args[])
{
int n = 1, total, dia, mes, año, edad = 0;
int nd, nm, na;
String name, fecha = "", todo = "";

JTextArea imp = new JTextArea();

nd = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dia actual"));
nm = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el mes actual"));
na = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año actual"));

todo += "fecha actual:"+nd+"/"+nm+"/"+na+"\n"+"NOMBRE COMPLETO\tFECHA DE NAC\tEDAD\n";

total = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de personas que desea ingresar: "));

do 
{	
name = JOptionPane.showInputDialog("Ingrese el nombre de la persona "+n);
dia = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dia de nacimiento de "+name));
mes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el mes de nacimiento de "+name));
año = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año de nacimiento de "+name));

if (mes > nm)
{
edad = na - año - 1;
}
else if (mes <= nm)
{
if (dia < nd) 
{
edad = na - año - 1;
}
else 
{
edad = na - año;
}
}
else 
{
edad = na - año;
}


fecha = dia+" de "+mes+" de "+año;

todo += name+"\t"+fecha+"\t"+edad+"\n";

n++;

}while(total >= n);

imp.setText(todo);

JOptionPane.showMessageDialog(null, imp);

System.exit(0);
}

}
