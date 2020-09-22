import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) {
        SentenceGenerator sentenceGenerator = new SentenceGenerator();

        String sentence = sentenceGenerator.getSentence();

        System.out.println(sentence);

        TimeWatch watch = TimeWatch.start();
        Scanner scanner = new Scanner(System.in);
        String typedWords = scanner.nextLine();

        long passedTimeInMs = watch.time();
        long passedTimeInSeconds = watch.time(TimeUnit.SECONDS);
        System.out.println("Here are your milliseconds");
        System.out.println(passedTimeInMs);
    }
}
