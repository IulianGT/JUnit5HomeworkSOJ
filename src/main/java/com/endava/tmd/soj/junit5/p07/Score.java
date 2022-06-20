package com.endava.tmd.soj.junit5.p07;

import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

public class Score {
    private AtomicInteger correctAnswers = new AtomicInteger();
    private AtomicInteger incorrectAnswers = new AtomicInteger();

    public Score addCorrectAnswer() {
        correctAnswers.incrementAndGet();
        return this;
    }

    public Score addIncorrectAnswer() {
        incorrectAnswers.incrementAndGet();
        return this;
    }

    public String getPercent() {
        int correct = correctAnswers.get();
        int incorrect = incorrectAnswers.get();
        int total = correct + incorrect;

        double percent = total == 0 ? 100 : 100.0 * correct / total;
        return String.format("%.1f", percent);
    }

    public static void main(String[] args) {
        Score game = new Score();
        game.addCorrectAnswer();
        game.addCorrectAnswer();
        String res = game.getPercent();
        float result = Float.parseFloat(game.getPercent());
        String.format(Locale.getDefault(), res);
        System.out.println(res);
        System.out.println(result);
    }
}
