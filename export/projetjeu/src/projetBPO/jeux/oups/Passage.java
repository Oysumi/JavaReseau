package projetBPO.jeux.oups;

public class Passage {

    private Piece salleUne ;
    private Piece salleDeux ;
    private boolean activeTrappe = false ; // Permet de savoir si ce passage active une trappe
    private int numSalleTrappe = -1 ; // Trappe à activer au cas où le passage active un piège

    public Passage(Piece premiereSalle, Piece secondeSalle){
        salleUne = premiereSalle ;
        salleDeux = secondeSalle ;
    }

    public Passage(Piece premiereSalle, Piece secondeSalle, int noSalleTrappe){
        this(premiereSalle, secondeSalle) ;
        ajouterPiege(noSalleTrappe);
    }

    public void ajouterPiege(int sallePiege){
        activeTrappe = true ;
        numSalleTrappe = sallePiege ;
    }

    public boolean activePiege(){
        return activeTrappe ;
    }

    public int activeTrappe(){
        return numSalleTrappe ;
    }

    public Piece premiereSalle(){
        return salleUne ;
    }

    public Piece secondeSalle(){
        return salleDeux ;
    }
}
