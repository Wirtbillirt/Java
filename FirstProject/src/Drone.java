public class Drone extends Vehiculo {
    private double costoPorKm;

    public Drone(String id, double capacidadCarga, double velocidadPromedio, double costoPorKm) {
        super(id, "Drone de Entrega", capacidadCarga, velocidadPromedio);
        this.costoPorKm = costoPorKm;
    }

    
    public double calcularTiempoEntrega(double distancia) {
        return distancia / velocidadPromedio;
    }

  
    public double calcularCostoEntrega(double distancia, double peso) {
        return distancia * costoPorKm + peso * 0.1; 
    }
}
