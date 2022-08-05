import java.util.*;

public class MaxFreq {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {

        List<String> candidates = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {

            if (i + minSize <= s.length()) {
                candidates.add(s.substring(i, i + minSize));
            }
            if (maxSize != minSize) {
                if (i + minSize + (maxSize - minSize) <= s.length()) {
                    candidates.add(s.substring(i, i + minSize + (maxSize - minSize)));
                }
            }
        }

        Map<String, Integer> subStringCounter = new HashMap<>();
        for (String candidate : candidates) {
            Set<Character> letterCounter = new HashSet<>();
            boolean valid = true;
            for (int i = 0; i < candidate.length(); i++) {
                char value = candidate.charAt(i);

                letterCounter.add(value);
                if (letterCounter.size() > maxLetters)
                    valid = false;
            }
            if (valid) {
                if (subStringCounter.containsKey(candidate)) {
                    subStringCounter.replace(candidate, subStringCounter.get(candidate) + 1);
                } else {
                    subStringCounter.put(candidate, 1);
                }
            }
        }
        if(subStringCounter.size() == 0) return 0;
        int maxRepeating = subStringCounter.
                entrySet().
                stream().
                max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getValue();

        return maxRepeating;
    }

    public static void main(String[] args) {

        /**
         * Input: s = "aababcaab", maxLetters = 2, minSize = 3, maxSize = 4
         * Output: 2
         * Explanation: Substring "aab" has 2 ocurrences in the original string.
         * It satisfies the conditions, 2 unique letters and size 3 (between minSize and maxSize).
         */
        String S = "abcde";
        int maxLetters = 2;
        int minSize = 3;
        int maxSize = 3;
        System.out.println(new MaxFreq().maxFreq(S, maxLetters, minSize, maxSize));
    }
}
