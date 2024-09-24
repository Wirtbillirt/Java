import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab1_1 extends JFrame {
    private String[] nombres;
    private int[] semestres;
    private double[] promedios;
    private int n = -1; // Número de alumnos registrados
    private int tam;

    private JTextField nombreField, semestresField, promedioField;
    private JTextField buscarNombreField, buscarSemestresField, buscarPromedioField;
    private JTextField listarAlumnoField; // Campo para listar alumno
    private JTextField tamanoField; // Campo para el tamaño del arreglo
    private JButton establecerTamanoButton, listarButton, volverButton, darAltaButton;
    private JTextArea listadoArea;
    private JButton aceptarModificarButton, aceptarBajaButton;
    private JTextField nombreBajaField; // Campo para el nombre a eliminar

    public Lab1_1(Desordenado desordenadoFrame) {
        inicializarLab1_1(desordenadoFrame);
    }

    private void inicializarLab1_1(Desordenado desordenadoFrame) {
        setTitle("Gestión de Alumnos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panelPrincipal = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Establecer tamaño del arreglo (movido al principio)
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

        // Número de semestres cursados
        JLabel semestresLabel = new JLabel("Número de semestres cursados:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panelPrincipal.add(semestresLabel, gbc);

        semestresField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panelPrincipal.add(semestresField, gbc);

        // Calificación promedio total
        JLabel promedioLabel = new JLabel("Calificación promedio total:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        panelPrincipal.add(promedioLabel, gbc);

        promedioField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 3;
        panelPrincipal.add(promedioField, gbc);

        // Botones
        listarButton = new JButton("Listar Todos");
        gbc.gridx = 3;
        gbc.gridy = 3;
        panelPrincipal.add(listarButton, gbc);

        darAltaButton = new JButton("Dar de Alta");
        gbc.gridx = 4;
        gbc.gridy = 3;
        panelPrincipal.add(darAltaButton, gbc);

        // Botón volver en la esquina inferior izquierda
        volverButton = new JButton("Volver");
        gbc.gridx = 0;
        gbc.gridy = 10;
        panelPrincipal.add(volverButton, gbc);

        // Panel para modificar alumno
        JLabel modificarLabel = new JLabel("Modificar Semestres y Promedio:");
        gbc.gridx = 0;
        gbc.gridy = 6;
        panelPrincipal.add(modificarLabel, gbc);

        buscarNombreField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 6;
        panelPrincipal.add(buscarNombreField, gbc);

        buscarSemestresField = new JTextField(10);
        gbc.gridx = 2;
        gbc.gridy = 6;
        panelPrincipal.add(buscarSemestresField, gbc);

        buscarPromedioField = new JTextField(10);
        gbc.gridx = 3;
        gbc.gridy = 6;
        panelPrincipal.add(buscarPromedioField, gbc);

        aceptarModificarButton = new JButton("Aceptar");
        gbc.gridx = 4;
        gbc.gridy = 6;
        panelPrincipal.add(aceptarModificarButton, gbc);

        // JLabel y campo para listar un alumno
        JLabel listarLabel = new JLabel("Listar Alumno:");
        gbc.gridx = 0;
        gbc.gridy = 7;
        panelPrincipal.add(listarLabel, gbc);

        listarAlumnoField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 7;
        panelPrincipal.add(listarAlumnoField, gbc);

        JButton listarUnoButton = new JButton("Listar");
        gbc.gridx = 2;
        gbc.gridy = 7;
        panelPrincipal.add(listarUnoButton, gbc);

        // JLabel para eliminar alumno
        JLabel bajaLabel = new JLabel("Eliminar Alumno:");
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

        // Panel para listar todos los alumnos
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

        listarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarTodos();
            }
        });

        listarUnoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarAlumno();
            }
        });

        darAltaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                darDeAlta();
            }
        });

        aceptarModificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aceptarModificacion();
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
                volverADesordenado(desordenadoFrame);
            }
        });
    }

    private void establecerTamano() {
        try {
            tam = Integer.parseInt(tamanoField.getText());
            if (tam > 0) {
                nombres = new String[tam];
                semestres = new int[tam];
                promedios = new double[tam];
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
            semestres[n] = Integer.parseInt(semestresField.getText());
            promedios[n] = Double.parseDouble(promedioField.getText());
            nombreField.setText("");
            semestresField.setText("");
            promedioField.setText("");
            listadoArea.setText("Alumno " + nombres[n] + " dado de alta.");
        } else {
            listadoArea.setText("Error: El arreglo está lleno.");
        }
    }

    private void darDeBaja() {
        String nombreBaja = nombreBajaField.getText();
        int pos = buscar(nombreBaja);
        if (pos >= 0) {
            for (int i = pos; i < n; i++) {
                nombres[i] = nombres[i + 1];
                semestres[i] = semestres[i + 1];
                promedios[i] = promedios[i + 1];
            }
            n--;
            listadoArea.setText("Alumno dado de baja correctamente.");
        } else {
            listadoArea.setText("Alumno no encontrado.");
        }
    }

    private void listarAlumno() {
        String nombreBuscar = listarAlumnoField.getText();
        int pos = buscar(nombreBuscar);
        if (pos >= 0) {
            listadoArea.setText("Nombre: " + nombres[pos] + ", Semestres: " + semestres[pos] + ", Promedio: " + promedios[pos]);
        } else {
            listadoArea.setText("Alumno no encontrado.");
        }
    }

    private void listarTodos() {
        listadoArea.setText("");
        for (int i = 0; i <= n; i++) {
            listadoArea.append("Nombre: " + nombres[i] + ", Semestres: " + semestres[i] + ", Promedio: " + promedios[i] + "\n");
        }
    }

    private int buscar(String nombre) {
        for (int i = 0; i <= n; i++) {
            if (nombres[i].equalsIgnoreCase(nombre)) {
                return i;
            }
        }
        return -1;
    }

    private void aceptarModificacion() {
        String nombreBuscar = buscarNombreField.getText();
        int pos = buscar(nombreBuscar);
        if (pos >= 0) {
            semestres[pos] = Integer.parseInt(buscarSemestresField.getText());
            promedios[pos] = Double.parseDouble(buscarPromedioField.getText());
            listadoArea.setText("Alumno modificado correctamente.");
        } else {
            listadoArea.setText("Alumno no encontrado.");
        }
    }

    private void volverADesordenado(Desordenado desordenadoFrame) {
        desordenadoFrame.setVisible(true);
        dispose();
    }
}
