package projetBPO.tests.TestAlgo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projetBPO.algos.LargeurDAbord;
import projetBPO.jeux.jeudemots.Dictionnaire;
import projetBPO.jeux.EtatAvecEtatFinalPredefini;
import projetBPO.jeux.jeudemots.JeuDeMots;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class LargeurDAbordTest {

    private LargeurDAbord algo ;
    private JeuDeMots jdm ;
    private Dictionnaire dico ;

    @BeforeEach
    void setUp(){
        algo = new LargeurDAbord();
        jdm = new JeuDeMots("abat");
        dico = new Dictionnaire();
        try {
            dico.setMots("../dico4.txt");
        } catch (IOException e) {
            System.out.println("Impossible d'ouvrir le dictionnaire.");
            System.exit(3);
        }
        jdm.setDictionnaire(dico);
        EtatAvecEtatFinalPredefini.setEtatFinal(new JeuDeMots("ABOT"));
    }

    @Test
    void testRechercheVrai(){

        long startTime = System.nanoTime();
        if (!algo.existeChemin(jdm)) {
            fail("Il existe un chemin vers ce mot.");
        }
        long estimatedTime = System.nanoTime() - startTime ;

        System.out.println("LARGEUR D'ABORD POUR ABOT (TRUE) : " + estimatedTime + "ns.");

        EtatAvecEtatFinalPredefini.setEtatFinal(new JeuDeMots("IXAT"));

        startTime = System.nanoTime();
        if (!algo.existeChemin(jdm)) {
            fail("Il existe un chemin vers ce mot.");
        }
        estimatedTime = System.nanoTime() - startTime ;

        System.out.println("LARGEUR D'ABORD POUR IXAT (TRUE) : " + estimatedTime + "ns.");
    }

    @Test
    void testRechercheFaux(){
        EtatAvecEtatFinalPredefini.setEtatFinal(new JeuDeMots("JABO"));

        long startTime = System.nanoTime();
        if (algo.existeChemin(jdm)) {
            fail("Il n'existe pas de chemin vers ce mot.");
        }
        long estimatedTime = System.nanoTime() - startTime ;

        System.out.println("LARGEUR D'ABORD POUR JABO (FALSE) : " + estimatedTime + "ns.");

        EtatAvecEtatFinalPredefini.setEtatFinal(new JeuDeMots("KAMO"));

        startTime = System.nanoTime();
        if (algo.existeChemin(jdm)) {
            fail("Il n'existe pas de chemin vers ce mot.");
        }
        estimatedTime = System.nanoTime() - startTime ;

        System.out.println("LARGEUR D'ABORD POUR KAMO (FALSE) : " + estimatedTime + "ns.");
    }
}