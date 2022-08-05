import java.util.HashMap;
import java.util.Map;

public class CanCreateOtherStri {


    int stringsConstruction(String a, String b) {

        Map<Character, Integer> aFreq = new HashMap<>();
        Map<Character, Integer> bFreq = new HashMap<>();

        for (int i = 0; i < a.length(); i++) {
            if (aFreq.containsKey(a.charAt(i))) {
                aFreq.put(a.charAt(i), aFreq.get(a.charAt(i)) + 1);
            } else {
                aFreq.put(a.charAt(i), 1);
            }
        }

        for (int i = 0; i < b.length(); i++) {
            if (bFreq.containsKey(b.charAt(i))) {
                bFreq.put(b.charAt(i), bFreq.get(b.charAt(i)) + 1);
            } else {
                bFreq.put(b.charAt(i), 1);
            }
        }

        int maxTimes = Integer.MAX_VALUE;
        for (Character aKey : aFreq.keySet()) {
            Integer aFrequency = aFreq.get(aKey);
            Integer bFrequency = bFreq.get(aKey);
            if(bFrequency != null){
                if(bFrequency.intValue() < maxTimes)
                    maxTimes = bFrequency / aFrequency;
            }else {
                return 0;
            }
        }
        return maxTimes;
    }

    public static void main(String[] args) {
        int result = new CanCreateOtherStri().stringsConstruction("abcde", "abccba");
        System.out.println(result);
    }
}
