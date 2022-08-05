import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TeemoAttacking {


    static int findPoisonedDuration(int[] timeSeries, int duration) {


            final List<int[]> intervals = new ArrayList<>();
            int poisonedTime = 0;
            for (int i = 1; i < timeSeries.length; i++) {

                int currentTime  = timeSeries[i];
                int prevStart = timeSeries[i-1];
                int prevEnd = (timeSeries[i-1] + duration)-1;
                poisonedTime += (currentTime + duration)-1;
                if(isInRange(currentTime,prevStart,prevEnd)) {
                    poisonedTime = 0;
                }
                final int[] interval = new int[2];
                interval[0] = timeSeries[i];
                interval[1] = (timeSeries[i] + duration) - 1;
                intervals.add(interval);
        }

        System.out.println("");

        return poisonedTime;
    }

    private static boolean isInRange (int target, int start, int end) {
        return  (target >= start  && target <= end);
    }
    public static void main(String[] args) {
        findPoisonedDuration(new int []{1,2/*,3,4,5,6,7,8,9*/},2);

    }
}
