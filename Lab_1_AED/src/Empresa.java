import javax.swing.*;

public class Empresa {
    public static void main(String[] args) {
        int tam = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño del arreglo"));

        String[] nombre = new String[tam];
        String[] direccion = new String[tam];
        int[] edad = new int[tam];
        String[] sexo = new String[tam];
        int[] antiguedad = new int[tam];
        int opc, n = -1;

        do {
            opc = Integer.parseInt(JOptionPane.showInputDialog("Control de Empleados \n 1. Listar todos los empleados \n" +
                    " 2. Dar de Alta a un empleado \n 3. Dar de Baja a un empleado \n" +
                    " 4. Modificar los años de antigüedad de un empleado \n" +
                    " 5. Listar los datos de un empleado determinado \n 6. Salir"));

            switch (opc) {
                case 1:
                    listarTodos(nombre, direccion, edad, sexo, antiguedad, n);
                    break;

                case 2:
                    n = darAlta(nombre, direccion, edad, sexo, antiguedad, n, tam);
                    break;

                case 3:
                    n = darBaja(nombre, direccion, edad, sexo, antiguedad, n);
                    break;

                case 4:
                    modificarAntiguedad(nombre, antiguedad, n);
                    break;

                case 5:
                    listarUno(nombre, direccion, edad, sexo, antiguedad, n);
                    break;

                case 6:
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción Invalida");
            }
        } while (opc != 6);

        System.exit(0);
    }

    public static void listarTodos(String[] nombre, String[] direccion, int[] edad, String[] sexo, int[] antiguedad, int n) {
        String salida = "Nombre\tDirección\tEdad\tSexo\tAntigüedad\n";

        for (int i = 0; i <= n; i++) {
            salida += nombre[i] + "\t" + direccion[i] + "\t" + edad[i] + "\t" + sexo[i] + "\t" + antiguedad[i] + "\n";
        }

        JTextArea textArea = new JTextArea(salida);
        textArea.setEditable(false);
        JOptionPane.showMessageDialog(null, textArea);
    }

    public static int darAlta(String[] nombre, String[] direccion, int[] edad, String[] sexo, int[] antiguedad, int n, int tam) {
        if (n < tam - 1) {
            String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nombre del empleado");
            int pos = buscar(nombre, nuevoNombre, n);

            if (pos >= 0 && nuevoNombre.equalsIgnoreCase(nombre[pos])) {
                JOptionPane.showMessageDialog(null, nuevoNombre + " ya existe.");
            } else {
                n = n + 1;
                pos = pos * -1;

                for (int i = n; i > pos; i--) {
                    nombre[i] = nombre[i - 1];
                    direccion[i] = direccion[i - 1];
                    edad[i] = edad[i - 1];
                    sexo[i] = sexo[i - 1];
                    antiguedad[i] = antiguedad[i - 1];
                }

                nombre[pos] = nuevoNombre;
                direccion[pos] = JOptionPane.showInputDialog("Ingrese la dirección del empleado");
                edad[pos] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del empleado"));
                sexo[pos] = JOptionPane.showInputDialog("Ingrese el sexo del empleado (M/F)");
                antiguedad[pos] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese los años de antigüedad del empleado"));

                JOptionPane.showMessageDialog(null, "Alta realizada con éxito.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay espacio en el arreglo.");
        }

        return n;
    }

    public static int darBaja(String[] nombre, String[] direccion, int[] edad, String[] sexo, int[] antiguedad, int n) {
        if (n > -1) {
            String nomBaja = JOptionPane.showInputDialog("Ingrese el nombre del empleado a eliminar");
            int pos = buscar(nombre, nomBaja, n);

            if (pos < 0) {
                JOptionPane.showMessageDialog(null, nomBaja + " no existe.");
            } else {
                for (int i = pos; i < n; i++) {
                    nombre[i] = nombre[i + 1];
                    direccion[i] = direccion[i + 1];
                    edad[i] = edad[i + 1];
                    sexo[i] = sexo[i + 1];
                    antiguedad[i] = antiguedad[i + 1];
                }
                n = n - 1;
                JOptionPane.showMessageDialog(null, "Empleado eliminado con éxito.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay empleados registrados.");
        }

        return n;
    }

    public static void modificarAntiguedad(String[] nombre, int[] antiguedad, int n) {
        if (n > -1) {
            String nomBusca = JOptionPane.showInputDialog("Ingrese el nombre del empleado a modificar");
            int pos = buscar(nombre, nomBusca, n);

            if (pos < 0) {
                JOptionPane.showMessageDialog(null, nomBusca + " no existe.");
            } else {
                antiguedad[pos] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese los nuevos años de antigüedad para el empleado " + nombre[pos]));
                JOptionPane.showMessageDialog(null, "Antigüedad modificada con éxito.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay empleados registrados.");
        }
    }

    public static void listarUno(String[] nombre, String[] direccion, int[] edad, String[] sexo, int[] antiguedad, int n) {
        if (n > -1) {
            String nomBusca = JOptionPane.showInputDialog("Ingrese el nombre del empleado a buscar");
            int pos = buscar(nombre, nomBusca, n);

            if (pos < 0) {
                JOptionPane.showMessageDialog(null, nomBusca + " no existe.");
            } else {
                JOptionPane.showMessageDialog(null, "Nombre: " + nombre[pos] + "\nDirección: " + direccion[pos] + "\nEdad: " + edad[pos] +
                        "\nSexo: " + sexo[pos] + "\nAntigüedad: " + antiguedad[pos]);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay empleados registrados.");
        }
    }

    public static int buscar(String[] nombre, String nomBusca, int n) {
        int i = 0;
        while ((i <= n) && (nombre[i].compareTo(nomBusca) < 0)) {
            i++;
        }

        if ((i > n) || (nombre[i].compareTo(nomBusca) > 0)) {
            return -i;
        } else {
            return i;
        }
    }
}
