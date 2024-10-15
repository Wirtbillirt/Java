import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab3 extends JFrame {

    private JButton ejercicio1Button;
    private JButton ejercicio2Button;
    private JButton ejercicio3Button;
    private JButton ejercicio4Button;
    private JButton ejercicio5Button;
    private JButton ejercicio6Button;
    private JButton ejercicio7Button;
    private JButton simulacionButton;
    private JButton volverButton;
    private JLabel tituloLabel;

    public Lab3(Menu menu) {
        inicializarLab3(menu);
    }

    private void inicializarLab3(Menu menu) {
        // Crear un JPanel personalizado para la imagen de fondo
        JPanel panelPrincipal = new JPanel(null) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon fondo = cargarImagen("/Fondo.jpg");  // Usamos la misma imagen de fondo que en Menu
                if (fondo != null) {
                    g.drawImage(fondo.getImage(), 0, 0, getWidth(), getHeight(), this);
                }
            }
        };

        // Crear el título
        tituloLabel = new JLabel("Recursividad", SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 18));
        tituloLabel.setForeground(Color.WHITE);
        tituloLabel.setBounds(350, 20, 100, 40);
        panelPrincipal.add(tituloLabel);

        // Crear los botones
        ejercicio1Button = new JButton("Ejercicio 1");
        ejercicio2Button = new JButton("Ejercicio 2");
        ejercicio3Button = new JButton("Ejercicio 3");
        ejercicio4Button = new JButton("Ejercicio 4");
        ejercicio5Button = new JButton("Ejercicio 5");
        ejercicio6Button = new JButton("Ejercicio 6");
        ejercicio7Button = new JButton("Ejercicio 7");
        simulacionButton = new JButton("Simulación");
        volverButton = new JButton("Volver");

        // Colores de los botones
        Color botonColor = Color.decode("#e6e6fa");
        Color textoBotonColor = Color.BLACK;

        JButton[] botones = {ejercicio1Button, ejercicio2Button, ejercicio3Button, ejercicio4Button,
                ejercicio5Button, ejercicio6Button, ejercicio7Button, simulacionButton, volverButton};
        for (JButton boton : botones) {
            boton.setBackground(botonColor);
            boton.setForeground(textoBotonColor);
            boton.setFocusPainted(false);
        }

        // Posicionar los botones (distribución en 4 filas y 2 columnas)
        ejercicio1Button.setBounds(150, 100, 150, 30);
        ejercicio2Button.setBounds(500, 100, 150, 30);
        ejercicio3Button.setBounds(150, 160, 150, 30);
        ejercicio4Button.setBounds(500, 160, 150, 30);
        ejercicio5Button.setBounds(150, 220, 150, 30);
        ejercicio6Button.setBounds(500, 220, 150, 30);
        ejercicio7Button.setBounds(150, 280, 150, 30);
        simulacionButton.setBounds(500, 280, 150, 30);
        volverButton.setBounds(20, 500, 100, 30);  // Botón volver en la esquina inferior izquierda

        // Añadir los botones al panel principal
        panelPrincipal.add(ejercicio1Button);
        panelPrincipal.add(ejercicio2Button);
        panelPrincipal.add(ejercicio3Button);
        panelPrincipal.add(ejercicio4Button);
        panelPrincipal.add(ejercicio5Button);
        panelPrincipal.add(ejercicio6Button);
        panelPrincipal.add(ejercicio7Button);
        panelPrincipal.add(simulacionButton);
        panelPrincipal.add(volverButton);

        // Configurar la ventana
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);  // Centrar la ventana
        setResizable(false);

        // Acción del botón volver para regresar al menú
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.setVisible(true);
                dispose();
            }
        });

        // Acción de los botones para abrir las clases correspondientes
        ejercicio1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Lab3_1 lab3_1 = new Lab3_1(Lab3.this);
                lab3_1.setVisible(true);
                setVisible(false);
            }
        });

        ejercicio2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Lab3_2 lab3_2 = new Lab3_2(Lab3.this);
                lab3_2.setVisible(true);
                setVisible(false);
            }
        });

        ejercicio3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Lab3_3 lab3_3 = new Lab3_3(Lab3.this);
                lab3_3.setVisible(true);
                setVisible(false);
            }
        });

        ejercicio4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Lab3_4 lab3_4 = new Lab3_4(Lab3.this);
                lab3_4.setVisible(true);
                setVisible(false);
            }
        });

        ejercicio5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Lab3_5 lab3_5 = new Lab3_5(Lab3.this);
                lab3_5.setVisible(true);
                setVisible(false);
            }
        });

        ejercicio6Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Lab3_6 lab3_6 = new Lab3_6(Lab3.this);
                lab3_6.setVisible(true);
                setVisible(false);
            }
        });

        ejercicio7Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Lab3_7 lab3_7 = new Lab3_7(Lab3.this);
                lab3_7.setVisible(true);
                setVisible(false);
            }
        });

        // Acción del botón simulación
        simulacionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Simulacion simulacion = new Simulacion(Lab3.this);
                simulacion.setVisible(true);
                setVisible(false);
            }

        });
    }

    private ImageIcon cargarImagen(String path) {
        return new ImageIcon(getClass().getResource(path));
    }
}

