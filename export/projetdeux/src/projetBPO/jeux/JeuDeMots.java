package projetBPO.jeux;

import java.util.ArrayList;
import java.util.Iterator;

public class JeuDeMots extends EtatAvecEtatFinalPredefini implements Iterable<String> {

    private StringBuilder mot ;
    private static Dictionnaire dico ;

    public JeuDeMots(String word){
        // On récupère la taille du mot
        int size = word.length();

        mot = new StringBuilder(size);
        mot.append(word);
    }

    public void setDictionnaire(Dictionnaire d){
        dico = d ;
    }

    public String toString(){
        return mot.toString();
    }

    public boolean equals(IEtat etat){
        return toString().equals(etat.toString());
    }

    public Iterator<IEtat> iterator(){
        int size = mot.length();
        int index = 0 ;
        ArrayList<IEtat> succ = new ArrayList<IEtat>(26*size);

        // On va modifier un par un les caractères du mot actuel
        while (index < size){
            mot.replace(index, index+1, "a");
            if (dico.contient(mot.toString())){
                succ.add(new JeuDeMots(mot.toString()));
            }
            mot.replace(index,index+1,"b");
            if (dico.contient(mot)){
                succ.add(new JeuDeMots(mot));
            }
            mot.replace(index,index+1,"c");
            if (dico.contient(mot)){
                succ.add(new JeuDeMots(mot));
            }
            mot.replace(index,index+1,"d");
            if (dico.contient(mot)){
                succ.add(new JeuDeMots(mot));
            }
            mot.replace(index,index+1,"e");
            if (dico.contient(mot)){
                succ.add(new JeuDeMots(mot));
            }
            mot.replace(index,index+1,"f");
            if (dico.contient(mot)){
                succ.add(new JeuDeMots(mot));
            }
            mot.replace(index,index+1,"g");
            if (dico.contient(mot)){
                succ.add(new JeuDeMots(mot));
            }
            mot.replace(index,index+1,"h");
            if (dico.contient(mot)){
                succ.add(new JeuDeMots(mot));
            }
            mot.replace(index,index+1,"i");
            if (dico.contient(mot)){
                succ.add(new JeuDeMots(mot));
            }
            mot.replace(index,index+1,"j");
            if (dico.contient(mot)){
                succ.add(new JeuDeMots(mot));
            }
            mot.replace(index,index+1,"k");
            if (dico.contient(mot)){
                succ.add(new JeuDeMots(mot));
            }
            mot.replace(index,index+1,"l");
            if (dico.contient(mot)){
                succ.add(new JeuDeMots(mot));
            }
            mot.replace(index,index+1,"m");
            if (dico.contient(mot)){
                succ.add(new JeuDeMots(mot));
            }
            mot.replace(index,index+1,"n");
            if (dico.contient(mot)){
                succ.add(new JeuDeMots(mot));
            }
            mot.replace(index,index+1,"o");
            if (dico.contient(mot)){
                succ.add(new JeuDeMots(mot));
            }
            mot.replace(index,index+1,"p");
            if (dico.contient(mot)){
                succ.add(new JeuDeMots(mot));
            }
            mot.replace(index,index+1,"q");
            if (dico.contient(mot)){
                succ.add(new JeuDeMots(mot));
            }
            mot.replace(index,index+1,"r");
            if (dico.contient(mot)){
                succ.add(new JeuDeMots(mot));
            }
            mot.replace(index,index+1,"s");
            if (dico.contient(mot)){
                succ.add(new JeuDeMots(mot));
            }
            mot.replace(index,index+1,"t");
            if (dico.contient(mot)){
                succ.add(new JeuDeMots(mot));
            }
            mot.replace(index,index+1,"u");
            if (dico.contient(mot)){
                succ.add(new JeuDeMots(mot));
            }
            mot.replace(index,index+1,"v");
            if (dico.contient(mot)){
                succ.add(new JeuDeMots(mot));
            }
            mot.replace(index,index+1,"w");
            if (dico.contient(mot)){
                succ.add(new JeuDeMots(mot));
            }
            mot.replace(index,index+1,"x");
            if (dico.contient(mot)){
                succ.add(new JeuDeMots(mot));
            }
            mot.replace(index,index+1,"y");
            if (dico.contient(mot)){
                succ.add(new JeuDeMots(mot));
            }
            mot.replace(index,index+1,"z");
            if (dico.contient(mot)){
                succ.add(new JeuDeMots(mot));
            }
        }
    }
}
