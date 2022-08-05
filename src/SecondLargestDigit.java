import java.util.ArrayList;
import java.util.List;

public class SecondLargestDigit {

    public int secondHighest(String s) {
      //  List<Integer> digits = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < s.length();i++) {
            char current = s.charAt(i);
            boolean foundMax = false;
            if(Character.isDigit(current)){
                int value = Integer.parseInt(String.valueOf(current));
                if(value > max){
                   secondMax = max;
                   max = value;
                   foundMax = true;
                }
                if(!foundMax){
                    if(value > secondMax && value != max){
                        secondMax = value;
                    }
                }
            }
        }
        if(secondMax == Integer.MIN_VALUE || secondMax == max) return -1;
        return secondMax;
    }

    public static void main(String[] args) {
        System.out.println(new SecondLargestDigit().secondHighest("ck077"));
    }
}
