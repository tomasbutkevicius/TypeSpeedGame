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
        int repeat = 4;
        ArrayList<String> givenWords = new ArrayList<>();

        SentenceGenerator sentenceGenerator = new SentenceGenerator();
        while (repeat != 0) {
            sentence = sentenceGenerator.getSentence();
            System.out.print(sentence.substring(0, 1).toUpperCase() + sentence.substring(1));

            String[] words = sentence.split("\\s");
            totalWords += words.length;
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
        System.out.println(seconds);
        String[] typedWords = input.split("\\s");

        System.out.println("given WORDS:");
        for(int i = 0; i < givenWords.size(); i++){
            System.out.print(givenWords.get(i) + " ");
        }
        System.out.println("typed WORDS:");
        for(int i = 0; i < typedWords.length; i++){
            System.out.print(typedWords[i] + " ");
        }

        Long wordsPerMinute = (totalWords * 60) / seconds;
        player.setWordsPerMinute(wordsPerMinute);

        Printer.printPlayerList(players, player);

        System.out.println("Enter any key to continue...");
        scanner.nextLine();
        return true;
    }
}
