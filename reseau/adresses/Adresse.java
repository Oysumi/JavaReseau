package reseau.adresses;

/**
 * @author martine
 * @version 20 nov. 2014
 */
public class Adresse {

    private Octet[] adr ;
    
    /**
     * Constructeur de copie (copie profonde)
     * @param a adresse à copier
     * @exception AssertionError si a est null
     */
    public Adresse(Adresse a) {
        // L'assertion [si a est null, on retourne une erreur] est contenue dans le constructeur avec en paramètre un String
        // dans le but de pouvoir appeler le constructeur ainsi (qui nécessite d'être écrit en premier) :
        this(a.toString()) ;
    }

    /**
     * Constructeur à partir du tableau d'octets
     * @param al octets
     * @exception AssertionError si al est null
     */
    public Adresse(Octet... al) {
        assert(al != null):"Appel au constructeur avec null" ;
        this.adr = al ;
    }

    /**
     * Adresse 0
     * @param nbBits nombre de bits
     * @exception AssertionError si le nombre total de bits n'est pas un multiple de 8 supérieur ou égal à 8
     */
    public Adresse(int nbBits) {
        assert(nbBits%8 == 0):"Nombre de bits incorrect (pas un multiple de 8)" ;
        int oct = nbBits / 8 ;
        this.adr = new Octet[oct] ;
        for (int i = 0 ; i < oct ; i++)
        {
            this.adr[i] = new Octet(0) ;
        }
    }

    /**
     * Adresse masque composée de nbBitsUn bits à 1 suivis de 0 pour compléter.
     * @param nbBits nombre de bits total
     * @param nbBitsUn nombre de bits à 1
     * @exception AssertionError si le nombre total de bits n'est pas un multiple de 8 supérieur ou égal à 8
     * @exception AssertionError si le nombre total de 1 est incorrect (négatif ou supérieur à nbBits)
     */
    public Adresse(int nbBits, int nbBitsUn) {
        assert(nbBits % 8 == 0 && nbBits >= 8):"Nombre de bits incorrect (pas un multiple de 8 ou inférieur à 8)" ;
        assert(nbBitsUn >= 0 && nbBitsUn <= nbBits):"Nombre de bits à fixer à 1 incorrect" ;

        int nbOctet = nbBits / 8 ;
        int nbBitsUnBis = nbBitsUn ; // sera utile pour la boucle dans un but de réinitialisation
        int nbUn = 0 ;

        this.adr = new Octet[nbOctet] ;

        for (int i = 0 ; i < nbOctet ; i++)
        {
            nbUn = (nbBitsUnBis - 8 >= 0) ? 8 : nbBitsUnBis ; // Comme sur un octet nous avons 8 bits, on fixe au maximum 8 uns

            this.adr[i] = new Octet() ; // On instancie notre octet pour ensuite lui fixer le bon nombre de bits à 1
            this.adr[i].setUn(nbUn) ; // Maintenant instancé, on peut lui fixer le nombre de 1

            /* Si nbBitsUnBis >= 8, alors il reste des bits à fixer à 1
             * sinon, les étapes précedentes ont fixés un nombre de bits < 8 à 1
             * donc nous ne devons plus mettre de 1 dans l'adresse, d'où nbBitsUnBis = 0 */
            nbBitsUnBis = (nbBitsUnBis - 8 >= 0) ? nbBitsUnBis - 8 : 0 ;
        }
    }

    /**
     * Constructeur à partir d'une adresse écrite sous forme de notation décimale pointée (par ex : 245.156.0.0)
     * @param s notation décimale pointée d'une adresse (par ex : 245.156.0.0)
     * @exception AssertionError si le nombre d'octets est différent de 4, 6, 8 ou si un entier est trop grand
     */
    public Adresse(String s) {

        // Sert pour le constructeur de copie
        assert(s != null):"Appel au constructeur avec null" ;

        String[] temp = s.split("[.]") ; // On extrait les différents octets séparés par un point

        int nbOctet = temp.length ;

        boolean nbre = (nbOctet != 4 && nbOctet != 6 && nbOctet != 8) ;
        assert !nbre : "Erreur : nombre d'octet incorrect" ; // si nbre = true, alors les 3 conditions ne sont pas vérifiées

        this.adr = new Octet[nbOctet] ;

        // Servira à vérifier la taille de l'entier codé sur l'ième octet
        int entier = 0 ;

        // Remplissage de l'adresse (donc du tableau d'octets)
        for ( int i = 0 ; i < nbOctet ; i++ )
        {
            entier = Integer.parseInt(temp[i]) ; // on extrait les entiers d'une chaîne de caractères et on vérifie si ce n'est pas trop grand
            assert (entier <= 255 && entier >= 0) : "Erreur : entier trop grand ou trop petit" ; 
            this.adr[i] = new Octet(entier) ;
        }
    }

    /**
     * Retourne le nombre de bits
     * @return le nombre de bits
     */
    public int size() {
        return this.getNbreOctets() * 8 ;
    }

    /**
     * Retourne le nombre d'octets
     * @return le nombre d'octets
     */
    public int getNbreOctets() {
        return this.adr.length ;
    }

    /**
     * Appliquer un masque
     * @param masque masque à appliquer
     * @exception AssertionError si le masque et le receveur ne sont pas de la même taille
     */
    public void masquer(Adresse masque) {
    }

    /**
     * Inverser les octets (0 &rarr; 1, 1 &rarr; 0)
     */
    public void inverser() {
        for ( Octet o : this.adr )
        {
            o.inverser() ;
        }
    }

    /**
     * Fixer les octets
     * @param alo octets
     * @exception AssertionError si alo est null
     */
    public void setOctets(Octet... alo)  {

        assert(alo!=null):"Appel au constructeur avec null" ;
        int k = 0 ;

        for ( Octet o : alo )
        {
            this.setOctet(o, k) ;
            k++ ;
        }
    }

    /**
     * Fixer un des octets de l'adresse, k est le rang de l'octet, k &ge; 0
     * @param o octet
     * @param k rang de l'octet
     * @exception AssertionError si k n'est pas entre 0 et le nombre d'octets
     */
    public void setOctet(Octet o, int k)  {
        assert(k >= 0 && k <= this.size()):"Position d'octet incorrect" ;
        this.adr[k] = new Octet(o) ;
    }

    /**
     * Consulter un des octets de l'adresse, k est le rang de l'octet, k &ge; 0
     * @param k rang de l'octet
     * @return l'octet de rang k de l'adresse
     * @exception AssertionError si k n'est pas entre 0 et le nombre d'octets
     */
    public Octet getOctet(int k) {
        assert(k >= 0 && k <= this.size()):"Position d'octet incorrect" ;
        return this.adr[k] ;
    }

    /**
     * Construit la chaîne de caractères où la valeur de chaque octet est séparé du suivant par un point.
     * Par exemple 192.45.43.100
     * @return la chaîne de caractères construite
     */
    public String toString() {

        /* On prévoit le pire des cas : une adresse 8 octets avec des entiers >= 100 séparés par 7 points 
         * donc 8 * 3 + 7 places */
        StringBuilder presentation = new StringBuilder(31) ;

        for ( Octet s : this.adr )
        {
            presentation.append(s) ;
            presentation.append(".") ;
        }

        // De par la boucle, on rajoute forcément un point en trop à la fin de l'adresse qu'il faut supprimer
        int pointASupp = presentation.length() ;
        presentation.deleteCharAt(pointASupp - 1) ;

        return presentation.toString() ;
    }

}
