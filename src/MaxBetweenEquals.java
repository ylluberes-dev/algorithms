import java.util.ArrayList;
import java.util.List;

public class MaxBetweenEquals {

    public int maxLengthBetweenEqualCharacters(String s) {
        List<String> subStrings = new ArrayList<>();
        String max = "";
        boolean duplicate = false;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    duplicate = true;
                    if (max.length() < s.substring(i + 1, j).length()) {
                        max = s.substring(i + 1, j);
                    }
                }
            }

        }
        if(!duplicate) return -1;
        return max.length();
    }

    public static void main(String[] args) {
        System.out.println(new MaxBetweenEquals().maxLengthBetweenEqualCharacters("cabbac"));
    }
}
