import java.util.HashMap;
import java.util.Map;

public class CountTriple {
    private static int countTriple(String str) {
        if (str == null || str.length() < 3) return 0;
        int tripleCount = 0;
        //final Map<Integer, Character> indexHolder = new HashMap<>();
        for (int i = 0; i < str.length() - 2; i++) {
            if (str.charAt(i) == str.charAt(i + 1) && str.charAt(i) == str.charAt(i + 2)) {
              //  if (!indexHolder.containsKey(i)) {
                    tripleCount++;
              //  }
              //  indexHolder.put(i,str.charAt(i));
            }
        }
        return tripleCount;
    }

    public static void main(String[] args) {
        System.out.println(countTriple("222abyyycdXXX"));
    }
}
