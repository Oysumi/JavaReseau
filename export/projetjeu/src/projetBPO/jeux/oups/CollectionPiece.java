package projetBPO.jeux.oups;

public class CollectionPiece {

    private Piece[] collection ;

    public CollectionPiece(int taille) {
        collection = new Piece[taille] ;
        for (int i = 0 ; i < taille ; i++){
            collection[i] = new Piece(i+1);
        }
    }

    public CollectionPiece(Piece ... salles){
        collection = salles ;
    }

    public void ouvrirFermer(int numero) throws IndexOutOfBoundsException{
        collection[numero-1].changeTrappe();
    }

    public int nbSalles(){
        return collection.length ;
    }

    public Piece getPiece(int numero) throws IndexOutOfBoundsException{
        return collection[numero - 1] ;
    }

    public void ajouterTresor(int numero) throws IndexOutOfBoundsException{
        collection[numero - 1].ajouteTresor();
    }
}
