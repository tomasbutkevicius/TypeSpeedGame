import java.util.Random;

public class SentenceGenerator {
    private static String Nouns[] = {
            "the plant", "an animal", "a human", "the water", "Jordan", "the tree", "the sky", "the father"
    };
    private static String Verbs[] = {
            "walks", "controls", "can't find", "swims to", "dances near", "sings to", "screams to", "looks to", "falls from"
    };

    public String getSentence() {
        Random randNum = new Random();
        int firstNoun = randNum.nextInt(Nouns.length);
        int firstVerb = randNum.nextInt(Verbs.length);
        int secondNoun = randNum.nextInt(Nouns.length);

        return Nouns[firstNoun] + " " + Verbs[firstVerb] + " " + Nouns[secondNoun] + ". ";
    }
}
