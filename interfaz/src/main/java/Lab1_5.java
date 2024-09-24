import javax.swing.*;
import java.awt.*;

public class Lab1_5 extends JFrame {
    private String[] ubicacion;
    private int[] extension;
    private double[] precio;
    private int n = -1; // Número de departamentos registrados
    private int tam;

    private JTextField ubicacionField, extensionField, precioField;
    private JTextField buscarExtensionField, modificarExtensionField, nuevoPrecioField, tamanoField;
    private JTextArea resultadoArea;
    private JButton aceptarButton, altaButton, bajaButton, modificarButton, listarButton, listarUnoButton, volverButton;

    public Lab1_5(ordenado ordenadoFrame) {
        inicializarLab1_5(ordenadoFrame);
    }

    private void inicializarLab1_5(ordenado ordenadoFrame) {
        setTitle("Gestión de Departamentos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panelPrincipal = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Establecer tamaño del arreglo
        JLabel tamanoLabel = new JLabel("Establecer tamaño del arreglo:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelPrincipal.add(tamanoLabel, gbc);

        tamanoField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panelPrincipal.add(tamanoField, gbc);

        aceptarButton = new JButton("Establecer tamaño");
        gbc.gridx = 2;
        gbc.gridy = 0;
        panelPrincipal.add(aceptarButton, gbc);

        // Campos de alta
        JLabel ubicacionLabel = new JLabel("Ubicación:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panelPrincipal.add(ubicacionLabel, gbc);

        ubicacionField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panelPrincipal.add(ubicacionField, gbc);

        JLabel extensionLabel = new JLabel("Extensión (m²):");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panelPrincipal.add(extensionLabel, gbc);

        extensionField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panelPrincipal.add(extensionField, gbc);

        JLabel precioLabel = new JLabel("Precio:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        panelPrincipal.add(precioLabel, gbc);

        precioField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 3;
        panelPrincipal.add(precioField, gbc);

        altaButton = new JButton("Dar de Alta");
        gbc.gridx = 2;
        gbc.gridy = 3;
        panelPrincipal.add(altaButton, gbc);

        // Campos de baja
        JLabel buscarExtensionLabel = new JLabel("Extensión (m²) a eliminar:");
        gbc.gridx = 0;
        gbc.gridy = 4;
        panelPrincipal.add(buscarExtensionLabel, gbc);

        buscarExtensionField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 4;
        panelPrincipal.add(buscarExtensionField, gbc);

        bajaButton = new JButton("Dar de Baja");
        gbc.gridx = 2;
        gbc.gridy = 4;
        panelPrincipal.add(bajaButton, gbc);

        // Modificar precio
        JLabel modificarExtensionLabel = new JLabel("Extensión (m²) a modificar:");
        gbc.gridx = 0;
        gbc.gridy = 5;
        panelPrincipal.add(modificarExtensionLabel, gbc);

        modificarExtensionField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 5;
        panelPrincipal.add(modificarExtensionField, gbc);

        JLabel nuevoPrecioLabel = new JLabel("Nuevo Precio:");
        gbc.gridx = 0;
        gbc.gridy = 6;
        panelPrincipal.add(nuevoPrecioLabel, gbc);

        nuevoPrecioField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 6;
        panelPrincipal.add(nuevoPrecioField, gbc);

        modificarButton = new JButton("Modificar Precio");
        gbc.gridx = 2;
        gbc.gridy = 6;
        panelPrincipal.add(modificarButton, gbc);

        // Buscar departamento
        JLabel buscarUnoLabel = new JLabel("Buscar Departamento (m²):");
        gbc.gridx = 0;
        gbc.gridy = 7;
        panelPrincipal.add(buscarUnoLabel, gbc);

        JTextField buscarDepartamentoField = new JTextField(10); // Campo para ingresar la extensión a buscar
        gbc.gridx = 1;
        gbc.gridy = 7;
        panelPrincipal.add(buscarDepartamentoField, gbc);

        listarUnoButton = new JButton("Buscar Departamento");
        gbc.gridx = 2;
        gbc.gridy = 7;
        panelPrincipal.add(listarUnoButton, gbc);

        // Listar todos los departamentos
        listarButton = new JButton("Listar Departamentos");
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 3;
        panelPrincipal.add(listarButton, gbc);

        // Volver y salir
        volverButton = new JButton("Volver");
        gbc.gridx = 0;
        gbc.gridy = 12;
        gbc.gridwidth = 2;
        panelPrincipal.add(volverButton, gbc);



        // Resultados
        resultadoArea = new JTextArea(10, 40);
        resultadoArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultadoArea);
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 3;
        panelPrincipal.add(scrollPane, gbc);

        // Acciones de botones
        aceptarButton.addActionListener(e -> establecerTamano());
        altaButton.addActionListener(e -> darAlta());
        bajaButton.addActionListener(e -> darBaja());
        modificarButton.addActionListener(e -> modificarPrecio());
        listarButton.addActionListener(e -> listarTodos());
        listarUnoButton.addActionListener(e -> listarUno(buscarDepartamentoField.getText()));
        volverButton.addActionListener(e -> volverAOrdenado(ordenadoFrame));
      

        setContentPane(panelPrincipal);
    }

    private void establecerTamano() {
        try {
            tam = Integer.parseInt(tamanoField.getText());
            if (tam > 0) {
                ubicacion = new String[tam];
                extension = new int[tam];
                precio = new double[tam];
                resultadoArea.append("Tamaño establecido correctamente.\n");
                aceptarButton.setEnabled(false); // Desactivar el botón
            } else {
                resultadoArea.append("El tamaño debe ser mayor que 0.\n");
            }
        } catch (NumberFormatException ex) {
            resultadoArea.append("Ingrese un número válido.\n");
        }
    }

    private void darAlta() {
        if (n < tam - 1) {
            n++;
            ubicacion[n] = ubicacionField.getText();
            extension[n] = Integer.parseInt(extensionField.getText());
            precio[n] = Double.parseDouble(precioField.getText());
            resultadoArea.append("Departamento dado de alta correctamente.\n");
            ordenarArreglos(); // Ordenar después de dar de alta
        } else {
            resultadoArea.append("No hay más espacio en el arreglo.\n");
        }
    }

    private void darBaja() {
        try {
            int extBuscar = Integer.parseInt(buscarExtensionField.getText());
            int pos = buscar(extBuscar);
            if (pos >= 0) {
                for (int i = pos; i < n; i++) {
                    ubicacion[i] = ubicacion[i + 1];
                    extension[i] = extension[i + 1];
                    precio[i] = precio[i + 1];
                }
                n--;
                resultadoArea.append("Departamento eliminado.\n");
            } else {
                resultadoArea.append("Departamento no encontrado.\n");
            }
        } catch (NumberFormatException ex) {
            resultadoArea.append("Ingrese un número válido.\n");
        }
    }

    private void modificarPrecio() {
        try {
            int extBuscar = Integer.parseInt(modificarExtensionField.getText());
            int pos = buscar(extBuscar);
            if (pos >= 0) {
                precio[pos] = Double.parseDouble(nuevoPrecioField.getText());
                resultadoArea.append("Precio modificado correctamente.\n");
            } else {
                resultadoArea.append("Departamento no encontrado.\n");
            }
        } catch (NumberFormatException ex) {
            resultadoArea.append("Ingrese un número válido.\n");
        }
    }

    private void listarTodos() {
        StringBuilder salida = new StringBuilder("Ubicación\tExtensión (m²)\tPrecio\n");
        for (int i = 0; i <= n; i++) {
            salida.append(ubicacion[i]).append("\t").append(extension[i]).append("\t").append(precio[i]).append("\n");
        }
        resultadoArea.setText(salida.toString());
    }

    private void listarUno(String extensionTexto) {
        try {
            int extBuscar = Integer.parseInt(extensionTexto);
            int pos = buscar(extBuscar);
            if (pos >= 0) {
                resultadoArea.setText("Ubicación: " + ubicacion[pos] + "\nExtensión: " + extension[pos] + " m²\nPrecio: " + precio[pos]);
            } else {
                resultadoArea.setText("Departamento no encontrado.\n");
            }
        } catch (NumberFormatException ex) {
            resultadoArea.setText("Ingrese un número válido.\n");
        }
    }

    private int buscar(int extBuscar) {
        for (int i = 0; i <= n; i++) {
            if (extension[i] == extBuscar) {
                return i;
            }
        }
        return -1;
    }

    private void ordenarArreglos() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                if (extension[j] > extension[j + 1]) {
                    // Intercambiar ubicaciones
                    String tempUbicacion = ubicacion[j];
                    ubicacion[j] = ubicacion[j + 1];
                    ubicacion[j + 1] = tempUbicacion;

                    // Intercambiar extensiones
                    int tempExtension = extension[j];
                    extension[j] = extension[j + 1];
                    extension[j + 1] = tempExtension;

                    // Intercambiar precios
                    double tempPrecio = precio[j];
                    precio[j] = precio[j + 1];
                    precio[j + 1] = tempPrecio;
                }
            }
        }
    }

    private void volverAOrdenado(ordenado ordenadoFrame) {
        ordenadoFrame.setVisible(true);
        this.dispose();
    }
}
