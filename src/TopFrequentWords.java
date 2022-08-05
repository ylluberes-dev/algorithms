import java.util.*;

public class TopFrequentWords {

     static class WordFrequency implements Comparable<WordFrequency> {
        String word;
        int frequency;

        public WordFrequency(String word, int frequency) {
            this.word = word;
            this.frequency = frequency;
        }

        @Override
        public int compareTo(WordFrequency o) {
            if (this.frequency == o.frequency) {
                return this.word.compareTo(o.word);
            } else {
                if (this.frequency > o.frequency) {
                    return -1;
                } else {
                    return 1;
                }
            }
        }
    }

    public List<String> topKFrequent(String[] words, int k) {

        List<WordFrequency> output = new ArrayList<>();
        List<String> result = new ArrayList<>();
        Map<String, Integer> counter = new HashMap<>();
        //Counting the frequencies of the words
        for (String word : words) {
            counter.put(word, counter.getOrDefault(word, 0) + 1);
        }

        for (int i = 1; i <= k; i++) {
            int max = 0;
            int frequency = 0;
            for (String wordKey : counter.keySet()) {
                frequency = counter.get(wordKey);
                if (frequency > max) {
                    max = frequency;
                }
            }
            List<String> removable = new ArrayList<>();
            for (String wordKey: counter.keySet()){
                if(counter.get(wordKey) == max){
                    removable.add(wordKey);
                    output.add(new WordFrequency(wordKey,max));
                }
            }

            for(String toDelete: removable){
                counter.remove(toDelete);
            }
            removable.clear();
        }

        Collections.sort(output);

        System.out.println();
        for (int i = 0; i < k; i++){
            result.add(output.get(i).word);
        }

        return result;
    }

    public List<String> solve2 (String[] words, int k) {


         return null;
    }

    private static void printList(List<String> words) {
        if (words != null && words.size() > 0) {
            for (String word : words) {
                System.out.print(word + " ");
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("Output test case #1: ");
         printList(new TopFrequentWords().topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 1));
        System.out.println();

        System.out.println("Output test case #2: ");
        printList(new TopFrequentWords().topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));
        System.out.println();

    }
}
