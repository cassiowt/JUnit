package com.targettrust.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe de testes para o Forneceder.
 * Exemplos de tratamento de exception com JUnit.
 * 
 * Para gerar CNPJ v�lidos use http://www.geradorcnpj.com/
 * @author Gilberto Lupatini
 */
public class FornecedorTest {
    
    Fornecedor fornecedor;

    @Before
    public void setUp() throws Exception {
	fornecedor = new Fornecedor();
    }

    @Test
    public void test() {
	String cnpj = "39.270.367/0001-60";
	fornecedor.setIdentificador(cnpj);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testCnpjNulo() {
	String cnpj = "1010101";
	fornecedor.setIdentificador(cnpj);
    }
    
    @Test
    public void testCnpjNuloTestandoMensagem() {
	try {
	    fornecedor.setIdentificador("1010101");
	    //N�o pode passar com esse CNPJ
	    Assert.fail("CNPJ devia ser inv�lido");
	} catch (IllegalArgumentException e) {
	    //Teste se a mensagem corresponde tamb�m
	    Assert.assertTrue("Mensagem do erro: Teste de CNPJ falhou", e.getMessage().equals("CNPJ Invalido"));
	}

    }

}
