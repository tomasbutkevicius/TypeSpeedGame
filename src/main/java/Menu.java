import Creator.SentenceGenerator;
import Model.Leaderboard;
import Model.Race;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public static void launch(Leaderboard leaderboard) throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        String command = "";

        while (!command.equals("exit")) {
            printMenuInformation();
            command = scanner.next();

            if(validateCommand(command))
                switch (MenuCommand.valueOf(command.toUpperCase())){
                    case START:
                        Race typeRace = new TypeRace(4, leaderboard, new SentenceGenerator());
                        typeRace.start();
                        break;
                    case STATS:
                        Printer.printStats(leaderboard);
                        break;
                    case SAVE:
                        ObjectIO.WriteObjectToFile(leaderboard);
                        break;
                    case LOAD:
                        leaderboard = ObjectIO.readObjectFromFile(leaderboard);
                        break;
                    case EXIT:
                        break;
                } else System.out.println("Invalid command");
            }
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

    public static boolean validateCommand(String test) {

        for (MenuCommand c : MenuCommand.values()) {
            if (c.name().equals(test.toUpperCase())) {
                return true;
            }
        }

        return false;
    }
}

