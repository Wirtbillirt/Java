import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class Ejercicio8 {

    public static void main(String[] args) {
        int pesoLibras = obtenerEntero("Ingrese el peso en libras:");
        if (pesoLibras == -1) {
            return;
        }

        double pesoKg = pesoLibras * 0.453592;

        DecimalFormat formato = new DecimalFormat("#.##");
        JOptionPane.showMessageDialog(null, String.format("Peso en libras: %d\nPeso en kilogramos: %s", pesoLibras, formato.format(pesoKg)));
    }

    private static int obtenerEntero(String mensaje) {
        int numero = 0;
        boolean numeroValido = false;
        while (!numeroValido) {
            String input = JOptionPane.showInputDialog(mensaje);
            if (input == null) {
                return -1;
            }
            try {
                numero = Integer.parseInt(input);
                if (numero < 0) {
                    JOptionPane.showMessageDialog(null, "Error: Ingrese un número positivo.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    numeroValido = true;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Ingrese un número entero válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return numero;
    }
}
