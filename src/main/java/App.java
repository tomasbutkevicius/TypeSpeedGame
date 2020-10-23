import Controller.PlayerController;
import Model.Leaderboard;
import Model.Player;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<Player> players = PlayerController.generatePlayerList();
        Leaderboard leaderboard = new Leaderboard(players);
        Menu.launch(leaderboard);
    }
}
