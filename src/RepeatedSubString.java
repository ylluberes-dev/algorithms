import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedSubString {

    public boolean repeatedSubstringPattern(String s) {
        Set<String> subsStrings = new HashSet<>();

        for (int i = 0; i < s.length(); i ++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String sub = s.substring(i,j);
                if(sub.equals(s)) continue;
                if(s.length() % sub.length() == 0) {
                    subsStrings.add(sub);
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        for (String subString: subsStrings) {
            int size = s.length() / subString.length();

            for (int i = 0; i < size; i++) {
                builder.append(subString);
            }

            if(builder.toString().equals(s)) {
                return true;
            }
            builder.setLength(0);
        }

        return false;
    }


    static boolean solve2 (String s) {
        int l = 0;
        List<Integer> factors = new ArrayList<>();
        int N = s.length();
        int max = -1;
        for (int i = 1; i < N; i++) {
            if(N % i == 0) {
                factors.add(i);
                max = i;
            }
        }
        Set<String> subStrings  = new HashSet<>();
        int left = 0;
        for (int i = 1 ; i < s.length();i ++) {
           if(factors.contains(i - left)) {
               subStrings.add(s.substring(left,i));
           }else {
               if (i - l == max){
                   l++;
               }
           }
        }
        System.out.println();
        return false;
    }
    public static void main(String[] args) {
        System.out.println("abcabcabcabc".length());
        System.out.println( RepeatedSubString.solve2("abcabcabcabc"));
    }
}
