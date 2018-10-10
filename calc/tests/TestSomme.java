package calc.tests ;
import calc.* ;

public class TestSomme
{
	public static void main(String[] args)
	{
		testValeur() ;
		testToString() ;
	}

	private static void testValeur()
	{
		Nombre n = new Nombre(0);
		Nombre m = new Nombre(2);
		Somme s = new Somme(n, m) ;

		assert(s.valeur()==2):"Mauvaise valeur obtenue par la somme" ;

		// rien ne nous empêche de prendre des valeurs négatives
		n = new Nombre(-80) ;
		m = new Nombre(123) ;
		s = new Somme(n, m) ;

		assert(s.valeur()==43):"Mauvaise valeur obtenue par la somme" ;

		// test sur deux valeurs négatives pour voir
		m = new Nombre(-78955586) ;
		s = new Somme(n, m) ;

		assert(s.valeur()==-78955666):"Mauvaise valeur obtenue par la somme" ;

		// somme des deux neutres de Z
		m = new Nombre(0) ;
		n = new Nombre(0) ;
		s = new Somme(m, n) ;

		assert(s.valeur()==0):"Mauvaise valeur obtenue par la somme" ;

		// somme d'une somme ..., par exemple 25 + ( 27 + (23 +26) )
		m = new Nombre(25) ;
		n = new Nombre(27) ;
		Nombre o = new Nombre(23) ;
		Nombre p = new Nombre(26) ;

		Somme prem = new Somme(o, p) ;
		Somme sec = new Somme(n, prem) ;
		Somme dern = new Somme(m, sec) ; // l'addition dans Z est commutative donc pas besoin de tester la place des paramètres

		assert(dern.valeur()==101):"Mauvaise valeur obtenue par la somme" ;
	}

	private static void testToString()
	{
		Nombre n = new Nombre(0);
		Nombre m = new Nombre(2);
		Somme s = new Somme(n, m) ;

		assert(s.toString().equals("(0+2)")):"Mauvaise représentation de la somme" ;

		// rien ne nous empêche de prendre des valeurs négatives
		n = new Nombre(-80) ;
		m = new Nombre(123) ;
		s = new Somme(n, m) ;

		assert(s.toString().equals("(-80+123)")):"Mauvaise représentation de la somme" ;

		// test sur deux valeurs négatives pour voir
		m = new Nombre(-78955586) ;
		s = new Somme(n, m) ;

		assert(s.toString().equals("(-80+-78955586)")):"Mauvaise représentation de la somme" ;

		// somme des deux neutres de Z
		m = new Nombre(0) ;
		n = new Nombre(0) ;
		s = new Somme(m, n) ;

		assert(s.toString().equals("(0+0)")):"Mauvaise représentation de la somme" ;

		// somme d'une somme ..., par exemple 25 + ( 27 + (23 +26) )
		m = new Nombre(25) ;
		n = new Nombre(27) ;
		Nombre o = new Nombre(23) ;
		Nombre p = new Nombre(26) ;

		Somme prem = new Somme(o, p) ;
		Somme sec = new Somme(n, prem) ;
		Somme dern = new Somme(m, sec) ; // l'addition dans Z est commutative donc pas besoin de tester la place des paramètres

		assert(dern.toString().equals("(25+(27+(23+26)))")):"Mauvaise représentation de la somme" ;
	}
}