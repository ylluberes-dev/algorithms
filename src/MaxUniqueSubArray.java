import java.util.*;

public class MaxUniqueSubArray {


    public int maximumUniqueSubarray(int[] nums) {
        if(nums.length == 1)
            return nums[0];

        List<Set<Integer>> subArrays = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> cur = null;
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs((j + 1) - i) == nums.length) continue;
                cur = convertToSet(nums, i, j);
            }
            if(cur != null) {
                subArrays.add(cur);
            }

        }
        return extractMax(subArrays);

    }

    private static Set<Integer> convertToSet(int[] nums, int from, int to) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        for (int i = from; i <= to; i++) {
           boolean added =  set.add(nums[i]);
           sum+= nums[i];
            System.out.println("Added number: "+nums[i]+ " "+(added==true?"YES":"NO") );

        }
        System.out.println("Final result: "+sum);
        return set;
    }


    private static int extractMax(List<Set<Integer>> subArrays) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (Set s : subArrays) {
            // valor del i-esimo subarreglo
            sum = 0;
            for (Object o : s) {
                sum += (int) o;
            }
            if (!(sum > max)) {
                sum = max;
            }
            max = sum;


        }
        return sum;
    }

    private static void print(int[] values) {
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + " ");
        }
    }

    public static void main(String[] args) {
        System.out.println(new MaxUniqueSubArray().maximumUniqueSubarray(new int[]{187,470,25,436,538,809,441,167,477,110,275,133,666,345,411,459,490,266,987,965,429,166,809,340,467,318,125,165,809,610,31,585,970,306,42,189,169,743,78,810,70,382,367,490,787,670,476,278,775,673,299,19,893,817,971,458,409,886,434}));
       //int nums [] = {187,470,25,436,538,809,441,167,477,110,275,133,666,345,411,459,490,266,987,965,429,166,809,340,467,318,125,165,809,610,31,585,970,306,42,189,169,743,78,810,70,382,367,490,787,670,476,278,775,673,299,19,893,817,971,458,409,886,434};
      //  Set<Integer> set = convertToSet(nums,0,nums.length-1);

    }
}
