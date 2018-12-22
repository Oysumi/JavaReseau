package projetBPO.tests;

import projetBPO.jeux.Dictionnaire;

import java.util.Iterator;

import static com.sun.tools.internal.ws.wsdl.parser.Util.fail;
import static org.junit.jupiter.api.Assertions.*;

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
        monDico.setMots("loupiot");
        if (!monDico.contient("loupiot")){
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

        monDico.setMots("manger");

        if (!monDico.contient("manger")){
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

        if(!monDico.toString().equals("loup, chien, chat, feuille, ville")){
            fail("L'affichage du dictionnaire n'est pas bon.");
        }

        monDico.setMots("titeuf");

        if(!monDico.toString().equals("loup, chien, chat, feuille, ville, titeuf")){
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
        if (!mot.equals("loup")){
            fail("Litérateur ne possède pas les bons mots du dictionnaire.");
        }

        mot = iter.next();

        if (!mot.equals("chien")){
            fail("Litérateur ne possède pas les bons mots du dictionnaire.");
        }

        mot = iter.next();

        if (!mot.equals("chat")){
            fail("Litérateur ne possède pas les bons mots du dictionnaire.");
        }

        mot = iter.next();

        if (!mot.equals("feuille")){
            fail("Litérateur ne possède pas les bons mots du dictionnaire.");
        }

        mot = iter.next();

        if (!mot.equals("ville")){
            fail("Litérateur ne possède pas les bons mots du dictionnaire.");
        }

        mot = iter.next();

        if (!mot.equals("anticonstitutionnellement")){
            fail("Litérateur ne possède pas les bons mots du dictionnaire.");
        }

        // On test si on est bien à la fin de l'itérateur
        if (iter.hasNext()){
            fail("L'itérateur ne devrait plus avoir de mots à parcourir.");
        }
    }

}