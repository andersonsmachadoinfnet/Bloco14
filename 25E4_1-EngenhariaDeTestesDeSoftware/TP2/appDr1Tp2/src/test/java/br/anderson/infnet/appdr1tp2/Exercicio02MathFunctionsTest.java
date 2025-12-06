package br.anderson.infnet.appdr1tp2;

import br.anderson.infnet.appdr1tp2.exercicio02.MathFunctions;
import net.jqwik.api.*;
import net.jqwik.api.constraints.IntRange;

import static org.assertj.core.api.Assertions.*;

public class Exercicio02MathFunctionsTest {
    @Property
    void dobroSempreIgualOuMaior(@ForAll @IntRange(min = 0)int number) {
        int result = MathFunctions.multiplyByTwo(number);
        assertThat(result).isGreaterThanOrEqualTo(number);
    }

    @Property
    void dobroSempreIgualOuMaiorComGeradorCustomizado(@ForAll("numerosAleatorios") int number) {
        int result = MathFunctions.multiplyByTwo(number);
        assertThat(result).isEqualTo(number * 2);
    }

    @Property
    void multiplyByTwoPreservaParidade(@ForAll("numerosPares") int number) {
        int result = MathFunctions.multiplyByTwo(number);
        assertThat(result % 2).isZero();
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
