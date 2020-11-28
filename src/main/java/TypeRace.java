import Controller.PlayerController;
import Creator.SentenceFactory;
import Creator.SentenceGenerator;
import Model.Leaderboard;
import Model.Player;
import Model.Race;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class TypeRace extends Race {
    private int sentenceCount;
    private Leaderboard leaderboard;
    private SentenceGenerator sentenceGenerator;

    public TypeRace(int sentenceCount, Leaderboard leaderboard, SentenceGenerator sentenceGenerator) {
        this.sentenceCount = sentenceCount;
        this.leaderboard = leaderboard;
        this.sentenceGenerator = sentenceGenerator;
    }

    public void start(){
        List<Player> players = leaderboard.getPlayers();
        Player player = PlayerController.createPlayer(players);
        if(player == null){
            return;
        }
        Scanner scanner = new Scanner(System.in);


        SentenceFactory sentenceFactory = new SentenceFactory(sentenceGenerator);
        String sentences = sentenceFactory.getSentences(sentenceCount);

        String[] givenWords = sentences.split("\\s");

        System.out.println(sentences);

        System.out.println();
        System.out.println("Repeat:");

        handleUserInput(players, player, scanner, givenWords);
    }

    private void handleUserInput(List<Player> players, Player player, Scanner scanner, String[] givenWords) {
        TimeWatch watch = TimeWatch.start();
        String input = scanner.nextLine();
        Long seconds = watch.time(TimeUnit.SECONDS);
        String[] typedWords = input.split("\\s");

        Double accuracy = GrammarChecker.getAccuracy(givenWords, typedWords);
        final DecimalFormat df = new DecimalFormat("#0.00");
        accuracy = Double.parseDouble(df.format(accuracy));
        if(accuracy < 30){
            System.out.println("Accuracy was less than 50%. Player disqualified");
            PlayerController.removePlayerFromList(players, player);
        } else {
            Long wordsPerMinute = (givenWords.length * 60) / seconds;
            player.setWordsPerMinute(wordsPerMinute);
            player.setAccuracy(accuracy);
            Printer.printPlayerList(leaderboard, player);
        }
        System.out.println("Enter any key to continue...");
        scanner.nextLine();
    }
}
