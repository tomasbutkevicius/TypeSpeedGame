import Model.Caretaker;
import Model.Leaderboard;
import Model.Originator;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Leaderboard leaderboard = Leaderboard.getInstance();
        Caretaker caretaker = new Caretaker();
        Originator originator = new Originator();
        Menu menu = new Menu(leaderboard, caretaker, originator);
        menu.launch();
    }
}
