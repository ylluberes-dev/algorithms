import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindTheDifference {

    public char findTheDifference(String s, String t) {

        List<String> strList = new ArrayList<>();

        if (s == null || "".equals(s)) {
            return t.charAt(0);
        }

        if (t == null || "".equals(t)) {
            return s.charAt(0);
        }

        Map<Character, Integer> tableS = new HashMap<>();
        for (Character c: s.toCharArray()) {
            if (tableS.containsKey(c)) {
                tableS.replace(c,tableS.get(c) + 1);
            }else {
                tableS.put(c,1);
            }
        }

        Map<Character,Integer> tableT = new HashMap<>();
        for (Character c: t.toCharArray()) {
            if (tableT.containsKey(c)) {
                tableT.replace(c,tableT.get(c) + 1);
            }else {
                tableT.put(c,1);
            }
        }

        for (Character c: tableT.keySet()){
            boolean found = false;
            for (Character k: tableS.keySet()){
                if (c == k) {
                    found = true;
                    if (tableT.get(k) > tableS.get(c)){
                        return k;
                    }
                }
            }
            if (!found){
                return c;
            }
        }


        return 'C';
    }


    public static void main(String[] args) {
        System.out.println(new FindTheDifference().findTheDifference("abcd","abcde"));
    }
}
