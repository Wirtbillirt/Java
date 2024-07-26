import java.text.DecimalFormat;
public class Ejercicio_2 extends Object{

private double radio;

DecimalFormat mp = new DecimalFormat(".##");

public Ejercicio_2()
{
radio = 0;
}

public void Radio(double r)
{
radio = r;
}

public String GetArea()
{
return mp.format(Math.PI*Math.pow(radio, 2));
}

public String GetLongitud()
{
return mp.format(2*Math.PI*radio);
}
}
