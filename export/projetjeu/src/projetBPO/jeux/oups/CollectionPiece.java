package projetBPO.jeux.oups;

public class CollectionPiece {

    private Piece[] collection ;

    /* FAIRE UN CONSTRUCTEUR ALÉATOIRE */

    public CollectionPiece(Piece ... salles){
        collection = salles ;
    }

    public void ouvrirFermer(int numero) throws IndexOutOfBoundsException{
        collection[numero].changeTrappe();
    }

    public int nbSalles(){
        return collection.length ;
    }

    public Piece getPiece(int numero) throws IndexOutOfBoundsException{
        return collection[numero] ;
    }

    public void ajouterTresor(int numero) throws IndexOutOfBoundsException{
        collection[numero].ajouteTresor();
    }
}
