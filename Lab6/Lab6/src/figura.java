public class figura extends Object{
	
	protected float area, volumen;
	
	public figura()
	{
		area = 0;
		volumen = 0;
	}
	
	public void SetAsignar(float radio)
	{
		area = (float) (4 * Math.PI * Math.pow(radio, 2));
		volumen = (float) (1.33333333333 * Math.PI * Math.pow(radio, 3));
	}
	
	public String imprimir() 
	{
		return area + "\t" +volumen;
	}
	
}
