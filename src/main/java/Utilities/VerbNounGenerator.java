package Utilities;

import java.util.Random;

public class VerbNounGenerator extends SentenceGenerator {
    private String[] Nouns = getNouns();
    private String[] Verbs = getVerbs();

    @Override
    public String generateString() {
        Random randNum = new Random();
        int Verb = randNum.nextInt(Verbs.length);
        int Noun = randNum.nextInt(Nouns.length);

        return Verbs[Verb] + " " + Nouns[Noun] + ". ";
    }
}
