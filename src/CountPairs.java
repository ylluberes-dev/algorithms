public class CountPairs {

    public int countPairs(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    int result =i * j;
                    if (result % k == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        new CountPairs().countPairs(new int []{3,1,2,2,2,1,3}, 2);
    }
}
