package org.scturkey.kata;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LibraryTest {

    @Mock
    Library library;

    @InjectMocks
    Game game;

    @Test
    void testSomeLibraryMethod() {
        //when
        when(library.someLibraryMethod()).thenReturn(true);

        //then
        assertThat(game.doSomeStuff()).isEqualTo(true);
    }
}
