import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab3_2 extends JFrame {
    private JTextField palabraField;
    private JTextArea resultadoArea;
    private JButton invertirButton;
    private JButton volverButton;
    private Lab3 lab3Frame;

    public Lab3_2(Lab3 lab3Frame) {
        this.lab3Frame = lab3Frame;
        inicializarLab3_2();
    }

    private void inicializarLab3_2() {
        setTitle("Inversión de Palabra - Recursividad");
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

        // Etiqueta y campo para ingresar la palabra
        JLabel palabraLabel = new JLabel("Ingrese una palabra:");
        palabraLabel.setFont(new Font("Arial", Font.BOLD, 14));
        palabraField = new JTextField(20);
        palabraField.setFont(new Font("Arial", Font.PLAIN, 14));
        palabraField.setToolTipText("Ingrese la palabra que desea invertir");

        invertirButton = new JButton("Invertir Palabra");
        invertirButton.setFont(new Font("Arial", Font.BOLD, 14));
        invertirButton.setBackground(new Color(100, 149, 237));
        invertirButton.setForeground(Color.WHITE);
        invertirButton.setFocusPainted(false);
        invertirButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Añadir componentes al panel superior
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelSuperior.add(palabraLabel, gbc);

        gbc.gridx = 1;
        panelSuperior.add(palabraField, gbc);

        gbc.gridx = 2;
        panelSuperior.add(invertirButton, gbc);

        panelPrincipal.add(panelSuperior, BorderLayout.NORTH);

        // Área de resultado con JScrollPane
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

        volverButton = new JButton("Volver");
        volverButton.setFont(new Font("Arial", Font.BOLD, 14));
        volverButton.setBackground(new Color(220, 20, 60));
        volverButton.setForeground(Color.WHITE);
        volverButton.setFocusPainted(false);
        volverButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        panelBotones.add(volverButton);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

        setContentPane(panelPrincipal);

        // Acciones de los botones
        invertirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invertirPalabra();
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

    private void invertirPalabra() {
        String palabra = palabraField.getText().trim();
        if (palabra.isEmpty()) {
            mostrarMensajeError("Error: Ingrese una palabra.");
            return;
        }

        if (!palabra.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ]+")) {
            mostrarMensajeError("Error: La palabra debe contener solo letras.");
            return;
        }

        String invertida = invertirRecursivamente(palabra);
        mostrarResultado("Palabra original: " + palabra + "\nPalabra invertida: " + invertida + "\n");
    }

    private String invertirRecursivamente(String palabra) {
        if (palabra.isEmpty()) {
            return palabra;
        }
        return invertirRecursivamente(palabra.substring(1)) + palabra.charAt(0);
    }

    // Métodos para mostrar mensajes en el área de resultado
    private void mostrarMensajeError(String mensaje) {
        resultadoArea.setForeground(Color.RED);
        resultadoArea.setText(mensaje + "\n");
    }

    private void mostrarResultado(String mensaje) {
        resultadoArea.setForeground(new Color(34, 139, 34)); // Verde oscuro
        resultadoArea.setText(mensaje);
    }
}
