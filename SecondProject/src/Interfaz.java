import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz {

    private JTextField nombreField;
    private JComboBox<String> residenciaBox; 
    private JTextField horasEnCasaField;
    private JCheckBox alergiasBox;
    private JTextField espacioDisponibleField;
    private JComboBox<String> nivelDeActividadBox;
    private JTextArea resultadoArea;
    private Datos baseDatos;
    private Recomendacion recomendacion;

    public Interfaz() {
        baseDatos = new Datos();
        recomendacion = new Recomendacion();
        crearYMostrarInterfaz();
    }

    private void crearYMostrarInterfaz() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout()); 
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        nombreField = new JTextField(20);
        residenciaBox = new JComboBox<String>(new String[]{"Casa", "Departamento", "Otros"});
        horasEnCasaField = new JTextField(5);
        alergiasBox = new JCheckBox("Tiene alergias");
        espacioDisponibleField = new JTextField(5);
        nivelDeActividadBox = new JComboBox<String>(new String[]{"Baja", "Media", "Alta"});
        resultadoArea = new JTextArea(5, 20); 
        resultadoArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultadoArea);

        JButton guardarButton = new JButton("Guardar y Recomendar");
        guardarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarYRecomendar();
            }
        });

        
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Nombre:"), gbc);
        
        gbc.gridx = 1;
        panel.add(nombreField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Residencia:"), gbc);
        
        gbc.gridx = 1;
        panel.add(residenciaBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Horas en casa:"), gbc);
        
        gbc.gridx = 1;
        panel.add(horasEnCasaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(alergiasBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JLabel("Espacio disponible (m²):"), gbc);
        
        gbc.gridx = 1;
        panel.add(espacioDisponibleField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(new JLabel("Nivel de actividad:"), gbc);
        
        gbc.gridx = 1;
        panel.add(nivelDeActividadBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.CENTER;
        panel.add(guardarButton, gbc);

        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.BOTH;
        panel.add(scrollPane, gbc);

        JOptionPane.showMessageDialog(null, panel, "Recomendador de Mascotas", JOptionPane.PLAIN_MESSAGE);
    }

    private void guardarYRecomendar() {
        try {
            String nombre = nombreField.getText();
            String residencia = (String) residenciaBox.getSelectedItem();
            int horasEnCasa = Integer.parseInt(horasEnCasaField.getText());
            boolean tieneAlergias = alergiasBox.isSelected();
            int espacioDisponible = Integer.parseInt(espacioDisponibleField.getText());
            String nivelDeActividad = (String) nivelDeActividadBox.getSelectedItem();

            Usuario usuario = new Usuario(nombre, residencia, horasEnCasa, tieneAlergias, espacioDisponible, nivelDeActividad);
            baseDatos.guardarUsuario(usuario);

            String recomendacionTexto = recomendacion.recomendarMascota(usuario);
            resultadoArea.setText("Recomendación para " + nombre + ": " + recomendacionTexto);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese valores válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Interfaz();
            }
        });
    }
}
