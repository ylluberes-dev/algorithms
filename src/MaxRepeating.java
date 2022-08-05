import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxRepeating {
    static class Range {
        private int start;
        private int end;

        public Range(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public void setEnd(int end) {
            this.end = end;
        }
    }

    public int maxRepeating(String sequence, String word) {
        if (word.length() > sequence.length()) return 0;
        boolean wordSame = true;
        for (int i = 0; i < word.length() - 1; i++) {
            if (word.charAt(i) != word.charAt(i + 1)) {
                wordSame = false;
                break;
            }
        }
        if (wordSame) {
            if(!sequence.contains(String.valueOf(word.charAt(0)))) return 0;
            //Count the maximun number of characters that are consecutive in sequence that are equals to word[i]
            int count = 1;
            int max = 0;
            for (int i = 0; i < sequence.length() - 1; i++) {
                if(sequence.charAt(i) == word.charAt(0)) {
                    if(sequence.charAt(i) == sequence.charAt(i + 1)){
                        count++;
                    }
                }else {
                    if(count > max)
                        max = count;
                    count = 1;
                }
            }
            if(count > max)
                max = count;
            return max / word.length();
        }


        int wordSize = word.length();
        Map<String, Range> rangeMap = new HashMap<>();
        int max = -1;
        int count = 0;
        for (int i = 0; i < sequence.length(); i++) {
            if (i + wordSize <= sequence.length()) {
                String subString = sequence.substring(i, i + wordSize);
                if (subString.equals(word)) {
                    //System.out.print(" [" + i + "," + "" + (i + wordSize) + "]");
                    if (rangeMap.containsKey(subString)) {
                        Range current = rangeMap.get(subString);
                        if ((current.start + wordSize == i) && (current.end + wordSize == i + wordSize)) {
                            current.setStart(i);
                            current.setEnd(i + wordSize);
                        } else {
                            count = 0;
                            if (count > max) {
                                max = count;
                            }
                            rangeMap.put(subString, new Range(i, i + wordSize));
                        }
                    } else {
                        rangeMap.put(subString, new Range(i, i + wordSize));
                    }
                    count += wordSize;
                }

            }
            if (count > max)
                max = count;
        }
        return max / wordSize;
    }


    public static void main(String[] args) {
        System.out.println(new MaxRepeating().maxRepeating("caaaa", "a"));
    }

}
