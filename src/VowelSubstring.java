import java.util.Arrays;
import java.util.List;

public class VowelSubstring {

    private static final List<Character> vowels = Arrays.asList('a','e','i','o','u');
    public int countVowelSubstrings(String word) {

        int index = 0;
        while(index < word.length()) {
            char current = word.charAt(index);

        }
        return 0;
    }

    private boolean isVowel (final char value) {
        return vowels.contains(value);
    }


    public static void main(String[] args) {
        System.out.println(new VowelSubstring().countVowelSubstrings("aeiouu"));
    }
}
