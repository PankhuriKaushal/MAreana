package org.magical.arena.service;

import org.junit.jupiter.api.*;
import org.magical.arena.model.Player;
import org.magical.arena.model.wrapper.PlayersList;
import org.magical.arena.service.StartGameService;
import org.magical.arena.service.impl.StartGameImpl;

import java.io.*;
import java.util.Scanner;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StartGameServiceTest {

    private ByteArrayInputStream testInput;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testStartExecution_StopGame() {
        String input = "0";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(inputStream);
        StartGameImpl startGame = new StartGameService(scanner);
        startGame.startExecution();
        Assertions.assertEquals("Enter 0 for STOP the Game\n" +
                "End 1 to start fight\n" +
                "End 2 to start fight again\n" +
                "End Game", outContent.toString()
                .trim());
    }

    private void setTestInput(String input) {
        testInput = new ByteArrayInputStream(input.getBytes());
        System.setIn(testInput);
    }
}
