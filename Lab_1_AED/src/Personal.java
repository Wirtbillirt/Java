import javax.swing.*;

public class Personal {

    public static void main(String[] args) {
        int tam = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número máximo de empleados:"));
        String[] nombres = new String[tam];
        String[] sexos = new String[tam];
        int[] edades = new int[tam];

        int opc, n = -1;

        do {
            opc = Integer.parseInt(JOptionPane.showInputDialog(
                    "Departamento de Personal\n1. Dar de Alta\n2. Dar de Baja\n3. Actualizar Edad\n4. Imprimir Varones\n5. Imprimir Empleado\n6. Salir"));

            switch (opc) {
                case 1:
                    n = darDeAlta(nombres, sexos, edades, n, tam);
                    break;

                case 2:
                    n = darDeBaja(nombres, sexos, edades, n);
                    break;

                case 3:
                    actualizarEdad(nombres, edades, n);
                    break;

                case 4:
                    imprimirVarones(nombres, sexos, edades, n);
                    break;

                case 5:
                    imprimirEmpleado(nombres, sexos, edades, n);
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

    public static int darDeAlta(String[] nombres, String[] sexos, int[] edades, int n, int tam) {
        if (n < (tam - 1)) {
            n++;
            nombres[n] = JOptionPane.showInputDialog("Ingrese el nombre del empleado:");
            sexos[n] = JOptionPane.showInputDialog("Ingrese el sexo del empleado (M/F):");
            edades[n] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del empleado:"));
        } else {
            JOptionPane.showMessageDialog(null, "No hay espacio para más empleados.");
        }
        return n;
    }

    public static int darDeBaja(String[] nombres, String[] sexos, int[] edades, int n) {
        if (n >= 0) {
            String nombreBaja = JOptionPane.showInputDialog("Ingrese el nombre del empleado a dar de baja:");

            int i = 0;
            while (i <= n && !nombreBaja.equalsIgnoreCase(nombres[i])) {
                i++;
            }

            if (i > n) {
                JOptionPane.showMessageDialog(null, nombreBaja + " no se encuentra en el registro.");
            } else {
                for (int k = i; k < n; k++) {
                    nombres[k] = nombres[k + 1];
                    sexos[k] = sexos[k + 1];
                    edades[k] = edades[k + 1];
                }
                n--;
                JOptionPane.showMessageDialog(null, "Empleado dado de baja exitosamente.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay empleados registrados.");
        }
        return n;
    }

    public static void actualizarEdad(String[] nombres, int[] edades, int n) {
        if (n >= 0) {
            String nombreActualizar = JOptionPane.showInputDialog("Ingrese el nombre del empleado para actualizar la edad:");

            int i = 0;
            while (i <= n && !nombreActualizar.equalsIgnoreCase(nombres[i])) {
                i++;
            }

            if (i > n) {
                JOptionPane.showMessageDialog(null, nombreActualizar + " no se encuentra en el registro.");
            } else {
                edades[i] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva edad del empleado:"));
                JOptionPane.showMessageDialog(null, "Edad del empleado actualizada exitosamente.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay empleados registrados.");
        }
    }

    public static void imprimirVarones(String[] nombres, String[] sexos, int[] edades, int n) {
        if (n >= 0) {
            String salida = "Nombre\t\tSexo\t\tEdad\n";
            for (int i = 0; i <= n; i++) {
                if (sexos[i].equalsIgnoreCase("M")) {
                    salida += nombres[i] + "\t\t" + sexos[i] + "\t\t" + edades[i] + "\n";
                }
            }

            JTextArea areaTexto = new JTextArea(salida);
            areaTexto.setEditable(false);
            JOptionPane.showMessageDialog(null, areaTexto, "Lista de Empleados Varones", JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No hay empleados registrados.");
        }
    }

    public static void imprimirEmpleado(String[] nombres, String[] sexos, int[] edades, int n) {
        if (n >= 0) {
            String nombreImprimir = JOptionPane.showInputDialog("Ingrese el nombre del empleado a imprimir:");

            int i = 0;
            while (i <= n && !nombreImprimir.equalsIgnoreCase(nombres[i])) {
                i++;
            }

            if (i > n) {
                JOptionPane.showMessageDialog(null, nombreImprimir + " no se encuentra en el registro.");
            } else {
                String salida = "Nombre: " + nombres[i] + "\n"
                        + "Sexo: " + sexos[i] + "\n"
                        + "Edad: " + edades[i];
                JOptionPane.showMessageDialog(null, salida, "Información del Empleado", JOptionPane.PLAIN_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay empleados registrados.");
        }
    }
}
