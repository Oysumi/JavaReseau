package projetBPO.tests.TestJeuDeMots;

import projetBPO.jeux.jeudemots.Dictionnaire;

import java.io.IOException;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.fail;

class DictionnaireTest {

    private Dictionnaire monDico ;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        monDico = new Dictionnaire();
    }

    @org.junit.jupiter.api.Test
    void setMotsFaux() {
        // On test si notre dictionnaire est bien vide au départ
        if (monDico.contient("araignée")){
            fail("Le dictionnaire devrait être vide.");
        }

        // On ajoute quelques mots à notre dictionnaire
        monDico.setMots("loup", "chien", "chat", "feuille", "ville");

        if (monDico.contient("loupiot")){
            fail("Le dictionnaire ne devrait pas contenir ce mot.");
        }

        // On ajoute le mot "loupiot"
        monDico.setMots("loupiot", "oui");
        if (!monDico.contient("LOUPIOT")){
            fail("Le dictionnaire devrait contenir ce mot.");
        }
    }

    @org.junit.jupiter.api.Test
    void setMotsVrai() {
        monDico.setMots("loup", "chien", "chat", "feuille", "ville");

        // On va tester si chaque mot appartient bien au dictionnaire
        if (!monDico.contient("loup")){
            fail("Le dictionnaire devrait contenir ce mot.");
        }
        if (!monDico.contient("chien")){
            fail("Le dictionnaire devrait contenir ce mot.");
        }
        if (!monDico.contient("chat")){
            fail("Le dictionnaire devrait contenir ce mot.");
        }
        if (!monDico.contient("feuille")){
            fail("Le dictionnaire devrait contenir ce mot.");
        }
        if (!monDico.contient("ville")){
            fail("Le dictionnaire devrait contenir ce mot.");
        }

        // On test si l'ajout se passe bien
        if (monDico.contient("manger")){
            fail("Le dictionnaire ne devrait pas contenir ce mot.");
        }

        monDico.setMots("manger", "boire");

        if (!monDico.contient("manger")){
            fail("Le dictionnaire devrait contenir ce mot.");
        }

        if (!monDico.contient("boire")){
            fail("Le dictionnaire devrait contenir ce mot.");
        }
    }

    @org.junit.jupiter.api.Test
    void toStringTest(){
        // On test si notre dictionnaire est bien vide au départ
        if(!monDico.toString().equals("")){
            fail("Le dictionnaire devrait être vide");
        }

        monDico.setMots("loup", "chien", "chat", "feuille", "ville");

        if(!monDico.toString().equals("LOUP, CHIEN, CHAT, FEUILLE, VILLE")){
            fail("L'affichage du dictionnaire n'est pas bon.");
        }

        monDico.setMots("titeuf", "lol");

        if(!monDico.toString().equals("LOUP, CHIEN, CHAT, FEUILLE, VILLE, TITEUF, LOL")){
            fail("L'affichage du dictionnaire n'est pas bon.");
        }
    }

    @org.junit.jupiter.api.Test
    void iteratorTest(){

        Iterator<String> iter = monDico.iterator();

        // On test si notre dictionnaire est bien vide
        if (iter.hasNext()){
            fail("L'itérateur devrait être vide.");
        }

        monDico.setMots("loup", "chien", "chat", "feuille", "ville", "anticonstitutionnellement");
        iter = monDico.iterator();

        // On test si notre dictionnair est rempli
        if (!iter.hasNext()){
            fail("L'itérateur ne devrait pas être vide.");
        }

        String mot = iter.next();

        // On regarde le contenu de l'itérateur
        if (!mot.equals("LOUP")){
            fail("Litérateur ne possède pas les bons mots du dictionnaire.");
        }

        mot = iter.next();

        if (!mot.equals("CHIEN")){
            fail("Litérateur ne possède pas les bons mots du dictionnaire.");
        }

        mot = iter.next();

        if (!mot.equals("CHAT")){
            fail("Litérateur ne possède pas les bons mots du dictionnaire.");
        }

        mot = iter.next();

        if (!mot.equals("FEUILLE")){
            fail("Litérateur ne possède pas les bons mots du dictionnaire.");
        }

        mot = iter.next();

        if (!mot.equals("VILLE")){
            fail("Litérateur ne possède pas les bons mots du dictionnaire.");
        }

        mot = iter.next();

        if (!mot.equals("ANTICONSTITUTIONNELLEMENT")){
            fail("Litérateur ne possède pas les bons mots du dictionnaire.");
        }

        // On test si on est bien à la fin de l'itérateur
        if (iter.hasNext()){
            fail("L'itérateur ne devrait plus avoir de mots à parcourir.");
        }
    }

    @org.junit.jupiter.api.Test
    void setMotsPath(){
        try {
            monDico.setMots("../dicotest.txt");
        } catch (IOException e) {
            fail("La lecture fichier s'est mal passé.");
        }

        if (!monDico.contient("ABAT")){
            fail("Le dictionnaire devrait contenir ce mot.");
        }
        if (!monDico.contient("ABBE")){
            fail("Le dictionnaire devrait contenir ce mot.");
        }
        if (!monDico.contient("ABEE")){
            fail("Le dictionnaire devrait contenir ce mot.");
        }
        if (!monDico.contient("ABER")){
            fail("Le dictionnaire devrait contenir ce mot.");
        }
        if (!monDico.contient("ABLE")){
            fail("Le dictionnaire devrait contenir ce mot.");
        }
        if (!monDico.contient("ABOT")){
            fail("Le dictionnaire devrait contenir ce mot.");
        }
        if (!monDico.contient("ABRI")){
            fail("Le dictionnaire devrait contenir ce mot.");
        }
        if (!monDico.contient("ABUS")){
            fail("Le dictionnaire devrait contenir ce mot.");
        }
        if (!monDico.contient("ACAI")){
            fail("Le dictionnaire devrait contenir ce mot.");
        }
        if (!monDico.contient("ACCU")){
            fail("Le dictionnaire devrait contenir ce mot.");
        }
        if (!monDico.contient("ACES")){
            fail("Le dictionnaire devrait contenir ce mot.");
        }
        if (!monDico.contient("ACHE")){
            fail("Le dictionnaire devrait contenir ce mot.");
        }
        if (!monDico.contient("ACME")){
            fail("Le dictionnaire devrait contenir ce mot.");
        }
        if (!monDico.contient("ACNE")){
            fail("Le dictionnaire devrait contenir ce mot.");
        }
        if (!monDico.contient("ACON")){
            fail("Le dictionnaire devrait contenir ce mot.");
        }
        if (!monDico.contient("ACRA")){
            fail("Le dictionnaire devrait contenir ce mot.");
        }
        if (!monDico.contient("ACRE")){
            fail("Le dictionnaire devrait contenir ce mot.");
        }
        if (!monDico.contient("ActA")){
            fail("Le dictionnaire devrait contenir ce mot.");
        }
        if (!monDico.contient("AcTE")){
            fail("Le dictionnaire devrait contenir ce mot.");
        }
        if (!monDico.contient("actu")){
            fail("Le dictionnaire devrait contenir ce mot.");
        }
        if (!monDico.contient("ACUL")){
            fail("Le dictionnaire devrait contenir ce mot.");
        }
        if (!monDico.contient("ADAC")){
            fail("Le dictionnaire devrait contenir ce mot.");
        }
        if (!monDico.contient("ADAS")){
            fail("Le dictionnaire devrait contenir ce mot.");
        }
        if (!monDico.contient("ADAV")){
            fail("Le dictionnaire devrait contenir ce mot.");
        }
        if (!monDico.contient("ADNE")){
            fail("Le dictionnaire devrait contenir ce mot.");
        }
        if (!monDico.contient("ADON")){
            fail("Le dictionnaire devrait contenir ce mot.");
        }
        if (monDico.contient("ADOS")){
            fail("Le dictionnaire ne devrait pas contenir ce mot.");
        }
    }

}