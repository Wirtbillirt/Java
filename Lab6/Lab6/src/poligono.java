public class poligono extends Object{
	
	private figura radio;
	
	public poligono()
	{
		
	}
	
	public poligono(figura r)
	{
		radio = r;
	}
	
	public void SetAsigno(figura r)
	{
		radio = r;
	}
	
	public String toString()
	{
		return radio.imprimir();
	}

}
