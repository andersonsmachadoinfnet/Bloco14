package br.anderson.infnet.appDr1At.exercicio05;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LinearSearchTest {
	private final SearchAlgorithm searchAlgorithm = new LinearSearch();

	@Test
	@DisplayName("Deve encontrar elemento no início do array")
	void deveEncontrarElementoNoInicio() {
		Integer[] array = { 10, 20, 30 };

		int index = searchAlgorithm.find(array, 10);

		assertThat(index).isEqualTo(0);
	}

	@Test
	@DisplayName("Deve encontrar elemento no meio do array")
	void deveEncontrarElementoNoMeio() {
		Integer[] array = { 10, 20, 30 };

		int index = searchAlgorithm.find(array, 20);

		assertThat(index).isEqualTo(1);
	}

	@Test
	@DisplayName("Deve encontrar elemento no fim do array (valor limite)")
	void deveEncontrarElementoNoFim() {
		Integer[] array = { 10, 20, 30 };

		int index = searchAlgorithm.find(array, 30);

		assertThat(index).isEqualTo(2);
	}

	@Test
	@DisplayName("Deve retornar -1 quando elemento não existe")
	void deveRetornarMenosUmQuandoElementoNaoExiste() {
		Integer[] array = { 10, 20, 30 };

		int index = searchAlgorithm.find(array, 40);

		assertThat(index).isEqualTo(-1);
	}

	@Test
	@DisplayName("Deve funcionar com array unitário")
	void deveFuncionarComArrayUnitario() {
		Integer[] array = { 10 };

		int indexEncontrado = searchAlgorithm.find(array, 10);
		int indexNaoEncontrado = searchAlgorithm.find(array, 20);

		assertThat(indexEncontrado).isEqualTo(0);
		assertThat(indexNaoEncontrado).isEqualTo(-1);
	}

	@Test
	@DisplayName("Deve retornar -1 para array vazio (valor limite)")
	void deveRetornarMenosUmParaArrayVazio() {
		Integer[] array = {};

		int index = searchAlgorithm.find(array, 10);

		assertThat(index).isEqualTo(-1);
	}

	@Test
	@DisplayName("Deve funcionar com tipos genéricos (String)")
	void deveFuncionarComString() {
		String[] array = { "A", "B", "C" };

		int index = searchAlgorithm.find(array, "B");

		assertThat(index).isEqualTo(1);
	}
}
