package com.targettrust.model;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe simples de teste para o Modelo Funcionario.
 * 
 * @author Gilberto Lupatini
 */
public class FuncionarioTest {

	Funcionario funcionario;

	/**
	 * Normalmente o m�todo que deve ser executado antes, chama-se setUp.
	 */
	@Before
	public void setUp() {
		funcionario = new Funcionario();
	}

	/**
	 * Normalmente o m�todo que deve ser executado antes, chama-se tearDown.
	 */
	@After
	public void tearDown() {
		System.out.println("Teste finalizado... Posso usar esse m�todo para liberar conex�es, recursos em geral.. :D ");
	}

	/**
	 * Testa o c�lculo de sal�rio composto pelas horas X valor da hora.
	 */
	@Test
	public void testSalario() {
		funcionario.setSalario(180);// horas

		float salarioTotal = funcionario.getSalario();

		// Salario corresponde as horas trabalhadas (10) * valor hora do funcionario
		double salarioCorreto = (180 * Funcionario.VALOR_HORA);
		Assert.assertEquals(salarioTotal, salarioCorreto, 1);
	}
	@Test
	public void testSalarioPassandoValor() {
		funcionario.setSalario(180);// horas
		
		float salarioTotal = funcionario.getSalario(10);
		
		Assert.assertEquals(salarioTotal, 1800, 1);
	}
	
	@Test
	public void testSalarioPassandoValorErrado() {
		funcionario.setSalario(180);// horas
		
		float salarioTotal = funcionario.getSalario(11);
		
		Assert.assertNotEquals(salarioTotal, 1800, 1);
	}

}
