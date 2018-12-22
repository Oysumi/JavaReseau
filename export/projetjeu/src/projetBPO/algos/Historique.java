package projetBPO.algos;

import projetBPO.jeux.IEtat;

import java.util.ArrayList;

public class Historique {

    private ArrayList<IEtat>  histo ;

    public Historique(){
        histo = new ArrayList<>(250); // On préfère donner une grande capacité au départ
    }

    public void ajouter(IEtat etat){
        histo.add(etat);
    }

    public boolean contient(IEtat etat){
        return histo.contains(etat);
    }
}
