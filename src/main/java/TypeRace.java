import Controller.PlayerController;
import Model.Leaderboard;
import Model.Player;
import Model.Race;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class TypeRace extends Race {
    private int sentenceCount;
    private Leaderboard leaderboard;
    private SentenceGenerator sentenceGenerator = new SentenceGenerator();

    public TypeRace(int sentenceCount, Leaderboard leaderboard) {
        this.sentenceCount = sentenceCount;
        this.leaderboard = leaderboard;
    }

    public void start(){
        ArrayList<Player> players = leaderboard.getPlayers();
        Player player = PlayerController.createPlayer(players);
        if(player == null){
            return;
        }
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> givenWords = new ArrayList<>();

        createSentences(givenWords);

        System.out.println();
        System.out.println("Repeat:");

        handleUserInput(players, player, scanner, givenWords);
    }

    private void handleUserInput(ArrayList<Player> players, Player player, Scanner scanner, ArrayList<String> givenWords) {
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
    }

    private void createSentences(ArrayList<String> givenWords) {
        while (sentenceCount != 0) {
            String sentence = sentenceGenerator.getSentence();
            System.out.print(sentence.substring(0, 1).toUpperCase() + sentence.substring(1));

            String[] words = sentence.split("\\s");
            for(String word: words){
                givenWords.add(word);
            }
            sentenceCount = sentenceCount - 1;
        }
    }
}
