package reseau.tests;

import reseau.Message;
import reseau.adresses.Adresse;
import reseau.adresses.Octet;

public class TestMessage
{
	public static void main(String[] args)
    {
    	testToString() ;
        testAugmenter() ;
        testAjouter() ;
        testSupprimer() ;
        testSize() ;
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
        b = ( m.toString().equals("22.247.246.24.0.245.0.87") ) ;
        assert b : "Mauvaise représentation toString" ;
        mBis = new Message("KernelPanic") ; // on modifie mBis pour vérifier la copie profonde
        b = ( m.toString().equals(mBis.toString()) ) ; // si b = faux, alors seul mBis a été modifié donc on a bien une copie profonde
        assert !b : "Copie superficielle et non profonde" ;
        b = ( mBis.toString().equals("75.101.114.110.101.108.80.97.110.105.99")) ; // KernelPanic en ASCII
        assert b : "Mauvaise représentation toString" ;
        b = ( m.toString().equals("75.101.114.110.101.108.80.97.110.105.99")) ;
        assert !b : "Mauvaise représentation toString par copie superficielle" ;
        b = ( m.toString().equals("22.247.246.24.0.245.0.87")) ;
        assert b : "Mauvaise représentation toString" ;
    }

    public static void testSize()
    {
        Message m ;
        Message mBis ;
        Adresse a ;
        boolean b ;

        short i = 72 ;
        short j = 69 ;
        short k = 89 ;

        // message vide
        m = new Message() ;
        assert (m.size()==0) : "Mauvaise taille (message vide)" ;
        m.ajouter(new Octet(87)) ;
        assert(m.size()==1) : "Mauvaise taille" ;
        m.ajouter(new Adresse("78.25.66.21")) ;
        assert(m.size()==5) : "Mauvaise taille" ;
        m.supprimer(0) ;
        assert(m.size()==5) : "Mauvaise taille" ;
        m.ajouter(j) ;
        assert(m.size()==6) : "Mauvaise taille" ;
        m.ajouter(89) ; // int donc codé sur 2 octets
        assert(m.size()==8) : "Mauvaise taille" ;
        m.augmenter(45,0,4) ;
        assert(m.size()==8) : "Mauvaise taille" ;
        m.supprimer(2,4) ;
        assert(m.size()==5) : "Mauvaise taille" ;

        // message de petits entiers

        /* short i = 72 ;
         * short j = 69 ;
         * short k = 89 ;
         */

        m = new Message(i, j, k) ;
        assert(m.size()==3) : "Mauvaise taille" ;
        m.ajouter(new Octet(87)) ;
        assert(m.size()==4) : "Mauvaise taille" ;
        m.ajouter(new Adresse("78.25.66.25")) ;
        assert(m.size()==8) : "Mauvaise taille" ;
        m.supprimer(4) ;
        assert(m.size()==4) : "Mauvaise taille" ;
        m.ajouter(i) ;
        assert(m.size()==5) : "Mauvaise taille" ;
        m.ajouter(89) ; // int donc codé sur 2 octets
        assert(m.size()==7) : "Mauvaise taille" ;
        m.augmenter(45,0,4) ;
        assert(m.size()==7) : "Mauvaise taille" ;
        m.supprimer(2,4) ;
        assert(m.size()==4) : "Mauvaise taille" ;

        // message de grands entiers
        m = new Message(21345, 27765, 29742) ; // on a des grands entiers, donc ils sont codés sur deux octets
        assert(m.size()==6): "Mauvaise taille" ;
        m.ajouter(new Octet(87)) ;
        assert(m.size()==7) : "Mauvaise taille" ;
        m.ajouter(new Adresse("78.25.66.78")) ;
        assert(m.size()==11) : "Mauvaise taille" ;
        m.supprimer(5) ;
        assert(m.size()==6) : "Mauvaise taille" ;
        m.ajouter(j) ;
        assert(m.size()==7) : "Mauvaise taille" ;
        m.ajouter(89) ; // int donc codé sur 2 octets
        assert(m.size()==9) : "Mauvaise taille" ;
        m.augmenter(45,0,4) ;
        assert(m.size()==9) : "Mauvaise taille" ;
        m.supprimer(2,4) ;
        assert(m.size()==6) : "Mauvaise taille" ;

        // message avec une chaîne de caractères en paramètre
        m = new Message("Hello.") ;
        assert(m.size()==6): "Mauvaise taille" ;
        m.ajouter(new Octet(87)) ;
        assert(m.size()==7) : "Mauvaise taille" ;
        m.ajouter(new Adresse("78.25.66.78.145.24")) ;
        assert(m.size()==13) : "Mauvaise taille" ;
        m.supprimer(2) ;
        assert(m.size()==11) : "Mauvaise taille" ;
        m.ajouter(j) ;
        assert(m.size()==12) : "Mauvaise taille" ;
        m.ajouter(89) ; // int donc codé sur 2 octets
        assert(m.size()==14) : "Mauvaise taille" ;
        m.augmenter(2,0,10) ;
        assert(m.size()==14) : "Mauvaise taille" ;
        m.supprimer(8,8) ;
        assert(m.size()==13) : "Mauvaise taille" ;

        // message avec une adresse en paramètre
        a = new Adresse("187.25.63.1") ;
        m = new Message(a) ;
        assert(m.size()==4): "Mauvaise taille" ;
        m.ajouter(new Octet(87)) ;
        assert(m.size()==5) : "Mauvaise taille" ;
        m.ajouter(new Adresse("78.25.66.0.0.7")) ;
        assert(m.size()==11) : "Mauvaise taille" ;
        m.supprimer(9) ;
        assert(m.size()==2) : "Mauvaise taille" ;
        m.ajouter(j) ;
        assert(m.size()==3) : "Mauvaise taille" ;
        m.ajouter(89) ; // int donc codé sur 2 octets
        assert(m.size()==5) : "Mauvaise taille" ;
        m.augmenter(2,1,2) ;
        assert(m.size()==5) : "Mauvaise taille" ;
        m.supprimer(0,4) ;
        assert(m.size()==0) : "Mauvaise taille" ;

        // messge avec un message en paramètre
        mBis = new Message("KernelPanic") ;
        m = new Message(mBis) ;
        b = ( m.extraireChaine().equals("KernelPanic") ) ; // on vérifie d'abord qu'il y a bien copie du message (superficielle ou profonde)
        assert b : "Mauvaise copie" ;
        assert( (m.size() == mBis.size()) && (m.size() == 11)) : "Mauvaise taille en copie" ;
        mBis = new Message("Hello world !") ; // on modifie mBis pour vérifier la copie profonde
        b = ( m.size() != mBis.size() ) ;
        assert b : "Mauvaise taille dûe à une copie superficielle" ;

        m.ajouter(new Octet(87)) ;
        assert(m.size()==12) : "Mauvaise taille" ;
        m.ajouter(new Adresse(32)) ;
        assert(m.size()==16) : "Mauvaise taille" ;
        m.supprimer(4) ;
        assert(m.size()==12) : "Mauvaise taille" ;
        m.ajouter(j) ;
        assert(m.size()==13) : "Mauvaise taille" ;
        m.ajouter(89) ; // int donc codé sur 2 octets
        assert(m.size()==15) : "Mauvaise taille" ;
        m.augmenter(2,0,11) ;
        assert(m.size()==15) : "Mauvaise taille" ;
        m.supprimer(0,8) ;
        assert(m.size()==6) : "Mauvaise taille" ;
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

    private static void testAjouter()
    {
        Message m ;
        Message mBis ;
        Adresse a ;

        short ajout = 125 ;
        int ajoutGrand = 24456 ;
        int ajoutGrandPrime = 120 ;

        // message vide
        m = new Message() ;
        assert(m.toString().equals("")):"Mauvaise initialisation message vide" ;
        m.ajouter(ajout) ;
        assert(m.toString().equals("125")):"Mauvais octet ajouté (short)" ;
        m.ajouter(ajoutGrand) ;
        assert(m.toString().equals("125.95.136")):"Mauvais octet ajouté (int)" ;
        m.ajouter(ajoutGrandPrime) ;
        assert(m.toString().equals("125.95.136.0.120")):"Mauvais octet ajouté (int)" ;

        m.ajouter(new Octet(124)) ;
        assert(m.toString().equals("125.95.136.0.120.124")):"Mauvais octet ajouté (octet)" ;
        a = new Adresse(32) ;
        m.ajouter(a) ;
        assert(m.toString().equals("125.95.136.0.120.124.0.0.0.0")):"Mauvaise adresse ajoutée" ;
        mBis = new Message("HEY") ;
        m.ajouter(mBis) ;
        assert(m.toString().equals("125.95.136.0.120.124.0.0.0.0.72.69.89")):"Mauvaise message ajouté" ;

        // message de petits entiers
        short i = 72 ;
        short j = 69 ;
        short k = 89 ;

        m = new Message(i, j, k) ;
        m.ajouter(ajout) ;
        assert(m.toString().equals("72.69.89.125")):"Mauvais octet ajouté (short)" ;
        m.ajouter(ajoutGrand) ;
        assert(m.toString().equals("72.69.89.125.95.136")):"Mauvais octet ajouté (int)" ;
        m.ajouter(ajoutGrandPrime) ;
        assert(m.toString().equals("72.69.89.125.95.136.0.120")):"Mauvais octet ajouté (int)" ;
        
        m.ajouter(new Octet(124)) ;
        assert(m.toString().equals("72.69.89.125.95.136.0.120.124")):"Mauvais octet ajouté (octet)" ;
        a = new Adresse(32) ;
        m.ajouter(a) ;
        assert(m.toString().equals("72.69.89.125.95.136.0.120.124.0.0.0.0")):"Mauvaise adresse ajoutée" ;
        mBis = new Message("HEY") ;
        m.ajouter(mBis) ;
        assert(m.toString().equals("72.69.89.125.95.136.0.120.124.0.0.0.0.72.69.89")):"Mauvaise message ajouté" ;

        // message de grands entiers (faisant un appel tacite à cette méthode)
        m = new Message(245, 894, 0, 7047, 7) ;
        m.ajouter(ajout) ;
        assert(m.toString().equals("0.245.3.126.0.0.27.135.0.7.125")):"Mauvais octet ajouté (short)" ;
        m.ajouter(ajoutGrand) ;
        assert(m.toString().equals("0.245.3.126.0.0.27.135.0.7.125.95.136")):"Mauvais octet ajouté (int)" ;
        m.ajouter(ajoutGrandPrime) ;
        assert(m.toString().equals("0.245.3.126.0.0.27.135.0.7.125.95.136.0.120")):"Mauvais octet ajouté (int)" ;

        m.ajouter(new Octet(124)) ;
        assert(m.toString().equals("0.245.3.126.0.0.27.135.0.7.125.95.136.0.120.124")):"Mauvais octet ajouté (octet)" ;
        a = new Adresse("124.25.0.0") ;
        m.ajouter(a) ;
        assert(m.toString().equals("0.245.3.126.0.0.27.135.0.7.125.95.136.0.120.124.124.25.0.0")):"Mauvaise adresse ajoutée" ;
        mBis = new Message("HEY") ;
        m.ajouter(mBis) ;
        assert(m.toString().equals("0.245.3.126.0.0.27.135.0.7.125.95.136.0.120.124.124.25.0.0.72.69.89")):"Mauvaise message ajouté" ;

        // message avec une chaîne de caractères en paramètre
        m = new Message("Salut !") ;
        m.ajouter(ajout) ;
        assert(m.toString().equals("83.97.108.117.116.32.33.125")):"Mauvais octet ajouté (short)" ;
        m.ajouter(ajoutGrand) ;
        assert(m.toString().equals("83.97.108.117.116.32.33.125.95.136")):"Mauvais octet ajouté (int)" ;
        m.ajouter(ajoutGrandPrime) ;
        assert(m.toString().equals("83.97.108.117.116.32.33.125.95.136.0.120")):"Mauvais octet ajouté (int)" ;

        m.ajouter(new Octet()) ;
        assert(m.toString().equals("83.97.108.117.116.32.33.125.95.136.0.120.0")):"Mauvais octet ajouté (octet)" ;
        a = new Adresse("1.1.2.155") ;
        m.ajouter(a) ;
        assert(m.toString().equals("83.97.108.117.116.32.33.125.95.136.0.120.0.1.1.2.155")):"Mauvaise adresse ajoutée" ;
        mBis = new Message("HEY") ;
        m.ajouter(mBis) ;
        assert(m.toString().equals("83.97.108.117.116.32.33.125.95.136.0.120.0.1.1.2.155.72.69.89")):"Mauvaise message ajouté" ;

        // message avec une adresse en paramètre
        a = new Adresse("187.25.63.1") ;
        m = new Message(a) ;
        m.ajouter(ajout) ;
        assert(m.toString().equals("187.25.63.1.125")):"Mauvais octet ajouté (short)" ;
        m.ajouter(ajoutGrand) ;
        assert(m.toString().equals("187.25.63.1.125.95.136")):"Mauvais octet ajouté (int)" ;
        m.ajouter(ajoutGrandPrime) ;
        assert(m.toString().equals("187.25.63.1.125.95.136.0.120")):"Mauvais octet ajouté (int)" ;

        m.ajouter(new Octet(14)) ;
        assert(m.toString().equals("187.25.63.1.125.95.136.0.120.14")):"Mauvais octet ajouté (octet)" ;
        a = new Adresse(new Octet(22), new Octet(57), new Octet(34), new Octet(245)) ;
        m.ajouter(a) ;
        assert(m.toString().equals("187.25.63.1.125.95.136.0.120.14.22.57.34.245")):"Mauvaise adresse ajoutée" ;
        mBis = new Message("lol") ;
        m.ajouter(mBis) ;
        assert(m.toString().equals("187.25.63.1.125.95.136.0.120.14.22.57.34.245.108.111.108")):"Mauvaise message ajouté" ;

        // messge avec un message en paramètre
        mBis = new Message(5879, 63000, 245, 87) ;
        m = new Message(mBis) ;
        m.ajouter(ajout) ;
        assert(m.toString().equals("22.247.246.24.0.245.0.87.125")):"Mauvais octet ajouté (short)" ;
        m.ajouter(ajoutGrand) ;
        assert(m.toString().equals("22.247.246.24.0.245.0.87.125.95.136")):"Mauvais octet ajouté (int)" ;
        m.ajouter(ajoutGrandPrime) ;
        assert(m.toString().equals("22.247.246.24.0.245.0.87.125.95.136.0.120")):"Mauvais octet ajouté (int)" ;

        m.ajouter(new Octet(124)) ;
        assert(m.toString().equals("22.247.246.24.0.245.0.87.125.95.136.0.120.124")):"Mauvais octet ajouté (octet)" ;
        a = new Adresse(32) ;
        m.ajouter(a) ;
        assert(m.toString().equals("22.247.246.24.0.245.0.87.125.95.136.0.120.124.0.0.0.0")):"Mauvaise adresse ajoutée" ;
        mBis = new Message("lol") ;
        m.ajouter(mBis) ;
        assert(m.toString().equals("22.247.246.24.0.245.0.87.125.95.136.0.120.124.0.0.0.0.108.111.108")):"Mauvaise message ajouté" ;
    }

    public static void testAugmenter()
    {
        Message m ;
        Message mBis ;
        Adresse a ;
        boolean b ;

        // message de petits entiers
        short i = 72 ;
        short j = 69 ;
        short k = 89 ;

        m = new Message(i, j, k) ;
        m.augmenter(20,1,2) ;
        assert(m.toString().equals("72.89.109")):"Mauvaise augmentation" ;

        // message de grands entiers
        m = new Message(245, 894, 0, 7047, 7) ;
        m.augmenter(10,1,8) ;
        b = ( m.toString().equals("0.255.13.136.10.10.37.145.10.7") ) ;
        assert b : "Mauvaise augmentation" ;

        // message avec une chaîne de caractères en paramètre
        m = new Message("Salut !") ;
        m.augmenter(50,0,1) ;
        b = ( m.toString().equals("133.147.108.117.116.32.33")) ;
        assert b : "Mauvaise agmentation" ;

        // message avec une adresse en paramètre
        a = new Adresse("187.25.63.1") ;
        m = new Message(a) ;
        m.augmenter(0,0,3) ;
        b = ( m.toString().equals("187.25.63.1")) ;
        assert b : "Mauvaise augmentation" ;

        // messge avec un message en paramètre
        mBis = new Message("KernelPanic") ;
        m = new Message(mBis) ;
        m.augmenter(100,0,8) ;
        b = ( m.toString().equals("175.201.214.210.201.208.180.197.210.105.99") ) ;
        assert b : "Mauvaise augmentation" ;
    }

    public static void testSupprimer()
    {
        Message m ;
        Message mBis ;
        Adresse a ;
        boolean b ;

        // message de petits entiers
        short i = 72 ;
        short j = 69 ;
        short k = 89 ;
        short l = 142 ;
        short n = 0 ;
        short o = 14 ;

        m = new Message(i, j, k, l, n, o) ;
        m.supprimer(2) ;
        assert(m.toString().equals("89.142.0.14")):"Mauvaise suppression" ;
        m.supprimer(1,2) ;
        assert(m.toString().equals("89.14")):"Mauvaise suppression" ;

        // message de grands entiers
        m = new Message(245, 894, 0, 7047, 7) ;
        m.supprimer(5) ;
        b = ( m.toString().equals("0.27.135.0.7") ) ;
        assert b : "Mauvaise suppression" ;
        m.supprimer(2,4) ;
        b = ( m.toString().equals("0.27")) ;
        assert b : "Mauvaise suppression" ;

        // message avec une chaîne de caractères en paramètre
        m = new Message("Salut !") ;
        m.supprimer(0) ;
        b = ( m.toString().equals("83.97.108.117.116.32.33")) ;
        assert b : "Mauvaise suppression" ;
        m.supprimer(0,6) ;
        b = ( m.toString().equals("")) ;
        assert b : "Mauvaise suppression" ;

        // message avec une adresse en paramètre
        a = new Adresse("187.25.63.1") ;
        m = new Message(a) ;
        m.supprimer(1) ;
        b = ( m.toString().equals("25.63.1")) ;
        assert b : "Mauvaise suppression" ;
        m.supprimer(2,2) ;
        b = ( m.toString().equals("25.63")) ;
        assert b : "Mauvaise suppression" ;

        // messge avec un message en paramètre
        mBis = new Message("KernelPanic") ;
        m = new Message(mBis) ;
        m.supprimer(5) ;
        b = ( m.toString().equals("108.80.97.110.105.99") ) ;
        assert b : "Mauvaise suppression" ;
        m.supprimer(0,0) ;
        b = ( m.toString().equals("80.97.110.105.99")) ;
        assert b : "Mauvaise suppression" ;
    }
}
