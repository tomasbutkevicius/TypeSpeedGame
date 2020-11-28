public class GrammarChecker {
    public static Double getAccuracy(String givenWords, String typedWords) {
        String[] givenWordsArray = givenWords.split("\\s");
        String[] typedWordsArray = givenWords.split("\\s");

        Double mistakes = 0.0;
        int length;
        System.out.println(givenWordsArray.length);
        System.out.println(typedWordsArray.length);

        if (givenWordsArray.length >= typedWordsArray.length) {
            length = typedWordsArray.length;
            mistakes = (double) typedWordsArray.length - length;
        } else {
            length = typedWordsArray.length;
        }

        for (int i = 0; i < length; i++) {
            if (!givenWordsArray[i].equalsIgnoreCase(typedWordsArray[i])) {
                mistakes += 1.0;
            }
        }
        return ((double) givenWordsArray.length - mistakes) * 100D / givenWordsArray.length;
    }
}
