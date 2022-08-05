import java.util.*;

public class TwoStrings {


    /**
     * O(n*m)
     * n -> the length of s1
     * m -> the length of s2
     */
    static String twoStrings(String s1, String s2) {
        if ((s1 == null && s2 != null) || (s2 == null  && s1 != null)) {
            return "NO";
        }else {
            Map<Character,Integer> frequencyTable = new HashMap<>();
            for (int i = 0; i < s1.length(); i ++) {
                if (frequencyTable.containsKey(s1.charAt(i))){
                    int current = frequencyTable.get(s1.charAt(i));
                    frequencyTable.put(s1.charAt(i),current+1);
                }else {
                    frequencyTable.put(s1.charAt(i),1);
                }

            }
            for (int i = 0; i < s2.length(); i++){
               if (frequencyTable.containsKey(s2.charAt(i))) {
                   return "YES";
               }
            }
        }
        return "NO";
    }

    public static void main(String[] args) {
        System.out.println(twoStrings("wouldyoulikefries", "abcabcabcabcabcabc"));
    }
}
