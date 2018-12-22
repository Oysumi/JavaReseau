package projetBPO.tests.TestJeuDeMots;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projetBPO.jeux.jeudemots.Dictionnaire;
import projetBPO.jeux.IEtat;
import projetBPO.jeux.jeudemots.JeuDeMots;

import java.io.IOException;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;
import static projetBPO.jeux.EtatAvecEtatFinalPredefini.setEtatFinal;

class JeuDeMotsTest {

    private JeuDeMots jdm ;
    private Dictionnaire dico ;
    private JeuDeMots jeufinal ;

    @BeforeEach
    void setUp() {
        jdm = new JeuDeMots("abat");
        dico = new Dictionnaire("parts", "malin", "salut");
        jdm.setDictionnaire(dico);

        jeufinal = new JeuDeMots("acta");
        setEtatFinal(jeufinal);
    }

    @Test
    void setDico() {
        Iterator<String> it = this.dico.iterator();

        if (!it.next().toString().equals("PARTS")){
            fail("Le dictionnaire n'est pas le bon;");
        }
        if (!it.next().toString().equals("MALIN")){
            fail("Le dictionnaire n'est pas le bon;");
        }
        if (!it.next().toString().equals("SALUT")){
            fail("Le dictionnaire n'est pas le bon;");
        }

        if (it.hasNext()){
            fail("L'itérateur ne devrait plus avoir de mots à parcourir.");
        }
    }

    @Test
    void equalsFaux() {
        if (jdm.equals(jeufinal)){
            fail("Les deux états ne devraient pas être égaux.");
        }
    }

    @Test
    void equalsVrai() {
        // On test ici la casse
        JeuDeMots test = new JeuDeMots("ACTA");
        if (!jeufinal.equals(test)){
            fail("Les deux états devraient être égaux");
        }

        /***********************************************************/

        jdm = new JeuDeMots("acta");
        if (!jeufinal.equals(jdm)){
            fail("Les deux états devraient être égaux");
        }
    }

    @Test
    void estFinal(){
        if (jdm.estFinal()){
            fail("Ce n'est pas un état final.");
        }
        jdm = new JeuDeMots("acta");
        if (!jdm.estFinal()){
            fail("Ce devrait être un état final.");
        }
    }

    @Test
    void iteratorTest(){
        try {
            dico = new Dictionnaire();
            dico.setMots("../dicotest.txt");
            jdm.setDictionnaire(dico);
        } catch (IOException e) {
            fail("La lecture fichier s'est mal passé.");
        }

        Iterator<IEtat> it = jdm.iterator();

        if (!it.hasNext()){
            fail("L'itérateur devrait contenir des mots.");
        }
        if (!it.next().toString().equalsIgnoreCase("ABOT")){
            fail("L'itérateur ne contient pas les bons mots.");
        }
        if (!it.next().toString().equalsIgnoreCase("abam")){
            fail("L'itérateur ne contient pas les bons mots.");
        }
        if (!it.next().toString().equalsIgnoreCase("aban")){
            fail("L'itérateur ne contient pas les bons mots.");
        }
        if (!it.next().toString().equalsIgnoreCase("abaq")){
            fail("L'itérateur ne contient pas les bons mots.");
        }
        if (!it.next().toString().equalsIgnoreCase("abas")){
            fail("L'itérateur ne contient pas les bons mots.");
        }

        if (it.hasNext()){
            fail("L'itérateur ne devrait pas contenir plus de mots.");
        }
    }

}