import java.util.*;

public class FirstUniqChar {

        public int firstUniqChar(String s) {
            if (s == null || "".equals(s)) return -1;
            Map<Character, Integer> freqTable = Collections.synchronizedMap(
                    new LinkedHashMap<Character, Integer>());
            for (Character c: s.toCharArray()) {
                if (freqTable.containsKey(c)) {
                    freqTable.replace(c,freqTable.get(c) + 1);
                }else {
                    freqTable.put(c,1);
                }
            }

            for (Character c: freqTable.keySet()) {
                if (freqTable.get(c) == 1) {
                    return s.indexOf(c);
                }
            }

            return -1;
        }




        public static void main(String[] args) {
            System.out.println(new FirstUniqChar().firstUniqChar("aabb"));
        }
    }
