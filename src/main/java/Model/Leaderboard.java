package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Leaderboard implements Serializable {
    private ArrayList<Player> players;

    public Leaderboard(ArrayList<Player> players) {
        this.players = players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
}
