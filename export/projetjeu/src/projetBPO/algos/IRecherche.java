package projetBPO.algos;

import projetBPO.jeux.IEtat;

public interface IRecherche {
    /**
     * @return vrai si il existe un chemin
     */
    boolean existeChemin(IEtat etat);
}
