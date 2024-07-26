import javax.swing.*;

public class E4 {
    public static void main(String[] args) {
        StringBuilder tabla = new StringBuilder();
        tabla.append("Nombre completo          N1  N2  N3  Promedio\n");

        int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de estudiantes: "));

        for (int i = 1; i <= n; i++) {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre completo del estudiante " + i);
            String nota1Str = JOptionPane.showInputDialog("Ingrese la primera nota de " + nombre);
            String nota2Str = JOptionPane.showInputDialog("Ingrese la segunda nota de " + nombre);
            String nota3Str = JOptionPane.showInputDialog("Ingrese la tercera nota de " + nombre);

            int nota1 = Integer.parseInt(nota1Str);
            int nota2 = Integer.parseInt(nota2Str);
            int nota3 = Integer.parseInt(nota3Str);

            Notas notas = new Notas();
            notas.setNotas(nota1, nota2, nota3);
            Estudiantes estudiante = new Estudiantes(nombre, notas);

            tabla.append(estudiante.toString()).append("\n");
        }

        JTextArea areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        areaTexto.setText(tabla.toString());
        JOptionPane.showMessageDialog(null, areaTexto);

        System.exit(0);
    }
}
