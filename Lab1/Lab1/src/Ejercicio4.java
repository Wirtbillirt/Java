import javax.swing.JOptionPane;

public class Ejercicio4 {

    public static void main(String[] args) {

        int pedro = obtenerEdad("Ingrese la edad de Pedro:");
        if (pedro == -1) {
            JOptionPane.showMessageDialog(null, "Operación cancelada");
            return;
        }

        int juan = obtenerEdad("Ingrese la edad de Juan:");
        if (juan == -1) {
            JOptionPane.showMessageDialog(null, "Operación cancelada");
            return;
        }

        int mario = obtenerEdad("Ingrese la edad de Mario:");
        if (mario == -1) {
            JOptionPane.showMessageDialog(null, "Operación cancelada");
            return;
        }

        if (pedro == juan && pedro == mario && juan == mario) {
            JOptionPane.showMessageDialog(null, "Todos tienen la misma edad");
        } else if (pedro > juan && pedro > mario) {
            JOptionPane.showMessageDialog(null, "Pedro es el mayor");
        } else if (juan > mario) {
            JOptionPane.showMessageDialog(null, "Juan es el mayor");
        } else {
            JOptionPane.showMessageDialog(null, "Mario es el mayor");
        }
    }

    private static int obtenerEdad(String mensaje) {
        int edad = 0;
        boolean edadValida = false;
        while (!edadValida) {
            String input = JOptionPane.showInputDialog(mensaje);
            if (input == null) {
                return -1;
            }
            try {
                edad = Integer.parseInt(input);
                if (edad < 0) {
                    JOptionPane.showMessageDialog(null, "Error: Ingrese un número entero positivo.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    edadValida = true;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Ingrese un número entero válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return edad;
    }
}

