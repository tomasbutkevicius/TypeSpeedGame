import Model.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static void launch(ArrayList<Player> players) {
        Scanner scanner = new Scanner(System.in);
        String command = "";
        while (!command.equals("exit")) {
            System.out.println("\nPlease choose an action:\n"
                    + "\t start - start game.\n"
                    + "\t stats - see information about players\n"
                    + "\t exit - exit system\n"
            );
            command = scanner.next();

            switch (command) {
                case "start":
                    Race.start(players);
                    break;
                case "stats":
                    Printer.printStats(players);
                    break;
                case "exit":
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

