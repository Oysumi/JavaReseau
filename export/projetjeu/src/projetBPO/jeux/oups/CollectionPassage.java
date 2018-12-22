package projetBPO.jeux.oups;

import java.util.ArrayList;

public class CollectionPassage {

    private ArrayList<Passage> passages ;

    public CollectionPassage(){
        passages = new ArrayList<>(150); // On prévoit un grand nombre de passages
    }

    public CollectionPassage(Passage ... pass){
        this();
        for (Passage p : pass){
            passages.add(p);
        }
    }

    public int taille(){
        return passages.size() ;
    }

    /* Ne sera jamais utilisé réellement pour le jeu, ne sert qu'aux tests pour vérifier si tout se passe bien */
    public Passage getPassage(int numero){
        return passages.get(numero-1);
    }

    public void ajouterPassage(Passage pass){
        passages.add(pass);
    }
}
