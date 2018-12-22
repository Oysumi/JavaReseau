package projetBPO.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projetBPO.jeux.Dictionnaire;
import projetBPO.jeux.JeuDeMots;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;
import static projetBPO.jeux.EtatAvecEtatFinalPredefini.setEtatFinal;

class JeuDeMotsTest {

    private JeuDeMots jdm ;
    private Dictionnaire dico ;
    private JeuDeMots jeufinal ;

    @BeforeEach
    void setUp() {
        jdm = new JeuDeMots("mange");
        dico = new Dictionnaire("parts", "malin", "salut");
        jdm.setDictionnaire(dico);

        jeufinal = new JeuDeMots("malin");
        setEtatFinal(jeufinal);
    }

    @Test
    void setDico() {
        Iterator<String> it = this.dico.iterator();

        if (!it.next().toString("parts")){
            fail("Le dictionnaire n'est pas le bon;");
        }
        if (!it.next().toString("malin")){
            fail("Le dictionnaire n'est pas le bon;");
        }
        if (!it.next().toString("salut")){
            fail("Le dictionnaire n'est pas le bon;");
        }

        if (it.hasNext()){
            fail("L'itérateur ne devrait plus avoir de mots à parcourir.");
        }
    }

    @Test
    void equals() {
    }

}