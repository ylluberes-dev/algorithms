public class DetectCapital {


    enum WordType {
        CAPITAL,
        NONCAPITAL,
        MERGE

    }
    public boolean detectCapitalUse(String word) {
        if(word.length() == 1) return true;
        final char firstLetter = word.charAt(0);
        if(Character.isUpperCase(firstLetter)) {
                final char secondLetter = word.charAt(1);
                if(Character.isUpperCase(secondLetter)) {
                    if(word.length() == 2) return true;
                    if(getRemainingType(2,word).equals(WordType.CAPITAL)) return true;
                } else {
                    if(word.length() == 2) return true;
                    if(getRemainingType(2,word).equals(WordType.NONCAPITAL)) return true;
                }
        } else {
            if(getRemainingType(1,word).equals(WordType.NONCAPITAL)) return true;
        }
        return false;
    }
    private WordType getRemainingType (final int startAt, final String remaining) {
        int capitalCount = 0;
        int nonCapitalCount = 0;
        for (int i = startAt; i < remaining.length(); i++) {
            if(Character.isUpperCase(remaining.charAt(i))) {
                capitalCount ++;
            } else {
                nonCapitalCount ++;
            }
        }

        if(capitalCount == remaining.length() - startAt) return WordType.CAPITAL;
        if(nonCapitalCount == remaining.length() - startAt) return WordType.NONCAPITAL;
        return WordType.MERGE;
    }

    public static void main(String[] args) {
        System.out.println(new DetectCapital().detectCapitalUse("USA"));
        System.out.println(new DetectCapital().detectCapitalUse("Ca"));
        System.out.println(new DetectCapital().detectCapitalUse("FlaG"));
    }
}
