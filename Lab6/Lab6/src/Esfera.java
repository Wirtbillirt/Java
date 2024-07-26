import javax.swing.*;
public class Esfera {
	
	public static void main (String args[])
	{
		float r;
		String tabla = "";
		
		figura F = new figura();
		poligono P = new poligono(null);
		
		r = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el radio de la esfera: "));
		
		F.SetAsignar(r);
		P.SetAsigno(F);
		
		tabla += P;
		
		JTextArea imp = new JTextArea();
		imp.setEditable(false);
		imp.setText(tabla);
		JOptionPane.showMessageDialog(null, imp);
		
		System.exit(0);
	}
}