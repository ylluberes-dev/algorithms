import java.util.HashMap;
import java.util.Map;

public class CountBalls {

    /**
     * Always positive range
     * */
    public int countBalls(int lowLimit, int highLimit) {
        Map<Integer,Integer> boxTracker = new HashMap<>();
        for (int i = lowLimit; i <= highLimit; i++) {
            int key = getBoxNumber(i);
            if(boxTracker.containsKey(key)){
                boxTracker.replace(key,boxTracker.get(key) + 1);
            }else {
                boxTracker.put(key,1);
            }
        }
        int max = Integer.MIN_VALUE;
        for (Integer key: boxTracker.keySet()) {
            if(boxTracker.get(key) >  max){
                max = boxTracker.get(key);
            }
        }
        return max;
    }


    private static int getBoxNumber(int target) {
        int sum = 0;
        while (target > 0) {
            sum += target % 10;
            target /= 10;
        }
        return sum;
    }


    public static void main(String[] args) {
        //System.out.println(getBoxNumber(369));
        System.out.println(new CountBalls().countBalls(19, 28));
    }
}
