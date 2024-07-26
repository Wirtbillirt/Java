public class Estudiantes {
    private String nombreCompleto;
    private Notas notas;
    public Estudiantes() {
    }

    public Estudiantes(String nombreCompleto, Notas notas) {
        this.nombreCompleto = nombreCompleto;
        this.notas = notas;
    }

    public double calcularPromedio() {
        int nota1 = notas.getNota1();
        int nota2 = notas.getNota2();
        int nota3 = notas.getNota3();

        int sumaDosMayores;

        if (nota1 <= nota2 && nota1 <= nota3) {
            sumaDosMayores = nota2 + nota3;
        } else if (nota2 <= nota1 && nota2 <= nota3) {
            sumaDosMayores = nota1 + nota3;
        } else {
            sumaDosMayores = nota1 + nota2;
        }

        return sumaDosMayores / 2.0;
    }

    public String toString() {
        return nombreCompleto + " " + notas.imprimirNotas() + " " + calcularPromedio();
    }
}
