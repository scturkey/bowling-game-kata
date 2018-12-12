package org.scturkey.kata;

public class Game {

    private int[] knockedDownPins = new int[21];
    private int rollCounter = 0;

    public void roll(int knockedDownPins) {
        if (knockedDownPins == 10) {
            rollCounter++;
        }
        this.knockedDownPins[rollCounter++] = knockedDownPins;
    }

    public int score() {
        int totalScore = 0;
        for (int i = 0; i < knockedDownPins.length; i++) {
            if (knockedDownPins[i] == 10) {
                totalScore += knockedDownPins[i + 1] + knockedDownPins[i + 2];
            } else if (i > 0 && i % 2 == 1) {
                int frameScore = knockedDownPins[i] + knockedDownPins[i - 1];
                if (frameScore == 10) {
                    totalScore += knockedDownPins[i + 1];
                }
            }
            totalScore += knockedDownPins[i];
        }
        return totalScore;
    }
}
