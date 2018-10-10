package calc.tests ;

import calc.Nombre ;
import calc.Moyenne ;

public class TestMoyenne
{
	public static void main(String[] args)
	{
		testValeur() ;
		testToString() ;
	}

	private static void testValeur()
	{
		Nombre un = new Nombre(0);
		Nombre deux = new Nombre(2);
		Nombre trois = new Nombre(-250) ;
		Nombre quatre = new Nombre(-259654) ;
		Nombre cinq = new Nombre(24) ;
		Nombre six = new Nombre(78) ;
		Nombre sept = new Nombre(-785) ;
		
		Moyenne m = new Moyenne(un, deux, trois, quatre) ;
		assert(m.valeur()== -64975):"Mauvaise moyenne calculée" ;

		// l'addition étant commutative, l'ordre des paramètres importe peu
		m = new Moyenne(deux, un) ;
		assert(m.valeur()==1):"Mauvaise moyenne calculée" ;

		// on calcul la moyenne d'un ensemble d'un nombre
		m = new Moyenne(deux) ;
		assert(m.valeur()==deux.valeur()):"Mauvaise moyenne calculée" ;

		// on calcul la moyenne d'une valeur avec le résultat retourné par une fonction moyenne
		Moyenne mBis = new Moyenne(un, deux, trois) ;
		assert(mBis.valeur()== -82):"Mauvaise moyenne calculée" ;

		Moyenne mBisBis = new Moyenne(mBis, cinq, sept) ;
		assert(mBisBis.valeur()== -281):"Mauvaise moyenne calculée" ;

		m = new Moyenne(mBisBis, six) ;
		assert(m.valeur()== -101):"Mauvaise moyenne calculée" ;
		
	}

	private static void testToString()
	{
		Nombre un = new Nombre(0);
		Nombre deux = new Nombre(2);
		Nombre trois = new Nombre(-250) ;
		Nombre quatre = new Nombre(-259654) ;
		Nombre cinq = new Nombre(24) ;
		Nombre six = new Nombre(78) ;
		Nombre sept = new Nombre(-785) ;
		
		Moyenne m = new Moyenne(un, deux, trois, quatre) ;
		assert(m.toString().equals("moyenne(0, 2, -250, -259654)")):"Mauvaise représentation de moyenne" ;

		// on peut tester l'ordre des paramètres (deux paramètres car n paramètres -> n! assert un peu long)
		m = new Moyenne(deux, un) ;
		assert(m.toString().equals("moyenne(2, 0)")):"Mauvaise représentation de moyenne" ;
		m = new Moyenne(un, deux) ;
		assert(m.toString().equals("moyenne(0, 2)")):"Mauvaise représentation de moyenne" ;

		// on calcul la moyenne d'un ensemble d'un nombre
		m = new Moyenne(deux) ;
		assert(m.toString().equals("moyenne(2)")):"Mauvaise représentation de moyenne" ;

		// on calcul la moyenne d'une valeur avec le résultat retourné par une fonction moyenne
		Moyenne mBis = new Moyenne(un, deux, trois) ;
		assert(mBis.toString().equals("moyenne(0, 2, -250)")):"Mauvaise représentation de moyenne" ;

		Moyenne mBisBis = new Moyenne(mBis, cinq, sept) ;
		assert(mBisBis.toString().equals("moyenne(moyenne(0, 2, -250), 24, -785)")):"Mauvaise représentation de moyenne" ;

		m = new Moyenne(mBisBis, six) ;
		assert(m.toString().equals("moyenne(moyenne(moyenne(0, 2, -250), 24, -785), 78)")):"Mauvaise représentation de moyenne" ;
	}
}