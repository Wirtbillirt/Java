import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Baraja extends JFrame {
    private JTextArea areaTexto;
    private JTextField tamanoField;
    private JTextField elementosField;
    private JButton establecerTamanoButton;
    private JButton agregarElementosButton;
    private JButton ordenarButton;
    private int[] vector;
    private int tamano;

    public Baraja(Menuordenacion menuOrdenacion) {
        setTitle("Ordenación por Baraja");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Panel principal
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Panel superior
        JPanel panelSuperior = new JPanel(new GridLayout(2, 2, 10, 10));

        JLabel tamanoLabel = new JLabel("Tamaño del arreglo:");
        tamanoField = new JTextField();
        panelSuperior.add(tamanoLabel);
        panelSuperior.add(tamanoField);

        JLabel elementosLabel = new JLabel("Ingrese los elementos (separados por comas):");
        elementosField = new JTextField();
        elementosField.setEnabled(false);
        panelSuperior.add(elementosLabel);
        panelSuperior.add(elementosField);

        panelPrincipal.add(panelSuperior, BorderLayout.NORTH);

        // Área de texto
        areaTexto = new JTextArea(10, 30);
        areaTexto.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaTexto);
        panelPrincipal.add(scrollPane, BorderLayout.CENTER);

        // Panel inferior con los botones
        JPanel panelBotones = new JPanel(new BorderLayout());

        // Botón Regresar en la esquina inferior izquierda
        JPanel panelIzquierdo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton regresarButton = new JButton("Regresar");
        panelIzquierdo.add(regresarButton);
        panelBotones.add(panelIzquierdo, BorderLayout.WEST);

        // Otros botones en la parte inferior derecha
        JPanel panelDerecho = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        establecerTamanoButton = new JButton("Establecer Tamaño");
        agregarElementosButton = new JButton("Agregar Elementos");
        agregarElementosButton.setEnabled(false);
        ordenarButton = new JButton("Ordenar");
        ordenarButton.setEnabled(false);

        panelDerecho.add(establecerTamanoButton);
        panelDerecho.add(agregarElementosButton);
        panelDerecho.add(ordenarButton);
        panelBotones.add(panelDerecho, BorderLayout.EAST);

        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

        setContentPane(panelPrincipal);

        // Acción del botón "Regresar"
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuOrdenacion.setVisible(true);
                dispose(); // Cierra la ventana actual
            }
        });

        // Acciones de los otros botones
        establecerTamanoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                establecerTamano();
            }
        });

        agregarElementosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarElementos();
            }
        });

        ordenarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ordenar();
            }
        });
    }

    private void establecerTamano() {
        try {
            tamano = Integer.parseInt(tamanoField.getText());
            if (tamano <= 0) {
                mostrarMensaje("El tamaño debe ser mayor a 0");
                return;
            }
            vector = new int[tamano];
            areaTexto.setText("Arreglo desordenado:\n");
            elementosField.setEnabled(true);
            agregarElementosButton.setEnabled(true);
            ordenarButton.setEnabled(false);
            establecerTamanoButton.setEnabled(false);
        } catch (NumberFormatException ex) {
            mostrarMensaje("Por favor, ingrese un número válido para el tamaño del arreglo.");
        }
    }

    private void agregarElementos() {
        try {
            String[] elementos = elementosField.getText().split(",");
            if (elementos.length != tamano) {
                mostrarMensaje("Debe ingresar exactamente " + tamano + " elementos.");
                return;
            }

            for (int i = 0; i < tamano; i++) {
                vector[i] = Integer.parseInt(elementos[i].trim());
                areaTexto.append(vector[i] + "   ");
            }

            areaTexto.append("\n");
            ordenarButton.setEnabled(true);
            agregarElementosButton.setEnabled(false);
            elementosField.setEnabled(false);

        } catch (NumberFormatException ex) {
            mostrarMensaje("Por favor, ingrese números válidos separados por comas.");
        }
    }

    private void ordenar() {
        ordenarBaraja(vector, tamano);
        areaTexto.append("\nArreglo ordenado:\n");
        for (int i = 0; i < tamano; i++) {
            areaTexto.append(vector[i] + "   ");
        }
        ordenarButton.setEnabled(false);
    }

    public static void ordenarBaraja(int[] vector, int tamano) {
        for (int i = 1; i < tamano; i++) {
            int AUX = vector[i];
            int k = i - 1;
            while (k >= 0 && AUX < vector[k]) {
                vector[k + 1] = vector[k];
                k--;
            }
            vector[k + 1] = AUX;
        }
    }

    // Método para mostrar mensajes dentro del área de texto
    private void mostrarMensaje(String mensaje) {
        areaTexto.append("\n" + mensaje + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Crear una instancia de Menuordenacion para probar Baraja
            Menuordenacion menuOrdenacion = new Menuordenacion(new Lab2(null));
            Baraja baraja = new Baraja(menuOrdenacion);
            baraja.setVisible(true);
        });
    }
}

