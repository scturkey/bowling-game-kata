package org.scturkey.kata;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    @Test
    void should_calculateScoreForAllZeros() {
        Game game = new Game();
        for (int i=0; i<20; i++) {
            game.roll(0);
        }
        assertThat(game.score()).isEqualTo(0);
    }
}
