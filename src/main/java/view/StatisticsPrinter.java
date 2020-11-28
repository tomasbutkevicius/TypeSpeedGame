package view;

import Model.Leaderboard;
import Model.Player;

import java.util.Collections;
import java.util.List;

public class StatisticsPrinter {
    public static void printPlayerList(Leaderboard leaderboard, Player player) {
        List<Player> players = leaderboard.getPlayers();
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

    public static void printStats(Leaderboard leaderboard) {
        List<Player> players = leaderboard.getPlayers();
        Collections.sort(players);
        for (int i = 0; i < players.size(); i++) {
            System.out.print(" Place: " + (i + 1) + ", ");
            System.out.println(players.get(i).toString());
            System.out.println();
        }
    }
}
