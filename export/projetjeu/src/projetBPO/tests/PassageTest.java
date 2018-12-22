package projetBPO.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projetBPO.jeux.oups.Passage;
import projetBPO.jeux.oups.Piece;

import static org.junit.jupiter.api.Assertions.*;

class PassageTest {

    private Piece salleUn ;
    private Piece salleDeux ;
    private Passage pass ;

    @BeforeEach
    void setUp(){
        salleUn = new Piece(1);
        salleDeux = new Piece(false, true, 2);
        pass = new Passage(salleUn, salleDeux);
    }

    @Test
    void constructeur() {
        if (pass.activePiege()){
            fail("L'instanciation devrait faire que ce passage n'active pas de piège.");
        }
        if (pass.activeTrappe() != -1){
            fail("L'instanciation devrait faire que ce passage retourne -1 en salle piège : " + pass.activeTrappe());
        }
        if (!pass.premiereSalle().toString().equals("Numéro : 1 | Trésor : false | Trappe : false")){
            fail("La première salle du passage n'est pas la bonne.");
        }
        if (!pass.secondeSalle().toString().equals("Numéro : 2 | Trésor : false | Trappe : true")){
            fail("La seconde salle du passage n'est pas la bonne.");
        }
    }

    @Test
    void ajouterPiege() {
        pass.ajouterPiege(5);
        if (!pass.activePiege()){
            fail("Le passage devrait maintenant activer la trappe d'une autre salle.");
        }
        if (pass.activeTrappe() != 5){
            fail("L'activation de la trappe ne se fait pas dans la bonne salle : " + pass.activeTrappe());
        }
        pass.ajouterPiege(8);
        if (!pass.activePiege()){
            fail("Le passage devrait maintenant activer la trappe d'une autre salle.");
        }
        if (pass.activeTrappe() != 8){
            fail("L'activation de la trappe ne se fait pas dans la bonne salle : " + pass.activeTrappe());
        }
    }
}