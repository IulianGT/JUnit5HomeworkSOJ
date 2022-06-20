package com.endava.tmd.soj.junit5.p06.s1;

import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import org.assertj.core.internal.Integers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.endava.tmd.soj.junit5.p05.s1.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

// Provocare: Rescrieti scenariile de testare din tema precedenta folosind teste parametrizate.
// Se vor utiliza adnotarile @ParameterizedTest si @CsvSource
// E suficient sa scrieti 2 teste distincte:
// - Un test care verifica valoarea sumei a doua numere
// - Un test care verifica exceptiile generate
//
// Bonus: personalizarea numelui afisat al testului
//   * vom folosi {0} pentru a folosi valoarea primului parametru al metodei
//   * vom folosi {1} pentru a folosi valoarea celui de-al doilea parametru al metodei
//   * ...
//   dar NU in @DisplayName ci in atributul "name" al adnotarii @ParameterizedTest

public class ComputationUtilsTest {


    @CsvSource(
            {
            "0, 0, 0",
            }
    )
    @ParameterizedTest(name = " sum of ({0} + {1}) equals {2} ")
    void zeroShouldNotChangeZero(int a, int b,int result) {
        // JUnit Assertion
        //assertEquals(0, sum(0, 0));

        // AssertJ Assertion
        assertThat(sum(a, b)).isEqualTo(result);

        //assertThat(sum(0, 1)).isZero();
    }

    @ParameterizedTest(name = " {0} + {1} = {2} ")
    @CsvSource(
            {
                    "3, 0, 3",
                    "4, 0 , 4"
            }
    )
    void zeroShouldNotChangePositive(int a, int b,int result) {
        assertThat(sum(a, b)).isEqualTo(result);
    }

    @Test
    @DisplayName("-3 + 0 = -3")
    void zeroShouldNotChangeNegative() {
        assertThat(sum(-3,0)).isEqualTo(-3);
    }

    @Test
    @DisplayName("3 + 2 = 5")
    void twoPositiveNumbersShouldHaveAbsoluteValuesAddedAndPositiveResult() {
        assertThat(sum(3,2)).isEqualTo(5);
    }

    @Test
    @DisplayName("-1 + -3 = -4")
    void twoNegativeNumbersShouldHaveAbsoluteValuesAddedAndNegativeResult() {
        assertThat(sum(-1,-3)).isEqualTo(-4);
    }

    @Test
    @DisplayName("-3 + 6 = 3")
    void oneSmallNegativeAndOneBigPosiveNumberShouldHaveAbsoluteValuesSubtractedAndPositiveResult() {
        assertThat(sum(-3,6)).isEqualTo(3);
    }

    //@Disabled
    @Test
    @DisplayName("3 + -6 = -3")
    void oneBigNegativeAndOneSmallPosiveNumberShouldHaveAbsoluteValuesSubtractedAndNegativeResult() {
        assertThat(sum(3,-6)).isEqualTo(-3);
    }

//    @Test
//    @DisplayName("2147483647 + 1 \u21D2 Overflow")
//    void exceptionWhenSumIsGreaterThanIntegerMaxValue() {
//        // JUnit way of checking the exception class
//        //assertThrows(ArithmeticException.class, () -> sum(2147483647, 1));
//
//        // JUnit way of checking the exception class and its characteristics
//        //ArithmeticException exception = assertThrows(ArithmeticException.class, () -> sum(2147483647, 1));
//        //assertEquals("Overflow while computing the sum", exception.getMessage());
//
//        // AssertJ
////        assertThatThrownBy(() -> sum(2147483647, 1))
////                .isInstanceOf(ArithmeticException.class)
////                .hasMessage("Overflow while computing the sum");
//    }


    @ParameterizedTest(name = " sum of ({0} + {1}) throws overflow ")
    @CsvSource({
            "-2147483647, -5",
            "2147483647, 1"
    })
    void exceptionWhenSumIsLowerThanIntegerMinValue(int a, int b) {
        assertThatThrownBy(()->sum(a,b))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Overflow while computing the sum");
    }


}
