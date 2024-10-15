import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab3_6 extends JFrame {
    private JTextField numeroField;
    private JTextArea resultadoArea;
    private JButton calcularButton;
    private JButton resetearButton;
    private JButton volverButton;
    private Lab3 lab3Frame;

    public Lab3_6(Lab3 lab3Frame) {
        this.lab3Frame = lab3Frame;
        inicializarLab3_6();
    }

    private void inicializarLab3_6() {
        setTitle("Secuencia de ULAM");
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
        gbc.insets = new Insets(10, 10, 10, 10);

        // Instrucción del programa
        JLabel instruccionLabel = new JLabel("<html><h2>Secuencia de ULAM</h2>"
                + "<p>Ingrese un número mayor que 1 para calcular su secuencia de ULAM."
                + " La secuencia se generará recursivamente hasta llegar a 1.</p></html>");
        instruccionLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        panelPrincipal.add(instruccionLabel, gbc);

        // Etiqueta y campo para ingresar número
        JLabel numeroLabel = new JLabel("Número inicial (mayor que 1):");
        numeroLabel.setFont(new Font("Arial", Font.BOLD, 14));
        numeroField = new JTextField(20);
        numeroField.setFont(new Font("Arial", Font.PLAIN, 14));
        numeroField.setToolTipText("Ingrese un número entero mayor que 1");

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panelPrincipal.add(numeroLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        panelPrincipal.add(numeroField, gbc);

        // Botón para calcular secuencia ULAM
        calcularButton = new JButton("Calcular Secuencia");
        calcularButton.setFont(new Font("Arial", Font.BOLD, 14));
        calcularButton.setBackground(new Color(100, 149, 237));
        calcularButton.setForeground(Color.WHITE);
        calcularButton.setFocusPainted(false);
        calcularButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panelPrincipal.add(calcularButton, gbc);

        // Botón para resetear
        resetearButton = new JButton("Resetear");
        resetearButton.setFont(new Font("Arial", Font.BOLD, 14));
        resetearButton.setBackground(new Color(255, 165, 0));
        resetearButton.setForeground(Color.WHITE);
        resetearButton.setFocusPainted(false);
        resetearButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        resetearButton.setEnabled(false); // Deshabilitado hasta calcular

        gbc.gridx = 1;
        gbc.gridy = 2;
        panelPrincipal.add(resetearButton, gbc);

        // Botón para volver
        volverButton = new JButton("Volver");
        volverButton.setFont(new Font("Arial", Font.BOLD, 14));
        volverButton.setBackground(new Color(220, 20, 60));
        volverButton.setForeground(Color.WHITE);
        volverButton.setFocusPainted(false);
        volverButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        gbc.gridx = 2;
        gbc.gridy = 2;
        panelPrincipal.add(volverButton, gbc);

        // Área de resultado con JScrollPane
        resultadoArea = new JTextArea(20, 60);
        resultadoArea.setEditable(false);
        resultadoArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        resultadoArea.setBackground(new Color(255, 255, 255));
        resultadoArea.setBorder(BorderFactory.createTitledBorder("Resultados"));
        JScrollPane scrollPane = new JScrollPane(resultadoArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panelPrincipal.add(scrollPane, gbc);

        setContentPane(panelPrincipal);

        // Acciones de los botones
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularSecuenciaULAM();
            }
        });

        resetearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetearCalculo();
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

    private void calcularSecuenciaULAM() {
        resultadoArea.setText(""); // Limpiar el área de resultados
        try {
            int numero = Integer.parseInt(numeroField.getText().trim());
            if (numero > 1) {
                resultadoArea.append("Secuencia de ULAM:\n");
                calcularULAM(numero);
                resultadoArea.append("\nFin de la secuencia.\n");
                calcularButton.setEnabled(false);
                resetearButton.setEnabled(true);
            } else {
                mostrarMensajeError("Error: Ingrese un número mayor que 1.\n");
            }
        } catch (NumberFormatException ex) {
            mostrarMensajeError("Error: Ingrese un número válido.\n");
        }
    }

    private void calcularULAM(int numero) {
        resultadoArea.append(numero + " ");
        if (numero == 1) {
            return; // Termina cuando el número es 1
        }

        if (numero % 2 == 0) {
            calcularULAM(numero / 2); // Si es par, lo divide entre 2
        } else {
            calcularULAM(numero * 3 + 1); // Si es impar, lo multiplica por 3 y suma 1
        }
    }

    private void resetearCalculo() {
        numeroField.setText("");
        resultadoArea.setText("");
        calcularButton.setEnabled(true);
        resetearButton.setEnabled(false);
    }

    // Métodos para mostrar mensajes en el área de resultado
    private void mostrarMensajeError(String mensaje) {
        resultadoArea.setForeground(Color.RED);
        resultadoArea.setText(mensaje);
    }
}
