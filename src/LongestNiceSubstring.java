import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestNiceSubstring {

    public String longestNiceSubstring(String s) {
        if(s == null || s.equals("") || s.length() < 2)
            return "";
        List<String> subStrings = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i +1; j <= s.length(); j++) {
                String subString = s.substring(i,j);
                if(subString.length() > 1){
                    subStrings.add(subString);
                }
            }
        }
        String longest = "";
        for (String str: subStrings) {
            if(isNice(str)){
                if(str.length() > longest.length()){
                    longest = str;
                }
            }
        }


        return longest;
    }

    private static boolean isNice (String s) {
        for  (int i = 0; i < s.length();i++){
            Character cur = s.charAt(i);
            boolean found = false;
            for (int j = 0; j < s.length(); j++){
                if (i!= j){
                   if(Character.isLowerCase(cur)){
                       if(Character.isUpperCase(s.charAt(j))){
                           if(cur == Character.toLowerCase(s.charAt(j))){
                               found = true;
                           }
                       }
                   }else {
                       if(Character.isLowerCase(s.charAt(j))){
                           if(cur == Character.toUpperCase(s.charAt(j))){
                               found = true;
                           }
                       }
                   }
                }
            }
            if(!found) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new LongestNiceSubstring().longestNiceSubstring("dDzeE"));
        System.out.println(isNice("aAab"));
    }
}
