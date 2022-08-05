import java.util.ArrayList;
import java.util.List;

public class SelfDividing {

    public List<Integer> selfDividingNumbers(int left, int right) {
        // Time complexity O((right-left)* )
        List<Integer> values = new ArrayList<>();
        for(int i = left; i <= right; i++) {
            if(isSelfDividing(i))
                values.add(i);
        }
        return values;
    }


    static boolean isSelfDividing (int n){
        int temp = n;
        while(n != 0) {
            int digit = n % 10;
            if(digit == 0 || temp % digit != 0) return false;
            n /= 10;
        }
        return true;
    }

    public static void main(String[] args) {
        new SelfDividing().selfDividingNumbers(1,22);
    }
}
