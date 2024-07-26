public class Rectangulo {
private int base;
private int altura;

public Rectangulo() {
base = 1;
altura = 1;
}

public Rectangulo(int base, int altura) {
this.base = (base > 1) ? base : 1;
this.altura = (altura > 1) ? altura : 1;
}

public void setBase(int base) {
this.base = (base > 1) ? base : 1;
}

public void setAltura(int altura) {
this.altura = (altura > 1) ? altura : 1;
}

public int calcularPerimetro() {
return 2 * (base + altura);
}

public int calcularArea() {
return base * altura;
}

public int getBase() {
return base;
}

public int getAltura() {
return altura;
}
}
