package projetBPO.tests.TestOups;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projetBPO.jeux.oups.CollectionPiece;
import projetBPO.jeux.oups.Piece;

import static org.junit.jupiter.api.Assertions.*;

class CollectionPieceTest {

    private CollectionPiece collec ;
    private CollectionPiece collecVide ;

    @BeforeEach
    void setUp(){
        Piece un = new Piece(1);
        Piece deux = new Piece(2);
        Piece trois = new Piece(false, true , 3);
        Piece quatre = new Piece(4);
        Piece cinq = new Piece(true, false, 5);
        Piece six = new Piece(true, true,6);
        Piece sept = new Piece(false, true, 7);
        Piece huit = new Piece(8);

        collec = new CollectionPiece(un, deux, trois, quatre, cinq, six, sept, huit);

        collecVide = new CollectionPiece(5); // Une collection de 5 pièces
    }

    @Test
    void instanciation() {
        if (collec.nbSalles() != 8){
            fail("La collection de pièces n'a pas le bon nombre de pièces : " + collec.nbSalles());
        }
        if (!collec.getPiece(1).toString().equals("Numéro : 1 | Trésor : false | Trappe : false")){
            fail("La collection de pièces ne contient pas les bonnes pièces.");
        }
        if (!collec.getPiece(2).toString().equals("Numéro : 2 | Trésor : false | Trappe : false")){
            fail("La collection de pièces ne contient pas les bonnes pièces.");
        }
        if (!collec.getPiece(3).toString().equals("Numéro : 3 | Trésor : false | Trappe : true")){
            fail("La collection de pièces ne contient pas les bonnes pièces.");
        }
        if (!collec.getPiece(4).toString().equals("Numéro : 4 | Trésor : false | Trappe : false")){
            fail("La collection de pièces ne contient pas les bonnes pièces.");
        }
        if (!collec.getPiece(5).toString().equals("Numéro : 5 | Trésor : true | Trappe : false")){
            fail("La collection de pièces ne contient pas les bonnes pièces.");
        }
        if (!collec.getPiece(6).toString().equals("Numéro : 6 | Trésor : true | Trappe : true")){
            fail("La collection de pièces ne contient pas les bonnes pièces.");
        }
        if (!collec.getPiece(7).toString().equals("Numéro : 7 | Trésor : false | Trappe : true")){
            fail("La collection de pièces ne contient pas les bonnes pièces.");
        }
        if (!collec.getPiece(8).toString().equals("Numéro : 8 | Trésor : false | Trappe : false")){
            fail("La collection de pièces ne contient pas les bonnes pièces.");
        }

        if (collecVide.nbSalles() != 5){
            fail("La collection de pièces n'a pas le bon nombre de pièces : " + collecVide.nbSalles());
        }
        if (!collecVide.getPiece(1).toString().equals("Numéro : 1 | Trésor : false | Trappe : false")){
            fail("La collection de pièces ne contient pas les bonnes pièces.");
        }
        if (!collecVide.getPiece(2).toString().equals("Numéro : 2 | Trésor : false | Trappe : false")){
            fail("La collection de pièces ne contient pas les bonnes pièces.");
        }
        if (!collecVide.getPiece(3).toString().equals("Numéro : 3 | Trésor : false | Trappe : false")){
            fail("La collection de pièces ne contient pas les bonnes pièces.");
        }
        if (!collecVide.getPiece(4).toString().equals("Numéro : 4 | Trésor : false | Trappe : false")){
            fail("La collection de pièces ne contient pas les bonnes pièces.");
        }
        if (!collecVide.getPiece(5).toString().equals("Numéro : 5 | Trésor : false | Trappe : false")){
            fail("La collection de pièces ne contient pas les bonnes pièces.");
        }
    }

    @Test
    void ouvrirFermer(){
        collec.ouvrirFermer(1);
        collec.ouvrirFermer(2);
        collec.ouvrirFermer(3);
        collec.ouvrirFermer(4);
        collec.ouvrirFermer(5);
        collec.ouvrirFermer(6);
        collec.ouvrirFermer(7);
        collec.ouvrirFermer(8);

        if (!collec.getPiece(1).toString().equals("Numéro : 1 | Trésor : false | Trappe : true")){
            fail("La collection de pièces ne contient pas les bonnes pièces.");
        }
        if (!collec.getPiece(2).toString().equals("Numéro : 2 | Trésor : false | Trappe : true")){
            fail("La collection de pièces ne contient pas les bonnes pièces.");
        }
        if (!collec.getPiece(3).toString().equals("Numéro : 3 | Trésor : false | Trappe : false")){
            fail("La collection de pièces ne contient pas les bonnes pièces.");
        }
        if (!collec.getPiece(4).toString().equals("Numéro : 4 | Trésor : false | Trappe : true")){
            fail("La collection de pièces ne contient pas les bonnes pièces.");
        }
        if (!collec.getPiece(5).toString().equals("Numéro : 5 | Trésor : true | Trappe : true")){
            fail("La collection de pièces ne contient pas les bonnes pièces.");
        }
        if (!collec.getPiece(6).toString().equals("Numéro : 6 | Trésor : true | Trappe : false")){
            fail("La collection de pièces ne contient pas les bonnes pièces.");
        }
        if (!collec.getPiece(7).toString().equals("Numéro : 7 | Trésor : false | Trappe : false")){
            fail("La collection de pièces ne contient pas les bonnes pièces.");
        }
        if (!collec.getPiece(8).toString().equals("Numéro : 8 | Trésor : false | Trappe : true")){
            fail("La collection de pièces ne contient pas les bonnes pièces.");
        }
    }

    @Test
    void ajouterTresor(){
        collec.ajouterTresor(1);
        collec.ajouterTresor(2);
        collec.ajouterTresor(3);
        collec.ajouterTresor(4);
        collec.ajouterTresor(5);
        collec.ajouterTresor(6);
        collec.ajouterTresor(7);
        collec.ajouterTresor(8);

        if (!collec.getPiece(1).toString().equals("Numéro : 1 | Trésor : true | Trappe : false")){
            fail("La collection de pièces ne contient pas les bonnes pièces.");
        }
        if (!collec.getPiece(2).toString().equals("Numéro : 2 | Trésor : true | Trappe : false")){
            fail("La collection de pièces ne contient pas les bonnes pièces.");
        }
        if (!collec.getPiece(3).toString().equals("Numéro : 3 | Trésor : true | Trappe : true")){
            fail("La collection de pièces ne contient pas les bonnes pièces.");
        }
        if (!collec.getPiece(4).toString().equals("Numéro : 4 | Trésor : true | Trappe : false")){
            fail("La collection de pièces ne contient pas les bonnes pièces.");
        }
        if (!collec.getPiece(5).toString().equals("Numéro : 5 | Trésor : true | Trappe : false")){
            fail("La collection de pièces ne contient pas les bonnes pièces.");
        }
        if (!collec.getPiece(6).toString().equals("Numéro : 6 | Trésor : true | Trappe : true")){
            fail("La collection de pièces ne contient pas les bonnes pièces.");
        }
        if (!collec.getPiece(7).toString().equals("Numéro : 7 | Trésor : true | Trappe : true")){
            fail("La collection de pièces ne contient pas les bonnes pièces.");
        }
        if (!collec.getPiece(8).toString().equals("Numéro : 8 | Trésor : true | Trappe : false")){
            fail("La collection de pièces ne contient pas les bonnes pièces.");
        }
    }
}