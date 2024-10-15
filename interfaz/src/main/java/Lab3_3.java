import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class Lab3_3 extends JFrame {
    private JTextField elementosField;
    private JTextArea resultadoArea;
    private JButton agregarElementosButton;
    private JButton calcularButton;
    private JButton volverButton;
    private int[] arreglo = new int[10];
    private Lab3 lab3Frame;

    public Lab3_3(Lab3 lab3Frame) {
        this.lab3Frame = lab3Frame;
        inicializarLab3_3();
    }

    private void inicializarLab3_3() {
        setTitle("Producto de 10 Elementos - Recursividad");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Panel principal con GridBagLayout
        JPanel panelPrincipal = new JPanel(new GridBagLayout());
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelPrincipal.setBackground(new Color(245, 245, 245));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(15, 15, 15, 15);

        // Etiqueta y campo para ingresar elementos
        JLabel elementosLabel = new JLabel("Ingrese 10 números separados por comas:");
        elementosLabel.setFont(new Font("Arial", Font.BOLD, 16));
        elementosField = new JTextField(30);
        elementosField.setFont(new Font("Arial", Font.PLAIN, 14));
        elementosField.setToolTipText("Ingrese 10 números separados por comas (ejemplo: 1,2,3,4,5,6,7,8,9,10)");

        // Botón para agregar elementos
        agregarElementosButton = new JButton("Agregar Elementos");
        agregarElementosButton.setFont(new Font("Arial", Font.BOLD, 14));
        agregarElementosButton.setBackground(new Color(100, 149, 237));
        agregarElementosButton.setForeground(Color.WHITE);
        agregarElementosButton.setFocusPainted(false);
        agregarElementosButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Botón para calcular producto
        calcularButton = new JButton("Calcular Producto");
        calcularButton.setFont(new Font("Arial", Font.BOLD, 14));
        calcularButton.setBackground(new Color(34, 139, 34));
        calcularButton.setForeground(Color.WHITE);
        calcularButton.setFocusPainted(false);
        calcularButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        calcularButton.setEnabled(false); // Deshabilitado hasta agregar elementos

        // Añadir componentes al panel principal
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        panelPrincipal.add(elementosLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        panelPrincipal.add(elementosField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panelPrincipal.add(agregarElementosButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panelPrincipal.add(calcularButton, gbc);

        // Área de resultado con JScrollPane
        resultadoArea = new JTextArea(15, 50);
        resultadoArea.setEditable(false);
        resultadoArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        resultadoArea.setBackground(new Color(255, 255, 255));
        resultadoArea.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        JScrollPane scrollPane = new JScrollPane(resultadoArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Resultados"));

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panelPrincipal.add(scrollPane, gbc);

        // Panel inferior con el botón volver
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelBotones.setBackground(new Color(245, 245, 245));

        volverButton = new JButton("Volver");
        volverButton.setFont(new Font("Arial", Font.BOLD, 14));
        volverButton.setBackground(new Color(220, 20, 60));
        volverButton.setForeground(Color.WHITE);
        volverButton.setFocusPainted(false);
        volverButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        panelBotones.add(volverButton);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.NONE;
        panelPrincipal.add(panelBotones, gbc);

        setContentPane(panelPrincipal);

        // Acciones de los botones
        agregarElementosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarElementos();
            }
        });

        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularProducto();
            }
        });

        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lab3Frame.setVisible(true); // Regresa a Lab3
                dispose(); // Cierra esta ventana
            }
        });
    }

    private void agregarElementos() {
        try {
            String input = elementosField.getText().trim();
            if (input.isEmpty()) {
                mostrarMensajeError("Error: Ingrese los 10 elementos.");
                return;
            }

            String[] elementos = input.split(",");
            if (elementos.length != 10) {
                mostrarMensajeError("Error: Debe ingresar exactamente 10 elementos.");
                return;
            }

            for (int i = 0; i < 10; i++) {
                String elementoStr = elementos[i].trim();
                if (elementoStr.isEmpty()) {
                    mostrarMensajeError("Error: El elemento #" + (i + 1) + " está vacío.");
                    return;
                }
                int valor = Integer.parseInt(elementoStr);
                arreglo[i] = valor;
            }

            mostrarMensajeExito("Elementos ingresados correctamente.");
            elementosField.setEnabled(false); // Deshabilitar campo de elementos
            agregarElementosButton.setEnabled(false); // Deshabilitar botón de agregar
            calcularButton.setEnabled(true); // Habilitar el botón de calcular

        } catch (NumberFormatException ex) {
            mostrarMensajeError("Error: Ingrese números válidos separados por comas.");
        }
    }

    private void calcularProducto() {
        try {
            int producto = calcularProductoRecursivamente(arreglo, 0);
            DecimalFormat formateador = new DecimalFormat("#,###"); // Formato con separadores de miles
            mostrarResultado("El producto de los elementos es: " + formateador.format(producto));
        } catch (ArithmeticException ex) {
            mostrarMensajeError("Error: Desbordamiento al calcular el producto.");
        }
    }

    private int calcularProductoRecursivamente(int[] arr, int index) {
        if (index == arr.length) {
            return 1; // Caso base: multiplicar por 1
        }
        return arr[index] * calcularProductoRecursivamente(arr, index + 1);
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

    private void mostrarResultado(String mensaje) {
        resultadoArea.setForeground(new Color(0, 0, 0)); // Negro para resultados
        resultadoArea.append(mensaje + "\n");
    }

}

