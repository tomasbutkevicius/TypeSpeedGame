package Creator;

public class SentenceFactory {
    private String sentences;
    private Generator sentenceGenerator;

    public SentenceFactory(SentenceGenerator sentenceGenerator) {
        this.sentenceGenerator = sentenceGenerator;
        this.sentences = "";
    }

    public String getSentences(int sentenceCount) {
        while (sentenceCount != 0) {
            this.sentences += sentenceGenerator.generateString();
            sentenceCount = sentenceCount - 1;
        }
        return sentences;
    }
}
