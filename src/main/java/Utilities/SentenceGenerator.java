package Utilities;

import java.util.Random;

public class SentenceGenerator implements StringGenerator {
    private static final String Nouns[] = {
            "the plant", "an animal", "a human", "the water", "Jordan", "the tree", "the sky", "the father"
    };
    private static final String Verbs[] = {
            "walks", "controls", "can't find", "swims to", "dances near", "sings to", "screams to", "looks to", "falls from"
    };

    @Override
    public String generateString() {
        Random randNum = new Random();
        int firstNoun = randNum.nextInt(Nouns.length);
        int firstVerb = randNum.nextInt(Verbs.length);
        int secondNoun = randNum.nextInt(Nouns.length);

        return Nouns[firstNoun] + " " + Verbs[firstVerb] + " " + Nouns[secondNoun] + ". ";
    }

    public static String[] getNouns() {
        return Nouns;
    }

    public static String[] getVerbs() {
        return Verbs;
    }
}
