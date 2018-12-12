package org.scturkey.kata;

public class Game {

    private Library library;

    public Game(Library library) {
        this.library = library;
    }

    public boolean doSomeStuff() {
        return library.someLibraryMethod();
    }
}
