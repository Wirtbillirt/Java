public class Mercancia {
    private String descripcion;
    private double peso;
    private String tipo; 

    public Mercancia(String descripcion, double peso, String tipo) {
        this.descripcion = descripcion;
        this.peso = peso;
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPeso() {
        return peso;
    }

    public String getTipo() {
        return tipo;
    }
}
