import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrammarCheckerTest {

    @Test
    public void shouldGetMaxAccuracy(){
        Double accuracy = GrammarChecker.getAccuracy("this is a test", "this is a test");
        assertEquals(100D, accuracy);
    }

}