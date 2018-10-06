package reseau;

import reseau.adresses.Adresse;
import reseau.adresses.Octet;

/**
 * @author martine
 * @version 4 déc. 2014
 */
public class Message {

    /**
     * Construit un message vide
     */
    public Message() {
    }

    /**
     * Constructeur de copie (copie profonde)
     * @param mess nombre d'éléments à copier
     * @exception AssertionError si mess est null
     */
    public Message(Message mess) {
    }
    
    /**
     * Constructeur d'un message à partir des petits entiers
     * @param v des petits entiers qui constituent le message
     */
    public Message(short... v) {
    }
    
    /**
     * Constructeur d'un message à partir des entiers
     * @param v des entiers qui constituent le message
     */
    public Message(int... v) {
    }
    
    /**
     * Constructeur d'un message à partir de la chaîne de caractères
     * @param mot chaîne de caractères qui constitue le message
     */
    public Message(String mot) {
    }
    
    /**
     * Constructeur d'un message à partir de l'adresse
     * @param adr adresse à placer dans le message
     */
    public Message(Adresse adr) {
    }
        
    /**
     * Retourne le nmbre d'octets
     * @return le nombre d'octets
     */
    public int size() {
        return 0;
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
        return null ;
    }

    /**
     * Extraire les 2 octets situés en index et index+1 pour en faire un entier
     * octets forts puis faibles (big endian)
     * @param index index du premier octet
     * @exception AssertionError si index ou index+1 n'est pas dans le domaine du tableau
     * @return un entier
     */
    public int extraireEntier(int index) {
        return 0 ;
    }

    /**
     * Extraire les nbOctets premiers octets pour en faire une adresse
     * @param nbOctets nombre d'octets à extraire
     * @exception AssertionError si nbOctets &gt; longueur du message
     * @return une adresse
     */
    public Adresse extraireAdresse(int nbOctets) {
        return null ;
    }

    /**
     * Transformer le message en une suite de lettres, si possible 
     * @return null si l'un des octets n'est pas une lettre (maj ou min)
     */
    public String extraireChaine() {
        return null ;
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
