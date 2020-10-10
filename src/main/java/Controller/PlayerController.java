package Controller;

import Model.Player;

import java.util.ArrayList;

public class PlayerController {
    public static Player getPlayerByName(ArrayList<Player> players, String name){
        return players.stream().filter(player -> player.getName().equals(name)).findFirst().orElse(null);
    }
}
