import java.util.HashSet;
import java.util.Set;

public class HasAllCodes {

    public boolean hasAllCodes(String s, int k) {
        Set<String> values = new HashSet<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i +1; j <= s.length(); j++) {
                String subString = s.substring(i,j);
                if(subString.length() == k)
                    values.add(subString);
            }
        }

        return values.size() == Math.pow(2,k);
    }

    public static void main(String[] args) {
        System.out.println(new HasAllCodes().hasAllCodes("0000000001011100",4));
    }

}
