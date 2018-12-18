package br.com.targetrust.rn;

import br.com.targetrust.ed.Paciente;
import br.com.targetrust.service.PacienteRN;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Classe de teste para Paciente.
 * 
 * @author Gilberto Lupatini
 */
public class PacienteRNTest {

    private PacienteRN pacienteRN;

    @BeforeEach
    public void setUp() {
	pacienteRN = new PacienteRN();
    }



    @Test
    public void testCadastroPaciente() {
	cadastrarPacientes();

	int size = pacienteRN.listaPacientes().size();
	assertTrue(size == 6, "A lista de pacientes tem size: " + size);
    }

    @Test
    public void testBuscaPacientePeloNomeSemResultado() {
	cadastrarPacientes();

	List<Paciente> pacientesComEsseNome = pacienteRN.buscaPaciente("João Inácio");
	assertEquals( 0, pacientesComEsseNome.size(), "Paciente não devia estar cadastrado!");
    }

    @Test
    public void testBuscaPacientePeloNome() {
	cadastrarPacientes();

	List<Paciente> pacientesComEsseNome = pacienteRN.buscaPaciente("Maria");
	List<String> nomesEncontrados = new ArrayList<String>();
	for (Paciente paciente : pacientesComEsseNome) {
	    nomesEncontrados.add(paciente.getNome());
	}

	String[] pacientes = { "Maria Oliveira", "Maria dos Santos" };
	assertArrayEquals(pacientes, nomesEncontrados.toArray());
    }

    @Test
    public void testBuscaPacienteIs() {
	cadastrarPacientes();

	Paciente paciente1 = pacienteRN.listaPacientes().get(1);

	assertThat(paciente1, is(notNullValue()));
    }

    @Test
    public void testBuscaPacienteAny() {
	cadastrarPacientes();

	Paciente paciente1 = pacienteRN.listaPacientes().get(1);
	assertThat(paciente1, any(Paciente.class));
    }

    @Test
    public void testBuscaPacienteAnyOf() {
	cadastrarPacientes();

	Paciente paciente1 = pacienteRN.listaPacientes().get(1);
	assertThat(paciente1, is(anyOf(nullValue(), instanceOf(Paciente.class))));
    }

    @Test
    public void testBuscaPacienteAllOff() {
	cadastrarPacientes();

	List<Paciente> pacientesComEsseNome = pacienteRN.buscaPaciente("João");
	Paciente paciente1 = pacienteRN.listaPacientes().get(1);

	assertThat(pacientesComEsseNome.get(0), allOf(notNullValue(), equalTo(paciente1)));
    }

    @Test
    public void testBuscaPacienteIsEqualsTo() {
	cadastrarPacientes();

	List<Paciente> pacientesComEsseNome = pacienteRN.buscaPaciente("Maria Oliveira");

	// assertArrayEquals("Maria Oliveira",
	// pacientesComEsseNome.get(0).getNome());
	assertThat("Maria Oliveira", is(equalTo(pacientesComEsseNome.get(0).getNome())));
    }

    @Test
    public void testBuscaPacienteEveryItem() {
	cadastrarPacientes();

	List<Paciente> pacientesComEsseNome = pacienteRN.buscaPaciente("Maria");

	List<String> nomesEncontrados = new ArrayList<String>();
	for (Paciente paciente : pacientesComEsseNome) {
	    nomesEncontrados.add(paciente.getNome());
	}

	assertThat(nomesEncontrados, everyItem(containsString("Maria")));
    }

    @Test
    public void testBuscaPacienteBoth() {
	cadastrarPacientes();

	List<Paciente> pacientesComEsseNome = pacienteRN.buscaPaciente("Fábio");

	List<String> nomesEncontrados = new ArrayList<String>();
	for (Paciente paciente : pacientesComEsseNome) {
	    nomesEncontrados.add(paciente.getNome());
	}

	// Assert.assertThat(nomesEncontrados, is(both(notNullValue())));
    }

    @Test
    public void testBuscaPacienteHasItems() {
	cadastrarPacientes();

	List<Paciente> pacientesComEsseNome = pacienteRN.buscaPaciente("João");

	assertThat(pacientesComEsseNome, hasItems(pacienteRN.listaPacientes().get(1)));
    }

    /**
     * Utiliário para cadastrar base de dados de teste.
     */
    private void cadastrarPacientes() {
	pacienteRN.cadastrarPaciente(new Paciente("Maria Oliveira", "101.000.000-00", "(51) 9981 9791"));
	pacienteRN.cadastrarPaciente(new Paciente("João da Silva", "010.000.000-00", "(51) 9999 9999"));
	pacienteRN.cadastrarPaciente(new Paciente("Felipe Almeida", "100.000.000-00", "(51) 9991 9991"));
	pacienteRN.cadastrarPaciente(new Paciente("Maria dos Santos", "101.000.000-00", "(51) 9981 9791"));
	pacienteRN.cadastrarPaciente(new Paciente("Fábio Felipe Oliveira", "101.000.000-00", "(51) 9981 9791"));
	pacienteRN.cadastrarPaciente(new Paciente("Fábio Oliveira Ortiz", "101.000.000-00", "(51) 9981 9791"));
    }

}
