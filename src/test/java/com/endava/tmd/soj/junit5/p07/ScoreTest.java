package com.endava.tmd.soj.junit5.p07;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.endava.tmd.soj.junit5.p07.Score.*;
import static org.assertj.core.api.Assertions.assertThat;

// Provocare: definiti cel putin 3 teste pentru clasa care tine scorul
// Unde e cel mai potrivit ca sa initializam variabila "score"?
//
// Pentru un raspuns corect si doua incorecte, cat ar trebui sa fie scorul: 33.3 sau 33,3 ?
// 
// Daca avem colegi pe proiect care sunt din diferite parti ale lumii,
// cum putem scrie testul astfel incat sa functioneze pentru toti, indiferent de ce Locale are fiecare? 
class ScoreTest {
    private Score score;
    @Test
    @DisplayName("All are right answers.")
    void getOneHundredPercentByOnlyAnsweringRight(){
        Score game = new Score();
        game.addCorrectAnswer();
        game.addCorrectAnswer();
        assertThat(game.getPercent()).isEqualTo(String.format(Locale.getDefault(), "100.0"));
    }

    @Test
    @DisplayName("There are NO answers.")
    void getOneHundredPercentByNotAnsweringAtAll(){
        Score game = new Score();
        assertThat(game.getPercent()).isEqualTo(String.format(Locale.getDefault(), "100.0"));
    }

    @Test
    @DisplayName("Two correct answers and one incorrect answer.")
    void getCalculusOfTheFormulaRight(){
        Score game = new Score();
        game.addCorrectAnswer();
        game.addCorrectAnswer();
        game.addIncorrectAnswer();

        assertThat(game.getPercent()).isEqualTo(String.format(Locale.getDefault(), "66.7"));
    }

    @Test
    @DisplayName("One right answer and two incorrect answers.")
    void getPercentageForOneRightAnswerAndTwoIncorrectAnswers(){
        Score game = new Score();
        game.addCorrectAnswer();
        game.addIncorrectAnswer();
        game.addIncorrectAnswer();

        assertThat(game.getPercent()).isEqualTo(String.format(Locale.getDefault(), "33.3"));
    }
}
