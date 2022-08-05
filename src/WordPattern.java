import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordPattern {

    public boolean wordPattern(String pattern, String s) {

        final String [] words = s.split(" ");
        if(words.length != pattern.length()) return false;
        Map<Character,String> map = new HashMap<>();
        for(int i = 0; i < pattern.length(); i++) {
            char value = pattern.charAt(i);
            if(map.containsKey(value)) {
                if(!map.get(value).equals(words[i])) return false;
            }else {
                for (Character key : map.keySet()) {
                    if(map.get(key).equals(words[i])) return false;
                }
                map.put(value,words[i]);
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(new WordPattern().wordPattern("abba","dog dog dog dog"));
    }
}
