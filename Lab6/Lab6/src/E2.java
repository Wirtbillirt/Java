import javax.swing.*;

public class E2 {

	public static void main(String args[])
	{
		Telefono P = new Telefono();
		Cell A = new Cell(null, null);
		
		String name, tabla = "Nombre Completo\tTelefonos\n\t\tDomicilio/Trabajo/Celular\n";
		String D, T, C;
		
		int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de personas: "));
		
		for (int i = 1; i <= n; i++)
		{
			name = JOptionPane.showInputDialog("Ingrese el nombre de la persona " + i);
			D = JOptionPane.showInputDialog("Ingrese el numero de Domicilio de: " + name);
			T = JOptionPane.showInputDialog("Ingrese el numero de Trabajo de: " + name);
			C = JOptionPane.showInputDialog("Ingrese el numero de Celular de: " + name);
			
			P.setAsignar(D, T, C);
			A.SetAsignar(name, P);
			
			tabla += A;
		}
		
		JTextArea imp = new JTextArea();
		imp.setEditable(false);
		imp.setText(tabla);
		JOptionPane.showMessageDialog(null, imp);
		
		System.exit(0);
	}
}
