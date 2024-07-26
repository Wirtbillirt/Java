public class Barco extends Vehiculo {
    private double costoPorKm;

    public Barco(String id, double capacidadCarga, double velocidadPromedio, double costoPorKm) {
        super(id, "Barco", capacidadCarga, velocidadPromedio);
        this.costoPorKm = costoPorKm;
    }

   
    public double calcularTiempoEntrega(double distancia) {
        return distancia / velocidadPromedio;
    }

    
    public double calcularCostoEntrega(double distancia, double peso) {
        return distancia * costoPorKm + peso * 0.3; 
    }
}
