package main;

import controller.PasswordGame;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
        PasswordGame.getInstance().startNewGame();
    }
}
