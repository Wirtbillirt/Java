import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Desordenado extends JFrame {
    private JButton ejercicio1Button;
    private JButton ejercicio2Button;
    private JButton ejercicio3Button;
    private JButton volverButton;
    private JLabel labelTitulo;

    public Desordenado(Lab1 lab1) {
        inicializarDesordenado(lab1);
    }

    private void inicializarDesordenado(Lab1 lab1) {
        // Configurar layout principal
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Crear el JLabel para el título "Arreglos Desordenados"
        labelTitulo = new JLabel("Arreglos Desordenados", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        panelPrincipal.add(labelTitulo, BorderLayout.NORTH);

        // Crear los botones
        ejercicio1Button = new JButton("Ejercicio 1");
        ejercicio2Button = new JButton("Ejercicio 2");
        ejercicio3Button = new JButton("Ejercicio 3");
        volverButton = new JButton("Volver");

        // Panel central con GridBagLayout para centrar los botones
        JPanel panelBotones = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        panelBotones.add(ejercicio1Button, gbc);

        gbc.gridy = 1;
        panelBotones.add(ejercicio2Button, gbc);

        gbc.gridy = 2;
        panelBotones.add(ejercicio3Button, gbc);

        // Añadir el panel de botones al centro del panel principal
        panelPrincipal.add(panelBotones, BorderLayout.CENTER);

        // Panel inferior con el botón "Volver"
        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelInferior.add(volverButton);
        panelPrincipal.add(panelInferior, BorderLayout.SOUTH);

        // Configurar la ventana
        setContentPane(panelPrincipal);
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Añadir ActionListener para el botón "Volver"
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                volverALab1(lab1);
            }
        });

        // Añadir ActionListener para el botón "Ejercicio 1"
        ejercicio1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarLab1_1();
            }
        });

        // Añadir ActionListener para el botón "Ejercicio 2"
        ejercicio2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarLab1_2();
            }
        });

        // Añadir ActionListener para el botón "Ejercicio 3"
        ejercicio3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarLab1_3();
            }
        });
    }

    private void volverALab1(Lab1 lab1) {
        lab1.setVisible(true);
        this.dispose();
    }

    private void mostrarLab1_1() {
        Lab1_1 lab1_1 = new Lab1_1(this);
        lab1_1.setVisible(true);
        this.setVisible(false);
    }

    private void mostrarLab1_2() {
        Lab1_2 lab1_2 = new Lab1_2(this);
        lab1_2.setVisible(true);
        this.setVisible(false);
    }

    private void mostrarLab1_3() {
        Lab1_3 lab1_3 = new Lab1_3(this);
        lab1_3.setVisible(true);
        this.setVisible(false);
    }
}
