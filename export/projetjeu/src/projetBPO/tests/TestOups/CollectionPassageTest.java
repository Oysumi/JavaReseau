package projetBPO.tests.TestOups;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projetBPO.jeux.oups.CollectionPassage;
import projetBPO.jeux.oups.Passage;
import projetBPO.jeux.oups.Piece;

import static org.junit.jupiter.api.Assertions.*;

class CollectionPassageTest {

    private CollectionPassage collecPass ;

    @BeforeEach
    void setUp(){
        Piece pieceUne = new Piece(1);
        Piece pieceDeux = new Piece(2);
        Piece pieceTrois = new Piece(false, true, 3);
        Piece pieceQuatre = new Piece(4);
        Piece pieceCinq = new Piece(false, true, 5);
        Piece pieceSix = new Piece(6);
        Piece pieceSept = new Piece(false, true, 7);
        Piece pieceHuit = new Piece(8);
        Piece pieceNeuf = new Piece(true, false, 9);

        Passage passageUn = new Passage(pieceUne, pieceDeux);
        Passage passageDeux = new Passage(pieceUne, pieceQuatre);
        Passage passageTrois = new Passage(pieceDeux, pieceTrois);
        Passage passageQuatre = new Passage(pieceTrois, pieceSix);
        Passage passageCinq = new Passage(pieceQuatre, pieceSept);
        Passage passageSix = new Passage(pieceQuatre, pieceCinq);
        Passage passageSept = new Passage(pieceCinq, pieceHuit);
        Passage passageHuit = new Passage(pieceSept, pieceHuit);
        Passage passageNeuf = new Passage(pieceHuit, pieceNeuf);

        /*        ______ ______ ______
                 |      |      |      |
                 |   1      2     3P  |
                 |__  __|______|__  __|
                 |      |      |      |      P = PIEGE
                 |   4     5P  |   6  |      T = TRESOR
                 |__  __|__  __|______|
                 |      |      |      |
                 |  7P      8     9T  |
                 |______|______|______|

         */

        collecPass = new CollectionPassage(passageUn, passageDeux, passageTrois, passageQuatre,
                                           passageCinq, passageSix, passageSept, passageHuit,
                                           passageNeuf);
    }

    @Test
    void taille() {
        if (collecPass.taille() != 9){
            fail("La collection ne contient pas le bon nombre de passage.");
        }

        Piece testUn = new Piece(54);
        Piece testDeux = new Piece(5552);
        Passage factice = new Passage(testUn, testDeux);

        collecPass.ajouterPassage(factice);

        if (collecPass.taille() != 10){
            fail("La collection ne contient pas le nombre de passage (ajouterPassage).");
        }

        Passage res = collecPass.getPassage(10);
        if (res.activePiege()){
            fail("Le passage n'active aucun piège.");
        }
        if (res.activeTrappe() != -1){
            fail("Le numéro de salle à activer (-1) n'est pas le bon : " + res.activeTrappe());
        }
        if (!res.premiereSalle().toString().equals("Numéro : 54 | Trésor : false | Trappe : false")){
            fail("La collection de passage ne retourne pas le bon passage.");
        }
        if (!res.secondeSalle().toString().equals("Numéro : 5552 | Trésor : false | Trappe : false")){
            fail("La collection de passage ne retourne pas le bon passage.");
        }
    }

