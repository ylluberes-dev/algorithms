import java.util.HashMap;
import java.util.Map;

public class MakeStringEquals {


    public boolean makeEqual(String[] words) {
            final Map<Character,Integer> freqTable = new HashMap<>();
            for (String value: words) {
                for(Character character: value.toCharArray()) {
                    if(freqTable.containsKey(character)) {
                        freqTable.put(character,freqTable.get(character)+ 1);
                    } else {
                        freqTable.put(character,1);
                    }
                }
            }
            for(Character c: freqTable.keySet()) {
                if(freqTable.get(c) % words.length != 0) {
                    return false;
                }
            }

            return true;

    }

    public static void main(String[] args) {

        System.out.println(new MakeStringEquals().makeEqual(new String []{"a","b"}));
    }
}
