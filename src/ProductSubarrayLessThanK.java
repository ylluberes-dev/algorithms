public class ProductSubarrayLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0 || nums.length == 0) return 0;
        int subArrays = 0;
        for (int i = 0; i < nums.length; i++) {
            int product = nums[i];
            if (product < k) subArrays++;
            for (int j = i + 1; j < nums.length; j++) {
                product = product * nums[j];
                if (product < k) {
                    subArrays++;
                } else {
                    break;
                }
            }
        }
        return subArrays;
    }

    int solve2(int[] nums, int k) {
        if (k == 0 || nums.length == 0) return 0;
        int subArrays = 0;
        int l = 0;
        int i = l + 1;
        int product = 1;
        boolean rightUpper = false;
        while (l < nums.length - 1) {
            if(!rightUpper) {
                product = nums[l] * nums[i];
            }else {
                product = product * nums[i];
            }
            if(product < k){
                subArrays++;
                rightUpper = true;
            }else {
                l++;
                rightUpper = false;
            }
            i++;
        }

        for (i = 0; i < nums.length; i++) {
            if (nums[i] < k) {
                subArrays++;
            }
        }
        return subArrays;
    }

    public static void main(String[] args) {
        System.out.println(new ProductSubarrayLessThanK().solve2(new int[]{10,9,10,4,3,8,3,3,6,2,10,10,9,3}, 19));
    }
}
