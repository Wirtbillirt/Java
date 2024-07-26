import java.util.ArrayList;

public class Gestion {
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Ruta> rutas;
    private ArrayList<Meteorologica> condicionesMeteorologicas;

    public Gestion() {
        vehiculos = new ArrayList<Vehiculo>();
        rutas = new ArrayList<Ruta>();
        condicionesMeteorologicas = new ArrayList<Meteorologica>();
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    public void agregarRuta(Ruta ruta) {
        rutas.add(ruta);
    }

    public void Meteorologica(Meteorologica condicion) {
        condicionesMeteorologicas.add(condicion);
    }

    public Vehiculo buscarVehiculo(String id) {
        for (Vehiculo v : vehiculos) {
            if (v.getId().equals(id)) {
                return v;
            }
        }
        return null;
    }

    public Ruta buscarRuta(String origen, String destino) {
        for (Ruta r : rutas) {
            if (r.getOrigen().equals(origen) && r.getDestino().equals(destino)) {
                return r;
            }
        }
        return null;
    }

    public Meteorologica buscarCondicionMeteorologica(String descripcion) {
        for (Meteorologica c : condicionesMeteorologicas) {
            if (c.getDescripcion().equals(descripcion)) {
                return c;
            }
        }
        return null;
    }

    public double calcularTiempoEntrega(Vehiculo vehiculo, Ruta ruta, Meteorologica condicion) {
        double tiempoBase = vehiculo.calcularTiempoEntrega(ruta.getDistancia());
        return tiempoBase * (1 + condicion.getFactorImpacto());
    }

    public double calcularCostoEntrega(Vehiculo vehiculo, Ruta ruta, Mercancia mercancia, Meteorologica condicion) {
        double costoBase = vehiculo.calcularCostoEntrega(ruta.getDistancia(), mercancia.getPeso());
        return costoBase * (1 + condicion.getFactorImpacto());
    }
}
