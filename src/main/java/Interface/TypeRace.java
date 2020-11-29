package Interface;

import Interface.Controller.PlayerController;
import Utilities.*;
import Model.Leaderboard;
import Model.Player;
import Model.Race;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class TypeRace extends Race {
    private int sentenceCount;
    private Leaderboard leaderboard;
    private StringGenerator stringGenerator;
    private PlayerController playerController;

    public TypeRace(int sentenceCount, Leaderboard leaderboard, PlayerController playerController) {
        this.sentenceCount = sentenceCount;
        this.leaderboard = leaderboard;
        this.playerController = playerController;
    }

    public void start() {
        List<Player> playerList = leaderboard.getPlayers();
        Player player = playerController.createPlayer(playerList);
        if (player == null) {
            return;
        }

        if(Math.random() < 0.5) {
            stringGenerator = new SentenceGenerator();
        } else {
            stringGenerator = new VerbNounGenerator();
        }

        SentenceFactory sentenceFactory = new SentenceFactory(stringGenerator);

        String givenWords = sentenceFactory.getSentences(sentenceCount);
        printStart(givenWords);
        handleUserInput(playerList, player, givenWords);
    }

    private void printStart(String givenWords) {
        System.out.println(givenWords);

        System.out.println();
        System.out.println("Repeat:");
    }

    private void handleUserInput(List<Player> playerList, Player player, String givenWords) {
        Scanner scanner = new Scanner(System.in);
        TimeWatch watch = TimeWatch.start();
        String typedWords = scanner.nextLine();
        Long seconds = watch.time(TimeUnit.SECONDS);

        GrammarChecker grammarChecker = new GrammarChecker(givenWords, typedWords);
        Double accuracy = grammarChecker.getAccuracy();

        evaluatePlayer(playerList, player, givenWords, seconds, accuracy);

        System.out.println("Enter any key to continue...");
        scanner.nextLine();
    }

    private void evaluatePlayer(List<Player> playerList, Player player, String givenWords, Long seconds, Double accuracy) {
        final DecimalFormat df = new DecimalFormat("#0.00");
        accuracy = Double.parseDouble(df.format(accuracy));

        if (accuracy < 50) {
            disqualifyPlayer(playerList, player);
            System.out.println("Accuracy was less than 50%. Player disqualified");
        } else {
            updatePlayer(player, givenWords, seconds, accuracy);
            StatisticsPrinter.printPlayerInLeaderboard(leaderboard, player);
        }
    }

    private void updatePlayer(Player player, String givenWords, Long seconds, Double accuracy) {
        String[] givenWordsArray = givenWords.split("\\s");
        Long wordsPerMinute = (givenWordsArray.length * 60) / seconds;
        player.setWordsPerMinute(wordsPerMinute);
        player.setAccuracy(accuracy);
    }

    private void disqualifyPlayer(List<Player> playerList, Player player) {
        PlayerController playerController = new PlayerController();
        playerController.removePlayerFromList(playerList, player);
    }
}
