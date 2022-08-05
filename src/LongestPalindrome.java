import java.util.ArrayList;
import java.util.List;

public class LongestPalindrome {

    public int longestPalindrome(String s) {
        List<String> candidateList = new ArrayList<>();
        for (int i = 0; i < s.length();i++) {
            for (int j = 0; j < s.length(); j++) {
                if (i  < j ){
                    String candidate = s.substring(i,j);
                    candidateList.add(candidate);
                }
            }
        }

        System.out.println();
        return 1;
    }


    public static void main(String[] args) {
       System.out.println(new LongestPalindrome().longestPalindrome("abccccdd"));
       // System.out.println("hola".substring(1,3));
    }
}
