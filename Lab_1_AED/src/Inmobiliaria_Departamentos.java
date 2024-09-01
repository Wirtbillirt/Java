import javax.swing.*;

public class Inmobiliaria_Departamentos {
    public static void main(String[] args) {
        int tam = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño del arreglo"));
        
        String ubicacion[] = new String[tam];
        int extension[] = new int[tam];
        double precio[] = new double[tam];
        int opc, n = -1;

        do {
            opc = Integer.parseInt(JOptionPane.showInputDialog("Control de Departamentos Rentados \n 1. Dar de Alta a un departamento \n" +
                                                               " 2. Dar de Baja a un departamento \n 3. Modificar el precio de un departamento \n" +
                                                               " 4. Listar los datos de un departamento \n 5. Listar todos los registros \n 6. Salir"));

            switch (opc) {
                case 1: n = InsertaO(ubicacion, extension, precio, n, tam); break;
                case 2: n = EliminaO(ubicacion, extension, precio, n); break;
                case 3: ModificaO(ubicacion, extension, precio, n); break;
                case 4: ImprimirUno(ubicacion, extension, precio, n); break;
                case 5: ImprimirTodos(ubicacion, extension, precio, n); break;
                case 6: break;
                default: JOptionPane.showMessageDialog(null, "Opción Inválida");
            }
        } while (opc != 6);

        System.exit(0);
    }

    public static int InsertaO(String ubicacion[], int extension[], double precio[], int n, int tam) {
        if (n == -1) {
            n++;
            ubicacion[n] = JOptionPane.showInputDialog("Ingrese la ubicación del departamento");
            extension[n] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la extensión del departamento en m²"));
            precio[n] = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del departamento"));
        } else if (n < (tam - 1)) {
            int extNueva = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la extensión del nuevo departamento en m²"));
            int pos = Busca(extension, extNueva, n);
            if (pos >= 0) {
                JOptionPane.showMessageDialog(null, "Ya existe un departamento con esa extensión");
            } else {
                n++;
                pos = pos * (-1);
                for (int i = n; i >= (pos + 1); i--) {
                    ubicacion[i] = ubicacion[i - 1];
                    extension[i] = extension[i - 1];
                    precio[i] = precio[i - 1];
                }
                ubicacion[pos] = JOptionPane.showInputDialog("Ingrese la ubicación del nuevo departamento");
                extension[pos] = extNueva;
                precio[pos] = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del nuevo departamento"));
                JOptionPane.showMessageDialog(null, "Departamento agregado exitosamente");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay espacio en el arreglo");
        }
        return n;
    }

    public static int EliminaO(String ubicacion[], int extension[], double precio[], int n) {
        if (n > -1) {
            int extBuscar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la extensión del departamento a eliminar en m²"));
            int pos = Busca(extension, extBuscar, n);
            if (pos < 0) {
                JOptionPane.showMessageDialog(null, "No existe un departamento con esa extensión");
            } else {
                for (int i = pos; i < n; i++) {
                    ubicacion[i] = ubicacion[i + 1];
                    extension[i] = extension[i + 1];
                    precio[i] = precio[i + 1];
                }
                n--;
                JOptionPane.showMessageDialog(null, "Departamento eliminado exitosamente");
            }
        } else {
            JOptionPane.showMessageDialog(null, "El arreglo está vacío");
        }
        return n;
    }

    public static void ModificaO(String ubicacion[], int extension[], double precio[], int n) {
        if (n > -1) {
            int extBuscar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la extensión del departamento a modificar en m²"));
            int pos = Busca(extension, extBuscar, n);
            if (pos < 0) {
                JOptionPane.showMessageDialog(null, "No existe un departamento con esa extensión");
            } else {
                precio[pos] = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el nuevo precio del departamento"));
                JOptionPane.showMessageDialog(null, "Precio del departamento modificado exitosamente");
            }
        } else {
            JOptionPane.showMessageDialog(null, "El arreglo está vacío");
        }
    }

    public static void ImprimirUno(String ubicacion[], int extension[], double precio[], int n) {
        if (n > -1) {
            int extBuscar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la extensión del departamento a listar en m²"));
            int pos = Busca(extension, extBuscar, n);
            if (pos < 0) {
                JOptionPane.showMessageDialog(null, "No existe un departamento con esa extensión");
            } else {
                JOptionPane.showMessageDialog(null, "Ubicación: " + ubicacion[pos] + "\nExtensión: " + extension[pos] + " m²\nPrecio: " + precio[pos]);
            }
        } else {
            JOptionPane.showMessageDialog(null, "El arreglo está vacío");
        }
    }

    public static void ImprimirTodos(String ubicacion[], int extension[], double precio[], int n) {
        if (n > -1) {
            StringBuilder sal = new StringBuilder("Ubicación \t Extensión (m²) \t Precio \n");
            for (int i = 0; i <= n; i++) {
                sal.append(ubicacion[i]).append("\t").append(extension[i]).append(" m² \t").append(precio[i]).append("\n");
            }
            JTextArea imp = new JTextArea();
            imp.setText(sal.toString());
            imp.setEditable(false);
            JOptionPane.showMessageDialog(null, imp);
        } else {
            JOptionPane.showMessageDialog(null, "El arreglo está vacío");
        }
    }

    public static int Busca(int extension[], int extBuscar, int n) {
        int i = 0;
        while (i <= n && extension[i] < extBuscar) {
            i++;
        }
        if (i > n || extension[i] > extBuscar) {
            return -i;
        } else {
            return i;
        }
    }
}
