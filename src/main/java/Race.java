import Controller.PlayerController;
import Model.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Race {
    public static Boolean start(ArrayList<Player> players){

        Player player = PlayerController.createPlayer(players);

        if(player == null){
            return false;
        }

        Scanner scanner = new Scanner(System.in);

        String sentence;
        Integer totalWords = 0;
        Long seconds = 0L;
        int repeat = 4;

        SentenceGenerator sentenceGenerator = new SentenceGenerator();
        while (repeat != 0) {
            String[] words;
            sentence = sentenceGenerator.getSentence();
            System.out.print(sentence.substring(0, 1).toUpperCase() + sentence.substring(1));
            words = sentence.split("\\s");
            totalWords += words.length;
            repeat = repeat - 1;
        }

        System.out.println();
        System.out.println("Repeat:");
        TimeWatch watch = TimeWatch.start();
        String typedWords = scanner.nextLine();
        seconds = watch.time(TimeUnit.SECONDS);
        System.out.println("total words: " + totalWords);
        Long wordsPerMinute = (totalWords * 60) / seconds;
        player.setWordsPerMinute(wordsPerMinute);
        Printer.printPlayerList(players, player);
        System.out.println("Enter any key to continue...");
        scanner.nextLine();
        return true;
    }
}
