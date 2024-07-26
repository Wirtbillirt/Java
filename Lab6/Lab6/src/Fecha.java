class Fecha {
	    protected int dia;
	    protected int mes;
	    protected int año;


	    protected static final String[] MESES = {"enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"};

    public Fecha() {
        this.dia = 1;
        this.mes = 1;
        this.año = 1900;
    }

    public void setAño(int año) {
        if (año >= 1900 && año <= 3000) {
            this.año = año;
        } else {
            this.año = 1900;
        }
    }

    public int calcularDiasMes(int mes, int año) {
        int[] diasMes = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (mes == 2 && (año % 4 == 0 && (año % 100 != 0 || año % 400 == 0))) {
            return 29;
        }
        return diasMes[mes];
    }

    public void setMes(int mes) {
        if (mes >= 1 && mes <= 12) {
            this.mes = mes;
        } else {
            this.mes = 1;
        }
    }

    public void setDia(int dia, int mes, int año) {
        int diasEnMes = calcularDiasMes(mes, año);
        if (dia > 0 && dia <= diasEnMes) {
            this.dia = dia;
        } else {
            this.dia = 1;
        }
    }

    public void asignarFecha(int dia, int mes, int año) {
        setAño(año);
        setMes(mes);
        setDia(dia, mes, año);
    }

    public String imprimir() {
        return dia + " de " + MESES[mes - 1] + " de " + año;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAño() {
        return año;
    }
}
