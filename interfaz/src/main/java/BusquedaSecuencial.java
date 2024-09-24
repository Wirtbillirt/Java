import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BusquedaSecuencial extends JFrame {

    private JButton volverButton;
    private BusquedadBinaria busquedadBinaria;
    private JTextField tamanoField;
    private JTextField elementosField;
    private JTextField buscarField;
    private JTextArea areaTexto;
    private JButton establecerTamanoButton;
    private JButton agregarElementosButton;
    private JButton buscarButton;
    private int[] vector;
    private int tamano;

    public BusquedaSecuencial(BusquedadBinaria busquedadBinaria) {
        this.busquedadBinaria = busquedadBinaria;
        inicializarBusquedaSecuencial();
    }

    private void inicializarBusquedaSecuencial() {
        setTitle("Búsqueda Secuencial");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Panel principal
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Panel superior
        JPanel panelSuperior = new JPanel(new GridLayout(3, 3, 10, 10));

        JLabel tamanoLabel = new JLabel("Tamaño del arreglo:");
        tamanoField = new JTextField();
        establecerTamanoButton = new JButton("Establecer");

        panelSuperior.add(tamanoLabel);
        panelSuperior.add(tamanoField);
        panelSuperior.add(establecerTamanoButton);

        JLabel elementosLabel = new JLabel("Ingrese los elementos (separados por comas):");
        elementosField = new JTextField();
        agregarElementosButton = new JButton("Agregar");

        panelSuperior.add(elementosLabel);
        panelSuperior.add(elementosField);
        panelSuperior.add(agregarElementosButton);

        JLabel buscarLabel = new JLabel("Número a buscar:");
        buscarField = new JTextField();
        buscarButton = new JButton("Buscar");

        panelSuperior.add(buscarLabel);
        panelSuperior.add(buscarField);
        panelSuperior.add(buscarButton);

        panelPrincipal.add(panelSuperior, BorderLayout.NORTH);

        // Área de texto
        areaTexto = new JTextArea(10, 30);
        areaTexto.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaTexto);
        panelPrincipal.add(scrollPane, BorderLayout.CENTER);

        // Panel inferior con el botón de volver
        JPanel panelBotones = new JPanel(new FlowLayout());

        volverButton = new JButton("Volver");
        volverButton.addActionListener(e -> volverABusquedadBinaria());
        panelBotones.add(volverButton);

        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

        setContentPane(panelPrincipal);

        // Acción de los botones
        establecerTamanoButton.addActionListener(e -> establecerTamano());
        agregarElementosButton.addActionListener(e -> agregarElementos());
        buscarButton.addActionListener(e -> buscarNumero());
    }

    private void establecerTamano() {
        try {
            tamano = Integer.parseInt(tamanoField.getText());
            vector = new int[tamano];
            areaTexto.setText("Arreglo desordenado:\n");
            agregarElementosButton.setEnabled(true);
            elementosField.setEnabled(true);
            buscarField.setEnabled(true);
            establecerTamanoButton.setEnabled(false);
        } catch (NumberFormatException ex) {
            areaTexto.append("Por favor, ingrese un número válido para el tamaño del arreglo.\n");
        }
    }

    private void agregarElementos() {
        try {
            String[] elementos = elementosField.getText().split(",");
            if (elementos.length != tamano) {
                areaTexto.append("Debe ingresar exactamente " + tamano + " elementos.\n");
                return;
            }

            for (int i = 0; i < tamano; i++) {
                vector[i] = Integer.parseInt(elementos[i].trim());
                areaTexto.append(vector[i] + "   ");
            }
            areaTexto.append("\n");
            agregarElementosButton.setEnabled(false);
            elementosField.setEnabled(false);
            buscarButton.setEnabled(true);
        } catch (NumberFormatException ex) {
            areaTexto.append("Por favor, ingrese números válidos separados por comas.\n");
        }
    }

    private void buscarNumero() {
        try {
            int buscar = Integer.parseInt(buscarField.getText());
            int posicion = busquedaSecuencialDesordenada(vector, tamano, buscar);
            if (posicion != -1) {
                areaTexto.append("El número " + buscar + " se encuentra en la posición: " + posicion + ".\n");
            } else {
                areaTexto.append("El número " + buscar + " no se encuentra en el arreglo.\n");
            }
        } catch (NumberFormatException ex) {
            areaTexto.append("Por favor, ingrese un número válido para buscar.\n");
        }
    }

    private void volverABusquedadBinaria() {
        busquedadBinaria.setVisible(true);
        this.dispose();
    }

    // Modificar el método para que devuelva la posición del elemento si es encontrado.
    public static int busquedaSecuencialDesordenada(int vector[], int tam, int x) {
        for (int i = 0; i < tam; i++) {
            if (vector[i] == x) {
                return i; // Retorna la posición del elemento.
            }
        }
        return -1; // Retorna -1 si no lo encuentra.
    }
}

