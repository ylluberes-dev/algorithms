import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UnCommonWords
{
    public String[] uncommonFromSentences(String s1, String s2) {
        final Set<String> uncommonWords = new HashSet<>();
        final String S = s1 + " " + s2;
        addUncommonWords(S,uncommonWords);
        final String [] result = new String [uncommonWords.size()];
        int index = 0;
        for(String word: uncommonWords) {
            result[index] = word;
            index++;
        }

        return result;
    }


    private void addUncommonWords (final String sentence, final Set<String> unCommonWords) {
        final List<String> BLACK_LIST = new ArrayList<>();
        for(String word: sentence.split(" ")) {
            if(!BLACK_LIST.contains(word) && !unCommonWords.add(word)) {
                unCommonWords.remove(word);
                BLACK_LIST.add(word);
            }
        }
    }



    public static void main(String[] args) {
        final String S1 = "s z z z s";
        final String S2 = "s z ejt";
        String [] res = new UnCommonWords().uncommonFromSentences(S1,S2);
        System.out.println();

    }

    /**
     *
     * "s z z z s"
     * "s z ejt"
     */
}
