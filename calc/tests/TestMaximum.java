package calc.tests ;

import calc.Maximum ;
import calc.Nombre ;

public class TestMaximum
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
		
		Maximum m = new Maximum(un, deux, trois, quatre) ;
		assert(m.valeur()==deux.valeur()):"Mauvais max calculé" ;

		// on peut tester l'ordre des paramètres (deux paramètres car n paramètres -> n! assert un peu long)
		m = new Maximum(deux, un) ;
		assert(m.valeur()==deux.valeur()):"Mauvais max calculé" ;
		m = new Maximum(un, deux) ;
		assert(m.valeur()==deux.valeur()):"Mauvais max calculé" ;

		// on calcule le max d'un ensemble d'un nombre
		m = new Maximum(deux) ;
		assert(m.valeur()==deux.valeur()):"Mauvais max calculé" ;

		// on calcule le max d'une valeur avec le résultat retourné par une fonction max
		Maximum mBis = new Maximum(un, deux, trois) ;
		assert(mBis.valeur()==deux.valeur()):"Mauvais max calculé" ;

		Maximum mBisBis = new Maximum(mBis, cinq, sept) ;
		assert(mBisBis.valeur()==cinq.valeur()):"Mauvais max calculé" ;

		m = new Maximum(mBisBis, six) ;
		assert(m.valeur()==six.valeur()):"Mauvais max calculé" ;
		
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
		
		Maximum m = new Maximum(un, deux, trois, quatre) ;
		assert(m.toString().equals("max(0, 2, -250, -259654)")):"Mauvaise représentation de max" ;

		// on peut tester l'ordre des paramètres (deux paramètres car n paramètres -> n! assert un peu long)
		m = new Maximum(deux, un) ;
		assert(m.toString().equals("max(2, 0)")):"Mauvaise représentation de max" ;
		m = new Maximum(un, deux) ;
		assert(m.toString().equals("max(0, 2)")):"Mauvaise représentation de max" ;

		// on calcule le max d'un ensemble d'un nombre
		m = new Maximum(deux) ;
		assert(m.toString().equals("max(2)")):"Mauvaise représentation de max" ;

		// on calcule le max d'une valeur avec le résultat retourné par une fonction max
		Maximum mBis = new Maximum(un, deux, trois) ;
		assert(mBis.toString().equals("max(0, 2, -250)")):"Mauvaise représentation de max" ;

		Maximum mBisBis = new Maximum(mBis, cinq, sept) ;
		assert(mBisBis.toString().equals("max(max(0, 2, -250), 24, -785)")):"Mauvaise représentation de max" ;

		m = new Maximum(mBisBis, six) ;
		assert(m.toString().equals("max(max(max(0, 2, -250), 24, -785), 78)")):"Mauvaise représentation de max" ;
	}
}