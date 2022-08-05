import java.util.HashMap;
import java.util.Map;

public class TestingMap {
    public boolean canConstruct(String ransomNote, String magazine) {

        Map<Character,Integer> aCounter = countCharacters(ransomNote);
        Map<Character,Integer> bCounter = countCharacters(magazine);

        for(Character c: aCounter.keySet()) {
            if(!(bCounter.containsKey(c))) {
                return false;
            }else {
                // if b map contains c char (ransomNote char) then
                // check if the number of c occurrences is the same in magazine map
                if(bCounter.get(c) <  aCounter.get(c)){
                    return false;
                }
            }
        }
        return true;
    }
    private static Map<Character,Integer> countCharacters (String word){
        Map<Character,Integer> map = new HashMap<>();

        for(int i = 0; i < word.length(); i ++) {
            char curr = word.charAt(i);
            map.put(curr,map.getOrDefault(curr,0)+1);
        }

        return map;
    }

    public static void main(String[] args) {
        //"bg"
        //"efjbdfbdgfjhhaiigfhbaejahgfbbgbjagbddfgdiaigdadhcfcj"
        System.out.println(new TestingMap().canConstruct("bg","efjbdfbdgfjhhaiigfhbaejahgfbbgbjagbddfgdiaigdadhcfcj"));
    }
}
