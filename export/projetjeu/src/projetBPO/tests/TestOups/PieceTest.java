package projetBPO.tests.TestOups;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projetBPO.jeux.oups.Passage;
import projetBPO.jeux.oups.Piece;

import static org.junit.jupiter.api.Assertions.*;

class PieceTest {

    private Piece salleUn ;
    private Piece salleDeux ;
    private Piece salleTrois ;
    private Piece salleQuatre ;
    private Piece salleCinq ;
    private Piece salleSix ;

    @BeforeEach
    void setUp(){
        salleUn = new Piece(false, true,1);
        salleDeux = new Piece(false, true,2);
        salleTrois = new Piece(true, false,3);
        salleQuatre = new Piece(true, true,4);
        salleCinq = new Piece(false, false,5);
        salleSix = new Piece(6);

        /*

                ______ ______ ______
               |      |      |      |
               |  P1     P2     T3  |       T = TRÉSOR
               |__  __|__  __|______|       P = PIEGE
               |      |      |      |
               | PT4  |   5      6  |
               |______|______|______|

         */

        Passage passageUn = new Passage(salleUn, salleDeux);
        Passage passageDeux = new Passage(salleUn, salleQuatre);
        Passage passageTrois = new Passage(salleDeux, salleTrois);
        Passage passageQuatre = new Passage(salleDeux, salleCinq);
        Passage passageCinq = new Passage(salleCinq, salleSix);

        salleUn.ajouterPassage(passageUn);
        salleUn.ajouterPassage(passageDeux);
        salleDeux.ajouterPassage(passageUn);
        salleDeux.ajouterPassage(passageTrois);
        salleDeux.ajouterPassage(passageQuatre);
        salleTrois.ajouterPassage(passageTrois);
        salleQuatre.ajouterPassage(passageDeux);
        salleCinq.ajouterPassage(passageQuatre);
        salleCinq.ajouterPassage(passageCinq);
        salleSix.ajouterPassage(passageCinq);
    }

    @Test
    void getNumero() {
        if (salleUn.getNumero() != 1){
            fail("La salle ne porte pas le bon numéro : " + salleUn.getNumero());
        }
        if (salleDeux.getNumero() != 2){
            fail("La salle ne porte pas le bon numéro : " + salleDeux.getNumero());
        }
        if (salleTrois.getNumero() != 3){
            fail("La salle ne porte pas le bon numéro : " + salleTrois.getNumero());
        }
        if (salleQuatre.getNumero() != 4){
            fail("La salle ne porte pas le bon numéro : " + salleQuatre.getNumero());
        }
        if (salleCinq.getNumero() != 5){
            fail("La salle ne porte pas le bon numéro : " + salleCinq.getNumero());
        }
        if (salleSix.getNumero() != 6){
            fail("La salle ne porte pas le bon numéro : " + salleSix.getNumero());
        }
    }

    @Test
    void trappeOuverte() {
        if (!salleUn.trappeOuverte()){
            fail("La trappe de cette salle devrait être ouverte.");
        }
        if (!salleDeux.trappeOuverte()){
            fail("La trappe de cette salle devrait être ouverte.");
        }
        if (salleTrois.trappeOuverte()){
            fail("La trappe de cette salle devrait être fermée.");
        }
        if (!salleQuatre.trappeOuverte()){
            fail("La trappe de cette salle devrait être ouverte.");
        }
        if (salleCinq.trappeOuverte()){
            fail("La trappe de cette salle devrait être fermée.");
        }
        if (salleSix.trappeOuverte()){
            fail("La trappe de cette salle devrait être fermée.");
        }
    }

    @Test
    void estUnTresor() {
        if (salleUn.estUnTresor()){
            fail("Cette salle ne doit pas contenir de trésor.");
        }
        if (salleDeux.estUnTresor()){
            fail("Cette salle ne doit pas contenir de trésor.");
        }
        if (!salleTrois.estUnTresor()){
            fail("Cette salle doit contenir un trésor.");
        }
        if (!salleQuatre.estUnTresor()){
            fail("Cette salle doit contenir un trésor.");
        }
        if (salleCinq.estUnTresor()){
            fail("Cette salle ne doit pas contenir de trésor.");
        }
        if (salleSix.estUnTresor()){
            fail("Cette salle ne doit pas contenir de trésor.");
        }
    }

