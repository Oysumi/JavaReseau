package reseau.tests;

import reseau.Message;
import reseau.adresses.Adresse;

public class TestMessage
{
	public static void main(String[] args)
    {
    	testToString() ;
        testExtraireChaine() ;
    }

    public static void testToString()
    {
    	Message m ;
        Message mBis ;
    	boolean b ;
        Adresse a ;

    	// message vide
    	m = new Message() ;
    	b = ( m.toString().isEmpty() ) ;
    	assert b : "Mauvaise représentation toString (message vide)" ;

    	// message de petits entiers
    	short i = 72 ;
    	short j = 69 ;
    	short k = 89 ;

    	m = new Message(i, j, k) ;
    	b = ( m.toString().equals("72.69.89")) ;
    	assert b : "Mauvaise représentation toString" ;

    	// message de grands entiers
    	m = new Message(245, 894, 0, 7047, 7) ;
    	b = ( m.toString().equals("0.245.3.126.0.0.27.135.0.7") ) ;
    	assert b : "Mauvaise représentation toString" ;

    	// message avec une chaîne de caractères en paramètre
    	m = new Message("Salut !") ;
    	b = ( m.toString().equals("83.97.108.117.116.32.33")) ; // cf. table ASCII
        assert b : "Mauvaise représentation toString" ;

        // message avec une adresse en paramètre
        a = new Adresse("187.25.63.1") ;
        m = new Message(a) ;
        b = ( m.toString().equals("187.25.63.1") ) ;
        assert b : "Mauvaise représentation toString" ;

        // messge avec un message en paramètre
        mBis = new Message(5879, 63000, 245, 87) ;
        m = new Message(mBis) ;
        b = ( m.toString().equals(mBis.toString()) ) ; // on vérifie d'abord qu'il y a bien copie du message (superficielle ou profonde)
        assert b : "Mauvaise copie" ;
        mBis = new Message("Hello world !") ; // on modifie mBis pour vérifier la copie profonde
        b = ( m.toString().equals(mBis.toString()) ) ; // si b = faux, alors seul mBis a été modifié donc on a bien une copie profonde
        assert !b : "Copie superficielle et non profonde" ;
    }

    public static void testExtraireChaine()
    {
        Message m ;
        Message mBis ;
        boolean b ;
        Adresse a ;

        // message vide
        m = new Message() ;
        b = ( m.extraireChaine().isEmpty() ) ;
        assert b : "Mauvaise extraction de chaîne (vide)" ;

        // message de petits entiers
        short i = 72 ;
        short j = 69 ;
        short k = 89 ;

        m = new Message(i, j, k) ;
        b = ( m.extraireChaine().equals("HEY")) ; // cf. ASCII
        assert b : "Mauvaise extraction de chaîne" ;

        // message de grands entiers
        m = new Message(21345, 27765, 29742) ;
        b = ( m.extraireChaine().equals("Salut.") ) ; // cf. ASCII
        assert b : "Mauvaise extraction de chaîne" ;

        // message avec une chaîne de caractères en paramètre
        m = new Message("Hello.") ;
        b = ( m.extraireChaine().equals("Hello.")) ; // cf. table ASCII
        assert b : "Mauvaise extraction de chaîne" ;

        // message avec une adresse en paramètre
        a = new Adresse("187.25.63.1") ;
        m = new Message(a) ;
        b = ( m.extraireChaine() == null ) ; // extraireChaine doit retourner String null ici
        assert b : "Mauvaise extraction de chaîne" ;

        // messge avec un message en paramètre
        mBis = new Message("KernelPanic") ;
        m = new Message(mBis) ;
        b = ( m.extraireChaine().equals("KernelPanic") ) ; // on vérifie d'abord qu'il y a bien copie du message (superficielle ou profonde)
        assert b : "Mauvaise copie" ;
        mBis = new Message("Hello world !") ; // on modifie mBis pour vérifier la copie profonde
        b = ( m.extraireChaine().equals("") ) ; // Hello world possède des espaces qui ne sont pas des lettres, donc normalement mBis retourne une chaîne vide
        assert !b : "Mauvaise extraction de chaîne dûe à une copie superficielle" ;
    }
}
