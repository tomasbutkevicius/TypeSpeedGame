package Utilities;

import Model.Player;

import java.util.List;

public class Originator {
    private List<Player> players;

    public void set(List<Player> newPlayers) {
        this.players = newPlayers;
    }

    public Memento storeInMemento() {
        return new Memento(players);
    }

    public List<Player> restoreFromMemento(Memento memento) {
        players = memento.getSavedPlayers();
        return players;
    }
}
