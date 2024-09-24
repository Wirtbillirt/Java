import javax.swing.*;
import java.awt.*;

public class Lab1_6 extends JFrame {
    private String[] nombres;
    private double[] ventas;
    private int n = -1; // Número de vendedores registrados
    private int tam;

    private JTextField tamanoField, nombreField, ventasField, buscarField, modificarNombreField, nuevasVentasField;
    private JTextArea outputArea;
    private JButton aceptarButton, altaButton, modificarButton, imprimirButton, volverButton;

    public Lab1_6(ordenado ordenadoFrame) {
        inicializarLab1_6(ordenadoFrame);
    }

    private void inicializarLab1_6(ordenado ordenadoFrame) {
        setTitle("Gestión de Vendedores");
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
        panelPrincipal.add(tamanoField, gbc);

        aceptarButton = new JButton("Establecer tamaño");
        gbc.gridx = 2;
        panelPrincipal.add(aceptarButton, gbc);

        // Campos de alta
        JLabel nombreLabel = new JLabel("Nombre:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panelPrincipal.add(nombreLabel, gbc);

        nombreField = new JTextField(10);
        gbc.gridx = 1;
        panelPrincipal.add(nombreField, gbc);

        JLabel ventasLabel = new JLabel("Ventas:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panelPrincipal.add(ventasLabel, gbc);

        ventasField = new JTextField(10);
        gbc.gridx = 1;
        panelPrincipal.add(ventasField, gbc);

        altaButton = new JButton("Dar de Alta");
        gbc.gridx = 2;
        panelPrincipal.add(altaButton, gbc);

        // Buscar vendedor
        JLabel buscarLabel = new JLabel("Buscar por Nombre:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        panelPrincipal.add(buscarLabel, gbc);

        buscarField = new JTextField(10);
        gbc.gridx = 1;
        panelPrincipal.add(buscarField, gbc);

        imprimirButton = new JButton("Imprimir Vendedor");
        gbc.gridx = 2;
        panelPrincipal.add(imprimirButton, gbc);

        // Modificar ventas en una misma línea
        JPanel modificarPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        modificarNombreField = new JTextField(10);
        nuevasVentasField = new JTextField(10);
        modificarButton = new JButton("Modificar Ventas");

        modificarPanel.add(new JLabel("Nombre para modificar:"));
        modificarPanel.add(modificarNombreField);
        modificarPanel.add(new JLabel("Nuevas Ventas:"));
        modificarPanel.add(nuevasVentasField);
        modificarPanel.add(modificarButton);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 3; // Occupy all columns
        panelPrincipal.add(modificarPanel, gbc);

        // Volver
        volverButton = new JButton("Volver");
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        panelPrincipal.add(volverButton, gbc);

        // Resultados
        outputArea = new JTextArea(10, 40);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 3;
        panelPrincipal.add(scrollPane, gbc);

        // Acciones de botones
        aceptarButton.addActionListener(e -> establecerTamano());
        altaButton.addActionListener(e -> darAlta());
        modificarButton.addActionListener(e -> modificarVentas());
        imprimirButton.addActionListener(e -> imprimirVendedor());
        volverButton.addActionListener(e -> volverAOrdenado(ordenadoFrame));

        setContentPane(panelPrincipal);
    }

    private void establecerTamano() {
        try {
            tam = Integer.parseInt(tamanoField.getText().trim());
            if (tam > 0) {
                nombres = new String[tam];
                ventas = new double[tam];
                outputArea.append("Tamaño establecido correctamente: " + tam + "\n");
                aceptarButton.setEnabled(false); // Desactivar el botón
            } else {
                outputArea.append("El tamaño debe ser mayor que 0.\n");
            }
        } catch (NumberFormatException ex) {
            outputArea.append("Ingrese un número válido para el tamaño.\n");
        }
    }

    private void darAlta() {
        if (n < tam - 1) {
            n++;
            String nombreNuevo = nombreField.getText().trim();
            double ventasNuevas;

            try {
                ventasNuevas = Double.parseDouble(ventasField.getText().trim());
            } catch (NumberFormatException ex) {
                outputArea.append("Ingrese un número válido para las ventas.\n");
                return;
            }

            if (nombreNuevo.isEmpty()) {
                outputArea.append("El nombre del vendedor no puede estar vacío.\n");
                return;
            }

            int pos = buscarPosicion(nombres, nombreNuevo);
            if (pos >= 0) {
                outputArea.append("Ya existe un vendedor con ese nombre.\n");
            } else {
                pos = -pos - 1;
                for (int i = n; i > pos; i--) {
                    nombres[i] = nombres[i - 1];
                    ventas[i] = ventas[i - 1];
                }
                nombres[pos] = nombreNuevo;
                ventas[pos] = ventasNuevas;
                outputArea.append("Vendedor dado de alta correctamente: " + nombreNuevo + "\n");
            }
        } else {
            outputArea.append("No hay más espacio en el arreglo.\n");
        }
    }

    private void modificarVentas() {
        String nombreBuscar = modificarNombreField.getText().trim();
        int pos = buscarPosicion(nombres, nombreBuscar);
        if (pos >= 0) {
            try {
                double nuevasVentas = Double.parseDouble(nuevasVentasField.getText().trim());
                ventas[pos] = nuevasVentas;
                outputArea.append("Ventas modificadas correctamente para: " + nombres[pos] + "\n");
            } catch (NumberFormatException ex) {
                outputArea.append("Ingrese un número válido para las ventas.\n");
            }
        } else {
            outputArea.append("Vendedor no encontrado.\n");
        }
    }

    private void imprimirVendedor() {
        String nombreBuscar = buscarField.getText().trim();
        int pos = buscarPosicion(nombres, nombreBuscar);
        if (pos >= 0) {
            outputArea.append("Nombre: " + nombres[pos] + "\nVentas: " + ventas[pos] + "\n");
        } else {
            outputArea.append("Vendedor no encontrado.\n");
        }
    }

    private int buscarPosicion(String[] array, String valorBuscar) {
        int i = 0;
        while (i <= n && array[i] != null && array[i].compareToIgnoreCase(valorBuscar) < 0) {
            i++;
        }
        if (i <= n && array[i] != null && array[i].equalsIgnoreCase(valorBuscar)) {
            return i;
        } else {
            return -i - 1;
        }
    }

    private void volverAOrdenado(ordenado ordenadoFrame) {
        ordenadoFrame.setVisible(true);
        this.dispose();
    }
}
