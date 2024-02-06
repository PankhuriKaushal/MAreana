package org.magical.arena.service.impl;

import org.magical.arena.model.Player;

public interface StartGameImpl {

    void enterPlayersDetails();

    void startExecution();

    void selectPlayerForFight(Player player_A, String player_A_Name, Player player_B, String player_B_Name);

    boolean startGame(Player attacker, String attakerName, Player defender, String defenderName);

    int roleDice();

    int fight(Player attackingPlayer, String attakerName, Player defendingPlayer, String defenderName);
}
