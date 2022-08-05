import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        final List<List<String>> ret = new ArrayList<>();
        final Set<String> subs = new HashSet<>();
        for (int i = 0; i < s.length(); i++){
            for (int j = i + 1; j <= s.length(); j++) {
                subs.add(s.substring(i,j));
            }
        }

        for (String substring : subs) {

        }
        System.out.println("");
        return null;
    }



    static void printList(final List<List<String>> list) {
        for (List<String> lists: list) {
            for (String strValue : lists) {
                System.out.print(strValue);
            }
            System.out.println(" ");
        }
    }

    public static void main(String[] args) {

    }
}
