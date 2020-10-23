import java.util.ArrayList;
import java.util.List;

public class GrammarChecker {
    public static Double getAccuracy(List<String> givenWords, ArrayList<String> typedWords){
        Double mistakes = 0.0;
        for(int i = 0; i < givenWords.size(); i++){
            try {
                if(!givenWords.get(i).equalsIgnoreCase(typedWords.get(i))){
                    mistakes += 1.0;
                }
            } catch (IndexOutOfBoundsException outOfBounds){ //TODO no exception
                System.out.println("You have entered not enough words");
                return 0D;
            }
        }
        return ((double)givenWords.size() - mistakes)*100D / givenWords.size();
    }
}
