package Interface.Controller;

import Model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerController {

    public PlayerController() {
    }

    public List<Player> generatePlayerList() {
        List<Player> players = new ArrayList<>();
        populatePlayerList(players);
        return players;
    }

    public Player getPlayerByName(List<Player> players, String name) {
        return players.stream().filter(player -> player.getName().equals(name)).findFirst().orElse(null);
    }

    public Boolean removePlayerFromList(List<Player> players, Player player) {
        return players.remove(player);
    }

    public Player createPlayer(List<Player> players) {
        System.out.println("Enter player name");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        if (getPlayerByName(players, name) != null) {
            System.out.println("Player already exists. Override? 'Y/N'");
            String answer = scanner.nextLine();

            if (answer.equalsIgnoreCase("y")) {
                return getPlayerByName(players, name);
            } else {
                return null;
            }
        }

        Player player = new Player(name);
        players.add(player);
        return player;
    }

    private void populatePlayerList(List<Player> players) {
        String[] names = {"Average computer typist", "proGamer3000", "Jordan", "Rambo", "Stallone"};
        Long[] wordsPerMinute = {41L, 100L, 50L, 90L, 60L};
        Double[] accuracies = {92D, 98D, 88D, 99D, 90D};

        for (int i = 0; i < names.length; i++) {
            players.add(new Player(names[i], wordsPerMinute[i], accuracies[i]));
        }
    }
}
