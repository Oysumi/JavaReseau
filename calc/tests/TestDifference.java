package calc.tests ;
import calc.* ;

public class TestDifference
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
		Difference d = new Difference(n, m) ;

		assert(d.valeur()==-2):"Mauvaise valeur obtenue par la différence" ;
		d = new Difference(m, n) ;
		assert(d.valeur()==2):"Mauvaise valeur obtenue par la difference" ;

		// rien ne nous empêche de prendre des valeurs négatives
		n = new Nombre(-80) ;
		m = new Nombre(123) ;
		d = new Difference(n, m) ;

		assert(d.valeur()==-203):"Mauvaise valeur obtenue par la différence" ;

		d = new Difference(m, n) ;
		assert(d.valeur()==203):"Mauvaise valeur obtenue par la différence" ;

		// test sur deux valeurs négatives pour voir
		m = new Nombre(-78955586) ;
		d = new Difference(n, m) ;

		assert(d.valeur()==78955506):"Mauvaise valeur obtenue par la difference" ;
		d = new Difference(m, n) ;
		assert(d.valeur()==-78955506):"Mauvaise valeur obtenue par la difference" ;


		// difference des deux neutres de Z
		m = new Nombre(0) ;
		n = new Nombre(0) ;
		d = new Difference(m, n) ;

		assert(d.valeur()==0):"Mauvaise valeur obtenue par la difference" ;

		d = new Difference(n, m) ;
		assert(d.valeur()==0):"Mauvaise valeur obtenue par la difference" ;

		// difference d'une difference ..., par exemple 25 - ( 27 - (23 - 26) )
		m = new Nombre(25) ;
		n = new Nombre(27) ;
		Nombre o = new Nombre(23) ;
		Nombre p = new Nombre(26) ;

		Difference prem = new Difference(o, p) ;
		Difference sec = new Difference(n, prem) ;
		Difference dern = new Difference(m, sec) ;

		assert(dern.valeur()==-5):"Mauvaise valeur obtenue par la difference" ;
	}

	private static void testToString()
	{
		Nombre n = new Nombre(0);
		Nombre m = new Nombre(2);
		Difference d = new Difference(n, m) ;

		assert(d.toString().equals("(0-2)")):"Mauvaise représentation de la difference" ;
		d = new Difference(m, n) ;
		assert(d.toString().equals("(2-0)")):"Mauvaise représentation de la difference" ;

		// rien ne nous empêche de prendre des toStrings négatives
		n = new Nombre(-80) ;
		m = new Nombre(123) ;
		d = new Difference(n, m) ;

		assert(d.toString().equals("(-80-123)")):"Mauvaise représentation de la difference" ;

		d = new Difference(m, n) ;
		assert(d.toString().equals("(123--80)")):"Mauvaise représentation de la difference" ;

		// test sur deux toStrings négatives pour voir
		m = new Nombre(-78955586) ;
		d = new Difference(n, m) ;

		assert(d.toString().equals("(-80--78955586)")):"Mauvaise représentation de la difference" ;
		d = new Difference(m, n) ;
		assert(d.toString().equals("(-78955586--80)")):"Mauvaise représentation de la difference" ;


		// difference des deux neutres de Z
		m = new Nombre(0) ;
		n = new Nombre(0) ;
		d = new Difference(m, n) ;

		assert(d.toString().equals("(0-0)")):"Mauvaise représentation de la difference" ;

		d = new Difference(n, m) ;
		assert(d.toString().equals("(0-0)")):"Mauvaise représentation de la difference" ;

		// difference d'une difference ..., par exemple 25 - ( 27 - (23 - 26) )
		m = new Nombre(25) ;
		n = new Nombre(27) ;
		Nombre o = new Nombre(23) ;
		Nombre p = new Nombre(26) ;

		Difference prem = new Difference(o, p) ;
		Difference sec = new Difference(n, prem) ;
		Difference dern = new Difference(m, sec) ;

		assert(dern.toString().equals("(25-(27-(23-26)))")):"Mauvaise représentation de la difference" ;
	}
}