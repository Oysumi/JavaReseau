package projetBPO.algos;

import projetBPO.jeux.IEtat;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class LargeurDAbord implements IRecherche {

    public boolean existeChemin(IEtat etat){
        Historique hist = new Historique();
        return existeChemin(etat, hist);
    }

    private boolean existeChemin(IEtat etat, Historique histo){
        boolean trouve = etat.estFinal() ;
        boolean cyclique = false ;
        Queue<IEtat> file = new LinkedList<IEtat>();
        file.add(etat);

        while (!file.isEmpty() && !trouve){
            IEtat actuel = file.poll();
            trouve = actuel.estFinal();
            cyclique = histo.contient(actuel);
            histo.ajouter(actuel);
            Iterator<IEtat> iter = actuel.iterator();

            if (!cyclique) {
                while (iter.hasNext()) {
                    file.add(iter.next());
                }
            }
        }
        return trouve ;
    }
}
