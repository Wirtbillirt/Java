public class Telefono extends Object {
	
	protected String domicilio, trabajo, celular;
	
	public Telefono()
	{
		domicilio = null;
		trabajo = null;
		celular = null;
	}
	
	public void setAsignar(String d, String t, String c)
	{
		domicilio = d;
		trabajo = t;
		celular = c;
	}
	
	public String imprimir()
	{
		return domicilio + " / " + trabajo + " / " + celular;
	}

}
