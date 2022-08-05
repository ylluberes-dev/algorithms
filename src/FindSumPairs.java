
import java.util.HashMap;
import java.util.Map;

public class FindSumPairs {
    private int[] nums1;
    private int[] nums2;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
    }

    public void add(int index, int val) {
        if (index < (nums2.length - 1))
            nums2[index] += val;
    }

    public int count(int tot) {
        int pairs = 0;
        for (int i = 0; i < nums2.length; i++) {
            for (int j = 0; j < nums1.length; j++) {
                if(nums1[i] + nums2[j] == tot){
                    pairs++;
                }
            }
        }
        return pairs;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 2, 2, 2, 3};
        int[] nums2 = {1, 4, 5, 2, 5, 4};

        // 1 1 2 2 2 3 1 4 5 2 5 4
        // K     v
        // 1     0
        // 1     1
        // 2     2
        // 2     3
        // 3     4
        // 1     5
        // 4     6
        // 5     7
        //
        FindSumPairs findSumPairs = new FindSumPairs(nums1, nums2);
        System.out.println(findSumPairs.count(7));

    }


}

