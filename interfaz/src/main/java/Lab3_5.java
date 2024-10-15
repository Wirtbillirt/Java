import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class Lab3_5 extends JFrame {
    private JTextArea resultadoArea;
    private JButton calcularButton;
    private JButton resetearButton;
    private JButton volverButton;
    private Lab3 lab3Frame;
    private static final double INTERES_PEDRO = 0.04; // 4% anual
    private static final double INTERES_JUAN = 0.023; // 2.3% anual

    public Lab3_5(Lab3 lab3Frame) {
        this.lab3Frame = lab3Frame;
        inicializarLab3_5();
    }

    private void inicializarLab3_5() {
        setTitle("Comparación de Cuentas - Pedro y Juan");
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
        JLabel instruccionLabel = new JLabel("<html><h2>Comparación de Cuentas de Ahorro</h2>"
                + "<p>Pedro y Juan abren cuentas al mismo tiempo en un banco. Pedro abre su cuenta con $400 a una tasa de interés anual del 4%, mientras que Juan abre su cuenta con $500 a una tasa de interés anual del 2.3%.</p>"
                + "<p>Este programa determinará en cuántos años la cuenta de Pedro superará a la de Juan.</p></html>");
        instruccionLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        panelPrincipal.add(instruccionLabel, gbc);

        // Área de resultado con JScrollPane
        resultadoArea = new JTextArea(20, 60);
        resultadoArea.setEditable(false);
        resultadoArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        resultadoArea.setBackground(new Color(255, 255, 255));
        resultadoArea.setBorder(BorderFactory.createTitledBorder("Resultados"));
        JScrollPane scrollPane = new JScrollPane(resultadoArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panelPrincipal.add(scrollPane, gbc);

        // Panel de botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panelBotones.setBackground(new Color(245, 245, 245));

        calcularButton = new JButton("Calcular");
        calcularButton.setFont(new Font("Arial", Font.BOLD, 14));
        calcularButton.setBackground(new Color(100, 149, 237));
        calcularButton.setForeground(Color.WHITE);
        calcularButton.setFocusPainted(false);
        calcularButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        resetearButton = new JButton("Resetear");
        resetearButton.setFont(new Font("Arial", Font.BOLD, 14));
        resetearButton.setBackground(new Color(255, 165, 0));
        resetearButton.setForeground(Color.WHITE);
        resetearButton.setFocusPainted(false);
        resetearButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        resetearButton.setEnabled(false); // Deshabilitado hasta calcular

        volverButton = new JButton("Volver");
        volverButton.setFont(new Font("Arial", Font.BOLD, 14));
        volverButton.setBackground(new Color(220, 20, 60));
        volverButton.setForeground(Color.WHITE);
        volverButton.setFocusPainted(false);
        volverButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        panelBotones.add(calcularButton);
        panelBotones.add(resetearButton);
        panelBotones.add(volverButton);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.NONE;
        panelPrincipal.add(panelBotones, gbc);

        setContentPane(panelPrincipal);

        // Acciones de los botones
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularAños();
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

    private void calcularAños() {
        double saldoPedro = 400.00;
        double saldoJuan = 500.00;
        int año = 2021;

        DecimalFormat df = new DecimalFormat("#,##0.00");

        // Limpiar área de resultados antes de calcular
        resultadoArea.setText("");
        resultadoArea.setForeground(Color.BLACK);

        resultadoArea.append(String.format("%-6s %-15s %-15s%n", "Año", "Cta. Pedro", "Cta. Juan"));
        resultadoArea.append("-------------------------------------------------\n");

        int añosParaSuperar = calcularCuentas(saldoPedro, saldoJuan, año, df);

        if (añosParaSuperar > 0) {
            resultadoArea.append("\nLa cuenta de Pedro supera a la de Juan en el año " + (año + añosParaSuperar) + ".\n");
        } else {
            resultadoArea.append("\nLa cuenta de Pedro nunca supera a la de Juan con las tasas actuales.\n");
        }

        // Deshabilitar el botón calcular y habilitar el botón resetear
        calcularButton.setEnabled(false);
        resetearButton.setEnabled(true);
    }

    private int calcularCuentas(double saldoPedro, double saldoJuan, int año, DecimalFormat df) {
        // Imprimir el saldo de Pedro y Juan para el año actual
        resultadoArea.append(String.format("%-6d %-15s %-15s%n", año, "$" + df.format(saldoPedro), "$" + df.format(saldoJuan)));

        // Verificar si la cuenta de Pedro ya es mayor a la de Juan
        if (saldoPedro > saldoJuan) {
            return 0; // Año en el que supera
        }

        // Recursión: incrementar el saldo de ambos para el próximo año
        double nuevoSaldoPedro = saldoPedro * (1 + INTERES_PEDRO);
        double nuevoSaldoJuan = saldoJuan * (1 + INTERES_JUAN);

        int resultadoRecursivo = calcularCuentas(nuevoSaldoPedro, nuevoSaldoJuan, año + 1, df);
        if (resultadoRecursivo == 0) {
            return 1; // Pedro supera en el siguiente año
        } else {
            return resultadoRecursivo + 1; // Incrementar el contador de años
        }
    }

    private void resetearCalculo() {
        resultadoArea.setText("");
        calcularButton.setEnabled(true);
        resetearButton.setEnabled(false);
    }

}
