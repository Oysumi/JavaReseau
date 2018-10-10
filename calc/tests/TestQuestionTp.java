package calc.tests ;

import calc.Nombre ;
import calc.Moyenne ;
import calc.Minimum ;
import calc.Maximum ;

public class TestQuestionTp
{
	public static void main(String[] args)
	{
		TestInstructionsValeurs() ;
		TestInstructionstoString() ;
	}

	private static void TestInstructionsValeurs()
	{
		Nombre un = new Nombre(1) ;
		Nombre moinsDeux = new Nombre(-2) ;
		Nombre trois = new Nombre(3) ;
		Nombre six = new Nombre(6) ;
		Nombre neuf = new Nombre(9) ;

		Moyenne moy ;
		Minimum min ;
		Maximum max ;

		// On va tester un grand ensemble de combinaisons pour voir si nous avons le résultat désiré
		max = new Maximum(six, neuf) ;
		moy = new Moyenne(un, moinsDeux, trois) ;
		min = new Minimum(moy, max) ;

		assert(min.valeur()==0):"Mauvais enchainement de min/moy/max" ;

		max = new Maximum(six, neuf, trois) ;
		moy = new Moyenne(un, moinsDeux) ;
		min = new Minimum(moy, max) ;

		assert(min.valeur()==0):"Mauvais enchainement de min/moy/max" ;

		max = new Maximum(six, neuf, trois, moinsDeux) ;
		moy = new Moyenne(un) ;
		min = new Minimum(moy, max) ;

		assert(min.valeur()==1):"Mauvais enchainement de min/moy/max" ;

		max = new Maximum(neuf, trois, moinsDeux) ;
		moy = new Moyenne(un, six) ;
		min = new Minimum(moy, max) ;

		assert(min.valeur()==3):"Mauvais enchainement de min/moy/max" ;

		max = new Maximum(trois, moinsDeux) ;
		moy = new Moyenne(un, six, neuf) ;
		min = new Minimum(moy, max) ;

		assert(min.valeur()==3):"Mauvais enchainement de min/moy/max" ;

		max = new Maximum(moinsDeux) ;
		moy = new Moyenne(un, six, neuf, trois) ;
		min = new Minimum(moy, max) ;

		assert(min.valeur()== -2):"Mauvais enchainement de min/moy/max" ;

		/* -------------------------------------------------------------------------- */

		min = new Minimum(six, neuf) ;
		moy = new Moyenne(un, moinsDeux, trois) ;
		max = new Maximum(moy, min) ;

		assert(max.valeur()==6):"Mauvais enchainement de max/moy/min" ;

		min = new Minimum(six, neuf, trois) ;
		moy = new Moyenne(un, moinsDeux) ;
		max = new Maximum(moy, min) ;

		assert(max.valeur()==3):"Mauvais enchainement de max/moy/min" ;

		min = new Minimum(six, neuf, trois, moinsDeux) ;
		moy = new Moyenne(un) ;
		max = new Maximum(moy, min) ;

		assert(max.valeur()==1):"Mauvais enchainement de max/moy/min" ;

		min = new Minimum(neuf, trois, moinsDeux) ;
		moy = new Moyenne(un, six) ;
		max = new Maximum(moy, min) ;

		assert(max.valeur()==3):"Mauvais enchainement de max/moy/min" ;

		min = new Minimum(trois, moinsDeux) ;
		moy = new Moyenne(un, six, neuf) ;
		max = new Maximum(moy, min) ;

		assert(max.valeur()==5):"Mauvais enchainement de max/moy/min" ;

		min = new Minimum(moinsDeux) ;
		moy = new Moyenne(un, six, neuf, trois) ;
		max = new Maximum(moy, min) ;

		assert(max.valeur()== 4):"Mauvais enchainement de max/moy/min" ;

		/* -------------------------------------------------------------------------- */

		max = new Maximum(six, neuf) ;
		min = new Minimum(un, moinsDeux, trois) ;
		moy = new Moyenne(max, min) ;

		assert(moy.valeur()==3):"Mauvais enchainement de moy/max/min" ;

		max = new Maximum(six, neuf, trois) ;
		min = new Minimum(un, moinsDeux) ;
		moy = new Moyenne(max, min) ;

		assert(moy.valeur()==3):"Mauvais enchainement de moy/max/min" ;

		max = new Maximum(six, neuf, trois, moinsDeux) ;
		min = new Minimum(un) ;
		moy = new Moyenne(max, min) ;

		assert(moy.valeur()==5):"Mauvais enchainement de moy/max/min" ;

		max = new Maximum(neuf, trois, moinsDeux) ;
		min = new Minimum(un, six) ;
		moy = new Moyenne(max, min) ;

		assert(moy.valeur()==5):"Mauvais enchainement de moy/max/min" ;

		max = new Maximum(trois, moinsDeux) ;
		min = new Minimum(un, six, neuf) ;
		moy = new Moyenne(max, min) ;

		assert(moy.valeur()==2):"Mauvais enchainement de moy/max/min" ;

		max = new Maximum(moinsDeux) ;
		min = new Minimum(un, six, neuf, trois) ;
		moy = new Moyenne(max, min) ;

		assert(moy.valeur()== 0):"Mauvais enchainement de moy/max/min" ;
	}

