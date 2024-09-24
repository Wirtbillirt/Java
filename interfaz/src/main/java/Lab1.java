import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab1 extends JFrame {
    private JButton ordenadosButton;
    private JButton desordenadosButton;
    private JButton volverButton;
    private JLabel labelTitulo;

    public Lab1() {
        inicializarLab1();
    }

    private void inicializarLab1() {
        // Configurar layout principal
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Configurar JLabel para el título con múltiples líneas
        labelTitulo = new JLabel("<html>ACTUALIZACION EN ARREGLOS<br>ORDENADOS Y DESORDENADOS</html>", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        labelTitulo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelPrincipal.add(labelTitulo, BorderLayout.NORTH);

        // Crear los botones
        ordenadosButton = new JButton("Ordenados");
        desordenadosButton = new JButton("Desordenados");
        volverButton = new JButton("Volver");

        // Panel central con GridBagLayout para centrar los botones
        JPanel panelBotones = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        panelBotones.add(ordenadosButton, gbc);

        gbc.gridy = 1;
        panelBotones.add(desordenadosButton, gbc);

        // Añadir panel de botones al centro del panel principal
        panelPrincipal.add(panelBotones, BorderLayout.CENTER);

        // Panel inferior con el botón "Volver"
        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelInferior.add(volverButton);
        panelPrincipal.add(panelInferior, BorderLayout.SOUTH);

        // Configurar la ventana
        setContentPane(panelPrincipal);
        setSize(400, 500); // Tamaño ajustado para ser consistente con otras ventanas
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        setResizable(false); // Evitar que se redimensione la ventana

        // Añadir ActionListener para el botón "Ordenados"
        ordenadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarOrdenado();
            }
        });

        desordenadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarDesordenado();
            }
        });

        // Añadir ActionListener para el botón "Volver"
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                volverAMenu();
            }
        });
    }

    private void mostrarOrdenado() {
        // Crear instancia de Ordenado y cerrar la ventana actual
        ordenado Ordenado = new ordenado(this);
        Ordenado.setVisible(true);
        this.dispose();
    }

    private void mostrarDesordenado() {
        // Crear instancia de Desordenado y cerrar la ventana actual
        Desordenado desordenado = new Desordenado(this);
        desordenado.setVisible(true);
        this.dispose();
    }

    private void volverAMenu() {
        // Crear instancia de Menu y cerrar esta ventana
        Menu menu = new Menu(null); // Pasar null ya que no se necesita referencia a Forma
        menu.setVisible(true);
        this.dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Lab1 lab1 = new Lab1();
            lab1.setVisible(true);
        });
    }
}