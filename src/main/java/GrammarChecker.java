import java.util.ArrayList;
import java.util.List;

public class GrammarChecker {
    public static Double getAccuracy(List<String> givenWords, ArrayList<String> typedWords){
        Double mistakes = 0.0;
        int length;

        if(givenWords.size() >= typedWords.size()){
            length = typedWords.size();
            mistakes = (double)givenWords.size() - length;
        } else {
            length = givenWords.size();
        }

        for(int i = 0; i < length; i++){
                if(!givenWords.get(i).equalsIgnoreCase(typedWords.get(i))){
                    mistakes += 1.0;
                }
        }
        return ((double)givenWords.size() - mistakes)*100D / givenWords.size();
    }
}
