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
    private JButton lab7Button;
    private JButton volverButton;
    private Forma forma;

    public Menu(Forma forma) {
        this.forma = forma;
        inicializarMenu();
    }

    private void inicializarMenu() {
        JPanel panelPrincipal = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(45, 92, 5, 92);

        labelMenu = new JLabel("Menu", SwingConstants.CENTER);
        labelMenu.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelPrincipal.add(labelMenu, gbc);

        lab1Button = new JButton("Lab 1");
        lab2Button = new JButton("Lab 2");
        lab3Button = new JButton("Lab 3");
        lab4Button = new JButton("Lab 4");
        lab5Button = new JButton("Lab 5");
        lab6Button = new JButton("Lab 6");
        lab7Button = new JButton("Lab 7");
        volverButton = new JButton("Volver");

        Dimension botonDimension = new Dimension(100, 30);
        lab1Button.setPreferredSize(botonDimension);
        lab2Button.setPreferredSize(botonDimension);
        lab3Button.setPreferredSize(botonDimension);
        lab4Button.setPreferredSize(botonDimension);
        lab5Button.setPreferredSize(botonDimension);
        lab6Button.setPreferredSize(botonDimension);
        lab7Button.setPreferredSize(botonDimension);
        volverButton.setPreferredSize(botonDimension);

        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;

        gbc.gridx = 0;
        panelPrincipal.add(lab1Button, gbc);

        gbc.gridx = 1;
        panelPrincipal.add(lab2Button, gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;
        panelPrincipal.add(lab3Button, gbc);

        gbc.gridx = 1;
        panelPrincipal.add(lab4Button, gbc);

        gbc.gridy = 3;
        gbc.gridx = 0;
        panelPrincipal.add(lab5Button, gbc);

        gbc.gridx = 1;
        panelPrincipal.add(lab6Button, gbc);

        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        panelPrincipal.add(lab7Button, gbc);

        gbc.gridy = 5;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panelPrincipal.add(volverButton, gbc);

        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setLocationRelativeTo(null);
        setResizable(false);

        // ActionListener para el botón "Lab 1"
        lab1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarLab1();
            }
        });

        // ActionListener para el botón "Lab 2"
        lab2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarLab2();
            }
        });

        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                volverAForma();
            }
        });
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

    private void volverAForma() {
        Forma forma = new Forma();
        forma.setVisible(true);
        this.dispose();
    }
}
