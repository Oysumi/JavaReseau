package reseau.tests;

import reseau.Message;
import reseau.adresses.Adresse;

public class TestMessage
{
	public static void main(String[] args)
    {
        testSize() ;
    	testToString() ;
        testExtraireChaine() ;
        testExtraireEntier() ;
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

    public static void testSize()
    {
        Message m ;
        Message mBis ;
        Adresse a ;
        boolean b ;

        // message vide
        m = new Message() ;
        assert (m.size()==0) : "Mauvaise taille (message vide)" ;

        // message de petits entiers
        short i = 72 ;
        short j = 69 ;
        short k = 89 ;

        m = new Message(i, j, k) ;
        assert(m.size()==3) : "Mauvaise taille" ;

        // message de grands entiers
        m = new Message(21345, 27765, 29742) ; // on a des grands entiers, donc ils sont codés sur deux octets
        assert(m.size()==6): "Mauvaise taille" ;

        // message avec une chaîne de caractères en paramètre
        m = new Message("Hello.") ;
        assert(m.size()==6): "Mauvaise taille" ;

        // message avec une adresse en paramètre
        a = new Adresse("187.25.63.1") ;
        m = new Message(a) ;
        assert(m.size()==4): "Mauvaise taille" ;

        // messge avec un message en paramètre
        mBis = new Message("KernelPanic") ;
        m = new Message(mBis) ;
        b = ( m.extraireChaine().equals("KernelPanic") ) ; // on vérifie d'abord qu'il y a bien copie du message (superficielle ou profonde)
        assert b : "Mauvaise copie" ;
        assert( (m.size() == mBis.size()) && (m.size() == 11)) : "Mauvaise taille en copie" ;
        mBis = new Message("Hello world !") ; // on modifie mBis pour vérifier la copie profonde
        b = ( m.size() != mBis.size() ) ;
        assert b : "Mauvaise taille dûe à une copie superficielle" ;
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

    public static void testExtraireEntier()
    {
        Message m ;
        Message mBis ;
        boolean b ;
        Adresse a ;

        // message de petits entiers
        short i = 72 ;
        short j = 69 ;
        short k = 89 ;

        m = new Message(i, j, k) ;
        b = ( m.extraireEntier(1) == 69 + 89 ) ;
        assert b : "Mauvaise extraction d'entier" ;

        // message de grands entiers
        m = new Message(245, 894, 0, 7047, 7) ;
        b = ( m.extraireEntier(2) == 3 + 126 ) ; // 894[10] = 11 01111110[2] en coupant en deux octets on a 3 + 126
        assert b : "Mauvaise extraction d'entier" ;

        // message avec une chaîne de caractères en paramètre
        m = new Message("Salut !") ;
        b = ( m.extraireEntier(3) == 117 + 116 ) ; // 117 = u en ASCII | 116 = t en ASCII
        assert b : "Mauvaise extraction d'entier" ;

        // message avec une adresse en paramètre
        a = new Adresse("187.25.63.1") ;
        m = new Message(a) ;
        b = ( m.extraireEntier(2) == 63 + 1 ) ;
        assert b : "Mauvaise extraction d'entier" ;

        // messge avec un message en paramètre
        mBis = new Message(5879, 63000, 245, 87) ;
        m = new Message(mBis) ;
        /* 5879[10] = 10110 11110111[2]
         * 63000[10] = 11110110 00011000[2]
         * donc on va effectuer : 11110111[2] + 11110110[2] = 247 + 246
         */
        b = ( m.extraireEntier(1) == 247 + 246 ) ;
        assert b : "Mauvaise extraction d'entier" ;
        mBis = new Message("Hello world !") ; // on modifie mBis pour vérifier la copie profonde
        b = ( m.extraireEntier(1) != 209 ) ; // 209 = 101 (e en ASCII) + 108 (l en ASCII)
        assert b : "Mauvaise extraction d'entier par copie superficielle" ;
    }
}
