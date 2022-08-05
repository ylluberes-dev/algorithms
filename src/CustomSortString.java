import java.util.HashMap;
import java.util.Map;

public class CustomSortString {


    public String customSortString(String order, String str) {

        StringBuilder builder = new StringBuilder();
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            char pivot = order.charAt(i);
            for (int j = 0; j < str.length(); j++) {
                char candidate = str.charAt(j);
                if(pivot == candidate){
                    builder.append(candidate);

                }
            }
            map.put(pivot,1);
        }
        System.out.println();
        for (int i = 0; i < str.length(); i ++){
           if(!map.containsKey(str.charAt(i))) {
               builder.append(str.charAt(i));
           }
        }
        return builder.toString();
    }

    public static void main(String[] args) {

        System.out.println("Test case #1: ");
        System.out.println(new CustomSortString().customSortString("cba","abcd"));
    }
}
