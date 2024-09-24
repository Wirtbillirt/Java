import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Lab1_3 extends JFrame {
    private String[] nombres;
    private String[] sexos;
    private int[] edades;
    private int n = -1; // Número de empleados registrados
    private int tam;

    private JTextField nombreField, sexoField, edadField;
    private JTextField buscarNombreField, nuevaEdadField;
    private JTextField listarEmpleadoField; // Campo para listar un empleado
    private JTextField tamanoField; // Campo para el tamaño del arreglo
    private JButton establecerTamanoButton, listarButton, volverButton, darAltaButton;
    private JTextArea listadoArea;
    private JButton aceptarModificarButton, aceptarBajaButton;
    private JTextField nombreBajaField; // Campo para el nombre a eliminar
    private Desordenado desordenado;

    public Lab1_3(Desordenado desordenado) {
        this.desordenado = desordenado;
        inicializarGestionEmpleados();
    }

    private void inicializarGestionEmpleados() {
        setTitle("Gestión de Empleados");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        // Nombre completo
        JLabel nombreLabel = new JLabel("Nombre completo:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panelPrincipal.add(nombreLabel, gbc);

        nombreField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panelPrincipal.add(nombreField, gbc);

        // Sexo
        JLabel sexoLabel = new JLabel("Sexo (M/F):");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panelPrincipal.add(sexoLabel, gbc);

        sexoField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panelPrincipal.add(sexoField, gbc);

        // Edad
        JLabel edadLabel = new JLabel("Edad:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        panelPrincipal.add(edadLabel, gbc);

        edadField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 3;
        panelPrincipal.add(edadField, gbc);

        // Botones
        darAltaButton = new JButton("Dar de Alta");
        gbc.gridx = 2;
        gbc.gridy = 3;
        panelPrincipal.add(darAltaButton, gbc);

        listarButton = new JButton("Listar Varones");
        gbc.gridx = 3;
        gbc.gridy = 3;
        panelPrincipal.add(listarButton, gbc);

        // Botón volver
        volverButton = new JButton("Volver");
        gbc.gridx = 0;
        gbc.gridy = 10;
        panelPrincipal.add(volverButton, gbc);

        // Panel para modificar empleado
        JLabel modificarLabel = new JLabel("Actualizar Edad:");
        gbc.gridx = 0;
        gbc.gridy = 4;
        panelPrincipal.add(modificarLabel, gbc);

        buscarNombreField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 4;
        panelPrincipal.add(buscarNombreField, gbc);

        nuevaEdadField = new JTextField(10);
        gbc.gridx = 2;
        gbc.gridy = 4;
        panelPrincipal.add(nuevaEdadField, gbc);

        aceptarModificarButton = new JButton("Aceptar");
        gbc.gridx = 3;
        gbc.gridy = 4;
        panelPrincipal.add(aceptarModificarButton, gbc);

        // JLabel y campo para listar un empleado
        JLabel listarLabel = new JLabel("Listar Empleado:");
        gbc.gridx = 0;
        gbc.gridy = 5;
        panelPrincipal.add(listarLabel, gbc);

        listarEmpleadoField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 5;
        panelPrincipal.add(listarEmpleadoField, gbc);

        JButton listarUnoButton = new JButton("Listar");
        gbc.gridx = 2;
        gbc.gridy = 5;
        panelPrincipal.add(listarUnoButton, gbc);

        // JLabel para eliminar empleado
        JLabel bajaLabel = new JLabel("Eliminar Empleado:");
        gbc.gridx = 0;
        gbc.gridy = 6;
        panelPrincipal.add(bajaLabel, gbc);

        nombreBajaField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 6;
        panelPrincipal.add(nombreBajaField, gbc);

        aceptarBajaButton = new JButton("Aceptar");
        gbc.gridx = 2;
        gbc.gridy = 6;
        panelPrincipal.add(aceptarBajaButton, gbc);

        // Panel para listar todos los empleados
        listadoArea = new JTextArea(10, 40);
        listadoArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(listadoArea);
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 4;
        panelPrincipal.add(scrollPane, gbc);

        // Acción de establecer tamaño
        establecerTamanoButton.addActionListener(e -> establecerTamano());
        darAltaButton.addActionListener(e -> darDeAlta());
        listarButton.addActionListener(e -> listarVarones());
        aceptarModificarButton.addActionListener(e -> modificarEdad());
        listarUnoButton.addActionListener(e -> listarEmpleado());
        aceptarBajaButton.addActionListener(e -> darDeBaja());
        volverButton.addActionListener(e -> volverADesordenado());

        setContentPane(panelPrincipal);
    }

    private void establecerTamano() {
        try {
            tam = Integer.parseInt(tamanoField.getText());
            if (tam <= 0) {
                listadoArea.setText("Error: El tamaño debe ser mayor que cero.");
            } else {
                nombres = new String[tam];
                sexos = new String[tam];
                edades = new int[tam];
                n = 0; // Reseteamos el número de empleados
                listadoArea.setText("Tamaño del arreglo establecido a " + tam);
            }
        } catch (NumberFormatException e) {
            listadoArea.setText("Error: Debe ingresar un número válido.");
        }
    }

    private void darDeAlta() {
        if (tam <= 0) {
            listadoArea.setText("Error: Establezca primero el tamaño del arreglo.");
            return;
        }
        if (n < tam) {
            nombres[n] = nombreField.getText();
            sexos[n] = sexoField.getText();
            edades[n] = Integer.parseInt(edadField.getText());
            n++;
            listadoArea.setText("Empleado " + nombres[n - 1] + " dado de alta.");
        } else {
            listadoArea.setText("Error: El arreglo está lleno.");
        }
    }

    private void listarVarones() {
        StringBuilder varones = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (sexos[i].equalsIgnoreCase("M")) {
                varones.append(nombres[i]).append(" - ").append(edades[i]).append(" años\n");
            }
        }
        if (varones.length() == 0) {
            listadoArea.setText("No hay empleados varones registrados.");
        } else {
            listadoArea.setText(varones.toString());
        }
    }

    private void modificarEdad() {
        String nombreBuscar = buscarNombreField.getText();
        for (int i = 0; i < n; i++) {
            if (nombres[i].equalsIgnoreCase(nombreBuscar)) {
                edades[i] = Integer.parseInt(nuevaEdadField.getText());
                listadoArea.setText("Edad de " + nombres[i] + " actualizada.");
                return;
            }
        }
        listadoArea.setText("Empleado no encontrado.");
    }

    private void listarEmpleado() {
        String nombreBuscar = listarEmpleadoField.getText();
        for (int i = 0; i < n; i++) {
            if (nombres[i].equalsIgnoreCase(nombreBuscar)) {
                listadoArea.setText(nombres[i] + " - " + sexos[i] + " - " + edades[i] + " años");
                return;
            }
        }
        listadoArea.setText("Empleado no encontrado.");
    }

    private void darDeBaja() {
        String nombreBaja = nombreBajaField.getText();
        for (int i = 0; i < n; i++) {
            if (nombres[i].equalsIgnoreCase(nombreBaja)) {
                // Shift left
                for (int j = i; j < n - 1; j++) {
                    nombres[j] = nombres[j + 1];
                    sexos[j] = sexos[j + 1];
                    edades[j] = edades[j + 1];
                }
                n--; // Reduce the count
                listadoArea.setText("Empleado " + nombreBaja + " dado de baja.");
                return;
            }
        }
        listadoArea.setText("Empleado no encontrado.");
    }

    private void volverADesordenado() {
        desordenado.setVisible(true);
        this.dispose();
    }
}
