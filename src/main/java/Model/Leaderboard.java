package Model;

import Controller.PlayerController;

import java.io.Serializable;
import java.util.List;

public class Leaderboard implements Serializable {
    private List<Player> players;

    private Leaderboard(List<Player> players) {
        this.players = players;
    }

    private static class LeaderboardHolder {
        public static final Leaderboard leaderboard = new Leaderboard(PlayerController.generatePlayerList());
    }


    public static Leaderboard getInstance(){
        return LeaderboardHolder.leaderboard;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
