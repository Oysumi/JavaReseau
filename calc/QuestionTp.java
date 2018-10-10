package calc ;

public class QuestionTp
{
	public static void main(String[] args)
	{
		// Test de permutations des fonctions effectué dans le packages calc.tests (calc.tests.TestQuestionTp)
		Nombre un = new Nombre(1) ;
		Nombre moinsDeux = new Nombre(-2) ;
		Nombre trois = new Nombre(3) ;
		Nombre six = new Nombre(6) ;
		Nombre neuf = new Nombre(9) ;

		Minimum min ;
		Moyenne moy ;
		Maximum max ;

		max = new Maximum(six, neuf) ;
		assert(max.valeur()==9):"Mauvais max calculé" ;
		assert(max.toString().equals("max(6, 9)")):"Mauvaise représentation de max" ;

		moy = new Moyenne(un, moinsDeux, trois) ;
		assert(moy.valeur()==0):"Mauvaise moyenne caculée" ;
		assert(moy.toString().equals("moyenne(1, -2, 3)")):"Mauvaise représentation de moyenne" ;

		min = new Minimum(moy, max) ;
		assert(min.valeur()==0):"Mauvais min calculé" ;
		assert(min.toString().equals("min(moyenne(1, -2, 3), max(6, 9))")):"Mauvaise représentation de min" ;

		System.out.println(min + " = " + min.valeur()) ;
	}
}