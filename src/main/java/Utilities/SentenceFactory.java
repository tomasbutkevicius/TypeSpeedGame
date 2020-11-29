package Utilities;

public class SentenceFactory {
    private String sentences;
    private StringGenerator sentenceStringGenerator;

    public SentenceFactory(StringGenerator sentenceStringGenerator) {
        this.sentenceStringGenerator = sentenceStringGenerator;
        this.sentences = "";
    }

    public String getSentences(int sentenceCount) {
        while (sentenceCount > 0) {
            this.sentences += sentenceStringGenerator.generateString();
            sentenceCount = sentenceCount - 1;
        }
        return sentences;
    }
}
