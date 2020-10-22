import Model.Leaderboard;
import Model.Player;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static void launch(Leaderboard leaderboard) throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        String command = "";
        while (!command.equals("exit")) {
            System.out.println("\nPlease choose an action:\n"
                    + "\t start - start game.\n"
                    + "\t stats - see information about players\n"
                    + "\t save - save leaderboard\n"
                    + "\t load - load last save\n"
                    + "\t exit - exit system\n"
            );
            command = scanner.next();

            switch (command) {
                case "start":
                    Race.start(leaderboard);
                    break;
                case "stats":
                    Printer.printStats(leaderboard);
                    break;
                case "save":
                    ObjectIO.WriteObjectToFile(leaderboard);
                    break;
                case "load":
                    ObjectIO.readObjectFromFile(leaderboard);
                    break;
                case "exit":
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

