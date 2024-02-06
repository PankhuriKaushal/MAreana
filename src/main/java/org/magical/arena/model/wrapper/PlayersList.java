package org.magical.arena.model.wrapper;

import org.magical.arena.model.Player;

import java.util.HashMap;
import java.util.Map;

public class PlayersList {
    private Map<String, Player> playerHashMap = new HashMap<>();

    public Map<String, Player> getPlayerList() {
        return playerHashMap;
    }

    public void addPlayerList(String playerName, Player player) {
        this.playerHashMap.put(playerName, player);
    }
}
