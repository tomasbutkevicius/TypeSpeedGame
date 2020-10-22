import Model.Player;

import java.util.ArrayList;
import java.util.Collections;

public class Printer {
    public static void printPlayerList(ArrayList<Player> players, Player player) {
        Collections.sort(players);
        for (int i = 0; i < players.size(); i++) {
            System.out.print(" Place: " + (i + 1) + ", ");
            if (players.get(i).equals(player)) {
                System.out.println("(you) " + players.get(i).toString());
            } else {
                System.out.println(players.get(i).toString());
            }
            System.out.println();
        }
    }

    public static void printStats(ArrayList<Player> players) {
        Collections.sort(players);
        for (int i = 0; i < players.size(); i++) {
            System.out.print(" Place: " + (i + 1) + ", ");
            System.out.println(players.get(i).toString());
            System.out.println();
        }
    }
}
