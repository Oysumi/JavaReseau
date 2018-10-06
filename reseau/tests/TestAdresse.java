package reseau.tests;

import reseau.adresses.Adresse;
import reseau.adresses.Octet;

public class TestAdresse
{
  public static void main(String[] args)
  {
      testToString() ;
      testGetNbreOctetsAdresse() ;
      testSize() ;
      testSetOctet() ;
      testSetOctets() ;
      testConstructeurCopie() ;
      testGetOctet() ;
      testInverser() ;
  }

  private static void testToString()
  {
      Adresse a ;
      int res ;

      // adresse vide
      a = new Adresse(16) ;
      res = a.getNbreOctets() ;
      assert(a.toString().equals("0.0")):"Mauvaise représentation toString" ;

      // adresse définie
      a = new Adresse("192.45.43.100"); // tests effectués pour des adresses avec entiers < 0 et > 255 + nbre d'octets incorrect
      assert(a.toString().equals("192.45.43.100")):"Mauvaise représentation toString" ;
       
      // adresse définie par des uns au début
      a = new Adresse(32, 10) ;
      assert(a.toString().equals("255.192.0.0")):"Mauvaise représentation toString" ;

      // adresse définie par un nombre variable d'octets en paramètre
      a = new Adresse(new Octet(255), new Octet(45), new Octet(100), new Octet(192)) ;
      assert(a.toString().equals("255.45.100.192")):"Mauvaise représentation toString" ;
  }

  private static void testGetNbreOctetsAdresse()
  {
      Adresse a ;
      int res ;

      // adresse vide
      a = new Adresse(16) ;
      res = a.getNbreOctets() ;
      assert(res==2):"Nombre d'octets incorrect" ;

      // adresse définie
      a = new Adresse("192.45.43.100.241.36");
      res = a.getNbreOctets() ;
      assert(res==6):"Nombre d'octets incorrect" ;
       
      // adresse définie par des uns au début
      a = new Adresse(32, 10) ;
      res = a.getNbreOctets() ;
      assert(res==4):"Nombre d'octets incorrect" ;

      // adresse définie par un nombre variable d'octets en paramètre
      a = new Adresse(new Octet(255), new Octet(45), new Octet(100)) ;
      res = a.getNbreOctets() ;
      assert(res==3):"Nombre d'octets incorrect" ;
   }

   private static void testSize()
   {
      Adresse a ;
      int res ;

      // adresse vide
      a = new Adresse(16) ;
      res = a.size() ;
      assert(res==16):"Nombre de bits incorrect" ;

      // adresse définie
      a = new Adresse("192.45.43.100");
      res = a.size() ;
      assert(res==32):"Nombre de bits incorrect" ;
       
      // adresse définie par des uns au début
      a = new Adresse(32, 10) ;
      res = a.size() ;
      assert(res==32):"Nombre de bits incorrect" ;

      // adresse définie par un nombre variable d'octets en paramètre
      a = new Adresse(new Octet(255), new Octet(45), new Octet(100), new Octet(192)) ;
      res = a.size() ;
      assert(res==32):"Nombre de bits incorrect" ;
   }

   private static void testSetOctet()
   {
      Adresse a ;
      Octet o ;

      // adresse vide
      a = new Adresse(16) ;
      o = new Octet(255) ;
      a.setOctet(o, 1) ;
      assert(a.toString().equals("0.255")):"Mauvais placement de l'octet" ;

      // adresse définie
      a = new Adresse("192.45.43.100"); 
      o = new Octet(22) ;
      a.setOctet(o,0) ;
      assert(a.toString().equals("22.45.43.100")) ;

      // adresse définie par des uns au début
      a = new Adresse(32, 10) ;
      o = new Octet(0) ;
      a.setOctet(o,1) ;
      assert(a.toString().equals("255.0.0.0")):"Mauvais placement de l'octet" ;

      // adresse définie par un nombre variable d'octets en paramètre
      a = new Adresse(new Octet(255), new Octet(45), new Octet(100), new Octet(192)) ;
      o = new Octet(89) ;
      a.setOctet(o,2) ;
      assert(a.toString().equals("255.45.89.192")):"Mauvais placement de l'octet" ;
   }

   private static void testSetOctets()
   {
      Adresse a ;
      Octet o ;

      // adresse vide
      a = new Adresse(16) ;
      a.setOctets(new Octet(22), new Octet(245)) ;
      assert(a.toString().equals("22.245")):"Mauvais placement de l'octet" ;

      // adresse définie
      a = new Adresse("192.45.43.100"); 
      a.setOctets(new Octet(24), new Octet(89)) ;
      assert(a.toString().equals("24.89.43.100")) ;

      // adresse définie par des uns au début
      a = new Adresse(32, 10) ;
      a.setOctets(new Octet(147), new Octet(74), new Octet(56)) ;
      assert(a.toString().equals("147.74.56.0")):"Mauvais placement de l'octet" ;

      // adresse définie par un nombre variable d'octets en paramètre
      a = new Adresse(new Octet(255), new Octet(45), new Octet(100), new Octet(192)) ;
      a.setOctets(new Octet(0), new Octet(24), new Octet(78), new Octet(189)) ;
      assert(a.toString().equals("0.24.78.189")):"Mauvais placement de l'octet" ;
   }

