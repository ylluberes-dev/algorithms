import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CountCharacters {


    /**
     * You are given an array of strings words and a string chars.
     * A string is good if it can be formed by characters from chars (each character can only be used once).
     * Return the sum of lengths of all good strings in words.
     *
     * @param words
     * @param chars
     * @return
     */
    public int countCharacters(String[] words, String chars) {
        int sumSize = 0;
        Map<Character, Integer> baseMap = storeFrequency(chars);
        for (String word : words) {
            Map<Character, Integer> eachWordMap = storeFrequency(word);
            boolean sameFrequency = true;
            for (Character wordKey : eachWordMap.keySet()) {
                if (!baseMap.containsKey(wordKey)) {
                    sameFrequency = false;
                    break;
                } else {
                    //If the base map contains the ith current-word character
                    //Now check if have the same frequencies
                    System.out.println(wordKey);
                    System.out.println("Word val: "+eachWordMap.get(wordKey));
                    System.out.println("Base map val: "+baseMap.get(wordKey));
                    if (baseMap.get(wordKey) < eachWordMap.get(wordKey)) {
                        sameFrequency = false;
                        break;
                    }
                }
            }
            if (sameFrequency)
                sumSize += word.length();

        }

        return sumSize;
    }


    private Map<Character, Integer> storeFrequency(String word) {
        Map<Character, Integer> counter = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);
            if (counter.containsKey(cur)) {
                counter.replace(cur, counter.get(cur) + 1);
            } else {
                counter.put(cur, 1);
            }
        }
        return counter;
    }



    public static void main(String[] args) {
        System.out.println(new CountCharacters().countCharacters(new String[]{"hello","world","leetcode"},"welldonehoneyr"));
    }


}
