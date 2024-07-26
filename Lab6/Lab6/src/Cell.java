public class Cell extends Object{
	
	private String name;
	private Telefono celu;
	
	public Cell()
	{
		
	}
	
	public Cell(String name, Telefono CE)
	{
		this.name = name;
		celu = CE;
	}
	
	public void SetAsignar(String name, Telefono CE)
	{
		this.name = name;
		celu = CE;
	}
	
	public String toString()
	{
		return name + "\t" + celu.imprimir() + "\n";
	}

}
