package com.endava.tmd.soj.junit5.p04;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.endava.tmd.soj.junit5.p01.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.assertThat;

// Provocare: Copiati metodele de test din tema de la p02, si adaugati ceea ce lipseste astfel incat
// sa fie testate si scenariile urmatoare. La ultima metoda, in cazul in care testul nu trece,
// adaugati adnotarea necesara astfel incat sa apara ca si "skipped"
@DisplayName("Tests for my sum method")
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
}
