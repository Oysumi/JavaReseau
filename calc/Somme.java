package calc ;

public class Somme extends Binaire
{
	public Somme(Expression gauche, Expression droit)
	{
		super(gauche,droit) ;
	}

	public int valeur()
	{
		return gauche.valeur() + droit.valeur() ;
	}

	public String getOperator()
	{
		return "+" ;
	}
}