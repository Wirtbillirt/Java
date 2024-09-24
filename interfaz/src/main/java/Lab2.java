import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab2 extends JFrame {
    private JButton metodoOrdenacionButton;
    private JButton busquedaBinariaButton;
    private JButton regresarButton;
    private Menu menu;

    public Lab2(Menu menu) {
        this.menu = menu;
        inicializarLab2();
    }

    private void inicializarLab2() {
        setTitle("Lab 2");
        setSize(400, 500); // Tamaño igual al de Menu
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Configurar layout principal
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Configurar JLabel para el título
        JLabel titulo = new JLabel("<html><div style='text-align: center;'>Métodos de Ordenación y Búsqueda</div></html>", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        panelPrincipal.add(titulo, BorderLayout.NORTH);

        // Crear los botones
        metodoOrdenacionButton = new JButton("Métodos de Ordenación");
        busquedaBinariaButton = new JButton("Búsqueda Binaria");
        regresarButton = new JButton("Regresar");

        // Crear panel para los botones y alinearlos horizontalmente
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        panelBotones.add(metodoOrdenacionButton, gbc);

        gbc.gridx = 1;
        panelBotones.add(busquedaBinariaButton, gbc);

        // Añadir panel de botones al centro del panel principal
        panelPrincipal.add(panelBotones, BorderLayout.CENTER);

        // Panel inferior con el botón "Regresar" alineado a la izquierda
        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelInferior.add(regresarButton);
        panelPrincipal.add(panelInferior, BorderLayout.SOUTH);

        setContentPane(panelPrincipal);

        // Acción para el botón "Métodos de Ordenación"
        metodoOrdenacionButton.addActionListener(e -> mostrarMenuOrdenacion());

        // Acción para el botón "Búsqueda Binaria"
        busquedaBinariaButton.addActionListener(e -> mostrarBusquedadBinaria());

        // Acción para el botón "Regresar"
        regresarButton.addActionListener(e -> regresarAMenu());
    }

    private void mostrarMenuOrdenacion() {
        Menuordenacion menuordenacion = new Menuordenacion(this);
        menuordenacion.setVisible(true);
        this.dispose();
    }

    private void mostrarBusquedadBinaria() {
        BusquedadBinaria busquedadBinaria = new BusquedadBinaria(this);
        busquedadBinaria.setVisible(true);
        this.dispose();
    }

    private void regresarAMenu() {
        menu.setVisible(true);
        this.dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Menu menu = new Menu(null); // Puedes reemplazar null por una referencia válida si es necesario
            Lab2 lab2 = new Lab2(menu);
            lab2.setVisible(true);
        });
    }
}
