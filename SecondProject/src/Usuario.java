public class Usuario {
    private String nombre;
    private String residencia;
    private int horasEnCasa;
    private boolean tieneAlergias;
    private int espacioDisponible;
    private String nivelDeActividad;

    public Usuario(String nombre, String residencia, int horasEnCasa, boolean tieneAlergias, int espacioDisponible, String nivelDeActividad) {
        this.nombre = nombre;
        this.residencia = residencia;
        this.horasEnCasa = horasEnCasa;
        this.tieneAlergias = tieneAlergias;
        this.espacioDisponible = espacioDisponible;
        this.nivelDeActividad = nivelDeActividad;
    }

    
    public String getNombre() { return nombre; }
    public String getResidencia() { return residencia; }
    public int getHorasEnCasa() { return horasEnCasa; }
    public boolean isTieneAlergias() { return tieneAlergias; }
    public int getEspacioDisponible() { return espacioDisponible; }
    public String getNivelDeActividad() { return nivelDeActividad; }

    
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setResidencia(String residencia) { this.residencia = residencia; }
    public void setHorasEnCasa(int horasEnCasa) { this.horasEnCasa = horasEnCasa; }
    public void setTieneAlergias(boolean tieneAlergias) { this.tieneAlergias = tieneAlergias; }
    public void setEspacioDisponible(int espacioDisponible) { this.espacioDisponible = espacioDisponible; }
    public void setNivelDeActividad(String nivelDeActividad) { this.nivelDeActividad = nivelDeActividad; }
}
