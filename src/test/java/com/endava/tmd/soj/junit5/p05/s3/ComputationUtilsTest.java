package com.endava.tmd.soj.junit5.p05.s3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.endava.tmd.soj.junit5.p05.s1.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

// Scopul acestei sectiuni este sa urmarim rescrierile de cod din partea de productie
// Deci pastram testele din sectiunea precedenta
class ComputationUtilsTest {

        @Test
        @DisplayName("0 + 0 = 0")
        void zeroShouldNotChangeZero() {
            // JUnit Assertion
            //assertEquals(0, sum(0, 0));

            // AssertJ Assertion
            assertThat(sum(0, 0)).isZero();

            //assertThat(sum(0, 1)).isZero();
        }

        @Test
        @DisplayName("3 + 0 = 3")
        void zeroShouldNotChangePositive() {
            assertThat(sum(3,0)).isEqualTo(3);
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

        @Test
        @DisplayName("2147483647 + 1 \u21D2 Overflow")
        void exceptionWhenSumIsGreaterThanIntegerMaxValue() {
            // JUnit way of checking the exception class
            //assertThrows(ArithmeticException.class, () -> sum(2147483647, 1));

            // JUnit way of checking the exception class and its characteristics
            //ArithmeticException exception = assertThrows(ArithmeticException.class, () -> sum(2147483647, 1));
            //assertEquals("Overflow while computing the sum", exception.getMessage());

            // AssertJ
            assertThatThrownBy(() -> sum(2147483647, 1))
                    .isInstanceOf(ArithmeticException.class)
                    .hasMessage("Overflow while computing the sum");
        }

        @Test
        @DisplayName("-2147483648 + (-1) \u21D2 Overflow")
        void exceptionWhenSumIsLowerThanIntegerMinValue() {
            assertThatThrownBy(()->sum(-2147483647,-5))
                    .isInstanceOf(ArithmeticException.class)
                    .hasMessage("Overflow while computing the sum");
        }

    }
