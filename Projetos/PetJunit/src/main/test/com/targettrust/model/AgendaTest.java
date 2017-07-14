package com.targettrust.model;

import java.util.Date;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe de teste para o Modelo Agenda. Exemplos de Utilizando Matchers.
 * 
 * @author Gilberto Lupatini
 */
public class AgendaTest {

	Agenda agenda;

	Animal animalExemplo, animalExemplo1;

	@Before
	public void setUp() throws Exception {
		agenda = new Agenda();
		animalExemplo = new Animal("Ruff", 30, 45, true, Especie.Mam�feros);
		animalExemplo1 = new Animal("Draco", 30, 45, true, Especie.Mam�feros);
	}

	@Test
	public void testIncluiAgendaSeEhDiferenteDeNull() {
		Consulta consultaInclusao = new Consulta(animalExemplo, new Date(), false, 70F);
		agenda.incluiAgenda(consultaInclusao);

		// X notNullValue() tenta deixar mais sem�ntico o teste
		Assert.assertThat(agenda.getConsultas(), CoreMatchers.notNullValue());
	}

	@Test
	public void testIncluiAgendaSeEhOMesmoObjeto() {
		Consulta consultaInclusao = new Consulta(animalExemplo, new Date(), false, 70F);
		agenda.incluiAgenda(consultaInclusao);

		// X is(equalsTo( Y )) tenta deixar mais sem�ntico o teste
		Assert.assertThat(agenda.getConsultas().get(0), CoreMatchers.is(CoreMatchers.equalTo(consultaInclusao)));
	}

	@Test
	public void testIncluiAgendaSeEhOMesmoObjetoComIS() {
		Consulta consultaInclusao = new Consulta(animalExemplo, new Date(), false, 70F);
		agenda.incluiAgenda(consultaInclusao);

		// IS tamb�m faz compara��es diretas
		Assert.assertThat(agenda.getConsultas().get(0), CoreMatchers.is(consultaInclusao));
	}

	@Test
	public void testIncluiAgendaMultiplosTestesEmUm() {
		Consulta consultaInclusao = new Consulta(animalExemplo, new Date(), false, 70F);
		agenda.incluiAgenda(consultaInclusao);

		// com allOf podemos testar v�rios crit�rios ao mesmo tempo ( funciona como um
		// AND)
		Assert.assertThat(agenda.getConsultas().get(0),
				CoreMatchers.allOf(CoreMatchers.notNullValue(), CoreMatchers.is(consultaInclusao)));
	}

	@Test
	@SuppressWarnings("unchecked")
	public void testIncluiAgendaMultiplosQualquerUmValido() {
		Consulta consultaInclusao = new Consulta(animalExemplo, new Date(), false, 70F);
		Consulta consultaInclusao1 = new Consulta(animalExemplo, new Date(), false, 170F);
		agenda.incluiAgenda(consultaInclusao);
		agenda.incluiAgenda(consultaInclusao1);

		// o anyOf � uma esp�cie de OR (neste caso nullValue � falso, mas o segundo
		// crit�rio � verdadeiro)
		Assert.assertThat(agenda.getConsultas().get(0),
				CoreMatchers.anyOf(CoreMatchers.nullValue(),
						           CoreMatchers.is(consultaInclusao)));
	}

	@Test
	@SuppressWarnings("unchecked")
	public void testIncluiAgendaAninhados() {
		Consulta consultaInclusao = new Consulta(animalExemplo, new Date(), false, 70F);
		agenda.incluiAgenda(consultaInclusao);

		// multiplos n�veis s�o permitidos. Os Matchers foram projetados para serem
		// usados assim.
		Assert.assertThat(agenda.getConsultas().get(0).getAnimal().getEspecie(),
				CoreMatchers.anyOf(CoreMatchers.is(CoreMatchers.nullValue()),
						CoreMatchers.is(consultaInclusao.getAnimal().getEspecie()),
						CoreMatchers.allOf(CoreMatchers.any(Especie.class), CoreMatchers.notNullValue(),
								CoreMatchers.is(consultaInclusao.getAnimal().getEspecie()))));
	}
	
	
	@Test
	public void testConsultaAgendaPorApelido() {
		
		Consulta consultaInclusao = new Consulta(animalExemplo, new Date(), false, 70F);
		Consulta consultaInclusao1 = new Consulta(animalExemplo1, new Date(), false, 70F);
		
		agenda.incluiAgenda(consultaInclusao);
		agenda.incluiAgenda(consultaInclusao1);
		
		Consulta consultaRetornada = agenda.consultarPorApelido("Ruff");
		
		Assert.assertThat(agenda.getConsultas().get(0), 
				   CoreMatchers.allOf(CoreMatchers.notNullValue(),
				   					  CoreMatchers.is(consultaRetornada)));
		
		
		
	}

}
