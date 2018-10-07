package reseau;

import reseau.adresses.Adresse;
import reseau.adresses.Octet;
import java.util.ArrayList ;

/**
 * @author martine
 * @version 4 déc. 2014
 */
public class Message {

	private ArrayList<Octet> myMessage ;
    /**
     * Construit un message vide
     */
    public Message() {
    	/* Quitte à écrire un message, on lui fournit une capacité de 100 "espaces" pour éviter la multiplication des objets morts
    	 * si mauvaise utilisation de l'application il y a */
    	this.myMessage = new ArrayList<Octet>(100) ;
    }

    /**
     * Constructeur de copie (copie profonde)
     * @param mess nombre d'éléments à copier
     * @exception AssertionError si mess est null
     */
    public Message(Message mess) {
    	assert(mess != null):"Appel au constructeur avec null" ;

    	int taille = mess.size() ;
    	this.myMessage = new ArrayList<Octet>(taille) ;

    	for ( int i = 0 ; i < taille ; i++ )
    	{
    		this.myMessage.add(mess.myMessage.get(i)) ;
    	}
    }
    
    /**
     * Constructeur d'un message à partir des petits entiers
     * @param v des petits entiers qui constituent le message
     * @exception AssertionError si un des paramètres > 255 ou < 0
     */
    public Message(short... v) {

    	// On peut se permettre d'allouer en mémoire avant de vérifier la justesse des entiers, car en cas d'erreur l'application s'arrête
    	this.myMessage = new ArrayList<Octet>(100 + v.length) ; // on prévoit une plus grande capacité en cas de modifications

    	// Un petit entier est codé sur un octet
    	for ( short entier : v )
    	{
    		assert(entier>=0 && entier<=255):"Entier négatif ou mauvais codage sur un octet" ;
    		this.myMessage.add(new Octet(entier)) ;
    	}
    }
    
    /**
     * Constructeur d'un message à partir des entiers
     * @param v des entiers qui constituent le message
     * @exception AssertionError si un des paramètres > 65 535 ou < 0
     */
    public Message(int... v) {

    	// On peut se permettre d'allouer en mémoire avant de vérifier la justesse des entiers, car en cas d'erreur l'application s'arrête
    	this.myMessage = new ArrayList<Octet>(100 + v.length * 2) ; // car grand entier codé sur 2 octets ET un prévoit une grande capacité pour modifs
    	
    	/* Nous avons besoin d'une représentation binaire de l'entier. On utilisera la méthode toBinarayString de l'enveloppe Integer
    	 * et nous affecterons le résultat à un StringBuilder pour éviter la multiplication des objets morts.
    	 * Au pire des cas, la représentation binaire est de taille 16 donc on initialise notre StringBuilder avec une capacité de 16*/
    	StringBuilder representBin = new StringBuilder(16) ;
    	int taille = 0 ; // permet de connaître la taille de la représentation binaire de notre entier
    	int index = 0 ; // permet d'extraire les octets
    	Octet o ;

    	// Un entier est codé sur un octet
    	for ( int entier : v )
    	{
    		assert(entier>=0 && entier<=65535):"Entier négatif ou trop grand pour codage sur 2 octets" ;

    		int baseDeux = 2 ; // Permettra la conversion d'un binaire en base 10 pour Integer.parseInt

    		// On ajoute dans le StringBuilder la chaîne de caractère composée de 0 et de 1 représentant notre entier en binaire
    		representBin.append( Integer.toBinaryString(entier) ) ;
    		// On récupère la taille de cette représentation binaire
    		taille = representBin.length() ;
    		// On récupère un index qui permet de créer le premier octet (avec poids forts en premier)
    		index = ( taille - 8 >= 0 ) ? taille - 8 : taille ;

    		/* Si la taille est strictement supérieure à 8, alors notre entier est supérieur à 255 et nécessite un octet supplémentaire pour
    		 * coder le reste */
    		if ( taille > 8 )
    		{
    			o = new Octet( Integer.parseInt(representBin.substring(0, index), baseDeux) ) ; // partie des bits de poids fort
    			this.myMessage.add(o) ;

    			o = new Octet( Integer.parseInt(representBin.substring(index, taille), baseDeux) ) ; // bits poids faible
    			this.myMessage.add(o) ;
    		}
    		else // sinon, notre entier est compris entre 0 et 255 et est codé en réalité sur un octet, on ajoute donc des 0 au début
    		{
    			o = new Octet(0) ;
    			this.myMessage.add(o) ; // partie des bits de poids fort

    			if ( taille == 1 ) // alors on extrait uniquement le bit 0 ou 1
    			{
    				o = new Octet( Character.getNumericValue(representBin.charAt(0)) ) ; // bits poids faible
    			}
    			else // sinon on extrait l'ensemble des bits
    			{
    				o = new Octet( Integer.parseInt(representBin.substring(0, taille), baseDeux) ) ; // bits poids faible
    			}

    			this.myMessage.add(o) ;
    		}

    		representBin.delete(0,taille) ; // on réutilise notre StringBuilder
    	}
    }
    
    /**
     * Constructeur d'un message à partir de la chaîne de caractères
     * @param mot chaîne de caractères qui constitue le message
     */
    public Message(String mot) {

    	assert(mot!=null):"Appel au constructeur avec null" ;

    	int taille = mot.length() ;

    	this.myMessage = new ArrayList<Octet>(taille) ;

    	for (int k = 0 ; k < taille ; k++)
    	{
    		this.myMessage.add(new Octet((int)mot.charAt(k))) ;
    	}
    }
    