    @Test
    void changeTrappeUneFois() {
        /* On suppose que les tests effectués sur TrappeOuverte se sont bien passés */
        salleUn.changeTrappe();
        salleDeux.changeTrappe();
        salleTrois.changeTrappe();
        salleQuatre.changeTrappe();
        salleCinq.changeTrappe();
        salleSix.changeTrappe();
        if (salleUn.trappeOuverte()){
            fail("La trappe de cette salle devrait être maintenant fermée.");
        }
        if (salleDeux.trappeOuverte()){
            fail("La trappe de cette salle devrait être maintenant fermée.");
        }
        if (!salleTrois.trappeOuverte()){
            fail("La trappe de cette salle devrait être mainteant ouverte.");
        }
        if (salleQuatre.trappeOuverte()){
            fail("La trappe de cette salle devrait être maintenat fermée.");
        }
        if (!salleCinq.trappeOuverte()){
            fail("La trappe de cette salle devrait être maintenant ouverte.");
        }
        if (!salleSix.trappeOuverte()){
            fail("La trappe de cette salle devrait être maintenant ouverte.");
        }
    }

    @Test
    void changeTrappeDeuxFois() {
        /* On suppose que les tests effectués sur TrappeOuverte se sont bien passés */
        salleUn.changeTrappe();
        salleUn.changeTrappe();

        salleDeux.changeTrappe();
        salleDeux.changeTrappe();

        salleTrois.changeTrappe();
        salleTrois.changeTrappe();

        salleQuatre.changeTrappe();
        salleQuatre.changeTrappe();

        salleCinq.changeTrappe();
        salleCinq.changeTrappe();

        salleSix.changeTrappe();
        salleSix.changeTrappe();

        if (!salleUn.trappeOuverte()){
            fail("La trappe de cette salle devrait être maintenant ouverte.");
        }
        if (!salleDeux.trappeOuverte()){
            fail("La trappe de cette salle devrait être maintenant ouverte.");
        }
        if (salleTrois.trappeOuverte()){
            fail("La trappe de cette salle devrait être mainteant fermée.");
        }
        if (!salleQuatre.trappeOuverte()){
            fail("La trappe de cette salle devrait être maintenat ouverte.");
        }
        if (salleCinq.trappeOuverte()){
            fail("La trappe de cette salle devrait être maintenant fermée.");
        }
        if (salleSix.trappeOuverte()){
            fail("La trappe de cette alle devrait être maintenant fermée.");
        }
    }

    @Test
    void ajouteTresor()
    {
        salleUn.ajouteTresor();
        salleDeux.ajouteTresor();
        salleTrois.ajouteTresor();
        salleQuatre.ajouteTresor();
        salleCinq.ajouteTresor();
        salleSix.ajouteTresor();

        if (!salleUn.estUnTresor()){
            fail("Cette salle devrait maintenant contenir un trésor.");
        }
        if (!salleDeux.estUnTresor()){
            fail("Cette salle devrait maintenant contenir un trésor.");
        }
        if (!salleTrois.estUnTresor()){
            fail("Cette salle devrait maintenant contenir un trésor.");
        }
        if (!salleQuatre.estUnTresor()){
            fail("Cette salle devrait maintenant contenir un trésor.");
        }
        if (!salleCinq.estUnTresor()){
            fail("Cette salle devrait maintenant contenir un trésor.");
        }
        if (!salleSix.estUnTresor()){
            fail("Cette salle devrait maintenant contenir un trésor.");
        }
    }

