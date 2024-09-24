import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab1_2 extends JFrame {
    private String[] nombres;
    private String[] telefonos;
    private double[] saldos;
    private boolean[] morosos;
    private int n = -1; // Número de clientes registrados
    private int tam;

    private JTextField nombreField, telefonoField, saldoField;
    private JCheckBox morosoCheckBox;
    private JTextField buscarNombreField;
    private JTextField tamanoField; // Campo para el tamaño del arreglo
    private JButton establecerTamanoButton, listarButton, volverButton, darAltaButton;
    private JTextArea listadoArea;
    private JButton aceptarModificarMorosoButton, aceptarBajaButton;
    private JTextField nombreModificarMorosoField, nombreBajaField;

    public Lab1_2(JFrame frame) {
        inicializarLab1_2(frame);
    }

    private void inicializarLab1_2(JFrame frame) {
        setTitle("Gestión de Clientes");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panelPrincipal = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Establecer tamaño del arreglo
        JLabel tamanoLabel = new JLabel("Establecer tamaño del arreglo:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelPrincipal.add(tamanoLabel, gbc);

        tamanoField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panelPrincipal.add(tamanoField, gbc);

        establecerTamanoButton = new JButton("Establecer tamaño");
        gbc.gridx = 2;
        gbc.gridy = 0;
        panelPrincipal.add(establecerTamanoButton, gbc);

        // Nombre del cliente
        JLabel nombreLabel = new JLabel("Nombre:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panelPrincipal.add(nombreLabel, gbc);

        nombreField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panelPrincipal.add(nombreField, gbc);

        // Teléfono del cliente
        JLabel telefonoLabel = new JLabel("Teléfono:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panelPrincipal.add(telefonoLabel, gbc);

        telefonoField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panelPrincipal.add(telefonoField, gbc);

        // Saldo del cliente
        JLabel saldoLabel = new JLabel("Saldo:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        panelPrincipal.add(saldoLabel, gbc);

        saldoField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 3;
        panelPrincipal.add(saldoField, gbc);

        // Moroso
        JLabel morosoLabel = new JLabel("Moroso:");
        gbc.gridx = 0;
        gbc.gridy = 4;
        panelPrincipal.add(morosoLabel, gbc);

        morosoCheckBox = new JCheckBox();
        gbc.gridx = 1;
        gbc.gridy = 4;
        panelPrincipal.add(morosoCheckBox, gbc);

        // Botones
        darAltaButton = new JButton("Dar de Alta");
        gbc.gridx = 2;
        gbc.gridy = 4;
        panelPrincipal.add(darAltaButton, gbc);

        listarButton = new JButton("Listar Todos");
        gbc.gridx = 3;
        gbc.gridy = 4;
        panelPrincipal.add(listarButton, gbc);

        volverButton = new JButton("Volver");
        gbc.gridx = 0;
        gbc.gridy = 10;
        panelPrincipal.add(volverButton, gbc);

        // Panel para modificar estado moroso
        JLabel modificarMorosoLabel = new JLabel("Modificar Estado Moroso:");
        gbc.gridx = 0;
        gbc.gridy = 6;
        panelPrincipal.add(modificarMorosoLabel, gbc);

        nombreModificarMorosoField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 6;
        panelPrincipal.add(nombreModificarMorosoField, gbc);

        aceptarModificarMorosoButton = new JButton("Aceptar");
        gbc.gridx = 2;
        gbc.gridy = 6;
        panelPrincipal.add(aceptarModificarMorosoButton, gbc);

        // Panel para eliminar cliente
        JLabel bajaLabel = new JLabel("Eliminar Cliente:");
        gbc.gridx = 0;
        gbc.gridy = 8;
        panelPrincipal.add(bajaLabel, gbc);

        nombreBajaField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 8;
        panelPrincipal.add(nombreBajaField, gbc);

        aceptarBajaButton = new JButton("Aceptar");
        gbc.gridx = 2;
        gbc.gridy = 8;
        panelPrincipal.add(aceptarBajaButton, gbc);

        // Panel para listar todos los clientes
        listadoArea = new JTextArea(10, 40);
        listadoArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(listadoArea);
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 5;
        panelPrincipal.add(scrollPane, gbc);

        setContentPane(panelPrincipal);

        // Listeners
        establecerTamanoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                establecerTamano();
            }
        });

        darAltaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                darDeAlta();
            }
        });

        listarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarTodos();
            }
        });

        aceptarModificarMorosoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarEstadoMoroso();
            }
        });

        aceptarBajaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                darDeBaja();
            }
        });

        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(true);
                dispose();
            }
        });
    }

    private void establecerTamano() {
        try {
            tam = Integer.parseInt(tamanoField.getText());
            if (tam > 0) {
                nombres = new String[tam];
                telefonos = new String[tam];
                saldos = new double[tam];
                morosos = new boolean[tam];
                establecerTamanoButton.setEnabled(false);
                listadoArea.setText("Tamaño del arreglo establecido a " + tam);
            }
        } catch (NumberFormatException ex) {
            listadoArea.setText("Error: Ingrese un número válido para el tamaño.");
        }
    }

    private void darDeAlta() {
        if (n < tam - 1) {
            n++;
            nombres[n] = nombreField.getText();
            telefonos[n] = telefonoField.getText();
            saldos[n] = Double.parseDouble(saldoField.getText());
            morosos[n] = morosoCheckBox.isSelected();
            nombreField.setText("");
            telefonoField.setText("");
            saldoField.setText("");
            morosoCheckBox.setSelected(false);
            listadoArea.setText("Cliente " + nombres[n] + " dado de alta.");
        } else {
            listadoArea.setText("Error: El arreglo está lleno.");
        }
    }

    private void modificarEstadoMoroso() {
        String nombreModificar = nombreModificarMorosoField.getText();
        int pos = buscar(nombreModificar);
        if (pos >= 0) {
            morosos[pos] = !morosos[pos]; // Cambia el estado moroso al opuesto
            listadoArea.setText("Estado moroso del cliente " + nombres[pos] + " modificado a " + (morosos[pos] ? "Sí" : "No"));
        } else {
            listadoArea.setText("Cliente no encontrado.");
        }
    }

    private void darDeBaja() {
        String nombreBaja = nombreBajaField.getText();
        int pos = buscar(nombreBaja);
        if (pos >= 0) {
            for (int i = pos; i < n; i++) {
                nombres[i] = nombres[i + 1];
                telefonos[i] = telefonos[i + 1];
                saldos[i] = saldos[i + 1];
                morosos[i] = morosos[i + 1];
            }
            n--;
            listadoArea.setText("Cliente dado de baja correctamente.");
        } else {
            listadoArea.setText("Cliente no encontrado.");
        }
    }

    private void listarTodos() {
        listadoArea.setText("");
        for (int i = 0; i <= n; i++) {
            listadoArea.append("Cliente: " + nombres[i] + "\nTeléfono: " + telefonos[i] + "\nSaldo: " + saldos[i] + "\nMoroso: " + (morosos[i] ? "Sí" : "No") + "\n\n");
        }
    }

    private int buscar(String nombre) {
        for (int i = 0; i <= n; i++) {
            if (nombres[i].equals(nombre)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        new Lab1_2(frame).setVisible(true);
    }
}
