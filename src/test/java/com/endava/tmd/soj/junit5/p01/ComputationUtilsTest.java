package com.endava.tmd.soj.junit5.p01;

// Provocari:
// 1. Adaugati adnotarea neecesara pentru a rula prima metoda ca si un test unitar
// 2. Rulati prima metoda ca si un test unitar
// 3. Decomentati asertiile din primul test, si efectuati importurile necesare. Rulati testul din nou.
// 4. Adaugati o linie care sa determine testul sa fie "failed". La sfarsit commentati acea linie
// 5. Completati celelalte metode astfel incat sa reprezinte scenarii de testare

import org.junit.jupiter.api.Test;
import static com.endava.tmd.soj.junit5.p01.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.assertThat;

class ComputationUtilsTest {

    @Test
    void zeroShouldNotChangeZero() {
        // JUnit Assertion
        //assertEquals(0, sum(0, 0));

        // AssertJ Assertion
        assertThat(sum(0, 0)).isZero();

        //assertThat(sum(0, 1)).isZero();
    }

    @Test
    void zeroShouldNotChangePositive() {
        assertThat(sum(3,0)).isEqualTo(3);
    }

    @Test
    void zeroShouldNotChangeNegative() {
        assertThat(sum(-3,0)).isEqualTo(-3);
    }
    @Test
    void twoPositiveNumbersShouldHaveAbsoluteValuesAddedAndPositiveResult() {
        assertThat(sum(3,2)).isEqualTo(5);
    }

    @Test
    void twoNegativeNumbersShouldHaveAbsoluteValuesAddedAndNegativeResult() {
        assertThat(sum(-1,-3)).isEqualTo(-4);
    }

    @Test
    void oneSmallNegativeAndOneBigPosiveNumberShouldHaveAbsoluteValuesSubtractedAndPositiveResult() {
        assertThat(sum(-3,6)).isEqualTo(3);
    }

    @Test
    void oneBigNegativeAndOneSmallPosiveNumberShouldHaveAbsoluteValuesSubtractedAndNegativeResult() {
        assertThat(sum(3,-6)).isEqualTo(-3);
    }

}
