import Controller.PlayerController;
import Model.Player;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) {
        SentenceGenerator sentenceGenerator = new SentenceGenerator();
        ArrayList<Player> playerList = getPlayers();
        System.out.println("Enter your name");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        Player player = new Player(name);

        if (PlayerController.getPlayerByName(playerList, name) != null) {
            player = PlayerController.getPlayerByName(playerList, name);
        } else {
            playerList.add(player);
        }


//        long passedTimeInSeconds = watch.time(TimeUnit.SECONDS);
        String typedWords;
        String sentence;

        Integer totalWords = 0;
        Long seconds = 0L;
        int repeat = 4;


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
        typedWords = scanner.nextLine();
        seconds = watch.time(TimeUnit.SECONDS);
        System.out.println("total words: " + totalWords);
        Long wordsPerMinute = (totalWords * 60) / seconds;
        player.setWordsPerMinute(wordsPerMinute);


        for (Player playerFromList : playerList) {
            if (playerFromList.equals(player)) {
                System.out.println("------------");
                System.out.println(playerFromList.toString());
                System.out.println("------------");
            } else {
                System.out.println(playerFromList.toString());
            }
        }
    }

    public static ArrayList<Player> getPlayers() {
        ArrayList<Player> players = new ArrayList<Player>();
        File file = new File("players.txt");

        if (file.exists() && !file.isDirectory()) {
            getPlayersFromFile(players, file);
        } else {
            generatePlayers(players);
        }
        return players;
    }

    private static void generatePlayers(ArrayList<Player> players) {
        String[] names = {"Smith", "proGamer3000", "Jordon", "Rambo", "Stallone" };
        Long[] wordsPerMinute = {151L, 182L, 140L, 163L, 138L};

        for (int i = 0; i < names.length; i++) {
            players.add(new Player(names[i], wordsPerMinute[i]));
        }
    }

    private static void getPlayersFromFile(ArrayList<Player> players, File file) {
        Scanner scanner = null;
        String line;
        try {
            scanner = new Scanner(file);
            while (scanner.hasNext()) {
                line = scanner.nextLine();
                String[] data = line.split("\\s");
                String name = data[0];
                Long wordsPerMinute = Long.parseLong(data[1]);
                Player player = new Player(name, wordsPerMinute);
                players.add(player);
            }
        } catch (Exception error) {
            System.out.println("Klaida");
            error.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
