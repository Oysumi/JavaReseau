package calc ;

public class Minimum extends Naires
{
	public Minimum(Expression... nbElem)
	{
		super(nbElem) ;
	}

	public int valeur()
	{
		int min = this.arg[0].valeur() ;

		for ( Expression expr : this.arg )
		{
			min = ( min > expr.valeur() ) ? expr.valeur() : min ;
		}

		return min ;
	}

	public String nomFonction()
	{
		return "min" ;
	}
}