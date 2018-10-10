package calc ;

public class Nombre implements Expression
{
	protected int val ;

	public Nombre(int v)
	{
		this.val = v ;
	}

	public int valeur()
	{
		return this.val ;
	}

	public String toString()
	{
		return ""+this.val ;
	}
}