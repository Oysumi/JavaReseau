package calc ;

public class Produit extends Binaire
{
	public Produit(Expression gauche, Expression droit)
	{
		super(gauche,droit) ;
	}

	public int valeur()
	{
		return gauche.valeur() * droit.valeur() ;
	}

	public String getOperator()
	{
		return "*" ;
	}
}