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
        SentenceGenerator sentenceGenerator = new SentenceGenerator();
        ArrayList<Player> players = getPlayers();
        Leaderboard leaderboard = new Leaderboard(players);
        Menu.launch(leaderboard);
    }

    public static ArrayList<Player> getPlayers() {
        ArrayList<Player> players = new ArrayList<Player>();
        File file = new File("players.txt");
        if (file.exists() && !file.isDirectory()) {
            getPlayersFromFile(players, file);
        } else {
            generatePlayers(players);
        }
        return players;
    }

    private static void generatePlayers(ArrayList<Player> players) {
        String[] names = {"Average computer typist", "proGamer3000", "Jordan", "Rambo", "Stallone" };
        Long[] wordsPerMinute = {41L, 100L, 50L, 90L, 60L};
        Double[] accuracies = {92D, 98D, 88D, 99D, 90D};

        for (int i = 0; i < names.length; i++) {
            players.add(new Player(names[i], wordsPerMinute[i], accuracies[i]));
        }
    }

    private static void getPlayersFromFile(ArrayList<Player> players, File file) {
        Scanner scanner = null;
        String line;
        try {
            scanner = new Scanner(file);
            while (scanner.hasNext()) {
                line = scanner.nextLine();
                String[] data = line.split("\\s");
                String name = data[0];
                Long wordsPerMinute = Long.parseLong(data[1]);
                Double accuracy = Double.parseDouble(data[2]);
                Player player = new Player(name, wordsPerMinute, accuracy);
                players.add(player);
            }
        } catch (Exception error) {
            System.out.println("Klaida");
            error.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
