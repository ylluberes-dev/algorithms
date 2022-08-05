import java.util.*;

public class LongestSubarray {

    public int longestSubarray(int[] nums, int limit) {
                int actualMax = Integer.MIN_VALUE;

                for (int i = 0; i < nums.length; i++) {

                    for (int j = i + 1; j <= nums.length; j++) {
                        int max = Integer.MIN_VALUE;
                        int min = Integer.MAX_VALUE;
                        for (int k = i; k < j; k++){
                        //    System.out.print(nums[k] +  " ");
                            if(nums[k] < min) {
                                min = nums[k];
                            }
                            if(nums[k] > max){
                                max = nums[k];
                            }
                        }
                        int diff = Math.abs(max - min);
                        if(diff <= limit){
                            int sizeOf = Math.abs(i-j);
                            if(sizeOf > actualMax)
                                actualMax = sizeOf;
                        }
                     //   System.out.println(" ");
                    }

                }
                return actualMax ;
    }


    private static int checkAbsoluteDiff(int[] nums, int limit) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        int diff = Math.abs(max - min);
        if (diff <= limit) {
            return nums.length;
        }
        return -1;
    }


    public static void main(String[] args) {
        System.out.println("Result: "+ new LongestSubarray().longestSubarray(new int[]{ 8,2,4,7}, 4));
    }
}
