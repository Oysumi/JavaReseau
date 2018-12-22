package projetBPO.tests.TestOups;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projetBPO.jeux.oups.Passage;
import projetBPO.jeux.oups.Piece;

import static org.junit.jupiter.api.Assertions.*;

class PassageTest {

    private Passage passUn ;
    private Passage passDeux ;

    @BeforeEach
    void setUp(){
        Piece salleUn = new Piece(1);
        Piece salleDeux = new Piece(false, true, 2);
        Piece salleTrois = new Piece(3);
        Piece salleQuatre = new Piece(4);

        passUn = new Passage(salleUn, salleDeux);
        passDeux = new Passage(salleTrois, salleQuatre, 2);
    }

    @Test
    void constructeur() {
        if (passUn.activePiege()){
            fail("L'instanciation devrait faire que ce passage n'active pas de piège.");
        }
        if (passUn.activeTrappe() != -1){
            fail("L'instanciation devrait faire que ce passage retourne -1 en salle piège : " + passUn.activeTrappe());
        }
        if (!passUn.premiereSalle().toString().equals("Numéro : 1 | Trésor : false | Trappe : false")){
            fail("La première salle du passage n'est pas la bonne.");
        }
        if (!passUn.secondeSalle().toString().equals("Numéro : 2 | Trésor : false | Trappe : true")){
            fail("La seconde salle du passage n'est pas la bonne.");
        }

        if (!passDeux.activePiege()){
            fail("L'instanciation devrait faire que ce passage active une trappe.");
        }
        if (passDeux.activeTrappe() != 2){
            fail("L'instanciation devrait faire que ce passage retourne 2 en salle piège : " + passDeux.activeTrappe());
        }
        if (!passDeux.premiereSalle().toString().equals("Numéro : 3 | Trésor : false | Trappe : false")){
            fail("La première salle du passage n'est pas la bonne.");
        }
        if (!passDeux.secondeSalle().toString().equals("Numéro : 4 | Trésor : false | Trappe : false")){
            fail("La seconde salle du passage n'est pas la bonne.");
        }
    }

    @Test
    void ajouterPiege() {
        passUn.ajouterPiege(5);
        if (!passUn.activePiege()){
            fail("Le passage devrait maintenant activer la trappe d'une autre salle.");
        }
        if (passUn.activeTrappe() != 5){
            fail("L'activation de la trappe ne se fait pas dans la bonne salle : " + passDeux.activeTrappe());
        }
        passUn.ajouterPiege(8);
        if (!passUn.activePiege()){
            fail("Le passage devrait maintenant activer la trappe d'une autre salle.");
        }
        if (passUn.activeTrappe() != 8){
            fail("L'activation de la trappe ne se fait pas dans la bonne salle : " + passDeux.activeTrappe());
        }
    }
}