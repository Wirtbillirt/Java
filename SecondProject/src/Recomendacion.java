public class Recomendacion {
    public String recomendarMascota(Usuario usuario) {
        boolean alergias = usuario.isTieneAlergias();
        int espacio = usuario.getEspacioDisponible();
        String nivelActividad = usuario.getNivelDeActividad();
        int horasEnCasa = usuario.getHorasEnCasa();
        String residencia = usuario.getResidencia();

        
        if (alergias) {
            return "Pez";
        }

        if (residencia.equals("Casa") && espacio > 100 && nivelActividad.equals("Alta")) {
            return "Perro";
        }

     
        if (residencia.equals("Departamento")) {
            if (horasEnCasa < 4) {
                return "Gato";
            } else if (horasEnCasa >= 4 && horasEnCasa < 8) {
                return "Hámster";
            } else {
                return "Periquito";
            }
        }

       
        if (espacio > 50 && espacio <= 100 && nivelActividad.equals("Media")) {
            return "Gato";
        }

    
        if (espacio <= 50 && nivelActividad.equals("Baja")) {
            return "Hámster";
        }

       
        return "Gato";
    }
}