	private static void TestInstructionstoString()
	{
		Nombre un = new Nombre(1) ;
		Nombre moinsDeux = new Nombre(-2) ;
		Nombre trois = new Nombre(3) ;
		Nombre six = new Nombre(6) ;
		Nombre neuf = new Nombre(9) ;

		Moyenne moy ;
		Minimum min ;
		Maximum max ;

		// On va tester un grand ensemble de combinaisons pour voir si nous avons le résultat désiré
		max = new Maximum(six, neuf) ;
		moy = new Moyenne(un, moinsDeux, trois) ;
		min = new Minimum(moy, max) ;

		assert(min.toString().equals("min(moyenne(1, -2, 3), max(6, 9))")):"Mauvaise représentation de min/moy/max" ;

		max = new Maximum(six, neuf, trois) ;
		moy = new Moyenne(un, moinsDeux) ;
		min = new Minimum(moy, max) ;

		assert(min.toString().equals("min(moyenne(1, -2), max(6, 9, 3))")):"Mauvaise représentation de min/moy/max" ;

		max = new Maximum(six, neuf, trois, moinsDeux) ;
		moy = new Moyenne(un) ;
		min = new Minimum(moy, max) ;

		assert(min.toString().equals("min(moyenne(1), max(6, 9, 3, -2))")):"Mauvaise représentation de min/moy/max" ;

		max = new Maximum(neuf, trois, moinsDeux) ;
		moy = new Moyenne(un, six) ;
		min = new Minimum(moy, max) ;

		assert(min.toString().equals("min(moyenne(1, 6), max(9, 3, -2))")):"Mauvaise représentation de min/moy/max" ;

		max = new Maximum(trois, moinsDeux) ;
		moy = new Moyenne(un, six, neuf) ;
		min = new Minimum(moy, max) ;

		assert(min.toString().equals("min(moyenne(1, 6, 9), max(3, -2))")):"Mauvaise représentation de min/moy/max" ;

		max = new Maximum(moinsDeux) ;
		moy = new Moyenne(un, six, neuf, trois) ;
		min = new Minimum(moy, max) ;

		assert(min.toString().equals("min(moyenne(1, 6, 9, 3), max(-2))")):"Mauvaise représentation de min/moy/max" ;

		/* -------------------------------------------------------------------------- */

		min = new Minimum(six, neuf) ;
		moy = new Moyenne(un, moinsDeux, trois) ;
		max = new Maximum(moy, min) ;

		assert(max.toString().equals("max(moyenne(1, -2, 3), min(6, 9))")):"Mauvaise représentation de max/moy/min" ;

		min = new Minimum(six, neuf, trois) ;
		moy = new Moyenne(un, moinsDeux) ;
		max = new Maximum(moy, min) ;

		assert(max.toString().equals("max(moyenne(1, -2), min(6, 9, 3))")):"Mauvaise représentation de max/moy/min" ;

		min = new Minimum(six, neuf, trois, moinsDeux) ;
		moy = new Moyenne(un) ;
		max = new Maximum(moy, min) ;

		assert(max.toString().equals("max(moyenne(1), min(6, 9, 3, -2))")):"Mauvaise représentation de max/moy/min" ;

		min = new Minimum(neuf, trois, moinsDeux) ;
		moy = new Moyenne(un, six) ;
		max = new Maximum(moy, min) ;

		assert(max.toString().equals("max(moyenne(1, 6), min(9, 3, -2))")):"Mauvaise représentation de max/moy/min" ;

		min = new Minimum(trois, moinsDeux) ;
		moy = new Moyenne(un, six, neuf) ;
		max = new Maximum(moy, min) ;

		assert(max.toString().equals("max(moyenne(1, 6, 9), min(3, -2))")):"Mauvaise représentation de max/moy/min" ;

		min = new Minimum(moinsDeux) ;
		moy = new Moyenne(un, six, neuf, trois) ;
		max = new Maximum(moy, min) ;

		assert(max.toString().equals("max(moyenne(1, 6, 9, 3), min(-2))")):"Mauvaise représentation de max/moy/min" ;

		/* -------------------------------------------------------------------------- */

		min = new Minimum(six, neuf) ;
		max = new Maximum(un, moinsDeux, trois) ;
		moy = new Moyenne(max, min) ;

		assert(moy.toString().equals("moyenne(max(1, -2, 3), min(6, 9))")):"Mauvaise représentation de moy/max/min" ;

		min = new Minimum(six, neuf, trois) ;
		max = new Maximum(un, moinsDeux) ;
		moy = new Moyenne(max, min) ;

		assert(moy.toString().equals("moyenne(max(1, -2), min(6, 9, 3))")):"Mauvaise représentation de moy/max/min" ;

		min = new Minimum(six, neuf, trois, moinsDeux) ;
		max = new Maximum(un) ;
		moy = new Moyenne(max, min) ;

		assert(moy.toString().equals("moyenne(max(1), min(6, 9, 3, -2))")):"Mauvaise représentation de moy/max/min" ;

		min = new Minimum(neuf, trois, moinsDeux) ;
		max = new Maximum(un, six) ;
		moy = new Moyenne(max, min) ;

		assert(moy.toString().equals("moyenne(max(1, 6), min(9, 3, -2))")):"Mauvaise représentation de moy/max/min" ;

		min = new Minimum(trois, moinsDeux) ;
		max = new Maximum(un, six, neuf) ;
		moy = new Moyenne(max, min) ;

		assert(moy.toString().equals("moyenne(max(1, 6, 9), min(3, -2))")):"Mauvaise représentation de moy/max/min" ;

		min = new Minimum(moinsDeux) ;
		max = new Maximum(un, six, neuf, trois) ;
		moy = new Moyenne(max, min) ;

		assert(moy.toString().equals("moyenne(max(1, 6, 9, 3), min(-2))")):"Mauvaise représentation de moy/max/min" ;
	}
}