import javax.swing.*;
public class E1 {
public static void main(String[] args) {
String diaActualStr = JOptionPane.showInputDialog("Ingrese el día actual: ");
String mesActualStr = JOptionPane.showInputDialog("Ingrese el mes actual: ");
String añoActualStr = JOptionPane.showInputDialog("Ingrese el año actual: ");

        int diaActual = Integer.parseInt(diaActualStr);
        int mesActual = Integer.parseInt(mesActualStr);
        int añoActual = Integer.parseInt(añoActualStr);

        Fecha fechaActual = new Fecha();
        fechaActual.asignarFecha(diaActual, mesActual, añoActual);

        StringBuilder tabla = new StringBuilder();
        tabla.append("Fecha Actual: ").append(fechaActual.imprimir()).append("\n\n");
        tabla.append("NOMBRE COMPLETO           FECHA DE NACIMIENTO           EDAD\n");

        int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de personas: "));

        for (int i = 1; i <= n; i++) {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la persona " + i);
            String diaNacimientoStr = JOptionPane.showInputDialog("Ingrese el día de nacimiento de " + nombre);
            String mesNacimientoStr = JOptionPane.showInputDialog("Ingrese el mes de nacimiento de " + nombre);
            String añoNacimientoStr = JOptionPane.showInputDialog("Ingrese el año de nacimiento de " + nombre);

            int diaNacimiento = Integer.parseInt(diaNacimientoStr);
            int mesNacimiento = Integer.parseInt(mesNacimientoStr);
            int añoNacimiento = Integer.parseInt(añoNacimientoStr);

            Fecha fechaNacimiento = new Fecha();
            fechaNacimiento.asignarFecha(diaNacimiento, mesNacimiento, añoNacimiento);
            Persona persona = new Persona(nombre, fechaNacimiento, fechaActual);

            tabla.append(persona.toString()).append("\n");
        }

        JTextArea areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        areaTexto.setText(tabla.toString());
        JOptionPane.showMessageDialog(null, areaTexto);

        System.exit(0);
    }
}
