package Controller;

import Model.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayerController {
    public static Player getPlayerByName(ArrayList<Player> players, String name){
        return players.stream().filter(player -> player.getName().equals(name)).findFirst().orElse(null);
    }

    public static Player createPlayer(ArrayList<Player> players){
        System.out.println("Enter player name");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        if(getPlayerByName(players, name) != null){
            System.out.println("Player already exists. Override? 'Y/N'");
            String answer = scanner.nextLine();

            if(answer.equalsIgnoreCase("y")){
                return getPlayerByName(players, name);
            } else {
                return null;
            }
        }

        Player player = new Player(name);
        players.add(player);
        return player;
    }
}
