package br.com.targettrust.trigonomeria;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestBasckara {

	Basckara basckara;	
	
	@Before
	public void setUp() throws Exception {
		basckara = new Basckara(1,3,2);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testValidaDeltaExistente() {
		double delta = basckara.calculaDelta();
		assertTrue( delta >= 0);
	}

	@Test
	public void testRaizUm() throws Exception {
		double raizUm = basckara.calculaRaizUm();
		assertTrue( raizUm == -1);
	}

	@Test
	public void testRaizDois() throws Exception {
		double raizDois = basckara.calculaRaizDois();
		assertTrue( raizDois == -2);
	}

	
	
}
