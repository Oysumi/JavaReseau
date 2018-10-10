package calc.tests ;

import calc.Minimum ;
import calc.Nombre ;

public class TestMinimum
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
		
		Minimum m = new Minimum(un, deux, trois, quatre) ;
		assert(m.valeur()==quatre.valeur()):"Mauvais min calculé" ;

		// on peut tester l'ordre des paramètres (deux paramètres car n paramètres -> n! assert un peu long)
		m = new Minimum(deux, un) ;
		assert(m.valeur()==un.valeur()):"Mauvais min calculé" ;
		m = new Minimum(un, deux) ;
		assert(m.valeur()==un.valeur()):"Mauvais min calculé" ;

		// on calcule le min d'un ensemble d'un nombre
		m = new Minimum(deux) ;
		assert(m.valeur()==deux.valeur()):"Mauvais min calculé" ;

		// on calcule le min d'une valeur avec le résultat retourné par une fonction min
		Minimum mBis = new Minimum(un, deux, trois) ;
		assert(mBis.valeur()==trois.valeur()):"Mauvais min calculé" ;

		Minimum mBisBis = new Minimum(mBis, cinq, sept) ;
		assert(mBisBis.valeur()==sept.valeur()):"Mauvais min calculé" ;

		m = new Minimum(mBisBis, six) ;
		assert(m.valeur()==sept.valeur()):"Mauvais min calculé" ;
		
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
		
		Minimum m = new Minimum(un, deux, trois, quatre) ;
		assert(m.toString().equals("min(0, 2, -250, -259654)")):"Mauvaise représentation de min" ;

		// on peut tester l'ordre des paramètres (deux paramètres car n paramètres -> n! assert un peu long)
		m = new Minimum(deux, un) ;
		assert(m.toString().equals("min(2, 0)")):"Mauvaise représentation de min" ;
		m = new Minimum(un, deux) ;
		assert(m.toString().equals("min(0, 2)")):"Mauvaise représentation de min" ;

		// on calcule le min d'un ensemble d'un nombre
		m = new Minimum(deux) ;
		assert(m.toString().equals("min(2)")):"Mauvaise représentation de min" ;

		// on calcule le min d'une valeur avec le résultat retourné par une fonction min
		Minimum mBis = new Minimum(un, deux, trois) ;
		assert(mBis.toString().equals("min(0, 2, -250)")):"Mauvaise représentation de min" ;

		Minimum mBisBis = new Minimum(mBis, cinq, sept) ;
		assert(mBisBis.toString().equals("min(min(0, 2, -250), 24, -785)")):"Mauvaise représentation de min" ;

		m = new Minimum(mBisBis, six) ;
		assert(m.toString().equals("min(min(min(0, 2, -250), 24, -785), 78)")):"Mauvaise représentation de min" ;
	}
}