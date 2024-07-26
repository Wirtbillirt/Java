public class Fecha extends Object {
private int dia;
private int mes;
private int año;

public Fecha() {
}

public void setFecha(int dia, int mes, int año) {
this.año = año;
this.mes = mes;
this.dia = dia;
}

public String getFechaFormateada() {
String mesTexto = "";
switch (mes) {
case 1: mesTexto = "enero"; break;
case 2: mesTexto = "febrero"; break;
case 3: mesTexto = "marzo"; break;
case 4: mesTexto = "abril"; break;
case 5: mesTexto = "mayo"; break;
case 6: mesTexto = "junio"; break;
case 7: mesTexto = "julio"; break;
case 8: mesTexto = "agosto"; break;
case 9: mesTexto = "septiembre"; break;
case 10: mesTexto = "octubre"; break;
case 11: mesTexto = "noviembre"; break;
case 12: mesTexto = "diciembre"; break;
default: mesTexto = "mes inválido"; break;
}
return dia + " de " + mesTexto + " de " + año;
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

public static boolean validarFecha(int dia, int mes, int año) {
if (año < 1900 || año > 3000) {
return false;
}
if (mes < 1 || mes > 12) {
return false;
}
if (dia < 1 || dia > 31) {
return false;
}
return true;
}
}
