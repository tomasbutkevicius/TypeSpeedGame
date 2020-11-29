public class GrammarChecker {
    private int mistakeCount;
    private String[] givenStringArray;
    private String[] typedStringArray;
    private Double accuracy;

    public GrammarChecker(String givenString, String typedString) {
        this.givenStringArray = givenString.split("\\s");
        this.typedStringArray = typedString.split("\\s");
        this.mistakeCount = calculateMistakeCount();
        this.accuracy = calculateAccuracy();
    }

    public Double getAccuracy() {
        return this.accuracy;
    }

    public int getMistakeCount(){
        return mistakeCount;
    }

    private Double calculateAccuracy() {
        return ((double) givenStringArray.length - mistakeCount) * 100D / givenStringArray.length;
    }

    private int calculateMistakeCount() {
        int mistakes = 0;
        if (givenStringArray.length > typedStringArray.length)
            mistakes = givenStringArray.length - typedStringArray.length;

        int shorterLength = getLengthOfShorter(givenStringArray, typedStringArray);
        for (int i = 0; i < shorterLength; i++) {
            if (!givenStringArray[i].equalsIgnoreCase(typedStringArray[i])) {
                mistakes += 1.0;
            }
        }
        return mistakes;
    }

    private int getLengthOfShorter(String[] arrayA, String[] arrayB) {
        if (arrayA.length >= arrayB.length) {
            return arrayB.length;
        }
        return arrayA.length;
    }

}
