package calc;

public abstract class Binaire implements Expression
{
	protected Expression gauche ;
	protected Expression droit ;

	public Binaire(Expression gauche, Expression droit)
	{
		assert(gauche!=null):"Ajout d'un null dans la branche gauche" ;
		assert(droit!=null):"Ajout d'un null dans la branche droite" ;
		this.gauche = gauche ;
		this.droit = droit ;
	}

	public String toString()
	{
		return "("+gauche+this.getOperator()+droit+")" ;
	}

	public abstract String getOperator();
}