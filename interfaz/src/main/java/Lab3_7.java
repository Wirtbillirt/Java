import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab3_7 extends JFrame {
    private JTextField numeroField;
    private JTextArea resultadoArea;
    private JButton calcularButton;
    private JButton resetearButton;
    private JButton volverButton;
    private Lab3 lab3Frame;

    public Lab3_7(Lab3 lab3Frame) {
        this.lab3Frame = lab3Frame;
        inicializarLab3_7();
    }

    private void inicializarLab3_7() {
        setTitle("Serie Fibonacci Recursiva");
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
        JLabel instruccionLabel = new JLabel("<html><h2>Serie Fibonacci Recursiva</h2>"
                + "<p>Ingrese un número N para calcular la serie de Fibonacci hasta el término N utilizando recursión.</p></html>");
        instruccionLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        panelPrincipal.add(instruccionLabel, gbc);

        // Etiqueta y campo para ingresar número
        JLabel numeroLabel = new JLabel("Ingrese el número N (mayor o igual a 0):");
        numeroLabel.setFont(new Font("Arial", Font.BOLD, 14));
        numeroField = new JTextField(20);
        numeroField.setFont(new Font("Arial", Font.PLAIN, 14));
        numeroField.setToolTipText("Ingrese un número entero mayor o igual a 0");

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panelPrincipal.add(numeroLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        panelPrincipal.add(numeroField, gbc);

        // Botón para calcular secuencia Fibonacci
        calcularButton = new JButton("Calcular Serie");
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
                calcularFibonacci();
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

    private void calcularFibonacci() {
        resultadoArea.setText(""); // Limpiar el área de resultados
        try {
            int n = Integer.parseInt(numeroField.getText().trim());
            if (n >= 0) {
                resultadoArea.append("Serie Fibonacci hasta el término " + n + ":\n");
                for (int i = 0; i <= n; i++) {
                    resultadoArea.append(fibonacci(i) + " ");
                }
                resultadoArea.append("\n");
                calcularButton.setEnabled(false);
                resetearButton.setEnabled(true);
            } else {
                mostrarMensajeError("Error: Ingrese un número mayor o igual a 0.\n");
            }
        } catch (NumberFormatException ex) {
            mostrarMensajeError("Error: Ingrese un número válido.\n");
        }
    }

    // Función recursiva para calcular Fibonacci
    private int fibonacci(int n) {
        if (n <= 1) {
            return n; // Los primeros dos términos son 0 y 1
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2); // Suma de los dos términos anteriores
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

    private void mostrarResultado(String mensaje) {
        resultadoArea.setForeground(new Color(0, 0, 0)); // Negro para resultados
        resultadoArea.append(mensaje);
    }

}
