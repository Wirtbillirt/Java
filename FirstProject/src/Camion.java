public class Camion extends Vehiculo {
    private double costoPorKm;

    public Camion(String id, double capacidadCarga, double velocidadPromedio, double costoPorKm) {
        super(id, "Camion", capacidadCarga, velocidadPromedio);
        this.costoPorKm = costoPorKm;
    }

  
    public double calcularTiempoEntrega(double distancia) {
        return distancia / velocidadPromedio;
    }

    
    public double calcularCostoEntrega(double distancia, double peso) {
        return distancia * costoPorKm + peso * 0.2; 
    }
}
