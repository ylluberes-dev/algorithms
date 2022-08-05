import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MaxUniqueSplit {

    public int maxUniqueSplit(String s) {
        Set<String> subStrings = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String subString = s.substring(i, j);
                subStrings.add(subString);
            }
        }

        Iterator<String> it = subStrings.iterator();
        StringBuilder builder = new StringBuilder();
        for (String element : subStrings) {
            builder.delete(0,builder.length());

        }
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        return -1;
    }

    public void backtrack (int pos, Set<String> subStrings, StringBuilder builder, String original) {
        if(original.equals(builder.toString()))
            return;

        for(String str: subStrings){

        }
    }

    public static void main(String[] args) {
        System.out.println(new MaxUniqueSplit().maxUniqueSplit("ababccc"));
    }
}
