import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab3_4 extends JFrame {
    private JTextField cadenaField;
    private JTextArea resultadoArea;
    private JButton contarEspaciosButton;
    private JButton volverButton;
    private Lab3 lab3Frame;

    public Lab3_4(Lab3 lab3Frame) {
        this.lab3Frame = lab3Frame;
        inicializarLab3_4();
    }

    private void inicializarLab3_4() {
        setTitle("Contar Espacios en Blanco - Recursividad");
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

        // Etiqueta y campo para ingresar cadena
        JLabel cadenaLabel = new JLabel("Ingrese una cadena de texto:");
        cadenaLabel.setFont(new Font("Arial", Font.BOLD, 16));
        cadenaField = new JTextField(30);
        cadenaField.setFont(new Font("Arial", Font.PLAIN, 14));
        cadenaField.setToolTipText("Ingrese la cadena de texto que desea analizar");

        // Botón para contar espacios
        contarEspaciosButton = new JButton("Contar Espacios");
        contarEspaciosButton.setFont(new Font("Arial", Font.BOLD, 14));
        contarEspaciosButton.setBackground(new Color(100, 149, 237));
        contarEspaciosButton.setForeground(Color.WHITE);
        contarEspaciosButton.setFocusPainted(false);
        contarEspaciosButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Añadir componentes al panel principal
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        panelPrincipal.add(cadenaLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        panelPrincipal.add(cadenaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panelPrincipal.add(contarEspaciosButton, gbc);

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
        contarEspaciosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contarEspacios();
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

    private void contarEspacios() {
        String cadena = cadenaField.getText().trim();
        if (cadena.isEmpty()) {
            mostrarMensajeError("Error: Ingrese una cadena de texto.");
            return;
        }

        int espaciosEnBlanco = contarEspaciosRecursivamente(cadena, 0);
        mostrarResultado("La cadena ingresada tiene " + espaciosEnBlanco + " espacios en blanco.\n");
    }

    private int contarEspaciosRecursivamente(String cadena, int index) {
        if (index == cadena.length()) {
            return 0; // Caso base: no hay más caracteres que revisar
        }
        int espacioActual = (cadena.charAt(index) == ' ') ? 1 : 0;
        return espacioActual + contarEspaciosRecursivamente(cadena, index + 1);
    }

    // Métodos para mostrar mensajes en el área de resultado
    private void mostrarMensajeError(String mensaje) {
        resultadoArea.setForeground(Color.RED);
        resultadoArea.setText(mensaje + "\n");
    }

    private void mostrarResultado(String mensaje) {
        resultadoArea.setForeground(new Color(0, 0, 0)); // Negro para resultados
        resultadoArea.append(mensaje);
    }

}

