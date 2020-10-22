import java.util.ArrayList;

public class GrammarChecker {
    public static Double getAccuracy(ArrayList<String> givenWords, ArrayList<String> typedWords){
        Double mistakes = 0.0;
        for(int i = 0; i < givenWords.size(); i++){
            try {
                if(!givenWords.get(i).equalsIgnoreCase(typedWords.get(i))){
                    mistakes += 1.0;
                }
            } catch (IndexOutOfBoundsException outOfBounds){
                System.out.println("You have entered not enough words");
                return 0D;
            }
        }
        return ((double)givenWords.size() - mistakes)*100 / givenWords.size();
    }
}
