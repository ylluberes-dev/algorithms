import java.util.ArrayList;
import java.util.List;

public class KeyboardRow {

    private static final char[] ROW_1 = "qwertyuiop".toCharArray();
    private static final char[] ROW_2 = "asdfghjkl".toCharArray();
    private static final char[] ROW_3 = "zxcvbnm".toCharArray();

    /**
     *
     * @param words
     * @return
     *
     * 1) Improvements.. : if you check that a character already exists, do not try to look at the row again.
     *
     */
    public String[] findWords (String[] words) {
        final List<String> ret = new ArrayList<>();
        for (String word : words) {
            if(canBeWrittenInRow(word,ROW_1)) {
                ret.add(word);
            } else if(canBeWrittenInRow(word,ROW_2)) {
                ret.add(word);
            }else if(canBeWrittenInRow(word,ROW_3)){
                ret.add(word);
            }
        }
        final String [] response = new String [ret.size()];
        ret.toArray(response);
        return response;
    }

    private boolean canBeWrittenInRow (String word, char [] row) {
        for (int i = 0; i < word.length(); i++) {
            final char current = Character.toLowerCase(word.charAt(i));
            boolean contains = false;
            for(int j = 0; j < row.length; j++) {
                if(current == Character.toLowerCase(row[j]))  {
                    contains = true;
                }
            }
            if(!contains) return false;
        }
        return true;
    }

    private static void printArr(final String [] arr) {
        for (String value: arr) {
            System.out.println(value);
        }
    }

    public static void main(String[] args) {
        final String [] testCase = {"omk"};
        printArr(new KeyboardRow().findWords(testCase));
    }
}
