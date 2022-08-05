import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinarySubArrays {

    public int numSubarraysWithSum(int[] nums, int goal) {
        //Find the positions of ones
        int count = 0;

        List<Integer> onesPos = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {

            int oneCount = 0;
            int k = i;
            while (oneCount != goal) {
                if(k == nums.length) break;
                if (nums[k] == 1) {
                    oneCount++;
                }
                k++;

            }
            if (oneCount == goal)
                count++;

        }
        System.out.println();
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new BinarySubArrays().numSubarraysWithSum(new int[]{1,0,1,0,1}, 0));
    }
}
