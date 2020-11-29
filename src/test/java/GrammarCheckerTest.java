import Utilities.GrammarChecker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrammarCheckerTest {

    @Test
    public void shouldGetMaxAccuracy(){
        GrammarChecker grammarChecker = new GrammarChecker("this is a test", "this is a test");
        Double accuracy = grammarChecker.getAccuracy();
        assertEquals(100D, accuracy);
    }

    @Test
    public void shouldGetHalfAccuracy(){
        GrammarChecker grammarChecker = new GrammarChecker("this is e ve", "this is a test");
        Double accuracy = grammarChecker.getAccuracy();

        assertEquals(50D, accuracy);
    }

    @Test
    public void shouldGetThirdAccuracy(){
        GrammarChecker grammarChecker = new GrammarChecker("this is e", "this");
        Double accuracy = grammarChecker.getAccuracy();

        Double expected = 1/3D*100D;
        assertEquals(Math.round(expected), Math.round(accuracy));
    }

}