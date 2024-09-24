import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menuordenacion extends JFrame {
    private JButton burbujaButton;
    private JButton burbujaSenalButton;
    private JButton shellButton;
    private JButton insercionDirectaButton;
    private JButton sacudidaButton;
    private JButton barajaButton;
    private JButton regresarButton;

    public Menuordenacion(Lab2 lab2) {
        inicializarMenuordenacion(lab2);
    }

    private void inicializarMenuordenacion(Lab2 lab2) {
        setTitle("Métodos de Ordenación");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Configurar layout principal
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Crear el JLabel para el título
        JLabel labelTitulo = new JLabel("Métodos de Ordenación", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        panelPrincipal.add(labelTitulo, BorderLayout.NORTH);

        // Crear los botones para los métodos de ordenación
        burbujaButton = new JButton("Burbuja");
        burbujaSenalButton = new JButton("Burbuja con Señal");
        shellButton = new JButton("Shell");
        insercionDirectaButton = new JButton("Inserción Directa");
        sacudidaButton = new JButton("Sacudida");
        barajaButton = new JButton("Baraja");
        regresarButton = new JButton("Regresar");

        // Panel central con GridBagLayout para centrar los botones
        JPanel panelBotones = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        panelBotones.add(burbujaButton, gbc);

        gbc.gridy = 1;
        panelBotones.add(burbujaSenalButton, gbc);

        gbc.gridy = 2;
        panelBotones.add(shellButton, gbc);

        gbc.gridy = 3;
        panelBotones.add(insercionDirectaButton, gbc);

        gbc.gridy = 4;
        panelBotones.add(sacudidaButton, gbc);

        gbc.gridy = 5;
        panelBotones.add(barajaButton, gbc);

        panelPrincipal.add(panelBotones, BorderLayout.CENTER);

        // Panel inferior con el botón "Regresar"
        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelInferior.add(regresarButton);
        panelPrincipal.add(panelInferior, BorderLayout.SOUTH);

        setContentPane(panelPrincipal);

        // Acción para el botón "Burbuja"
        burbujaButton.addActionListener(e -> mostrarBurbuja());

        // Acción para el botón "Regresar"
        regresarButton.addActionListener(e -> regresarALab2(lab2));
        // Acción para el botón "Sacudida"
        sacudidaButton.addActionListener(e -> mostrarSacudida());
        barajaButton.addActionListener(e -> mostrarBaraja());
        // Acción para el botón "Inserción Directa"
        insercionDirectaButton.addActionListener(e -> mostrarSeleccion());
        shellButton.addActionListener(e -> mostrarShell());

        burbujaSenalButton.addActionListener(e -> mostrarBurbujaSeñal());{

        }

    }

    private void mostrarBurbuja() {
        Burbuja burbuja = new Burbuja(this);
        burbuja.setVisible(true);
        this.dispose();
    }
    private void mostrarSacudida() {
        Sacudida sacudida = new Sacudida(this);
        sacudida.setVisible(true);
        this.dispose();
    }

    private void mostrarBaraja() {
        Baraja baraja = new Baraja(this);
        baraja.setVisible(true);
        this.dispose();
    }

    private void mostrarSeleccion() {
        Seleccion seleccion = new Seleccion(this);
        seleccion.setVisible(true);
        this.dispose();
    }
    private void mostrarShell() {
        Shell shell = new Shell (this);
        shell.setVisible(true);
        this.dispose();
    }



    private void regresarALab2(Lab2 lab2) {
        lab2.setVisible(true);
        this.dispose();
    }

    private void mostrarBurbujaSeñal() {
        Burbujaseñal burbujaSenal = new Burbujaseñal(this);
        burbujaSenal.setVisible(true);
        this.dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Puedes crear una instancia de Lab2 aquí si es necesario para probar Menuordenacion
            Lab2 lab2 = new Lab2(null);
            Menuordenacion menuordenacion = new Menuordenacion(lab2);
            menuordenacion.setVisible(true);
        });
    }
}
