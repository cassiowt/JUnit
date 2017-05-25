package br.com.cawt.trigonometria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Testes de Baskara.
 * 
 * @author Cássio Trindade
 */

@RunWith(Parameterized.class)
public class BaskaraTest {
	Baskara baskara;
	
	
	@Parameters(name="Teste nro {index}: Calculando a={0} b={1} c={2} x1={3} x2={4}")
    public static Collection<?> getCasosTeste() {
	return Arrays.asList(new Object[][] { 
		{  3, 4, 1, -3.0, 9.0 }, 
		{ -1, 2, 2, -0.7320508075688772, -2.732050807568877 }, 
		{  0, 0, 0, 0, 0},
	  });
    }
	
	public int a, b, c;
	public double x1, x2;
	
	
	
	public BaskaraTest(int a, int b, int c, double x1, double x2) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
		this.x1 = x1;
		this.x2 = x2;
	}

	@Before
	public void setUpl() {
	 baskara = new Baskara(a,b,c);

	}

	@Test
	public void testDuasRaizesDiferentes(){
		System.out.println(baskara.delta());
		assertTrue("Não Existem duas raizes diferentes", baskara.delta() > 0);
	}
	
	@Test
	public void testRaizesUm(){
		System.out.println(baskara.raizUm());
		assertTrue( baskara.raizUm() == this.x1);
	}
	
	@Test
	public void testRaizesDois(){
		System.out.println(baskara.raizDois());
		assertEquals( baskara.raizDois(), this.x2, 1);
	}
	
}
