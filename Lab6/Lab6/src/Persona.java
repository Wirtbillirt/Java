class Persona {
    private String nombre;
    private Fecha fechaNacimiento;
    private Fecha fechaActual;
	
    public Persona()
	{
		
	}

    public Persona(String nombre, Fecha fechaNacimiento, Fecha fechaActual) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaActual = fechaActual;
    }

    private int calcularEdad() {
        int edad = fechaActual.getAño() - fechaNacimiento.getAño();
        if (fechaActual.getMes() < fechaNacimiento.getMes() || 
           (fechaActual.getMes() == fechaNacimiento.getMes() && fechaActual.getDia() < fechaNacimiento.getDia())) {
            edad--;
        }
        return edad;
    }
    
    public String toString() {
  	  return nombre + " " + fechaNacimiento.imprimir() + " " + calcularEdad();
  }
}
