import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab1_4 extends JFrame {
    private String[] nombre;
    private String[] direccion;
    private int[] edad;
    private String[] sexo;
    private int[] antiguedad;
    private int n = -1; // Número de empleados registrados
    private int tam;

    private JTextField tamanoField, nombreField, direccionField, edadField, sexoField, antiguedadField;
    private JTextField nombreModField, antiguedadModField; // Campos para modificar antigüedad
    private JTextArea resultadoArea;
    private JButton establecerTamanoButton, altaButton, bajaButton, modificarButton, listarButton, buscarButton, volverButton;
    private JTextField buscarField; // Campo para buscar empleado

    public Lab1_4(ordenado ordenadoFrame) {
        inicializarLab1_4(ordenadoFrame);
    }

    private void inicializarLab1_4(ordenado ordenadoFrame) {
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

        tamanoField = new JTextField(10); // Campo para establecer el tamaño
        gbc.gridx = 1;
        gbc.gridy = 0;
        panelPrincipal.add(tamanoField, gbc);

        establecerTamanoButton = new JButton("Establecer tamaño");
        gbc.gridx = 2;
        gbc.gridy = 0;
        panelPrincipal.add(establecerTamanoButton, gbc);

        // Nombre completo
        JLabel nombreLabel = new JLabel("Nombre:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panelPrincipal.add(nombreLabel, gbc);

        nombreField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panelPrincipal.add(nombreField, gbc);

        // Dirección
        JLabel direccionLabel = new JLabel("Dirección:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panelPrincipal.add(direccionLabel, gbc);

        direccionField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panelPrincipal.add(direccionField, gbc);

        // Edad
        JLabel edadLabel = new JLabel("Edad:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        panelPrincipal.add(edadLabel, gbc);

        edadField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 3;
        panelPrincipal.add(edadField, gbc);

        // Sexo
        JLabel sexoLabel = new JLabel("Sexo (M/F):");
        gbc.gridx = 0;
        gbc.gridy = 4;
        panelPrincipal.add(sexoLabel, gbc);

        sexoField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 4;
        panelPrincipal.add(sexoField, gbc);

        // Antigüedad
        JLabel antiguedadLabel = new JLabel("Antigüedad:");
        gbc.gridx = 0;
        gbc.gridy = 5;
        panelPrincipal.add(antiguedadLabel, gbc);

        antiguedadField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 5;
        panelPrincipal.add(antiguedadField, gbc);

        // Botones
        altaButton = new JButton("Dar de Alta");
        gbc.gridx = 2;
        gbc.gridy = 3;
        panelPrincipal.add(altaButton, gbc);

        // Panel para modificar antigüedad
        JPanel modificarPanel = new JPanel();
        modificarPanel.setLayout(new FlowLayout()); // Alinear en una sola línea

        JLabel nombreModLabel = new JLabel("Nombre:");
        modificarPanel.add(nombreModLabel);

        nombreModField = new JTextField(10);
        modificarPanel.add(nombreModField);

        JLabel antiguedadModLabel = new JLabel("Nueva Antigüedad:");
        modificarPanel.add(antiguedadModLabel);

        antiguedadModField = new JTextField(5);
        modificarPanel.add(antiguedadModField);

        modificarButton = new JButton("Modificar Antigüedad");
        modificarPanel.add(modificarButton);

        gbc.gridx = 0;
        gbc.gridy = 6; // Ajusta la posición según tu diseño
        gbc.gridwidth = 3; // Asegúrate de que ocupa el espacio adecuado
        panelPrincipal.add(modificarPanel, gbc);

        listarButton = new JButton("Listar Empleados");
        gbc.gridx = 2;
        gbc.gridy = 7;
        panelPrincipal.add(listarButton, gbc);

        // Campo de búsqueda
        JLabel buscarLabel = new JLabel("Buscar Empleado:");
        gbc.gridx = 0;
        gbc.gridy = 8; // Ajusta la posición según tu diseño
        panelPrincipal.add(buscarLabel, gbc);

        buscarField = new JTextField(10);
        gbc.gridx = 1;
        panelPrincipal.add(buscarField, gbc);

        // Botón buscar
        buscarButton = new JButton("Buscar");
        gbc.gridx = 8;
        panelPrincipal.add(buscarButton, gbc);

        bajaButton = new JButton("Dar de Baja");
        gbc.gridx = 2;
        gbc.gridy = 9;
        panelPrincipal.add(bajaButton, gbc);

        // Botón volver
        volverButton = new JButton("Volver");
        gbc.gridx = 0;
        gbc.gridy = 12;
        gbc.gridwidth = 2;
        panelPrincipal.add(volverButton, gbc);

        // Panel para mostrar resultados
        resultadoArea = new JTextArea(10, 40);
        resultadoArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultadoArea);
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.gridwidth = 3;
        panelPrincipal.add(scrollPane, gbc);

        // Agregar acciones a los botones
        establecerTamanoButton.addActionListener(e -> establecerTamano());
        altaButton.addActionListener(e -> darAlta());
        modificarButton.addActionListener(e -> modificarAntiguedad());
        listarButton.addActionListener(e -> listarTodos());
        buscarButton.addActionListener(e -> listarUno());
        bajaButton.addActionListener(e -> darBaja());
        volverButton.addActionListener(e -> volverAOrdenado(ordenadoFrame));

        setContentPane(panelPrincipal);
    }

    private void establecerTamano() {
        String input = tamanoField.getText(); // Leer del nuevo campo
        try {
            tam = Integer.parseInt(input);
            if (tam > 0) {
                nombre = new String[tam];
                direccion = new String[tam];
                edad = new int[tam];
                sexo = new String[tam];
                antiguedad = new int[tam];
                resultadoArea.append("Tamaño establecido correctamente.\n");
                establecerTamanoButton.setEnabled(false); // Desactivar el botón
            } else {
                resultadoArea.append("El tamaño debe ser mayor que 0.\n");
            }
        } catch (NumberFormatException ex) {
            resultadoArea.append("Ingrese un número válido para el tamaño.\n");
        }
    }

    private void darAlta() {
        if (n < tam - 1) {
            String nuevoNombre = nombreField.getText().trim(); // Eliminar espacios en blanco

            if (nuevoNombre.isEmpty()) {
                resultadoArea.append("El nombre no puede estar vacío.\n");
                return;
            }

            n++;
            int pos = buscar(nuevoNombre);

            if (pos >= 0 && nuevoNombre.equalsIgnoreCase(nombre[pos])) {
                resultadoArea.append(nuevoNombre + " ya existe.\n");
                n--; // Decrementar n si el alta no se realiza
            } else {
                // Desplazar elementos hacia la derecha
                for (int i = n; i > pos; i--) {
                    nombre[i] = nombre[i - 1];
                    direccion[i] = direccion[i - 1];
                    edad[i] = edad[i - 1];
                    sexo[i] = sexo[i - 1];
                    antiguedad[i] = antiguedad[i - 1];
                }
                // Asignar nuevos valores
                nombre[pos] = nuevoNombre;
                direccion[pos] = direccionField.getText();
                edad[pos] = Integer.parseInt(edadField.getText());
                sexo[pos] = sexoField.getText();
                antiguedad[pos] = Integer.parseInt(antiguedadField.getText());

                resultadoArea.append("Empleado dado de alta correctamente.\n");
            }
        } else {
            resultadoArea.append("No hay más espacio en el arreglo.\n");
        }
    }

    private void darBaja() {
        String nombreBaja = nombreField.getText();
        int pos = buscar(nombreBaja);
        if (pos >= 0) {
            for (int i = pos; i < n; i++) {
                nombre[i] = nombre[i + 1];
                direccion[i] = direccion[i + 1];
                edad[i] = edad[i + 1];
                sexo[i] = sexo[i + 1];
                antiguedad[i] = antiguedad[i + 1];
            }
            n--;
            resultadoArea.append("Empleado eliminado.\n");
        } else {
            resultadoArea.append("Empleado no encontrado.\n");
        }
    }

    private void modificarAntiguedad() {
        String nombreMod = nombreModField.getText();
        int pos = buscar(nombreMod);
        if (pos >= 0) {
            antiguedad[pos] = Integer.parseInt(antiguedadModField.getText());
            resultadoArea.append("Antigüedad de " + nombreMod + " modificada correctamente.\n");
        } else {
            resultadoArea.append("Empleado no encontrado.\n");
        }
    }

    private void listarTodos() {
        StringBuilder salida = new StringBuilder("Nombre\tDirección\tEdad\tSexo\tAntigüedad\n");
        for (int i = 0; i <= n; i++) {
            salida.append(nombre[i]).append("\t").append(direccion[i]).append("\t").append(edad[i]).append("\t").append(sexo[i]).append("\t").append(antiguedad[i]).append("\n");
        }
        resultadoArea.setText(salida.toString());
    }

    private void listarUno() {
        String nombreBuscar = buscarField.getText();
        int pos = buscar(nombreBuscar);
        if (pos >= 0) {
            resultadoArea.setText("Nombre: " + nombre[pos] + "\nDirección: " + direccion[pos] + "\nEdad: " + edad[pos] +
                    "\nSexo: " + sexo[pos] + "\nAntigüedad: " + antiguedad[pos]);
        } else {
            resultadoArea.setText("Empleado no encontrado.\n");
        }
    }

    private int buscar(String nombreBuscar) {
        int i = 0;
        while (i <= n && nombre[i] != null && nombre[i].compareTo(nombreBuscar) < 0) {
            i++;
        }
        return (i > n || (nombre[i] != null && !nombre[i].equalsIgnoreCase(nombreBuscar))) ? -i : i;
    }

    private void volverAOrdenado(ordenado ordenadoFrame) {
        ordenadoFrame.setVisible(true);
        this.dispose();
    }
}
