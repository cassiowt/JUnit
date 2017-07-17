package br.com.targettrust.trigonomeria;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;



@RunWith(Parameterized.class)
public class TestCalculaBasckaraParameterized {

	Basckara basckara;

    @Parameters(name="Teste nro {index}: Calculando a={0} b={1} c= {2}")
    public static Collection<?> getCasosTeste() {
	return Arrays.asList(new Object[][] { 
		{ 1, 3, 2, -1, -2}, 
		{ 2, 9, 3, -0.36254139118231254, -4.1374586088176875} }); 
    }

    // @Parameter
    public double valorA;

    // @Parameter(1)
    public double valorB;

    // @Parameter(2)
    public double valorC;

    // @Parameter(3)
    public double resultadoRaizUm;
  
    // @Parameter(4)
    public double resultadoRaizDois;

    public TestCalculaBasckaraParameterized(double valorA, double valorB, double valorC, double raizUm,
			double raizDois) {
		super();
		this.valorA = valorA;
		this.valorB = valorB;
		this.valorC = valorC;
		this.resultadoRaizUm = raizUm;
		this.resultadoRaizDois = raizDois;
	}

    @Before
    public void setUp() {
    	basckara = new Basckara(this.valorA,this.valorB,this.valorC);
    }
    
    @Test
	public void testRaizUm() throws Exception {
		double raizUm = basckara.calculaRaizUm();
		assertEquals( raizUm , resultadoRaizUm, 0);
	}

	@Test
	public void testRaizDois() throws Exception {
		double raizDois = basckara.calculaRaizDois();
		assertEquals( raizDois , resultadoRaizDois, 0);
	}
}