   private static void testConstructeurCopie()
   {
      Adresse a ;
      Adresse aBis ;
      boolean b ;

      // adresse vide
      a = new Adresse(64) ;
      aBis = new Adresse(a) ;
      b = ( a.toString().equals(aBis.toString()) ) ; // On vérifie bien que les deux objets contiennent la même adresse
      assert b : "Erreur dans la copie d'adresse" ;
      a.setOctet(new Octet(22), 0) ;
      b = ( a.toString().equals(aBis.toString()) ) ; // On vérifie que les changements effectués sur a ne se sont pas faits sur aBis
      assert !b : "Le constructeur de copie effectue une copie superficielle" ;

      // adresse définie
      a = new Adresse("192.45.43.100");
      aBis = new Adresse(a) ;
      b = ( a.toString().equals(aBis.toString()) ) ; // On vérifie bien que les deux objets contiennent la même adresse
      assert b : "Erreur dans la copie d'adresse" ;
      a.setOctets(new Octet(24), new Octet(45)) ;
      b = ( a.toString().equals(aBis.toString()) ) ; // On vérifie que les changements effectués sur a ne se sont pas faits sur aBis
      assert !b : "Le constructeur de copie effectue une copie superficielle" ;

      // adresse définie par des uns au début
      a = new Adresse(32, 10) ;
      aBis = new Adresse(a) ;
      b = ( a.toString().equals(aBis.toString()) ) ; // On vérifie bien que les deux objets contiennent la même adresse
      assert b : "Erreur dans la copie d'adresse" ;
      a.setOctets(new Octet(24), new Octet(45), new Octet(12)) ;
      b = ( a.toString().equals(aBis.toString()) ) ; // On vérifie que les changements effectués sur a ne se sont pas faits sur aBis
      assert !b : "Le constructeur de copie effectue une copie superficielle" ;

      // adresse définie par un nombre variable d'octets en paramètre
      a = new Adresse(new Octet(255), new Octet(45), new Octet(100), new Octet(192)) ;
      aBis = new Adresse(a) ;
      b = ( a.toString().equals(aBis.toString()) ) ; // On vérifie bien que les deux objets contiennent la même adresse
      assert b : "Erreur dans la copie d'adresse" ;
      a.setOctet(new Octet(74), 3) ;
      b = ( a.toString().equals(aBis.toString()) ) ; // On vérifie que les changements effectués sur a ne se sont pas faits sur aBis
      assert !b : "Le constructeur de copie effectue une copie superficielle" ;
   }

   private static void testGetOctet()
   {
      Adresse a ;
      boolean b ;

      // adresse vide
      a = new Adresse(16) ;
      b = ( a.getOctet(0).getValue() == 0 ) ;
      assert b :"Mauvais octet récupéré" ;

      // adresse définie
      a = new Adresse("192.52.74.51.241.65") ; 
      b = ( a.getOctet(4).getValue() == 241 ) ;
      assert b :"Mauvais octet récupéré" ;

      // adresse définie par des uns au début
      a = new Adresse(32, 10) ;
      b = ( a.getOctet(1).getValue() == 192 ) ;
      assert b :"Mauvais octet récupéré" ;

      // adresse définie par un nombre variable d'octets en paramètre
      a = new Adresse(new Octet(255), new Octet(45), new Octet(100), new Octet(192)) ;
      b = ( a.getOctet(2).getValue() == 100 ) ;
      assert b :"Mauvais octet récupéré" ;
   }

   private static void testInverser()
   {
      Adresse a ;
      boolean b ;

      // adresse vide
      a = new Adresse(16) ;
      a.inverser() ;
      b = a.toString().equals("255.255") ;
      assert b:"Mauvais complément à 1" ;

      // adresse définie
      a = new Adresse("192.45.43.100"); // tests effectués pour des adresses avec entiers < 0 et > 255 + nbre d'octets incorrect
      a.inverser() ;
      b = a.toString().equals("63.210.212.155") ;
      assert b :"Mauvais complément à 1" ;
       
      // adresse définie par des uns au début
      a = new Adresse(32, 10) ;
      a.inverser() ;
      b = a.toString().equals("0.63.255.255") ;
      assert b :"Mauvais complément à 1" ;

      // adresse définie par un nombre variable d'octets en paramètre
      a = new Adresse(new Octet(255), new Octet(45), new Octet(100), new Octet(192)) ;
      a.inverser() ;
      b = a.toString().equals("0.210.155.63") ;
      assert b :"Mauvais complément à 1" ; 
   }
} 



