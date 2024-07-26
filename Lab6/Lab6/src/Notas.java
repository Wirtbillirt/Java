class Notas {
    protected int nota1;
    protected int nota2;
    protected int nota3;

    public Notas() {
        this.nota1 = 0;
        this.nota2 = 0;
        this.nota3 = 0;
    }

    public void setNotas(int nota1, int nota2, int nota3) {
        this.nota1 = (nota1 >= 0) ? nota1 : 0;
        this.nota2 = (nota2 >= 0) ? nota2 : 0;
        this.nota3 = (nota3 >= 0) ? nota3 : 0;
    }

    public int getNota1() {
        return nota1;
    }

    public int getNota2() {
        return nota2;
    }

    public int getNota3() {
        return nota3;
    }

    public String imprimirNotas() {
        return nota1 + " " + nota2 + " " + nota3;
    }
}
