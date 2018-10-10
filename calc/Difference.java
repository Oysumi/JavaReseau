package calc ;

public class Difference extends Binaire
{
	public Difference(Expression gauche, Expression droit)
	{
		super(gauche,droit) ;
	}

	public int valeur()
	{
		return gauche.valeur() - droit.valeur() ;
	}

	public String getOperator()
	{
		return "-" ;
	}
}