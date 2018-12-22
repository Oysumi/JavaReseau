package projetBPO.jeux.oups;

public class Piece {

    private int numero ;
    private boolean tresor;
    private boolean trappe;

    public Piece(int num){
        numero = num ;
        tresor = false ;
        trappe = false ;
    }

    public Piece(boolean tres, boolean trap, int num){
        this(num);
        tresor = tres;
        trappe = trap;
    }

    public void changeTrappe(){
        trappe = !trappe ;
    }

    public void ajouteTresor() { tresor = true ; }

    public int getNumero(){
        return numero;
    }

    public boolean trappeOuverte(){
        return trappe;
    }

    public boolean estUnTresor(){
        return tresor;
    }

    public String toString() {
        return "Numéro : " + numero + " | Trésor : " + tresor + " | Trappe : " + trappe ;
    }
}
