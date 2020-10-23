import Controller.PlayerController;
import Model.Leaderboard;
import Model.Player;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Race {
    public static Boolean start(Leaderboard leaderboard){
        ArrayList<Player> players = leaderboard.getPlayers();
        Player player = PlayerController.createPlayer(players);
        if(player == null){
            return false;
        }
        Scanner scanner = new Scanner(System.in);
        String sentence;
        int repeat = 4;
        ArrayList<String> givenWords = new ArrayList<>();
        SentenceGenerator sentenceGenerator = new SentenceGenerator();
        while (repeat != 0) {
            sentence = sentenceGenerator.getSentence();
            System.out.print(sentence.substring(0, 1).toUpperCase() + sentence.substring(1));

            String[] words = sentence.split("\\s");
            for(String word: words){
                givenWords.add(word);
            }
            repeat = repeat - 1;
        }

        System.out.println();
        System.out.println("Repeat:");

        TimeWatch watch = TimeWatch.start();
        String input = scanner.nextLine();
        Long seconds = watch.time(TimeUnit.SECONDS);
        ArrayList<String> typedWords = new ArrayList(Arrays.asList(input.split("\\s")));

        Double accuracy = GrammarChecker.getAccuracy(givenWords, typedWords);
        final DecimalFormat df = new DecimalFormat("#0.00");
        accuracy = Double.parseDouble(df.format(accuracy));
        if(accuracy < 30){
            System.out.println("Accuracy was less than 50%. Player disqualified");
            PlayerController.removePlayerFromList(players, player);
        } else {
            Long wordsPerMinute = (givenWords.size() * 60) / seconds;
            player.setWordsPerMinute(wordsPerMinute);
            player.setAccuracy(accuracy);
            Printer.printPlayerList(leaderboard, player);
        }
        System.out.println("Enter any key to continue...");
        scanner.nextLine();
        return true;
    }
}
