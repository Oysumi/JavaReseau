package calc;

public class Quotient extends Binaire
{
	public Quotient(Expression gauche, Expression droit)
	{
		super(gauche,droit) ;
		// on test le membre droit ici pour pallier le problème de super qui doit être la première instruction du constructeur
		// cela ne pose pas de problème car après affection des valeurs, on ne peut effectuer la division car le programme plante
		assert(droit.valeur()!=0):"Tentative de division par 0" ;
	}

	public int valeur()
	{
		return gauche.valeur() / droit.valeur() ;
	}

	public String getOperator()
	{
		return "/" ;
	}
}