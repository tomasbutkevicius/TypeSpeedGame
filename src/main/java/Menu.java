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
            printMenuInformation();
            command = scanner.next();
            leaderboard = handleUserAction(leaderboard, command);
        }
    }

    private static Leaderboard handleUserAction(Leaderboard leaderboard, String command) throws IOException, ClassNotFoundException {
        if(command.equalsIgnoreCase("exit")){
            System.exit(0);
        }
        try {
            leaderboard = MenuCommand.valueOf(command.toUpperCase()).execute(leaderboard);
        } catch (IllegalArgumentException exp){
            System.out.println("Invalid command");
        }
        return leaderboard;
    }

    private static void printMenuInformation() {
        System.out.println("\nPlease choose an action:\n"
                + "\t start - start game.\n"
                + "\t stats - see information about players\n"
                + "\t save - save leaderboard\n"
                + "\t load - load last save\n"
                + "\t exit - exit system\n"
        );
    }
}

