package calc ;

public abstract class Naires implements Expression
{
	protected Expression[] arg ;

	public Naires(Expression... argum)
	{
		int taille = argum.length ;
		arg = new Expression[taille] ;
		int k = 0 ;

		for ( Expression expr : argum )
		{
			assert(expr!=null):"Appel d'un constructeur sur un null" ;
			arg[k] = expr ;
			k++ ;
		}
	}

	public String toString()
	{
		int taille = this.arg.length ;

		StringBuilder str = new StringBuilder(10*arg.length) ;

		str.append(this.nomFonction()+"(") ;

		for ( Expression expr : this.arg )
		{
			str.append(expr+", ") ;
		}

		// on retire la derniere virgule et le dernier espace
		int nbElem = str.length() ;
		str.delete(nbElem - 2, nbElem) ; // str.length() - 2 inclusif mais str.length() exclusif
		str.append(")") ;

		return str.toString() ;
	}

	public abstract String nomFonction() ;
}