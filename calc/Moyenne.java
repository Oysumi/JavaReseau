package calc ;

public class Moyenne extends Naires
{
	public Moyenne(Expression... elements)
	{
		super(elements) ;
	}

	public int valeur()
	{
		double somme = 0 ;
		double nbElem = this.arg.length ;

		for ( Expression e : this.arg )
		{
			somme += (double)e.valeur() ;
		}

		return (int)(somme / nbElem) ;
	}

	public String nomFonction()
	{
		return "moyenne" ;
	}
}