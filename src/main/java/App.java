import Interface.Controller.PlayerController;
import Utilities.Caretaker;
import Model.Leaderboard;
import Utilities.Originator;
import Interface.Menu;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Menu menu = new Menu(Leaderboard.getInstance(), new Caretaker(), new Originator(), new PlayerController());
        menu.launch();
    }
}
