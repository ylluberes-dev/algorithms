import java.util.HashMap;
import java.util.Map;

public class CloseStrings {

    static class Frequency {
        private int frequency;
        private boolean available;

        public Frequency(int frequency, boolean available) {
            this.frequency = frequency;
            this.available = available;
        }

        public int getFrequency() {
            return frequency;
        }

        public boolean isAvailable() {
            return available;
        }

        public void setFrequency(int frequency) {
            this.frequency = frequency;
        }

        public void setAvailable(boolean available) {
            this.available = available;
        }
    }

    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        Map<Character, Frequency> aFrequencies = computeFrequencies(word1);
        Map<Character, Frequency> bFrequencies = computeFrequencies(word2);
        for (Character aKey : aFrequencies.keySet()) {
            boolean match = false;
            // If the word b does not contains the N(th) character of a, words does not are close
            if (!bFrequencies.containsKey(aKey)) {
                return false;
            } else {
                Frequency aFrequency = aFrequencies.get(aKey);
                for (Character bKey : bFrequencies.keySet()) {
                    // If there is a character with the same number of
                    // occurrences and is available (not compared yey)
                    Frequency bFrequency = bFrequencies.get(bKey);
                    if (aFrequency.frequency == bFrequency.frequency && bFrequency.isAvailable()) {
                        match = true;
                        bFrequency.setAvailable(false);
                        break;
                    }
                }
            }
            if(!match) return false;
        }
        return true;
    }

    private Map<Character, Frequency> computeFrequencies(String word) {
        final Map<Character, Frequency> frequencies = new HashMap<>();
        final int wordSize = word.length();
        for (int i = 0; i < wordSize; i++) {
            char current = word.charAt(i);
            if (frequencies.containsKey(current)) {
                Frequency existing = frequencies.get(current);
                existing.setFrequency(existing.getFrequency() + 1);
                frequencies.replace(current, existing);
            } else {
                frequencies.put(current, new Frequency(1, true));
            }
        }
        return frequencies;
    }

    public static void main(String[] args) {
        System.out.println("Output test case #1: ");
        System.out.println(new CloseStrings().closeStrings("abc", "bca"));
        System.out.println();

        System.out.println("Output test case #2: ");
        System.out.println(new CloseStrings().closeStrings("a", "aa"));
        System.out.println();

        System.out.println("Output test case #3: ");
        System.out.println(new CloseStrings().closeStrings("cabbba", "abbccc"));
        System.out.println();

        System.out.println("Output test case #4: ");
        System.out.println(new CloseStrings().closeStrings("cabbba", "aabbss"));
        System.out.println();
    }
}
