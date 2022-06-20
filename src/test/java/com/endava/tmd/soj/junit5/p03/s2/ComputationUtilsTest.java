package com.endava.tmd.soj.junit5.p03.s2;

import org.junit.jupiter.api.*;

import static com.endava.tmd.soj.junit5.p01.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.assertThat;

// Provocare: Copiati metodele de test din tema anterioara, si adaugati adnotarile necesare astfel incat
// sa fie rulate testele in ordine alfabetica. Modificati numele metodelor de test astfel incat metodele
// sa fie executate in ordinea in care sunt scrise

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@TestMethodOrder(MethodOrderer.MethodName.class)
@DisplayName("Tests for my sum method")
class ComputationUtilsTest {

    @Test
    @DisplayName("0 + 0 = 0")
    @Order(1)
    void zeroShouldNotChangeZero() {
        // JUnit Assertion
        //assertEquals(0, sum(0, 0));

        // AssertJ Assertion
        assertThat(sum(0, 0)).isZero();

        //assertThat(sum(0, 1)).isZero();
    }

    @Test
    @Order(2)
    @DisplayName("3 + 0 = 3")
    void zeroShouldNotChangePositive() {
        assertThat(sum(3,0)).isEqualTo(3);
    }

    @Test
    @Order(3)
    @DisplayName("-3 + 0 = -3")
    void zeroShouldNotChangeNegative() {
        assertThat(sum(-3,0)).isEqualTo(-3);
    }

    @Test
    @Order(4)
    @DisplayName("3 + 2 = 5")
    void twoPositiveNumbersShouldHaveAbsoluteValuesAddedAndPositiveResult() {
        assertThat(sum(3,2)).isEqualTo(5);
    }

    @Test
    @Order(5)
    @DisplayName("-1 + -3 = -4")
    void twoNegativeNumbersShouldHaveAbsoluteValuesAddedAndNegativeResult() {
        assertThat(sum(-1,-3)).isEqualTo(-4);
    }

    @Test
    @Order(6)
    @DisplayName("-3 + 6 = 3")
    void oneSmallNegativeAndOneBigPosiveNumberShouldHaveAbsoluteValuesSubtractedAndPositiveResult() {
        assertThat(sum(-3,6)).isEqualTo(3);
    }

    @Test
    @Order(7)
    @DisplayName("3 + -6 = -3")
    void oneBigNegativeAndOneSmallPosiveNumberShouldHaveAbsoluteValuesSubtractedAndNegativeResult() {
        assertThat(sum(3,-6)).isEqualTo(-3);
    }
}
