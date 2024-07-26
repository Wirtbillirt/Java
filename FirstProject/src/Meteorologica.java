public class Meteorologica{
    private String descripcion;
    private double factorImpacto; 

    public Meteorologica(String descripcion, double factorImpacto) {
        this.descripcion = descripcion;
        this.factorImpacto = factorImpacto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getFactorImpacto() {
        return factorImpacto;
    }
}
