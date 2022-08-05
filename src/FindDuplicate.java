import java.util.HashMap;
import java.util.Map;

public class FindDuplicate {

    public int findDuplicate(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        for (Integer key : freq.keySet()) {
            if (freq.get(key) >= 2) {
                return key;
            }
        }
        return -1;
    }


    static int solve (int[] nums)
    {
        for (int i = 0; i < nums.length; i++) {
            if(nums[nums[i]] < 0){
                return nums[i];
            }else {
                nums[nums[i]] = -1;;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        System.out.println(solve(new int [] {1,3,4,2,2}));
        System.out.println(new FindDuplicate().findDuplicate(new int [] {1,1,2}));
    }
}
