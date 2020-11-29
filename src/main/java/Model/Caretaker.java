package Model;

import java.util.ArrayList;
import java.util.List;

public class Caretaker {

    List<Memento> savedPlayers = new ArrayList<Memento>();

    public void addMemento(Memento memento) {
        savedPlayers.add(memento);
    }

    public Memento getMemento(int index) {
        return savedPlayers.get(index);
    }
}
