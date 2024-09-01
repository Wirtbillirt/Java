import javax.swing.*;

public class Telefonica {

    public static void main(String[] args) {
        int tam = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número máximo de clientes:"));
        String[] nombres = new String[tam];
        String[] telefonos = new String[tam];
        double[] saldos = new double[tam];
        boolean[] morosos = new boolean[tam];

        int opc, n = -1;

        do {
            opc = Integer.parseInt(JOptionPane.showInputDialog(
                    "Control de Clientes\n1. Dar de Alta\n2. Modificar Estado Moroso\n3. Dar de Baja\n4. Listar un Cliente\n5. Listar Todos los Clientes\n6. Salir"));

            switch (opc) {
                case 1:
                    n = darDeAlta(nombres, telefonos, saldos, morosos, n, tam);
                    break;

                case 2:
                    modificarMorosidad(nombres, morosos, n);
                    break;

                case 3:
                    n = darDeBaja(nombres, telefonos, saldos, morosos, n);
                    break;

                case 4:
                    listarCliente(nombres, telefonos, saldos, morosos, n);
                    break;

                case 5:
                    listarTodos(nombres, telefonos, saldos, morosos, n);
                    break;

                case 6:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Intente nuevamente.");
            }

        } while (opc != 6);

        System.exit(0);
    }

    public static int darDeAlta(String[] nombres, String[] telefonos, double[] saldos, boolean[] morosos, int n, int tam) {
        if (n < (tam - 1)) {
            n++;
            nombres[n] = JOptionPane.showInputDialog("Ingrese el nombre completo del cliente:");
            telefonos[n] = JOptionPane.showInputDialog("Ingrese el teléfono del cliente:");
            saldos[n] = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el saldo del cliente:"));
            int moroso = JOptionPane.showConfirmDialog(null, "¿El cliente es moroso?", "Estado Moroso", JOptionPane.YES_NO_OPTION);
            morosos[n] = (moroso == JOptionPane.YES_OPTION);
        } else {
            JOptionPane.showMessageDialog(null, "No hay espacio para más clientes.");
        }
        return n;
    }

    public static void modificarMorosidad(String[] nombres, boolean[] morosos, int n) {
        if (n >= 0) {
            String nombreModificar = JOptionPane.showInputDialog("Ingrese el nombre del cliente para modificar el estado moroso:");

            int i = 0;
            while (i <= n && !nombreModificar.equalsIgnoreCase(nombres[i])) {
                i++;
            }

            if (i > n) {
                JOptionPane.showMessageDialog(null, nombreModificar + " no se encuentra en el registro.");
            } else {
                int moroso = JOptionPane.showConfirmDialog(null, "¿El cliente es moroso?", "Modificar Estado Moroso", JOptionPane.YES_NO_OPTION);
                morosos[i] = (moroso == JOptionPane.YES_OPTION);
                JOptionPane.showMessageDialog(null, "Estado moroso del cliente modificado exitosamente.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay clientes registrados.");
        }
    }

    public static int darDeBaja(String[] nombres, String[] telefonos, double[] saldos, boolean[] morosos, int n) {
        if (n >= 0) {
            String nombreBaja = JOptionPane.showInputDialog("Ingrese el nombre del cliente a dar de baja:");

            int i = 0;
            while (i <= n && !nombreBaja.equalsIgnoreCase(nombres[i])) {
                i++;
            }

            if (i > n) {
                JOptionPane.showMessageDialog(null, nombreBaja + " no se encuentra en el registro.");
            } else {
                for (int k = i; k < n; k++) {
                    nombres[k] = nombres[k + 1];
                    telefonos[k] = telefonos[k + 1];
                    saldos[k] = saldos[k + 1];
                    morosos[k] = morosos[k + 1];
                }
                n--;
                JOptionPane.showMessageDialog(null, "Cliente dado de baja exitosamente.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay clientes registrados.");
        }
        return n;
    }

    public static void listarCliente(String[] nombres, String[] telefonos, double[] saldos, boolean[] morosos, int n) {
        if (n >= 0) {
            String nombreListar = JOptionPane.showInputDialog("Ingrese el nombre del cliente a listar:");

            int i = 0;
            while (i <= n && !nombreListar.equalsIgnoreCase(nombres[i])) {
                i++;
            }

            if (i > n) {
                JOptionPane.showMessageDialog(null, nombreListar + " no se encuentra en el registro.");
            } else {
                String salida = "Nombre: " + nombres[i] + "\n"
                        + "Teléfono: " + telefonos[i] + "\n"
                        + "Saldo: " + saldos[i] + "\n"
                        + "Moroso: " + (morosos[i] ? "Sí" : "No");
                JOptionPane.showMessageDialog(null, salida, "Información del Cliente", JOptionPane.PLAIN_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay clientes registrados.");
        }
    }

    public static void listarTodos(String[] nombres, String[] telefonos, double[] saldos, boolean[] morosos, int n) {
        if (n >= 0) {
            String salida = "Nombre\t\tTeléfono\t\tSaldo\t\tMoroso\n";
            for (int i = 0; i <= n; i++) {
                salida += nombres[i] + "\t\t" + telefonos[i] + "\t\t" + saldos[i] + "\t\t" + (morosos[i] ? "Sí" : "No") + "\n";
            }

            JTextArea areaTexto = new JTextArea(salida);
            areaTexto.setEditable(false);
            JOptionPane.showMessageDialog(null, areaTexto, "Listado de Clientes", JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No hay clientes registrados.");
        }
    }
}
