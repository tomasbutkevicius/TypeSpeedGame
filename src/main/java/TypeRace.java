import Controller.PlayerController;
import Creator.SentenceFactory;
import Creator.SentenceGenerator;
import Model.Leaderboard;
import Model.Player;
import Model.Race;
import view.StatisticsPrinter;

import java.text.DecimalFormat;
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
        List<Player> playerList = leaderboard.getPlayers();
        Player player = PlayerController.createPlayer(playerList);
        if(player == null){
            return;
        }
        Scanner scanner = new Scanner(System.in);


        SentenceFactory sentenceFactory = new SentenceFactory(sentenceGenerator);
        String sentences = sentenceFactory.getSentences(sentenceCount);

        System.out.println(sentences);

        System.out.println();
        System.out.println("Repeat:");

        handleUserInput(playerList, player, scanner, sentences);
    }

    private void handleUserInput(List<Player> playerList, Player player, Scanner scanner, String givenWords) {
        TimeWatch watch = TimeWatch.start();
        String typedWords = scanner.nextLine();
        Long seconds = watch.time(TimeUnit.SECONDS);

        Double accuracy = GrammarChecker.getAccuracy(givenWords, typedWords);
        final DecimalFormat df = new DecimalFormat("#0.00");
        accuracy = Double.parseDouble(df.format(accuracy));
        if(accuracy < 30){
            System.out.println("Accuracy was less than 50%. Player disqualified");
            PlayerController.removePlayerFromList(playerList, player);
        } else {
            String[] givenWordsArray = givenWords.split("\\s");
            Long wordsPerMinute = (givenWordsArray.length * 60) / seconds;
            player.setWordsPerMinute(wordsPerMinute);
            player.setAccuracy(accuracy);
            StatisticsPrinter.printPlayerList(leaderboard, player);
        }
        System.out.println("Enter any key to continue...");
        scanner.nextLine();
    }
}
