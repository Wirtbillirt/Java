import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Binaria extends JFrame {
    private JTextField tamanoField;
    private JTextField elementosField;
    private JTextField buscarField;
    private JTextArea areaTexto;
    private JButton establecerTamanoButton;
    private JButton agregarElementosButton;
    private JButton buscarButton;
    private JButton volverButton;
    private BusquedadBinaria busquedadBinaria;
    private int[] vector;
    private int tamano;

    public Binaria(BusquedadBinaria busquedadBinaria) {
        this.busquedadBinaria = busquedadBinaria;
        inicializarBinaria();
    }

    private void inicializarBinaria() {
        setTitle("Búsqueda Binaria");
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

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarNumero();
            }
        });
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
            ordenarSeleccion(vector, tamano);
            areaTexto.append("Arreglo ordenado:\n");
            for (int i = 0; i < tamano; i++) {
                areaTexto.append(vector[i] + "   ");
            }
            areaTexto.append("\n");
            buscarButton.setEnabled(true);
            agregarElementosButton.setEnabled(false);
            elementosField.setEnabled(false);

        } catch (NumberFormatException ex) {
            areaTexto.append("Por favor, ingrese números válidos separados por comas.\n");
        }
    }

    private void buscarNumero() {
        try {
            int buscar = Integer.parseInt(buscarField.getText());
            int posicion = busquedaBinaria(vector, tamano, buscar);
            if (posicion != -1) {
                areaTexto.append("El número " + buscar + " se encuentra en el arreglo en la posición " + posicion + ".\n");
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

    public static void ordenarSeleccion(int vector[], int tam) {
        for (int i = 0; i < tam - 1; i++) {
            int menor = vector[i];
            int k = i;
            for (int j = i + 1; j < tam; j++) {
                if (vector[j] < menor) {
                    menor = vector[j];
                    k = j;
                }
            }
            int temp = vector[i];
            vector[i] = menor;
            vector[k] = temp;
        }
    }

    public static int busquedaBinaria(int vector[], int tam, int x) {
        int inicio = 0, fin = tam - 1;

        while (inicio <= fin) {
            int centro = (inicio + fin) / 2;
            if (x == vector[centro]) {
                return centro;
            } else if (x < vector[centro]) {
                fin = centro - 1;
            } else {
                inicio = centro + 1;
            }
        }

        return -1;
    }
}
