import javax.swing.*;

public class Vendedores {
    public static void main(String[] args) {
        int tam = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño del arreglo"));

        String[] nombres = new String[tam];
        double[] ventas = new double[tam];
        int opc, n = -1;

        do {
            opc = Integer.parseInt(JOptionPane.showInputDialog("Control de Vendedores\n1. Dar de Alta a un Vendedor\n" +
                                                               "2. Modificar el Total de Ventas\n" +
                                                               "3. Imprimir el Registro de un Vendedor\n4. Salir"));

            switch (opc) {
                case 1: n = insertarVendedor(nombres, ventas, n, tam); break;
                case 2: modificarVentas(nombres, ventas, n); break;
                case 3: imprimirVendedor(nombres, ventas, n); break;
                case 4: break;
                default: JOptionPane.showMessageDialog(null, "Opción Inválida");
            }
        } while (opc != 4);

        System.exit(0);
    }

    public static int insertarVendedor(String[] nombres, double[] ventas, int n, int tam) {
        if (n < tam - 1) {
            String nombreNuevo = JOptionPane.showInputDialog("Ingrese el nombre del nuevo vendedor");
            int pos = buscarPosicion(nombres, nombreNuevo, n);

            if (pos >= 0) {
                JOptionPane.showMessageDialog(null, "Ya existe un vendedor con ese nombre");
            } else {
                n++;
                pos = pos * (-1);
                for (int i = n; i >= (pos + 1); i--) {
                    nombres[i] = nombres[i - 1];
                    ventas[i] = ventas[i - 1];
                }
                nombres[pos] = nombreNuevo;
                ventas[pos] = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el total de ventas del nuevo vendedor"));
                JOptionPane.showMessageDialog(null, "Vendedor agregado exitosamente");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay espacio en el arreglo");
        }
        return n;
    }

    public static void modificarVentas(String[] nombres, double[] ventas, int n) {
        if (n > -1) {
            String nombreBuscar = JOptionPane.showInputDialog("Ingrese el nombre del vendedor");
            int pos = buscarPosicion(nombres, nombreBuscar, n);

            if (pos < 0) {
                JOptionPane.showMessageDialog(null, "No existe un vendedor con ese nombre");
            } else {
                ventas[pos] = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el nuevo total de ventas"));
                JOptionPane.showMessageDialog(null, "Ventas del vendedor modificadas exitosamente");
            }
        } else {
            JOptionPane.showMessageDialog(null, "El arreglo está vacío");
        }
    }

    public static void imprimirVendedor(String[] nombres, double[] ventas, int n) {
        if (n > -1) {
            String nombreBuscar = JOptionPane.showInputDialog("Ingrese el nombre del vendedor a imprimir");
            int pos = buscarPosicion(nombres, nombreBuscar, n);

            if (pos < 0) {
                JOptionPane.showMessageDialog(null, "No existe un vendedor con ese nombre");
            } else {
                JOptionPane.showMessageDialog(null, "Nombre: " + nombres[pos] + "\nTotal de Ventas: " + ventas[pos]);
            }
        } else {
            JOptionPane.showMessageDialog(null, "El arreglo está vacío");
        }
    }

    public static int buscarPosicion(String[] nombres, String nombreBuscar, int n) {
        int i = 0;
        while (i <= n && nombres[i].compareToIgnoreCase(nombreBuscar) < 0) {
            i++;
        }
        if (i > n || !nombres[i].equalsIgnoreCase(nombreBuscar)) {
            return -i;
        } else {
            return i;
        }
    }
}
