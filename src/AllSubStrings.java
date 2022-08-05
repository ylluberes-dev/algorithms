import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllSubStrings {


    //abcde
    private List<String> getAllSubStrings(String s) {
        List<String> result = new ArrayList<>();

        for(int i = 0; i < s.length(); i++) {
            StringBuilder builder = new StringBuilder();
            for(int j = i; j < s.length(); j++) {
                builder.append(s.charAt(j));
            }
        }
        return null;
    }

    private void printAll(List<String> values) {
        if (values != null && values.size() > 0) {
            for (String subString : values) {
                System.out.println(values);
            }
        }
    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

    }
}
