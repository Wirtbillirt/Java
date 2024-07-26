import java.text.*;
public class Class_4 extends Object{

private float libras;

DecimalFormat df = new DecimalFormat(".##");

public Class_4()
{
libras = 0;
}

public void lb(float libras)
{
this.libras = libras;
}

public String GetLibras()
{
return df.format(2.205*libras);
}
}
