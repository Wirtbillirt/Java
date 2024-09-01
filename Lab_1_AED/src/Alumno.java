import javax.swing.*;

public class Alumno {

    public static void main(String[] args) {
        int tam = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número máximo de alumnos:"));
        String[] nombres = new String[tam];
        int[] semestres = new int[tam];
        double[] promedios = new double[tam];

        int opc, n = -1;

        do {
            opc = Integer.parseInt(JOptionPane.showInputDialog(
                    "Control de Alumnos\n1. Dar de Alta\n2. Dar de Baja\n3. Modificar número de semestres y promedio\n4. Listar un alumno\n5. Listar todos los registros\n6. Salir"));

            switch (opc) {
                case 1:
                    n = darDeAlta(nombres, semestres, promedios, n, tam);
                    break;

                case 2:
                    n = darDeBaja(nombres, semestres, promedios, n);
                    break;

                case 3:
                    modificarAlumno(nombres, semestres, promedios, n);
                    break;

                case 4:
                    listarAlumno(nombres, semestres, promedios, n);
                    break;

                case 5:
                    listarTodos(nombres, semestres, promedios, n);
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

    public static int darDeAlta(String[] nombres, int[] semestres, double[] promedios, int n, int tam) {
        if (n < (tam - 1)) {
            n++;
            nombres[n] = JOptionPane.showInputDialog("Ingrese el nombre completo del alumno:");
            semestres[n] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de semestres cursados:"));
            promedios[n] = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la calificación promedio total:"));
        } else {
            JOptionPane.showMessageDialog(null, "No hay espacio para más alumnos.");
        }
        return n;
    }

    public static int darDeBaja(String[] nombres, int[] semestres, double[] promedios, int n) {
        if (n >= 0) {
            String nombreBaja = JOptionPane.showInputDialog("Ingrese el nombre del alumno a dar de baja:");

            int i = 0;
            while (i <= n && !nombreBaja.equalsIgnoreCase(nombres[i])) {
                i++;
            }

            if (i > n) {
                JOptionPane.showMessageDialog(null, nombreBaja + " no se encuentra en el registro.");
            } else {
                for (int k = i; k < n; k++) {
                    nombres[k] = nombres[k + 1];
                    semestres[k] = semestres[k + 1];
                    promedios[k] = promedios[k + 1];
                }
                n--;
                JOptionPane.showMessageDialog(null, "Alumno dado de baja exitosamente.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay alumnos registrados.");
        }
        return n;
    }

    public static void modificarAlumno(String[] nombres, int[] semestres, double[] promedios, int n) {
        if (n >= 0) {
            String nombreModificar = JOptionPane.showInputDialog("Ingrese el nombre del alumno a modificar:");

            int i = 0;
            while (i <= n && !nombreModificar.equalsIgnoreCase(nombres[i])) {
                i++;
            }

            if (i > n) {
                JOptionPane.showMessageDialog(null, nombreModificar + " no se encuentra en el registro.");
            } else {
                semestres[i] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo número de semestres cursados:"));
                promedios[i] = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el nuevo promedio total:"));
                JOptionPane.showMessageDialog(null, "Datos del alumno modificados exitosamente.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay alumnos registrados.");
        }
    }

    public static void listarAlumno(String[] nombres, int[] semestres, double[] promedios, int n) {
        if (n >= 0) {
            String nombreListar = JOptionPane.showInputDialog("Ingrese el nombre del alumno a listar:");

            int i = 0;
            while (i <= n && !nombreListar.equalsIgnoreCase(nombres[i])) {
                i++;
            }

            if (i > n) {
                JOptionPane.showMessageDialog(null, nombreListar + " no se encuentra en el registro.");
            } else {
                String salida = "Nombre: " + nombres[i] + "\n"
                        + "Semestres cursados: " + semestres[i] + "\n"
                        + "Promedio total: " + promedios[i];
                JOptionPane.showMessageDialog(null, salida, "Información del Alumno", JOptionPane.PLAIN_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay alumnos registrados.");
        }
    }

    public static void listarTodos(String[] nombres, int[] semestres, double[] promedios, int n) {
        if (n >= 0) {
            String salida = "Nombre del alumno\tSemestres cursados\tPromedio total\n";
            for (int i = 0; i <= n; i++) {
                salida += nombres[i] + "\t" + semestres[i] + "\t" + promedios[i] + "\n";
            }

            JTextArea areaTexto = new JTextArea(salida);
            areaTexto.setEditable(false);
            JOptionPane.showMessageDialog(null, areaTexto, "Listado de Alumnos", JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No hay alumnos registrados.");
        }
    }
}



