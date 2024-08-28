import javax.swing.*;

public class inmobiliario {

    public static void main(String[] args) {
        int tam = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de departamentos:"));
        int[] extension = new int[tam];
        double[] precio = new double[tam];

        int opc, n = -1;

        do {
            opc = Integer.parseInt(JOptionPane.showInputDialog("Inmobiliaria\n1. Dar de Baja (Rentar Departamento)\n2. Insertar Departamento\n3. Modificar Precio\n4. Mostrar Departamentos\n5. Salir"));

            switch (opc) {
                case 1:
                    n = rentarDepartamento(extension, precio, n);
                    break;
                case 2:
                    n = insertarDepartamento(extension, precio, n, tam);
                    break;
                case 3:
                    modificarPrecio(extension, precio, n);
                    break;
                case 4:
                    mostrarDepartamentos(extension, precio, n);
                    break;
                case 5:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
            }

        } while (opc != 5);

        System.exit(0);
    }

    public static int rentarDepartamento(int[] extension, double[] precio, int n) {
        if (n >= 0) {
            int depARentar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la extensión del departamento a rentar:"));
            int i = 0;
            while (i <= n && extension[i] != depARentar) {
                i++;
            }

            if (i <= n) {
                for (int k = i; k < n; k++) {
                    extension[k] = extension[k + 1];
                    precio[k] = precio[k + 1];
                }
                JOptionPane.showMessageDialog(null, "Departamento rentado y dado de baja del sistema.");
                n--;
            } else {
                JOptionPane.showMessageDialog(null, "Departamento no encontrado.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay departamentos registrados.");
        }
        return n;
    }

    public static int insertarDepartamento(int[] extension, double[] precio, int n, int tam) {
        if (n < (tam - 1)) {
            n++;
            extension[n] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la extensión (m²) del departamento:"));
            precio[n] = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del departamento:"));
        } else {
            JOptionPane.showMessageDialog(null, "No hay espacio para registrar más departamentos.");
        }
        return n;
    }

    public static void modificarPrecio(int[] extension, double[] precio, int n) {
        if (n >= 0) {
            int depAModificar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la extensión del departamento para modificar el precio:"));
            int i = 0;
            while (i <= n && extension[i] != depAModificar) {
                i++;
            }

            if (i <= n) {
                precio[i] = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el nuevo precio del departamento:"));
                JOptionPane.showMessageDialog(null, "Precio modificado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Departamento no encontrado.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay departamentos registrados.");
        }
    }

    public static void mostrarDepartamentos(int[] extension, double[] precio, int n) {
        if (n >= 0) {
            String salida = "Extensión (m²)\tPrecio ($)\n";
            for (int i = 0; i <= n; i++) {
                salida += extension[i] + "\t" + precio[i] + "\n";
            }
            JTextArea areaDeTexto = new JTextArea(salida);
            areaDeTexto.setEditable(false);
            JOptionPane.showMessageDialog(null, areaDeTexto, "Listado de Departamentos", JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No hay departamentos registrados.");
        }
    }
}
