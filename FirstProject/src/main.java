import javax.swing.*;

public class main {
    private Gestion gestion;

    public main () {
        gestion = new Gestion ();
        inicializar();
    }

    private void inicializar() {
        String[] opciones = {"Agregar Vehículo", "Agregar Ruta", "Agregar Condición Meteorológica", "Calcular Entrega", "Salir"};
        int opcion;

        do {
            opcion = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Sistema de Gestión de Transportes",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);

            switch (opcion) {
                case 0:
                    agregarVehiculo();
                    break;
                case 1:
                    agregarRuta();
                    break;
                case 2:
                    agregarCondicionMeteorologica();
                    break;
                case 3:
                    calcularEntrega();
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + opcion);
            }
        } while (opcion != 4);
    }

    private void agregarVehiculo() {
        String id = JOptionPane.showInputDialog("Ingrese el ID del vehículo:");
        String[] tipos = {"Avion", "Barco", "Camion", "Tren de Carga", "Drone de Entrega"};
        String tipo = (String) JOptionPane.showInputDialog(null, "Seleccione el tipo de vehículo:", "Tipo de Vehículo",
                JOptionPane.QUESTION_MESSAGE, null, tipos, tipos[0]);
        double capacidadCarga = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la capacidad de carga (kg):"));
        double velocidadPromedio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la velocidad promedio (km/h):"));
        double costoPorKm = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el costo por km:"));

        Vehiculo vehiculo = null;
        if ("Avion".equals(tipo)) {
            vehiculo = new Avion(id, capacidadCarga, velocidadPromedio, costoPorKm);
        } else if ("Barco".equals(tipo)) {
            vehiculo = new Barco(id, capacidadCarga, velocidadPromedio, costoPorKm);
        } else if ("Camion".equals(tipo)) {
            vehiculo = new Camion(id, capacidadCarga, velocidadPromedio, costoPorKm);
        } else if ("Tren de Carga".equals(tipo)) {
            vehiculo = new Tren(id, capacidadCarga, velocidadPromedio, costoPorKm);
        } else if ("Drone de Entrega".equals(tipo)) {
            vehiculo = new Drone(id, capacidadCarga, velocidadPromedio, costoPorKm);
        }

        if (vehiculo != null) {
            gestion.agregarVehiculo(vehiculo);
            JOptionPane.showMessageDialog(null, "Vehículo agregado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Error al agregar el vehículo.");
        }
    }

    private void agregarRuta() {
        String origen = JOptionPane.showInputDialog("Ingrese el origen de la ruta:");
        String destino = JOptionPane.showInputDialog("Ingrese el destino de la ruta:");
        double distancia = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la distancia (km):"));

        Ruta ruta = new Ruta(origen, destino, distancia);
        gestion.agregarRuta(ruta);
        JOptionPane.showMessageDialog(null, "Ruta agregada exitosamente.");
    }

    private void agregarCondicionMeteorologica() {
        String descripcion = JOptionPane.showInputDialog("Ingrese la descripción de la condición meteorológica:");
        double factorImpacto = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el factor de impacto (0.1 = 10%):"));

        Meteorologica condicion = new Meteorologica (descripcion, factorImpacto);
        gestion.Meteorologica(condicion);
        JOptionPane.showMessageDialog(null, "Condición meteorológica agregada exitosamente.");
    }

    private void calcularEntrega() {
        String idVehiculo = JOptionPane.showInputDialog("Ingrese el ID del vehículo:");
        Vehiculo vehiculo = gestion.buscarVehiculo(idVehiculo);

        if (vehiculo == null) {
            JOptionPane.showMessageDialog(null, "Vehículo no encontrado.");
            return;
        }

        String origen = JOptionPane.showInputDialog("Ingrese el origen de la ruta:");
        String destino = JOptionPane.showInputDialog("Ingrese el destino de la ruta:");
        Ruta ruta = gestion.buscarRuta(origen, destino);

        if (ruta == null) {
            JOptionPane.showMessageDialog(null, "Ruta no encontrada.");
            return;
        }

        String descripcionCondicion = JOptionPane.showInputDialog("Ingrese la descripción de la condición meteorológica:");
        Meteorologica condicion = gestion.buscarCondicionMeteorologica(descripcionCondicion);

        if (condicion == null) {
            JOptionPane.showMessageDialog(null, "Condición meteorológica no encontrada.");
            return;
        }

        double pesoMercancia = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el peso de la mercancía (kg):"));
        String tipoMercancia = JOptionPane.showInputDialog("Ingrese el tipo de mercancía:");
        Mercancia mercancia = new Mercancia("Mercancía", pesoMercancia, tipoMercancia);

        double tiempoEntrega = gestion.calcularTiempoEntrega(vehiculo, ruta, condicion);
        double costoEntrega = gestion.calcularCostoEntrega(vehiculo, ruta, mercancia, condicion);

        String resultado = String.format("Tiempo de Entrega: %.2f horas\nCosto de Entrega: %.2f USD", tiempoEntrega, costoEntrega);
        JOptionPane.showMessageDialog(null, resultado);
    }

    public static void main(String[] args) {
        new main();
    }
}