    @Test
    void toStringTestInstanciation(){
        if (!salleUn.toString().equals("Numéro : 1 | Trésor : false | Trappe : true")){
            fail("La description de la salle n'est pas bonne.");
        }
        if (!salleDeux.toString().equals("Numéro : 2 | Trésor : false | Trappe : true")){
            fail("La description de la salle n'est pas bonne.");
        }
        if (!salleTrois.toString().equals("Numéro : 3 | Trésor : true | Trappe : false")){
            fail("La description de la salle n'est pas bonne.");
        }
        if (!salleQuatre.toString().equals("Numéro : 4 | Trésor : true | Trappe : true")){
            fail("La description de la salle n'est pas bonne.");
        }
        if (!salleCinq.toString().equals("Numéro : 5 | Trésor : false | Trappe : false")){
            fail("La description de la salle n'est pas bonne.");
        }
        if (!salleSix.toString().equals("Numéro : 6 | Trésor : false | Trappe : false")){
            fail("La description de la salle n'est pas bonne.");
        }
    }

    @Test
    void toStringTestChangeTresor(){

        salleUn.ajouteTresor();
        salleDeux.ajouteTresor();
        salleTrois.ajouteTresor();
        salleQuatre.ajouteTresor();
        salleCinq.ajouteTresor();
        salleSix.ajouteTresor();

        if (!salleUn.toString().equals("Numéro : 1 | Trésor : true | Trappe : true")){
            fail("La description de la salle n'est pas bonne.");
        }
        if (!salleDeux.toString().equals("Numéro : 2 | Trésor : true | Trappe : true")){
            fail("La description de la salle n'est pas bonne.");
        }
        if (!salleTrois.toString().equals("Numéro : 3 | Trésor : true | Trappe : false")){
            fail("La description de la salle n'est pas bonne.");
        }
        if (!salleQuatre.toString().equals("Numéro : 4 | Trésor : true | Trappe : true")){
            fail("La description de la salle n'est pas bonne.");
        }
        if (!salleCinq.toString().equals("Numéro : 5 | Trésor : true | Trappe : false")){
            fail("La description de la salle n'est pas bonne.");
        }
        if (!salleSix.toString().equals("Numéro : 6 | Trésor : true | Trappe : false")){
            fail("La description de la salle n'est pas bonne.");
        }
    }

    @Test
    void toStringTestChangeTrappe(){

        salleUn.changeTrappe();
        salleDeux.changeTrappe();
        salleTrois.changeTrappe();
        salleQuatre.changeTrappe();
        salleCinq.changeTrappe();
        salleSix.changeTrappe();

        if (!salleUn.toString().equals("Numéro : 1 | Trésor : false | Trappe : false")){
            fail("La description de la salle n'est pas bonne.");
        }
        if (!salleDeux.toString().equals("Numéro : 2 | Trésor : false | Trappe : false")){
            fail("La description de la salle n'est pas bonne.");
        }
        if (!salleTrois.toString().equals("Numéro : 3 | Trésor : true | Trappe : true")){
            fail("La description de la salle n'est pas bonne.");
        }
        if (!salleQuatre.toString().equals("Numéro : 4 | Trésor : true | Trappe : false")){
            fail("La description de la salle n'est pas bonne.");
        }
        if (!salleCinq.toString().equals("Numéro : 5 | Trésor : false | Trappe : true")){
            fail("La description de la salle n'est pas bonne.");
        }
        if (!salleSix.toString().equals("Numéro : 6 | Trésor : false | Trappe : true")){
            fail("La description de la salle n'est pas bonne.");
        }
    }

    @Test
    void toStringTestChangeTout(){

        salleUn.changeTrappe();
        salleUn.ajouteTresor();
        salleDeux.changeTrappe();
        salleDeux.ajouteTresor();
        salleTrois.changeTrappe();
        salleTrois.ajouteTresor();
        salleQuatre.changeTrappe();
        salleQuatre.ajouteTresor();
        salleCinq.changeTrappe();
        salleCinq.ajouteTresor();
        salleSix.changeTrappe();
        salleSix.ajouteTresor();

        if (!salleUn.toString().equals("Numéro : 1 | Trésor : true | Trappe : false")){
            fail("La description de la salle n'est pas bonne.");
        }
        if (!salleDeux.toString().equals("Numéro : 2 | Trésor : true | Trappe : false")){
            fail("La description de la salle n'est pas bonne.");
        }
        if (!salleTrois.toString().equals("Numéro : 3 | Trésor : true | Trappe : true")){
            fail("La description de la salle n'est pas bonne.");
        }
        if (!salleQuatre.toString().equals("Numéro : 4 | Trésor : true | Trappe : false")){
            fail("La description de la salle n'est pas bonne.");
        }
        if (!salleCinq.toString().equals("Numéro : 5 | Trésor : true | Trappe : true")){
            fail("La description de la salle n'est pas bonne.");
        }
        if (!salleSix.toString().equals("Numéro : 6 | Trésor : true | Trappe : true")){
            fail("La description de la salle n'est pas bonne.");
        }
    }

