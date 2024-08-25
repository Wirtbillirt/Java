import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class AED_Exercise1 {
    public static void main(String[] args) {
        int tam = Integer.parseInt(JOptionPane.showInputDialog("Tamaño del registro de docentes:"));
        String[] nombres = new String[tam];
        String[] direcciones = new String[tam];
        String[] documentos = new String[tam];
        int contador = 0;

        int opcion;

        do {
            opcion = mostrarMenu();
            contador = ejecutarOpcion(opcion, nombres, direcciones, documentos, contador, tam);
        } while (opcion != 5);
    }

    public static int mostrarMenu() {
        return Integer.parseInt(JOptionPane.showInputDialog(
                "Control de Docentes\n" +
                "1. Registrar docente\n" +
                "2. Eliminar docente\n" +
                "3. Modificar dirección\n" +
                "4. Imprimir registros\n" +
                "5. Salir"));
    }

    public static int ejecutarOpcion(int opcion, String[] nombres, String[] direcciones, String[] documentos, int contador, int tam) {
        if (opcion == 1) {
            return registrarDocente(nombres, direcciones, documentos, contador, tam);
        } else if (opcion == 2) {
            return eliminarDocente(nombres, direcciones, documentos, contador);
        } else if (opcion == 3) {
            modificarDireccion(nombres, direcciones, documentos, contador);
        } else if (opcion == 4) {
            imprimirDocentes(nombres, direcciones, documentos, contador);
        } else if (opcion == 5) {
            JOptionPane.showMessageDialog(null, "Saliendo del programa...");
        } else {
            JOptionPane.showMessageDialog(null, "Opción inválida. Intente nuevamente.");
        }
        return contador;
    }

    public static int registrarDocente(String[] nombres, String[] direcciones, String[] documentos, int contador, int tam) {
        if (contador < tam) {
            nombres[contador] = JOptionPane.showInputDialog("Nombre del docente:");
            direcciones[contador] = JOptionPane.showInputDialog("Dirección del docente:");
            documentos[contador] = JOptionPane.showInputDialog("Número de documento del docente:");
            JOptionPane.showMessageDialog(null, "Docente registrado exitosamente.");
            contador++;
        } else {
            JOptionPane.showMessageDialog(null, "Registro completo. No se pueden agregar más docentes.");
        }
        return contador;
    }

    public static int eliminarDocente(String[] nombres, String[] direcciones, String[] documentos, int contador) {
        if (contador > 0) {
            String docAEliminar = JOptionPane.showInputDialog("Número de documento del docente a eliminar:");

            int i = 0;
            while (i < contador && !documentos[i].equals(docAEliminar)) {
                i++;
            }

            if (i < contador) {
                for (int j = i; j < contador - 1; j++) {
                    nombres[j] = nombres[j + 1];
                    direcciones[j] = direcciones[j + 1];
                    documentos[j] = documentos[j + 1];
                }
                JOptionPane.showMessageDialog(null, "Docente eliminado exitosamente.");
                contador--;
            } else {
                JOptionPane.showMessageDialog(null, "Docente no encontrado.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay docentes registrados para eliminar.");
        }
        return contador;
    }

    public static void modificarDireccion(String[] nombres, String[] direcciones, String[] documentos, int contador) {
        if (contador > 0) {
            String docAModificar = JOptionPane.showInputDialog("Número de documento del docente a modificar:");

            int i = 0;
            while (i < contador && !documentos[i].equals(docAModificar)) {
                i++;
            }

            if (i < contador) {
                direcciones[i] = JOptionPane.showInputDialog("Nueva dirección:");
                JOptionPane.showMessageDialog(null, "Dirección modificada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Docente no encontrado.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay docentes registrados para modificar.");
        }
    }

    public static void imprimirDocentes(String[] nombres, String[] direcciones, String[] documentos, int contador) {
        if (contador > 0) {
            StringBuilder registros = new StringBuilder();
            for (int i = 0; i < contador; i++) {
                registros.append("Docente ").append(i + 1).append("\n");
                registros.append("Nombre: ").append(nombres[i]).append("\n");
                registros.append("Dirección: ").append(direcciones[i]).append("\n");
                registros.append("Documento: ").append(documentos[i]).append("\n\n");
            }
            JTextArea areaDeTexto = new JTextArea(registros.toString());
            areaDeTexto.setEditable(false);
            JOptionPane.showMessageDialog(null, areaDeTexto, "Registros de Docentes", JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No hay docentes registrados para imprimir.");
        }
    }
}


