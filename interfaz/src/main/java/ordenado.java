import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ordenado extends JFrame {
    private JButton ejercicio1Button;
    private JButton ejercicio2Button;
    private JButton ejercicio3Button;
    private JButton volverButton;
    private JLabel labelTitulo;

    public ordenado(Lab1 lab1) {
        inicializarOrdenado(lab1);
    }

    private void inicializarOrdenado(Lab1 lab1) {
        // Configurar layout principal
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Crear el JLabel para el título "Arreglos Ordenados"
        labelTitulo = new JLabel("Arreglos Ordenados", SwingConstants.CENTER);
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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
                mostrarLab1_4();
            }
        });

        // Añadir ActionListener para el botón "Ejercicio 2"
        ejercicio2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarLab1_5();
            }
        });

        // Añadir ActionListener para el botón "Ejercicio 3"
        ejercicio3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarLab1_6();
            }
        });
    }

    private void volverALab1(Lab1 lab1) {
        lab1.setVisible(true);
        this.dispose();
    }

    private void mostrarLab1_4() {
        Lab1_4 lab1_4 = new Lab1_4(this);
        lab1_4.setVisible(true);
        this.setVisible(false);
    }

    private void mostrarLab1_5() {
        Lab1_5 lab1_5 = new Lab1_5(this);
        lab1_5.setVisible(true);
        this.setVisible(false);
    }

    private void mostrarLab1_6() {
        Lab1_6 lab1_6 = new Lab1_6(this);
        lab1_6.setVisible(true);
        this.setVisible(false);
    }
}
