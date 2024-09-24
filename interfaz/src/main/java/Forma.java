import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Forma extends JFrame {
    private JPanel panel1;
    private JLabel labelUniversidad;
    private JLabel labelDactic;
    private JLabel labelPrograma;
    private JLabel labelCurso;
    private JLabel labelDocente;
    private JLabel labelLogo;
    private JLabel labelWil;
    private JButton botonSiguiente;

    public Forma() {
        inicializarForma();
    }

    private void inicializarForma() {
        // Crear los JLabels de texto
        labelUniversidad = new JLabel("Universidad Nacional De Ingeniería");
        labelUniversidad.setHorizontalAlignment(JLabel.CENTER);
        labelDactic = new JLabel("DACTIC");
        labelDactic.setHorizontalAlignment(JLabel.CENTER);
        labelPrograma = new JLabel("PROGRAMA ACADÉMICO DE INGENIERÍA EN COMPUTACIÓN");
        labelPrograma.setHorizontalAlignment(JLabel.CENTER);
        labelCurso = new JLabel("ALGORITMIZACIÓN Y ESTRUCTURAS DE DATOS");
        labelCurso.setHorizontalAlignment(JLabel.CENTER);
        labelDocente = new JLabel("Docente: Eliezer Josue Aburto Plata");
        labelDocente.setHorizontalAlignment(JLabel.CENTER);

        // Configurar imágenes (asume que las imágenes están en el recurso adecuado)
        ImageIcon iconoLogo = cargarImagen("/logo_uni.png");
        ImageIcon iconoWil = cargarImagen("/wil.jpg");

        if (iconoLogo != null && iconoWil != null) {
            Image imagenLogo = iconoLogo.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            Image imagenWil = iconoWil.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            labelLogo = new JLabel(new ImageIcon(imagenLogo));
            labelWil = new JLabel(new ImageIcon(imagenWil));
        }

        // Inicializar el panel principal con BorderLayout
        panel1 = new JPanel(new BorderLayout());

        // Panel superior con el logo
        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.setBorder(BorderFactory.createEmptyBorder(-10, 10, 10, 10));
        panelSuperior.add(labelLogo, BorderLayout.WEST);

        // Panel central con texto
        JPanel panelCentral = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.CENTER;

        panelCentral.add(labelUniversidad, gbc);
        gbc.gridy++;
        panelCentral.add(labelDactic, gbc);
        gbc.gridy++;
        panelCentral.add(labelPrograma, gbc);
        gbc.gridy++;
        panelCentral.add(labelCurso, gbc);
        gbc.gridy++;
        panelCentral.add(labelDocente, gbc);
        panelCentral.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panelSuperior.add(panelCentral, BorderLayout.CENTER);

        // Panel inferior con la imagen 'Wil'
        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelInferior.setBorder(BorderFactory.createEmptyBorder(80, 10, 10, 10));
        panelInferior.add(labelWil);

        panel1.add(panelSuperior, BorderLayout.NORTH);
        panel1.add(panelInferior, BorderLayout.CENTER);

        // Crear el botón "Siguiente"
        botonSiguiente = new JButton("Siguiente");
        botonSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarMenu();
            }
        });

        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelBoton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelBoton.add(botonSiguiente);

        panel1.add(panelBoton, BorderLayout.SOUTH);

        // Configurar la ventana
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void mostrarMenu() {
        // Crear instancia de Menu y cerrar esta ventana
        Menu menu = new Menu(this);
        menu.setVisible(true);
        this.dispose();
    }

    private ImageIcon cargarImagen(String ruta) {
        try {
            if (getClass().getResource(ruta) != null) {
                return new ImageIcon(getClass().getResource(ruta));
            } else {
                System.out.println("Archivo no encontrado: " + ruta);
                return null;
            }
        } catch (Exception e) {
            System.out.println("No se pudo cargar la imagen: " + ruta);
            return null;
        }
    }

    public static void main(String[] args) {
        Forma forma = new Forma();
        forma.setVisible(true);
    }
}
