import Controller.PlayerController;
import Model.Leaderboard;
import Model.Player;

import java.io.IOException;
import java.util.*;

public class App {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Player> players = PlayerController.generatePlayerList();
        Leaderboard leaderboard = new Leaderboard(players);
        Menu.launch(leaderboard);
    }
}