    /**
     * Constructeur d'un message à partir de l'adresse
     * @param adr adresse à placer dans le message
     */
    public Message(Adresse adr) {

    	int nbOctet = adr.getNbreOctets() ;
    	short[] param = new short[nbOctet] ;

    	this.myMessage = new ArrayList<Octet>(100 + nbOctet) ; // On prévoit toujours de la place en plus en cas de modifications

    	for ( int i = 0 ; i < nbOctet ; i++ )
    	{
    		param[i] = (short)adr.getOctet(i).getValue() ;
    	}

    	// Un petit entier est codé sur un octet
    	for ( short entier : param )
    	{
    		this.myMessage.add(new Octet(entier)) ;
    	}
    }
        
    /**
     * Retourne le nmbre d'octets
     * @return le nombre d'octets
     */
    public int size() {
        return this.myMessage.size() ;
    }

    /**
     * Ajouter un petit entier à la fin, entier &ge; 0
     * @param x entier à ajouter
     */
    public void ajouter(short x) {
    }

    /**
     * Ajouter un entier à la fin, entier &ge; 0
     * @param x entier à ajouter
     */
    public void ajouter(int x) {
    }

    /**
     * Ajouter un octet à la fin
     * @param o octet à ajouter
     * @exception AssertionError si o est null
     */
    public void ajouter(Octet o) {
    }
    
    /**
     * Concaténer un autre message
     * @param mess message à ajouter à la fin
     * @exception AssertionError si mess est null
     */
    public void ajouter(Message mess) {
    }
    
    /**
     * Ajouter les octets d'une adresse à la fin
     * @param adr adresse à ajouter
     * @exception AssertionError si adr est null
     */
    public void ajouter(Adresse adr) {
    }
    
    @Override
    public String toString() {
		
		// au pire des cas, un octet est > 100 donc 3 digits de représentation et un point pour séparer donc on multiplie par ( 3 + 1 ) 
    	StringBuilder message = new StringBuilder(this.size() * 4) ;

    	if ( this.size() == 0 ) // Si l'on a instancié un message vide
    	{
    		return "" ;
    	}
    	else // Si le message n'est pas vide
    	{
    		for ( Octet o : this.myMessage )
    		{
    			message.append(o) ;
    			message.append(".") ;
    		}
    	}

    	// De par la boucle, on rajoute forcément un point en trop à la fin du message qu'il faut supprimer
        int pointASupp = message.length() ;
        message.deleteCharAt(pointASupp - 1) ;

		return message.toString() ;
    }

    /**
     * Extraire les 2 octets situés en index et index+1 pour en faire un entier
     * octets forts puis faibles (big endian)
     * @param index index du premier octet
     * @exception AssertionError si index ou index+1 n'est pas dans le domaine du tableau
     * @return un entier
     */
    public int extraireEntier(int index) {
    	assert(index>=0 && index<=this.size()):"Extraction d'octet hors de la liste" ;
    	int result = this.myMessage.get(index).getValue() + this.myMessage.get(index+1).getValue() ;
        return result ;
    }

    /**
     * Extraire les nbOctets premiers octets pour en faire une adresse
     * @param nbOctets nombre d'octets à extraire
     * @exception AssertionError si nbOctets &gt; longueur du message
     * @return une adresse
     */
    public Adresse extraireAdresse(int nbOctets) {
    	assert(nbOctets>=0 && nbOctets<=this.size()):"Impossible d'extraire les nb premiers octets pour en faire une adresse" ;
    	Octet[] param = new Octet[nbOctets] ;
    	for ( int i=0 ; i < nbOctets ; i++ )
    	{
    		param[i] = this.myMessage.get(i) ;
    	}
        return new Adresse(param) ;
    }

    /**
     * Transformer le message en une suite de lettres, si possible 
     * @return null si l'un des octets n'est pas une lettre (maj ou min)
     */
    public String extraireChaine() {

        StringBuilder message = new StringBuilder(this.size()) ;
        String pasCaractère = null ; // on prévoit le cas où l'on a une valeur qui ne code pas un caractère
        boolean nullOuPas = false ;

    	if ( this.size() == 0 ) // Si l'on a instancié un message vide
    	{
    		return "" ;
    	}
    	else // Si le message n'est pas vide
    	{
    		for ( Octet o : this.myMessage )
    		{	
    			if ( o.estUneLettre() || o.estUnPoint() )
    			{
    				message.append((char)o.getValue()) ;
    			}
    			else
    			{
    				nullOuPas = true ;
    			}
    		}
    	}
    	return ( nullOuPas ) ? pasCaractère : message.toString() ;
    }

    /**
     * Augmenter de i chaque octet compris entre bi et bs
     * @param i valeur à ajouter
     * @param bi borne inférieure
     * @param bs borne supérieure
     */
    public void augmenter(int i, int bi, int bs) {
    }

    /**
     * On enlève les i premiers éléments
     * @param i nombre d'éléments à enlever
     * @exception AssertionError si i n'est pas dans le domaine du tableau
     */
    public void supprimer(int i) {
    }

    /**
     * On enlève les éléments entre debut et fin inclus
     * @param debut borne inférieure
     * @param fin borne supérieure
     * @exception AssertionError si on n'a pas 0 &le; debut &le; fin &lt; size()
     */
    public void supprimer(int debut, int fin) {
    }

}
