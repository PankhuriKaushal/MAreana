package org.magical.arena;

import org.magical.arena.service.StartGameService;
import org.magical.arena.service.impl.StartGameImpl;

public class Main {
    public static void main(String[] args) {
        StartGameImpl startGame = new StartGameService();
        startGame.enterPlayersDetails();
    }
}