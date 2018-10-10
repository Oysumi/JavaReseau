package calc.tests ;
import calc.Produit ;
import calc.Nombre ;

public class TestProduit
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
		Produit d = new Produit(n, m) ;

		// on sait d'avance que le produit est commutatif mais on test quand même la place des paramètres pour en être sûr

		assert(d.valeur()==0):"Mauvaise valeur obtenue par le produit" ;
		d = new Produit(m, n) ;
		assert(d.valeur()==0):"Mauvaise valeur obtenue par le produit" ;

		// rien ne nous empêche de prendre des valeurs négatives
		n = new Nombre(-80) ;
		m = new Nombre(123) ;
		d = new Produit(n, m) ;

		assert(d.valeur()==-9840):"Mauvaise valeur obtenue par le produit" ;

		d = new Produit(m, n) ;
		assert(d.valeur()==-9840):"Mauvaise valeur obtenue par le produit" ;

		// test sur deux valeurs négatives pour voir
		m = new Nombre(-7895) ;
		d = new Produit(n, m) ;

		assert(d.valeur()==631600):"Mauvaise valeur obtenue par le produit" ;
		d = new Produit(m, n) ;
		assert(d.valeur()==631600):"Mauvaise valeur obtenue par le produit" ;


		// Produit des deux neutres de Z
		m = new Nombre(0) ;
		n = new Nombre(0) ;
		d = new Produit(m, n) ;

		assert(d.valeur()==0):"Mauvaise valeur obtenue par le produit" ;

		d = new Produit(n, m) ;
		assert(d.valeur()==0):"Mauvaise valeur obtenue par le produit" ;

		// Produit d'un Produit ..., par exemple 25 * ( 27 * (23 * 26) )
		m = new Nombre(25) ;
		n = new Nombre(27) ;
		Nombre o = new Nombre(23) ;
		Nombre p = new Nombre(26) ;

		Produit prem = new Produit(o, p) ;
		Produit sec = new Produit(n, prem) ;
		Produit dern = new Produit(m, sec) ;

		assert(dern.valeur()==403650):"Mauvaise valeur obtenue par le produit" ;
	}

	private static void testToString()
	{
		Nombre n = new Nombre(0);
		Nombre m = new Nombre(2);
		Produit d = new Produit(n, m) ;

		assert(d.toString().equals("(0*2)")):"Mauvaise représentation du produit" ;
		d = new Produit(m, n) ;
		assert(d.toString().equals("(2*0)")):"Mauvaise représentation du produit" ;

		// rien ne nous empêche de prendre des toStrings négatives
		n = new Nombre(-80) ;
		m = new Nombre(123) ;
		d = new Produit(n, m) ;

		assert(d.toString().equals("(-80*123)")):"Mauvaise représentation du produit" ;

		d = new Produit(m, n) ;
		assert(d.toString().equals("(123*-80)")):"Mauvaise représentation du produit" ;

		// test sur deux toStrings négatives pour voir
		m = new Nombre(-78955586) ;
		d = new Produit(n, m) ;

		assert(d.toString().equals("(-80*-78955586)")):"Mauvaise représentation du produit" ;
		d = new Produit(m, n) ;
		assert(d.toString().equals("(-78955586*-80)")):"Mauvaise représentation du produit" ;


		// Produit des deux neutres de Z
		m = new Nombre(0) ;
		n = new Nombre(0) ;
		d = new Produit(m, n) ;

		assert(d.toString().equals("(0*0)")):"Mauvaise représentation du produit" ;

		d = new Produit(n, m) ;
		assert(d.toString().equals("(0*0)")):"Mauvaise représentation du produit" ;

		// Produit d'une Produit ..., par exemple 25 * ( 27 * (23 * 26) )
		m = new Nombre(25) ;
		n = new Nombre(27) ;
		Nombre o = new Nombre(23) ;
		Nombre p = new Nombre(26) ;

		Produit prem = new Produit(o, p) ;
		Produit sec = new Produit(n, prem) ;
		Produit dern = new Produit(m, sec) ;

		assert(dern.toString().equals("(25*(27*(23*26)))")):"Mauvaise représentation du produit" ;
	}
}