import java.util.HashMap;
import java.util.Map;

public class MinNumberOfFrogs {
    public int minNumberOfFrogs(String croakOfFrogs) {
        final int WORD_LIMIT = 5;
        if (croakOfFrogs.length() < WORD_LIMIT)
            return -1;

        Map<Character, Integer> croakCounter = new HashMap<>();
        for (int i = 0; i < croakOfFrogs.length(); i++) {
            char letter = croakOfFrogs.charAt(i);
            if (croakCounter.containsKey(letter)) {
                croakCounter.replace(letter, croakCounter.get(letter) + 1);
            } else {
                croakCounter.put(letter, 1);
            }
        }
        int baseFrequency = croakCounter.get('c');
        for (Character letterKey : croakCounter.keySet()) {
            int frequency = croakCounter.get(letterKey);
            //All the letters should appear the same number of times in croakOfFrogs
            // to be considered as valid combination of CROAK
            if (baseFrequency != frequency)
                return -1;
        }

        for (int i = 0; i < croakOfFrogs.length(); i++) {
            char letter = croakOfFrogs.charAt(i);
                if(letter == 'c') {
                    if(!foundNextCandidate(croakOfFrogs,'r',i)){
                        return -1;
                    }
                } else if (letter == 'r') {
                    if(!foundNextCandidate(croakOfFrogs,'o',i)){
                        return -1;
                    }
                }else if (letter == 'o') {
                    if(!foundNextCandidate(croakOfFrogs,'a',i)){
                        return -1;
                    }
                }else if(letter == 'a') {
                    if(!foundNextCandidate(croakOfFrogs,'k',i)){
                        return -1;
                    }
                }
        }
        System.out.println();
        for (int i = 0; i < croakOfFrogs.length(); i++) {
            if (i + WORD_LIMIT <= croakOfFrogs.length()) {
                System.out.println(croakOfFrogs.substring(i, i + WORD_LIMIT));
                if ("croak".equals(croakOfFrogs.substring(i, i + WORD_LIMIT))) {
                    if((i+WORD_LIMIT) + WORD_LIMIT <= croakOfFrogs.length()) {
                        if("croak".equals(croakOfFrogs.substring((i+WORD_LIMIT),(i+WORD_LIMIT) + WORD_LIMIT))) {
                            baseFrequency--;
                        }
                    }
                }
            }
        }
        return baseFrequency;
    }

    private static boolean foundNextCandidate (String croakOfFrogs, char target, int startPoint) {
        for (int i = startPoint + 1; i < croakOfFrogs.length(); i++){
            if(croakOfFrogs.charAt(i) == target){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new MinNumberOfFrogs().minNumberOfFrogs("crocakcroraoakk"));
    }
}
