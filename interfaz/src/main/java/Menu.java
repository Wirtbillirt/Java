import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    private JLabel labelMenu;
    private JButton lab1Button;
    private JButton lab2Button;
    private JButton lab3Button;
    private JButton lab4Button;
    private JButton lab5Button;
    private JButton lab6Button;
    private JButton volverButton;
    private Forma forma;

    public Menu(Forma forma) {
        this.forma = forma;
        inicializarMenu();
    }

    private void inicializarMenu() {
        // Crear un JPanel personalizado para la imagen de fondo
        JPanel panelPrincipal = new JPanel(null) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon fondo = cargarImagen("/Fondo.jpg");
                if (fondo != null) {
                    g.drawImage(fondo.getImage(), 0, 0, getWidth(), getHeight(), this);
                }
            }
        };

        labelMenu = new JLabel("Menu", SwingConstants.CENTER);
        labelMenu.setFont(new Font("Arial", Font.BOLD, 24));
        labelMenu.setForeground(Color.WHITE);
        labelMenu.setBounds(350, 20, 100, 40);
        panelPrincipal.add(labelMenu);

        lab1Button = new JButton("Lab 1");
        lab2Button = new JButton("Lab 2");
        lab3Button = new JButton("Lab 3");
        lab4Button = new JButton("Lab 4");
        lab5Button = new JButton("Lab 5");
        lab6Button = new JButton("Lab 6");
        volverButton = new JButton("Volver");

        Color botonColor = Color.decode("#e6e6fa");
        Color textoBotonColor = Color.BLACK;

        JButton[] botones = {lab1Button, lab2Button, lab3Button, lab4Button, lab5Button, lab6Button, volverButton};
        for (JButton boton : botones) {
            boton.setBackground(botonColor);
            boton.setForeground(textoBotonColor);
            boton.setFocusPainted(false);
        }

        lab1Button.setBounds(20, 100, 100, 30);
        lab3Button.setBounds(20, 200, 100, 30);
        lab5Button.setBounds(20, 300, 100, 30);
        lab2Button.setBounds(680, 100, 100, 30);
        lab4Button.setBounds(680, 200, 100, 30);
        lab6Button.setBounds(680, 300, 100, 30);
        volverButton.setBounds(20, 500, 100, 30);

        panelPrincipal.add(lab1Button);
        panelPrincipal.add(lab2Button);
        panelPrincipal.add(lab3Button);
        panelPrincipal.add(lab4Button);
        panelPrincipal.add(lab5Button);
        panelPrincipal.add(lab6Button);
        panelPrincipal.add(volverButton);

        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);

        lab1Button.addActionListener(e -> mostrarLab1());
        lab2Button.addActionListener(e -> mostrarLab2());
        lab3Button.addActionListener(e -> mostrarLab3());
        volverButton.addActionListener(e -> volverAForma());
    }

    private void mostrarLab1() {
        Lab1 lab1 = new Lab1();
        lab1.setVisible(true);
        this.dispose();
    }

    private void mostrarLab2() {
        Lab2 lab2 = new Lab2(this);
        lab2.setVisible(true);
        this.dispose();
    }

    private void mostrarLab3() {
        Lab3 lab3 = new Lab3(this);  // Cambiar aquí para redirigir a Lab3
        lab3.setVisible(true);
        this.dispose();
    }

    private void volverAForma() {
        Forma forma = new Forma();
        forma.setVisible(true);
        this.dispose();
    }

    private ImageIcon cargarImagen(String ruta) {
        return new ImageIcon(getClass().getResource(ruta));
    }
}