    @Test
    void passagesTest(){
        if (salleUn.nbPassages() != 2){
            fail("La salle n'a pas le bon nombre de passages.");
        }
        if (salleDeux.nbPassages() != 3){
            fail("La salle n'a pas le bon nombre de passages.");
        }
        if (salleTrois.nbPassages() != 1){
            fail("La salle n'a pas le bon nombre de passages.");
        }
        if (salleQuatre.nbPassages() != 1){
            fail("La salle n'a pas le bon nombre de passages.");
        }
        if (salleCinq.nbPassages() != 2){
            fail("La salle n'a pas le bon nombre de passages.");
        }
        if (salleSix.nbPassages() != 1){
            fail("La salle n'a pas le bon nombre de passages.");
        }

        /*********************************************************************/

        if (salleUn.getPassage(1).activePiege()){
            fail("Le passage ne devrait activer aucun piège.");
        }
        if (salleUn.getPassage(2).activePiege()) {
            fail("Le passage ne devrait activer aucun piège.");
        }
        if (salleDeux.getPassage(1).activePiege()) {
            fail("Le passage ne devrait activer aucun piège.");
        }
        if (salleDeux.getPassage(2).activePiege()) {
            fail("Le passage ne devrait activer aucun piège.");
        }
        if (salleDeux.getPassage(3).activePiege()) {
            fail("Le passage ne devrait activer aucun piège.");
        }
        if (salleTrois.getPassage(1).activePiege()) {
            fail("Le passage ne devrait activer aucun piège.");
        }
        if (salleQuatre.getPassage(1).activePiege()) {
            fail("Le passage ne devrait activer aucun piège.");
        }
        if (salleCinq.getPassage(1).activePiege()) {
            fail("Le passage ne devrait activer aucun piège.");
        }
        if (salleCinq.getPassage(2).activePiege()) {
            fail("Le passage ne devrait activer aucun piège.");
        }
        if (salleSix.getPassage(1).activePiege()) {
            fail("Le passage ne devrait activer aucun piège.");
        }

        /*********************************************************************/

        if (salleUn.getPassage(1).activeTrappe() != -1){
            fail("Le passage ne devrait activer aucun piège.");
        }
        if (salleUn.getPassage(2).activeTrappe() != -1) {
            fail("Le passage ne devrait activer aucun piège.");
        }
        if (salleDeux.getPassage(1).activeTrappe() != -1) {
            fail("Le passage ne devrait activer aucun piège.");
        }
        if (salleDeux.getPassage(2).activeTrappe() != -1) {
            fail("Le passage ne devrait activer aucun piège.");
        }
        if (salleDeux.getPassage(3).activeTrappe() != -1) {
            fail("Le passage ne devrait activer aucun piège.");
        }
        if (salleTrois.getPassage(1).activeTrappe() != -1) {
            fail("Le passage ne devrait activer aucun piège.");
        }
        if (salleQuatre.getPassage(1).activeTrappe() != -1) {
            fail("Le passage ne devrait activer aucun piège.");
        }
        if (salleCinq.getPassage(1).activeTrappe() != -1) {
            fail("Le passage ne devrait activer aucun piège.");
        }
        if (salleCinq.getPassage(2).activeTrappe() != -1) {
            fail("Le passage ne devrait activer aucun piège.");
        }
        if (salleSix.getPassage(1).activeTrappe() != -1) {
            fail("Le passage ne devrait activer aucun piège.");
        }

        /*********************************************************************/

        if (!salleUn.getPassage(1).premiereSalle().toString().equals("Numéro : 1 | Trésor : false | Trappe : true")){
            fail("La salle ne contient pas le bon passage.");
        }
        if (!salleUn.getPassage(1).secondeSalle().toString().equals("Numéro : 2 | Trésor : false | Trappe : true")){
            fail("La salle ne contient pas le bon passage.");
        }
        if (!salleUn.getPassage(2).premiereSalle().toString().equals("Numéro : 1 | Trésor : false | Trappe : true")){
            fail("La salle ne contient pas le bon passage.");
        }
        if (!salleUn.getPassage(2).secondeSalle().toString().equals("Numéro : 4 | Trésor : true | Trappe : true")){
            fail("La salle ne contient pas le bon passage.");
        }

        if (!salleDeux.getPassage(1).premiereSalle().toString().equals("Numéro : 1 | Trésor : false | Trappe : true")){
            fail("La salle ne contient pas le bon passage.");
        }
        if (!salleDeux.getPassage(1).secondeSalle().toString().equals("Numéro : 2 | Trésor : false | Trappe : true")){
            fail("La salle ne contient pas le bon passage.");
        }
        if (!salleDeux.getPassage(2).premiereSalle().toString().equals("Numéro : 2 | Trésor : false | Trappe : true")){
            fail("La salle ne contient pas le bon passage.");
        }
        if (!salleDeux.getPassage(2).secondeSalle().toString().equals("Numéro : 3 | Trésor : true | Trappe : false")){
            fail("La salle ne contient pas le bon passage.");
        }
        if (!salleDeux.getPassage(3).premiereSalle().toString().equals("Numéro : 2 | Trésor : false | Trappe : true")){
            fail("La salle ne contient pas le bon passage.");
        }
        if (!salleDeux.getPassage(3).secondeSalle().toString().equals("Numéro : 5 | Trésor : false | Trappe : false")){
            fail("La salle ne contient pas le bon passage.");
        }

        if (!salleTrois.getPassage(1).premiereSalle().toString().equals("Numéro : 2 | Trésor : false | Trappe : true")){
            fail("La salle ne contient pas le bon passage.");
        }
        if (!salleTrois.getPassage(1).secondeSalle().toString().equals("Numéro : 3 | Trésor : true | Trappe : false")){
            fail("La salle ne contient pas le bon passage.");
        }

        if (!salleQuatre.getPassage(1).premiereSalle().toString().equals("Numéro : 1 | Trésor : false | Trappe : true")){
            fail("La salle ne contient pas le bon passage.");
        }
        if (!salleQuatre.getPassage(1).secondeSalle().toString().equals("Numéro : 4 | Trésor : true | Trappe : true")){
            fail("La salle ne contient pas le bon passage.");
        }

        if (!salleCinq.getPassage(1).premiereSalle().toString().equals("Numéro : 2 | Trésor : false | Trappe : true")){
            fail("La salle ne contient pas le bon passage.");
        }
        if (!salleCinq.getPassage(1).secondeSalle().toString().equals("Numéro : 5 | Trésor : false | Trappe : false")){
            fail("La salle ne contient pas le bon passage.");
        }
        if (!salleCinq.getPassage(2).premiereSalle().toString().equals("Numéro : 5 | Trésor : false | Trappe : false")){
            fail("La salle ne contient pas le bon passage.");
        }
        if (!salleCinq.getPassage(2).secondeSalle().toString().equals("Numéro : 6 | Trésor : false | Trappe : false")){
            fail("La salle ne contient pas le bon passage.");
        }

        if (!salleSix.getPassage(1).premiereSalle().toString().equals("Numéro : 5 | Trésor : false | Trappe : false")){
            fail("La salle ne contient pas le bon passage.");
        }
        if (!salleSix.getPassage(1).secondeSalle().toString().equals("Numéro : 6 | Trésor : false | Trappe : false")){
            fail("La salle ne contient pas le bon passage.");
        }
    }
}