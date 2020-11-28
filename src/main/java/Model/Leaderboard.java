package Model;

import java.io.Serializable;
import java.util.List;

public class Leaderboard implements Serializable {
    private List<Player> players;

    public Leaderboard(List<Player> players) {
        this.players = players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
