package projetBPO.jeux.jeudemots;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Dictionnaire implements Iterable<String>{

    private ArrayList<String> m_dico ;

    public Dictionnaire() {
        m_dico = new ArrayList<String>(200);
    }

    public Dictionnaire(String ... mots) {
        this();
        setMots(mots);
    }

    public void setMots(String ... mots) {
        for (String word : mots) {
            m_dico.add(word.toUpperCase());
        }
    }

    public void setMots(String nomFichier) throws IOException{
        FileReader flot ;
        BufferedReader flotFiltre;

        flot = new FileReader(nomFichier);
        flotFiltre = new BufferedReader(flot);
        String ligne = flotFiltre.readLine() ;
        while(ligne != null){
            String[] mots = ligne.split(" ");
            setMots(mots);
            ligne = flotFiltre.readLine();
        }
    }

    public boolean contient(String mot) {
        return m_dico.contains(mot.toUpperCase());
    }

    public String toString(){
        /* On imagine des mots de 26 lettres, séparés par une virgule et un espace
         * càd 26*(nombre de mots) + nombre de mots*2 = nombre de mots * 28
         */
        StringBuilder temp = new StringBuilder(28*m_dico.size());

        /* On prévoit le cas où notre dictionnaire est vide pour ne pas lancer
         * d'exceptions
         */
        boolean isempty = true;

        for (String word : m_dico){
            temp.append(word);
            temp.append(", ");
            isempty = false ;
        }

        /* On retire la virgule et l'espace en trop à la fin si le dictionnaire
         * n'est pas vide
         */
        if (!isempty) {
            int size = temp.length();
            temp.delete(size - 2, size);
        }

        return temp.toString() ;
    }

    @Override
    public Iterator<String> iterator() {
        return m_dico.iterator();
    }
}
