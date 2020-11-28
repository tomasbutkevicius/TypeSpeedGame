public class GrammarChecker {
    public static Double getAccuracy(String[] givenWords, String[] typedWords) {
        System.out.print("Given: ");
        for(String word: givenWords)
            System.out.print(word + " ");
        System.out.println("Typed: ");
        for(String word: typedWords)
            System.out.print(word + " ");

        Double mistakes = 0.0;
        int length;
        System.out.println(givenWords.length);
        System.out.println(typedWords.length);

        if (givenWords.length >= typedWords.length) {
            length = typedWords.length;
            mistakes = (double) givenWords.length - length;
        } else {
            length = givenWords.length;
        }

        for (int i = 0; i < length; i++) {
            if (!givenWords[i].equalsIgnoreCase(typedWords[i])) {
                mistakes += 1.0;
            }
        }
        return ((double) givenWords.length - mistakes) * 100D / givenWords.length;
    }
}
