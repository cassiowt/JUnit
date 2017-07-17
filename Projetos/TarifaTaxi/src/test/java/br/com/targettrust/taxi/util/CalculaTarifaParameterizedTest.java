package br.com.targettrust.taxi.util;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import br.com.targettrust.taxi.rules.LocaleRule;

/**
 * Testes parameterizados de tarifa.
 * 
 * @author Gilberto Lupatini
 */
@RunWith(Parameterized.class)
public class CalculaTarifaParameterizedTest {

    @Rule
    public LocaleRule localeRule = new LocaleRule();
    
    private CalculaTarifa calculaTarifa;

    @Before
    public void setUp() {
	//Locale.setDefault(Locale.ENGLISH);
	calculaTarifa = new CalculaTarifa();
    }

	@Parameters(name = "Teste nro {index}: Calculando {1} kmB1: {2} - kmB2 {3}")
    public static Collection<?> getCasosTeste() {
	return Arrays.asList(new Object[][] { 
		{ Cidade.PORTO_ALEGRE, 7.8, "22.15", "30.26", "99,99" }, 
		{ Cidade.MANAUS, 50, "124.00", "149.00", "99,99"}, 
		{ Cidade.PORTO_ALEGRE, 63, "146.90" , "212.42", "99,99"},
		{ Cidade.PORTO_ALEGRE, 0, "4.52", "4.52" , "99,99"}, 
		{ Cidade.PORTO_ALEGRE, 10, "27.12", "37.52", "40.52" }, 
		{ Cidade.SAO_PAULO, 63, "177.75", "199.80" , "99,99"} });
    }

    // @Parameter
    public Cidade cidade;

    // @Parameter(1)
    public double distancia;

    // @Parameter(2)
    public String resultado;

    // @Parameter(3)
    public String resultadoBandeira2;
    
    // @Parameter(4)
    public String resultadoErrado;

	public CalculaTarifaParameterizedTest(Cidade cidade, double distancia, String resultado,
			String resultadoBandeira2, String resultadoErrado) {
		super();
		this.cidade = cidade;
		this.distancia = distancia;
		this.resultado = resultado;
		this.resultadoBandeira2 = resultadoBandeira2;
		this.resultadoErrado = resultadoErrado;
	}

	@Test
	public void testCalculaTarifa() {
		Double tarifa = calculaTarifa.calcula(this.cidade, this.distancia);
		String tarifaFormatada = new DecimalFormat("0.00").format(tarifa);

		assertThat(tarifaFormatada, equalTo(this.resultado));
	}

	@Test
	public void testeCalculaTarifaBandeira2() {
		Double tarifa = calculaTarifa.calculaBandeira2(this.cidade, this.distancia);
		String tarifaFormatada = new DecimalFormat("0.00").format(tarifa);

		assertThat(tarifaFormatada, equalTo(this.resultadoBandeira2));
	}
	
	@Test
	public void testeCalculaTarifaBandeira2Errado() {
		Double tarifa = calculaTarifa.calculaBandeira2(this.cidade, this.distancia);
		String tarifaFormatada = new DecimalFormat("0.00").format(tarifa);
		
		assertThat(tarifaFormatada, not(this.resultadoErrado));
	}
	
	
}
