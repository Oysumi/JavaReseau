package calc ;

public class Maximum extends Naires
{
	public Maximum(Expression... nbElem)
	{
		super(nbElem) ;
	}

	public int valeur()
	{
		int max = this.arg[0].valeur() ;

		for ( Expression expr : this.arg )
		{
			max = ( max < expr.valeur() ) ? expr.valeur() : max ;
		}

		return max ;
	}

	public String nomFonction()
	{
		return "max" ;
	}
}