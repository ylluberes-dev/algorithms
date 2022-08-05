import java.util.*;

public class MaxSumKpairs {

    public int maxOperations(int[] nums, int k) {

        Map<Integer, Integer> countTable = new HashMap<>();
        int operations = 0;

        for (int i = 0; i < nums.length; i++) {
            boolean foundPair = false;
            if(nums[i] < 0) continue;
            int rem = k  - nums[i];
            if (countTable.containsKey(rem)) {
                nums[countTable.get(rem)] = -1;
                nums[i] = -1;
                operations++;
                countTable.remove(rem);
                foundPair = true;
            }
            if(!foundPair){
                if(countTable.containsKey(nums[i])){

                }
                countTable.put(nums[i], i);
            }

        }
        System.out.println("");
        return operations;
    }


    public static void main(String[] args) {
        // nums = [1,2,3,4]  T = 5

        // K     V    rem
        // 1     0     4
        // 2     1     3
        // 3     2     2
        // 4     3     1

        // index 1 and 2

       // [4,4,1,3,1,3,2,2,5,5,1,5,2,1,2,3,5,4]
     //   2
        //[2,5,4,4,1,3,4,4,1,4,4,1,2,1,2,2,3,2,4,2]
        //3
        System.out.println(new MaxSumKpairs().maxOperations(new int[]{2,5,4,4,1,3,4,4,1,4,4,1,2,1,2,2,3,2,4,2}, 3));
    }
}
