import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab3_1 extends JFrame {
    private JTextArea resultadoArea;
    private JTextField tamanoField;
    private JTextField elementosField; // Campo para ingresar elementos del arreglo
    private JButton establecerTamanoButton;
    private JButton agregarElementosButton; // Botón para agregar elementos
    private JButton imprimirButton;
    private JButton volverButton;
    private int[] arreglo;
    private int tam = -1;
    private Lab3 lab3Frame;

    public Lab3_1(Lab3 lab3Frame) {
        this.lab3Frame = lab3Frame;
        inicializarLab3_1();
    }

    private void inicializarLab3_1() {
        setTitle("Recursividad - Ejercicio 1");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Panel principal con BorderLayout
        JPanel panelPrincipal = new JPanel(new BorderLayout(20, 20));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelPrincipal.setBackground(new Color(245, 245, 245));

        // Panel superior con GridBagLayout
        JPanel panelSuperior = new JPanel(new GridBagLayout());
        panelSuperior.setBackground(new Color(245, 245, 245));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Etiqueta y campo para tamaño del arreglo
        JLabel tamanoLabel = new JLabel("Tamaño del arreglo:");
        tamanoLabel.setFont(new Font("Arial", Font.BOLD, 14));
        tamanoField = new JTextField(15);
        tamanoField.setFont(new Font("Arial", Font.PLAIN, 14));
        tamanoField.setToolTipText("Ingrese el tamaño del arreglo (número entero positivo)");

        establecerTamanoButton = new JButton("Establecer Tamaño");
        establecerTamanoButton.setFont(new Font("Arial", Font.BOLD, 14));
        establecerTamanoButton.setBackground(new Color(100, 149, 237));
        establecerTamanoButton.setForeground(Color.WHITE);
        establecerTamanoButton.setFocusPainted(false);
        establecerTamanoButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Etiqueta y campo para elementos del arreglo
        JLabel elementosLabel = new JLabel("Elementos del arreglo:");
        elementosLabel.setFont(new Font("Arial", Font.BOLD, 14));
        elementosField = new JTextField(15);
        elementosField.setFont(new Font("Arial", Font.PLAIN, 14));
        elementosField.setToolTipText("Ingrese los elementos separados por comas (ej: 1,2,3)");
        elementosField.setEnabled(false); // Deshabilitar al inicio

        agregarElementosButton = new JButton("Agregar Elementos");
        agregarElementosButton.setFont(new Font("Arial", Font.BOLD, 14));
        agregarElementosButton.setBackground(new Color(60, 179, 113));
        agregarElementosButton.setForeground(Color.WHITE);
        agregarElementosButton.setFocusPainted(false);
        agregarElementosButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        agregarElementosButton.setEnabled(false); // Deshabilitar al inicio

        // Añadir componentes al panel superior
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelSuperior.add(tamanoLabel, gbc);

        gbc.gridx = 1;
        panelSuperior.add(tamanoField, gbc);

        gbc.gridx = 2;
        panelSuperior.add(establecerTamanoButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panelSuperior.add(elementosLabel, gbc);

        gbc.gridx = 1;
        panelSuperior.add(elementosField, gbc);

        gbc.gridx = 2;
        panelSuperior.add(agregarElementosButton, gbc);

        panelPrincipal.add(panelSuperior, BorderLayout.NORTH);

        // Área de texto con JScrollPane
        resultadoArea = new JTextArea(15, 50);
        resultadoArea.setEditable(false);
        resultadoArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        resultadoArea.setBackground(new Color(255, 255, 255));
        resultadoArea.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        JScrollPane scrollPane = new JScrollPane(resultadoArea);
        panelPrincipal.add(scrollPane, BorderLayout.CENTER);

        // Panel inferior con botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 10));
        panelBotones.setBackground(new Color(245, 245, 245));

        imprimirButton = new JButton("Imprimir Arreglo");
        imprimirButton.setFont(new Font("Arial", Font.BOLD, 14));
        imprimirButton.setBackground(new Color(255, 165, 0));
        imprimirButton.setForeground(Color.WHITE);
        imprimirButton.setFocusPainted(false);
        imprimirButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        imprimirButton.setEnabled(false);

        volverButton = new JButton("Volver");
        volverButton.setFont(new Font("Arial", Font.BOLD, 14));
        volverButton.setBackground(new Color(220, 20, 60));
        volverButton.setForeground(Color.WHITE);
        volverButton.setFocusPainted(false);
        volverButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        panelBotones.add(imprimirButton);
        panelBotones.add(volverButton);

        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

        setContentPane(panelPrincipal);

        // Acciones de los botones
        establecerTamanoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                establecerTamano();
            }
        });

        agregarElementosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarElementos();
            }
        });

        imprimirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                imprimirArreglo();
            }
        });

        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lab3Frame.setVisible(true); // Regresa a Lab3
                dispose();  // Cierra esta ventana
            }
        });
    }

    private void establecerTamano() {
        String input = tamanoField.getText().trim();
        if (input.isEmpty()) {
            mostrarMensajeError("Por favor, ingrese el tamaño del arreglo.");
            return;
        }
        try {
            tam = Integer.parseInt(input);
            if (tam > 0) {
                arreglo = new int[tam];
                elementosField.setEnabled(true); // Habilitar campo de elementos
                agregarElementosButton.setEnabled(true); // Habilitar botón de agregar
                establecerTamanoButton.setEnabled(false); // Deshabilitar botón de establecer tamaño
                tamanoField.setEnabled(false); // Evitar cambios posteriores
                mostrarMensajeExito("Tamaño del arreglo establecido: " + tam);
            } else {
                mostrarMensajeError("El tamaño debe ser un número entero positivo.");
            }
        } catch (NumberFormatException ex) {
            mostrarMensajeError("Error: Ingrese un número válido para el tamaño.");
        }
    }

    private void agregarElementos() {
        String input = elementosField.getText().trim();
        if (input.isEmpty()) {
            mostrarMensajeError("Por favor, ingrese los elementos del arreglo.");
            return;
        }
        String[] elementos = input.split(",");
        if (elementos.length != tam) {
            mostrarMensajeError("Debe ingresar exactamente " + tam + " elementos.");
            return;
        }

        try {
            for (int i = 0; i < tam; i++) {
                arreglo[i] = Integer.parseInt(elementos[i].trim());
            }

            elementosField.setEnabled(false); // Deshabilitar el campo de elementos
            agregarElementosButton.setEnabled(false); // Deshabilitar botón de agregar
            imprimirButton.setEnabled(true); // Habilitar el botón de imprimir
            mostrarMensajeExito("Elementos agregados correctamente.");
        } catch (NumberFormatException ex) {
            mostrarMensajeError("Error: Ingrese números válidos separados por comas.");
        }
    }

    private void imprimirArreglo() {
        resultadoArea.setText(""); // Limpiar pantalla
        resultadoArea.append("Orden original: ");
        imprimirEnOrden(arreglo, 0);
        resultadoArea.append("\nOrden inverso: ");
        imprimirEnReverso(arreglo, tam - 1);
    }

    private void imprimirEnOrden(int[] arr, int index) {
        if (index < arr.length) {
            resultadoArea.append(arr[index] + " ");
            imprimirEnOrden(arr, index + 1);
        }
    }

    private void imprimirEnReverso(int[] arr, int index) {
        if (index >= 0) {
            resultadoArea.append(arr[index] + " ");
            imprimirEnReverso(arr, index - 1);
        }
    }

    // Métodos para mostrar mensajes en el área de resultado
    private void mostrarMensajeError(String mensaje) {
        resultadoArea.setForeground(Color.RED);
        resultadoArea.setText(mensaje + "\n");
    }

    private void mostrarMensajeExito(String mensaje) {
        resultadoArea.setForeground(new Color(34, 139, 34)); // Verde oscuro
        resultadoArea.setText(mensaje + "\n");
    }
}