    @Test
    void getPassage() {
        Passage res ;

        res = collecPass.getPassage(1);
        if (res.activePiege()){
            fail("Le passage n'active aucun piège.");
        }
        if (res.activeTrappe() != -1){
            fail("Le numéro de salle à activer (-1) n'est pas le bon : " + res.activeTrappe());
        }
        if (!res.premiereSalle().toString().equals("Numéro : 1 | Trésor : false | Trappe : false")){
            fail("La collection de passage ne retourne pas le bon passage.");
        }
        if (!res.secondeSalle().toString().equals("Numéro : 2 | Trésor : false | Trappe : false")){
            fail("La collection de passage ne retourne pas le bon passage.");
        }

        res = collecPass.getPassage(2);
        if (res.activePiege()){
            fail("Le passage n'active aucun piège.");
        }
        if (res.activeTrappe() != -1){
            fail("Le numéro de salle à activer (-1) n'est pas le bon : " + res.activeTrappe());
        }
        if (!res.premiereSalle().toString().equals("Numéro : 1 | Trésor : false | Trappe : false")){
            fail("La collection de passage ne retourne pas le bon passage.");
        }
        if (!res.secondeSalle().toString().equals("Numéro : 4 | Trésor : false | Trappe : false")){
            fail("La collection de passage ne retourne pas le bon passage.");
        }

        res = collecPass.getPassage(3);
        if (res.activePiege()){
            fail("Le passage n'active aucun piège.");
        }
        if (res.activeTrappe() != -1){
            fail("Le numéro de salle à activer (-1) n'est pas le bon : " + res.activeTrappe());
        }
        if (!res.premiereSalle().toString().equals("Numéro : 2 | Trésor : false | Trappe : false")){
            fail("La collection de passage ne retourne pas le bon passage.");
        }
        if (!res.secondeSalle().toString().equals("Numéro : 3 | Trésor : false | Trappe : true")){
            fail("La collection de passage ne retourne pas le bon passage.");
        }

        res = collecPass.getPassage(4);
        if (res.activePiege()){
            fail("Le passage n'active aucun piège.");
        }
        if (res.activeTrappe() != -1){
            fail("Le numéro de salle à activer (-1) n'est pas le bon : " + res.activeTrappe());
        }
        if (!res.premiereSalle().toString().equals("Numéro : 3 | Trésor : false | Trappe : true")){
            fail("La collection de passage ne retourne pas le bon passage.");
        }
        if (!res.secondeSalle().toString().equals("Numéro : 6 | Trésor : false | Trappe : false")){
            fail("La collection de passage ne retourne pas le bon passage.");
        }

        res = collecPass.getPassage(5);
        if (res.activePiege()){
            fail("Le passage n'active aucun piège.");
        }
        if (res.activeTrappe() != -1){
            fail("Le numéro de salle à activer (-1) n'est pas le bon : " + res.activeTrappe());
        }
        if (!res.premiereSalle().toString().equals("Numéro : 4 | Trésor : false | Trappe : false")){
            fail("La collection de passage ne retourne pas le bon passage.");
        }
        if (!res.secondeSalle().toString().equals("Numéro : 7 | Trésor : false | Trappe : true")){
            fail("La collection de passage ne retourne pas le bon passage.");
        }

        res = collecPass.getPassage(6);
        if (res.activePiege()){
            fail("Le passage n'active aucun piège.");
        }
        if (res.activeTrappe() != -1){
            fail("Le numéro de salle à activer (-1) n'est pas le bon : " + res.activeTrappe());
        }
        if (!res.premiereSalle().toString().equals("Numéro : 4 | Trésor : false | Trappe : false")){
            fail("La collection de passage ne retourne pas le bon passage.");
        }
        if (!res.secondeSalle().toString().equals("Numéro : 5 | Trésor : false | Trappe : true")){
            fail("La collection de passage ne retourne pas le bon passage.");
        }

        res = collecPass.getPassage(7);
        if (res.activePiege()){
            fail("Le passage n'active aucun piège.");
        }
        if (res.activeTrappe() != -1){
            fail("Le numéro de salle à activer (-1) n'est pas le bon : " + res.activeTrappe());
        }
        if (!res.premiereSalle().toString().equals("Numéro : 5 | Trésor : false | Trappe : true")){
            fail("La collection de passage ne retourne pas le bon passage.");
        }
        if (!res.secondeSalle().toString().equals("Numéro : 8 | Trésor : false | Trappe : false")){
            fail("La collection de passage ne retourne pas le bon passage.");
        }

        res = collecPass.getPassage(8);
        if (res.activePiege()){
            fail("Le passage n'active aucun piège.");
        }
        if (res.activeTrappe() != -1){
            fail("Le numéro de salle à activer (-1) n'est pas le bon : " + res.activeTrappe());
        }
        if (!res.premiereSalle().toString().equals("Numéro : 7 | Trésor : false | Trappe : true")){
            fail("La collection de passage ne retourne pas le bon passage.");
        }
        if (!res.secondeSalle().toString().equals("Numéro : 8 | Trésor : false | Trappe : false")){
            fail("La collection de passage ne retourne pas le bon passage.");
        }

        res = collecPass.getPassage(9);
        if (res.activePiege()){
            fail("Le passage n'active aucun piège.");
        }
        if (res.activeTrappe() != -1){
            fail("Le numéro de salle à activer (-1) n'est pas le bon : " + res.activeTrappe());
        }
        if (!res.premiereSalle().toString().equals("Numéro : 8 | Trésor : false | Trappe : false")){
            fail("La collection de passage ne retourne pas le bon passage.");
        }
        if (!res.secondeSalle().toString().equals("Numéro : 9 | Trésor : true | Trappe : false")){
            fail("La collection de passage ne retourne pas le bon passage.");
        }
    }
}