import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountConsistentStrings {

    public int countConsistentStrings(String allowed, String[] words) {
        int count = 0;
        for (String str: words){
            if(allExists(allowed,str)){
                count++;
            }
        }
        return count;
    }

    private boolean allExists (String base, String word){
        Set<Character> distinctChars = new HashSet<>();
        for (Character c: word.toCharArray()){
            distinctChars.add(c);
        }
        //badab
        //bad -- ab
        int count = 0;
        for (Character c: distinctChars){
            for (int i = 0; i < base.length(); i++) {
                if(c == base.charAt(i)){
                    count++;
                }
            }
        }
        return count == distinctChars.size();
    }

    public static void main(String[] args) {
      int res =  new CountConsistentStrings().countConsistentStrings("ab",new String[]{"ad","bd","aaab","baa","badab"});
        System.out.println(res);
    }
}
