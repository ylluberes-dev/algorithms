public class MaxConsecutiveOnes {


    static int longestOnes(int[] nums, int k) {

        if(nums.length == 1)
            if(nums[0] == 1)
                return 1;
            else
                return k >= 1 ? 1 : 0;
        int l = 0;
        int flips = 0;
        int consecutive = 0;
        int max = Integer.MIN_VALUE;
        boolean fixed = false;
        for (int i = 0; i < nums.length-1; i++) {

            int right = nums[i+1];
            int left = nums[l];

            if(!fixed) {
                if (left == 0) {

                }
            }

            if(right == 1) {
                consecutive++;
            }else {
                if(flips < k){
                    consecutive++;
                    flips++;
                }
            }
            max = Math.max(max, consecutive);
        }
        return max;
    }

    public static void main(String[] args) {

        /**
         * Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
         */

        System.out.println(longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
    }
}
