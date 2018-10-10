package calc.tests ;
import calc.* ;

public class TestQuotient
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
		Quotient d = new Quotient(n, m) ;

		assert(d.valeur()==0):"Mauvaise valeur obtenue par le Quotient" ;

		// rien ne nous empêche de prendre des valeurs négatives
		n = new Nombre(-80) ;
		m = new Nombre(20) ;
		d = new Quotient(n, m) ;

		assert(d.valeur()==-4):"Mauvaise valeur obtenue par le Quotient" ;

		d = new Quotient(m, n) ;
		assert(d.valeur()==-1/4):"Mauvaise valeur obtenue par le Quotient" ;

		// test sur deux valeurs négatives pour voir
		m = new Nombre(-10) ;
		d = new Quotient(n, m) ;

		assert(d.valeur()==8):"Mauvaise valeur obtenue par le Quotient" ;
		d = new Quotient(m, n) ;
		assert(d.valeur()==1/8):"Mauvaise valeur obtenue par le Quotient" ;

		// Quotient d'un Quotient ..., par exemple 25 / ( 80 / (100 / 25) )
		m = new Nombre(25) ;
		n = new Nombre(80) ;
		Nombre o = new Nombre(100) ;
		Nombre p = new Nombre(25) ;

		Quotient prem = new Quotient(o, p) ;
		Quotient sec = new Quotient(n, prem) ;
		Quotient dern = new Quotient(m, sec) ;

		assert(dern.valeur()==5/4):"Mauvaise valeur obtenue par le Quotient" ;
	}

	private static void testToString()
	{
		Nombre n = new Nombre(0);
		Nombre m = new Nombre(2);
		Quotient d = new Quotient(n, m) ;

		assert(d.toString().equals("(0/2)")):"Mauvaise représentation du Quotient" ;

		// rien ne nous empêche de prendre des valeurs négatives
		n = new Nombre(-80) ;
		m = new Nombre(20) ;
		d = new Quotient(n, m) ;

		assert(d.toString().equals("(-80/20)")):"Mauvaise représentation du Quotient" ;

		d = new Quotient(m, n) ;
		assert(d.toString().equals("(20/-80)")):"Mauvaise représentation du Quotient" ;

		// test sur deux valeurs négatives pour voir
		m = new Nombre(-10) ;
		d = new Quotient(n, m) ;

		assert(d.toString().equals("(-80/-10)")):"Mauvaise représentation du Quotient" ;
		d = new Quotient(m, n) ;
		assert(d.toString().equals("(-10/-80)")):"Mauvaise représentation du Quotient" ;

		// Quotient d'un Quotient ..., par exemple 25 / ( 80 / (100 / 25) )
		m = new Nombre(25) ;
		n = new Nombre(80) ;
		Nombre o = new Nombre(100) ;
		Nombre p = new Nombre(25) ;

		Quotient prem = new Quotient(o, p) ;
		Quotient sec = new Quotient(n, prem) ;
		Quotient dern = new Quotient(m, sec) ;

		assert(dern.toString().equals("(25/(80/(100/25)))")):"Mauvaise représentation du Quotient" ;
	}
}