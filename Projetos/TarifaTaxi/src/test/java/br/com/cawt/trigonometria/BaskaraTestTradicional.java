package br.com.cawt.trigonometria;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Testes de Baskara.
 * 
 * @author Cássio Trindade
 */


public class BaskaraTestTradicional {
	Baskara baskara;
	@Before
	public void setUpl() {
	 baskara = new Baskara(-1, 2, 2);

	}

	@Test
	public void testDuasRaizesDiferentes(){
		System.out.println(baskara.delta());
		assertTrue("Não Existem duas raizes diferentes", baskara.delta() > 0);
	}
	
	@Test
	public void testRaizesUm(){
		System.out.println(baskara.raizUm());
		assertTrue( baskara.raizUm() == -0.7320508075688772);
	}
	
	@Test
	public void testRaizesDois(){
		System.out.println(baskara.raizDois());
		assertEquals( baskara.raizDois(), -2.732050807568877, 0);
	}
	
}
