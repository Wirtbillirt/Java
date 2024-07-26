public class Tren extends Vehiculo {
    private double costoPorKm;

    public Tren(String id, double capacidadCarga, double velocidadPromedio, double costoPorKm) {
        super(id, "Tren de Carga", capacidadCarga, velocidadPromedio);
        this.costoPorKm = costoPorKm;
    }

    
    public double calcularTiempoEntrega(double distancia) {
        return distancia / velocidadPromedio;
    }

    
    public double calcularCostoEntrega(double distancia, double peso) {
        return distancia * costoPorKm + peso * 0.4; 
    }
}
