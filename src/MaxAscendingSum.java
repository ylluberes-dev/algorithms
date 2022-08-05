public class MaxAscendingSum {

    public int maxAscendingSum(int[] nums) {

        int max = Integer.MIN_VALUE;
        int sum = nums[0];

        int product = sum < 0 ? -1 : sum > 0 ? 1: 0;
        int res = product > 0 ? 1: product < 0 ? -1: 0;

        boolean newStart = false;

        for (int i = 0; i < nums.length; i++){

            if (newStart) {
                 sum = nums[i];
            }
           for (int j = i + 1 ; j < nums.length; j++) {
               if (nums[j] > nums[i]){
                   sum += nums[j];
                   newStart = false;
                   break;

               }else {
                   newStart = true;
                   //sum = 0;
                   break;
               }
           }
           if(sum > max){
               max = sum;
            }

        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaxAscendingSum().maxAscendingSum(new int[]{10,20,30,40,50}));
    }
}
