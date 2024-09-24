import javax.swing.*;
import java.awt.*;

public class BusquedadBinaria extends JFrame {

    private JButton volverButton;
    private JButton binariaButton;
    private JButton busquedaSecuencialButton;
    private JButton busquedaSecuencialOrdenadaButton;
    private Lab2 lab2;

    public BusquedadBinaria(Lab2 lab2) {
        this.lab2 = lab2;
        inicializarBusquedadBinaria();
    }

    private void inicializarBusquedadBinaria() {
        setTitle("Búsqueda Binaria");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Configurar layout principal
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Crear el JLabel para el título
        JLabel labelTitulo = new JLabel("Búsqueda Binaria", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        panelPrincipal.add(labelTitulo, BorderLayout.NORTH);

        // Crear los botones para las búsquedas
        binariaButton = new JButton("Búsqueda Binaria");
        busquedaSecuencialButton = new JButton("Desordenada");
        busquedaSecuencialOrdenadaButton = new JButton("Ordenada");
        volverButton = new JButton("Volver");

        // Panel central con GridBagLayout para centrar los botones
        JPanel panelBotones = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridy = 0;
        panelBotones.add(binariaButton, gbc);

        gbc.gridy = 1;
        panelBotones.add(busquedaSecuencialButton, gbc);

        gbc.gridy = 2;
        panelBotones.add(busquedaSecuencialOrdenadaButton, gbc);

        panelPrincipal.add(panelBotones, BorderLayout.CENTER);

        // Panel inferior con el botón "Volver" alineado a la izquierda
        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelInferior.add(volverButton);
        panelPrincipal.add(panelInferior, BorderLayout.SOUTH);

        setContentPane(panelPrincipal);

        // Acciones de los botones
        binariaButton.addActionListener(e -> abrirBinaria());
        busquedaSecuencialButton.addActionListener(e -> abrirBusquedaSecuencial());
        busquedaSecuencialOrdenadaButton.addActionListener(e -> abrirBusquedaSecuencialOrdenada());
        volverButton.addActionListener(e -> volverALab2());
    }

    private void abrirBinaria() {
        Binaria binaria = new Binaria(this);
        binaria.setVisible(true);
        this.dispose();
    }

    private void abrirBusquedaSecuencial() {
        BusquedaSecuencial busquedaSecuencial = new BusquedaSecuencial(this);
        busquedaSecuencial.setVisible(true);
        this.dispose();
    }

    private void abrirBusquedaSecuencialOrdenada() {
        BusquedaSecuencialOrdenada busquedaSecuencialOrdenada = new BusquedaSecuencialOrdenada(this);
        busquedaSecuencialOrdenada.setVisible(true);
        this.dispose();
    }

    private void volverALab2() {
        lab2.setVisible(true);
        this.dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Lab2 lab2 = new Lab2(null); // Cambia esto según tu implementación
            BusquedadBinaria busquedadBinaria = new BusquedadBinaria(lab2);
            busquedadBinaria.setVisible(true);
        });
    }
}
