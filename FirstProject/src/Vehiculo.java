public abstract class Vehiculo {
    protected String id;
    protected String tipo;
    protected double capacidadCarga;
    protected double velocidadPromedio;
    protected boolean disponible;

    public Vehiculo(String id, String tipo, double capacidadCarga, double velocidadPromedio) {
        this.id = id;
        this.tipo = tipo;
        this.capacidadCarga = capacidadCarga;
        this.velocidadPromedio = velocidadPromedio;
        this.disponible = true;
    }

    public String getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    public double getVelocidadPromedio() {
        return velocidadPromedio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public abstract double calcularTiempoEntrega(double distancia);

    public abstract double calcularCostoEntrega(double distancia, double peso);
}
