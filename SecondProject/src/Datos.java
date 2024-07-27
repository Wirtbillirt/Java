import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Datos {
    private static final String FILE_NAME = "usuarios.txt";

  
    public void guardarUsuario(Usuario usuario) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(FILE_NAME, true));
            writer.write(usuario.getNombre() + "," + usuario.getResidencia() + "," + usuario.getHorasEnCasa() + "," +
                    usuario.isTieneAlergias() + "," + usuario.getEspacioDisponible() + "," + usuario.getNivelDeActividad());
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error al guardar el usuario: " + e.getMessage());
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    System.err.println("Error al cerrar el escritor: " + e.getMessage());
                }
            }
        }
    }

    public List<Usuario> cargarUsuarios() {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(FILE_NAME));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    Usuario usuario = new Usuario(parts[0], parts[1], Integer.parseInt(parts[2]), Boolean.parseBoolean(parts[3]), Integer.parseInt(parts[4]), parts[5]);
                    usuarios.add(usuario);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al cargar los usuarios: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error al procesar el archivo: datos mal formateados");
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.err.println("Error al cerrar el lector: " + e.getMessage());
                }
            }
        }
        return usuarios;
    }
}

