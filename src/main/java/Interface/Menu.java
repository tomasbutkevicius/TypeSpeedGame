package Interface;

import Interface.Controller.PlayerController;
import Utilities.Caretaker;
import Utilities.Originator;
import Utilities.SentenceGenerator;
import Model.*;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private Leaderboard leaderboard;
    private Caretaker caretaker;
    private Originator originator;
    private int currentPlayers;
    private PlayerController playerController;

    public Menu(Leaderboard leaderboard, Caretaker caretaker, Originator originator, PlayerController playerController) {
        this.leaderboard = leaderboard;
        this.caretaker = caretaker;
        this.originator = originator;
        this.playerController = playerController;
    }

    public void launch() throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        String command = "";

        while (!command.equals("exit")) {
            printMenuInformation();
            command = scanner.next();

            if (isValidCommand(command))
                switch (MenuCommand.valueOf(command.toUpperCase())) {
                    case START:
                        Race typeRace = new TypeRace(4, leaderboard, playerController);
                        typeRace.start();
                        break;
                    case STATS:
                        StatisticsPrinter.printStats(leaderboard);
                        break;
                    case SAVE:
                        ObjectIO.WriteObjectToFile(leaderboard);
                        break;
                    case LOAD:
                        handleLoadAction();
                        break;
                    case UNDO:
                        handleUndo();
                        break;
                    case EXIT:
                        break;
                }
            else System.out.println("Invalid command");
        }
    }

    private void handleUndo() {
        if (currentPlayers >= 1) {
            currentPlayers--;
            List<Player> players = originator.restoreFromMemento(caretaker.getMemento(currentPlayers));
            leaderboard.setPlayers(players);
            System.out.println("Loaded previous state");
        } else {
            System.out.println("No previous states");
        }
    }

    private void handleLoadAction() throws IOException, ClassNotFoundException {
        originator.set(leaderboard.getPlayers());

        caretaker.addMemento(originator.storeInMemento());

        currentPlayers++;
        leaderboard = ObjectIO.readObjectFromFile(leaderboard);
    }

    private static void printMenuInformation() {
        System.out.println("\nPlease choose an action:\n"
                + "\t start - start game.\n"
                + "\t stats - see information about players\n"
                + "\t save - save leaderboard to file\n"
                + "\t load - load leaderboard from file\n"
                + "\t undo - undo leaderboard\n"
                + "\t exit - exit system\n"
        );
    }

    public static boolean isValidCommand(String test) {

        for (MenuCommand c : MenuCommand.values()) {
            if (c.name().equals(test.toUpperCase())) {
                return true;
            }
        }

        return false;
    }
}

