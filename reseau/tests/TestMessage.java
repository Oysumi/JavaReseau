package reseau.tests;

import reseau.Message;

public class TestMessage
{
	public static void main(String[] args)
    {
    	testToString() ;
    }

    public static void testToString()
    {
    	Message m ;
    	boolean b ;

    	// message vide
    	m = new Message() ;
    	b = ( m.toString().isEmpty() ) ;
    	assert b : "Mauvaise représentation toString (message vide)" ;

    	// message de petits entiers
    	short i = 245 ;
    	short j = 15 ;
    	short k = 78 ;

    	m = new Message(i, j, k) ;
    	b = ( m.toString().equals("245.15.78")) ;
    	assert b : "Mauvaise représentation toString" ;

    	// message de grands entiers
    	m = new Message(245, 894, 0, 7047, 7) ;
    	b = ( m.toString().equals("0.245.3.126.0.0.27.135.0.7")) ;
    	assert b : "Mauvaise représentation toString" ;
    }
}
