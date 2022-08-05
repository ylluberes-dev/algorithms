import java.util.HashMap;
import java.util.Map;

public class IsomorphicString {

    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || (s.length() != t.length())) return false;
        final Map<Character, Character> mappingTable = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (mappingTable.containsKey(sChar)) {
                if (mappingTable.get(sChar) != tChar) return false;
            }
            mappingTable.put(sChar, tChar);

        }
        for(Character k1: mappingTable.keySet()) {
            final char mappedValue = mappingTable.get(k1);
            for (Character k2 : mappingTable.keySet()) {
                if(k1 != k2) {
                    if(mappingTable.get(k2) == mappedValue) return false;
                }
            }
        }

        return true;
    }


    public static void main(String[] args) {
        /**
         * "badc" - >
         * "baba"
         */
        System.out.println(new IsomorphicString().isIsomorphic("badc", "baba"));
    }
}
