import java.util.Arrays;

public class DivideString {

    public String[] divideString(String s, int k, char fill) {
        final int groups = (s.length() / k) + (s.length() % k > 0 ? 1 : 0);
        // s = 1 (characters)
        // k = 3 (size)
        //# of groups = # of characters divided by the group size

        final String [] result = new String[groups];
        int groupCount = 0;
        int count = 0;
        //boolean lastGroupCondition = result[result.length -1].length() < k;
        for (int i = 0; (i < s.length() || result[result.length -1].length() < k); i++){
            if(count == k) {groupCount++; count = 0;}
            if(result[groupCount] == null)
                result[groupCount] = "";
            if(i >= s.length() && result[result.length -1].length() < k) {
                result[result.length-1] += fill;
            }else {
                result[groupCount] += s.charAt(i);
                count++;
            }
        }

        return result;
    }


    public static void main (String [] args) {
        final String s = "abcdefghi";
        final int k = 3;
        final char fill = 'x';
        System.out.println(new DivideString().divideString(
                s,k,fill
        ));

    }

}
