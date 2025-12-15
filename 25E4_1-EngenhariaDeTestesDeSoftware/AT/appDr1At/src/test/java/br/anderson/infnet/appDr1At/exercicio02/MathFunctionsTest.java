package br.anderson.infnet.appDr1At.exercicio02;

import net.jqwik.api.Arbitraries;
import net.jqwik.api.Arbitrary;
import net.jqwik.api.Assume;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.Provide;
import net.jqwik.api.RandomDistribution;
import net.jqwik.api.lifecycle.BeforeProperty;

import java.util.Arrays;

import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.*;

public class MathFunctionsTest {
	private MathFunctions math;

	@BeforeProperty
	void setUp() {
		math = new MathFunctions(Mockito.mock(MathLogger.class));
	}

	@Property
	void multiplyByTwoPreservaParidade(@ForAll("numerosPares") int number) {
		int result = math.multiplyByTwo(number);

		assertThat(result % 2).isZero();
	}

	@Property
	void generateMultiplcationTableGaranteMultiplicidade(@ForAll("numerosAleatorios") int number) {
		int limit = 10;
		int[] table = math.generateMultiplicationTable(number, limit);

		assertThat(table).hasSize(limit);

		if (number == 0) {
			for (int num : table) {
				assertThat(num).isZero();
			}
		} else {
			for (int i = 0; i < limit; i++) {
				int expected = number * (i + 1);
				assertThat(table[i]).isEqualTo(expected);
				assertThat(table[i] % number).isZero();
			}
		}
	}

	@Property
	void garanteIsPrimo(@ForAll("numerosAleatorios") int number) {
		if (math.isPrime(number)) {
			for (int divisor = 2; divisor < number; divisor++) {
				assertThat(number % divisor).isNotZero();
			}
		}
	}

	@Property
	void calcularAverageGaranteEstarEntraMaxEMin(@ForAll int[] numbers) {
		Assume.that(numbers != null && numbers.length > 0);

		Double average = math.calculateAverage(numbers);
		int max = Arrays.stream(numbers).max().getAsInt();
		int min = Arrays.stream(numbers).min().getAsInt();

		assertThat(average).isGreaterThanOrEqualTo(min);
		assertThat(average).isLessThanOrEqualTo(max);
	}

	@Provide
	Arbitrary<Integer> numerosAleatorios() {
		return Arbitraries.integers()
				.greaterOrEqual(-1_000_000)
				.lessOrEqual(1_000_000)
				.withDistribution(RandomDistribution.uniform());
	}

	@Provide
	Arbitrary<Integer> numerosPares() {
		return Arbitraries.integers()
				.greaterOrEqual(-1_000_000)
				.lessOrEqual(1_000_000)
				.filter(n -> n % 2 == 0); // garante apenas pares
	}
}
