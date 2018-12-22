package projetBPO.algos;

import projetBPO.jeux.IEtat;

import java.util.Iterator;

public class ProfondeurDAbord implements IRecherche {

    public boolean existeChemin(IEtat etat){
        Historique histo = new Historique();
        return existeChemin(etat, histo);
    }

    private boolean existeChemin(IEtat etat, Historique h){

        boolean trouve = etat.estFinal();
        boolean cyclique = h.contient(etat) ;
        h.ajouter(etat);
        Iterator<IEtat> iterator = etat.iterator();

        while (!trouve && iterator.hasNext()){
            IEtat e = iterator.next() ;
            cyclique = h.contient(e);
            if (!cyclique) {
                trouve = existeChemin(e, h);
            }
        }

        return trouve ;
    }
}
