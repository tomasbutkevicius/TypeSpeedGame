import Creator.SentenceFactory;
import Creator.SentenceGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SentenceFactoryTest {

    @Test
    public void shouldGetTenSentences(){
        SentenceFactory sentenceFactory = new SentenceFactory(new SentenceGenerator());
        String[] sentences = sentenceFactory.getSentences(10).split("\\. ");

        assertEquals(10, sentences.length);
    }
}
