package Model;

import java.util.List;

public class Memento {
    private List<Player> players;

    public Memento(List<Player> playersSave) {
        players = playersSave;
    }

    public List<Player> getSavedPlayers() {
        return players;
    }

}
