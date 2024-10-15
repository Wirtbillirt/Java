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
    private JLabel labelWilNombre;
    private JLabel labelAngel;
    private JLabel labelAngelNombre;
    private JButton botonSiguiente;

    public Forma() {
        inicializarForma();
    }

    private void inicializarForma() {
        // Crear los JLabels de texto
        labelUniversidad = new JLabel("UNIVERSIDAD NACIONAL DE INGENIERÍA");
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
        ImageIcon fondo = cargarImagen("/Fondo.jpg");
        ImageIcon iconoAngel = cargarImagen("/Angel.jpg");

        if (iconoLogo != null && iconoWil != null && iconoAngel != null) {
            Image imagenLogo = iconoLogo.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            Image imagenWil = iconoWil.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            Image imagenAngel = iconoAngel.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            labelLogo = new JLabel(new ImageIcon(imagenLogo));
            labelWil = new JLabel(new ImageIcon(imagenWil));
            labelAngel = new JLabel(new ImageIcon(imagenAngel));

            // Agregar los nombres debajo de las imágenes
            labelWilNombre = new JLabel("Wilberth Alejandro Pérez Loredo");
            labelWilNombre.setHorizontalAlignment(JLabel.CENTER);
            labelAngelNombre = new JLabel("Ángel Rafael Maltez Navarrete");
            labelAngelNombre.setHorizontalAlignment(JLabel.CENTER);
        }

        // Inicializar el panel principal con fondo
        panel1 = new FondoPanel(fondo.getImage());
        panel1.setLayout(new BorderLayout());

        // Panel superior con el logo
        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.setOpaque(false); // Hacer transparente
        panelSuperior.setBorder(BorderFactory.createEmptyBorder(-10, 10, 10, 10));
        panelSuperior.add(labelLogo, BorderLayout.WEST);

        // Panel central con texto
        JPanel panelCentral = new JPanel(new GridBagLayout());
        panelCentral.setOpaque(false); // Hacer transparente
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

        // Panel inferior con las imágenes y los nombres
        JPanel panelInferior = new JPanel(new GridLayout(1, 2));  // Distribuir las imágenes en dos columnas
        panelInferior.setOpaque(false); // Hacer transparente

        // Panel izquierdo con imagen Wil y su nombre
        JPanel panelIzquierda = new JPanel(new BorderLayout());
        panelIzquierda.setOpaque(false); // Hacer transparente
        panelIzquierda.add(labelWil, BorderLayout.CENTER);
        panelIzquierda.add(labelWilNombre, BorderLayout.SOUTH);

        // Panel derecho con imagen Angel y su nombre
        JPanel panelDerecha = new JPanel(new BorderLayout());
        panelDerecha.setOpaque(false); // Hacer transparente
        panelDerecha.add(labelAngel, BorderLayout.CENTER);
        panelDerecha.add(labelAngelNombre, BorderLayout.SOUTH);

        panelInferior.add(panelIzquierda);
        panelInferior.add(panelDerecha);

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
        panelBoton.setOpaque(false); // Hacer transparente
        panelBoton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelBoton.add(botonSiguiente);
        panel1.add(panelBoton, BorderLayout.SOUTH);

        // Configurar la ventana
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
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

    // Clase personalizada para establecer la imagen de fondo
    class FondoPanel extends JPanel {
        private Image imagenFondo;

        public FondoPanel(Image imagen) {
            this.imagenFondo = imagen;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (imagenFondo != null) {
                g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }

    public static void main(String[] args) {
        Forma forma = new Forma();
        forma.setVisible(true);
    }
}
