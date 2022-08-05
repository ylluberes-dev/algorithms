import java.util.ArrayList;
import java.util.List;

public class MoveZeros {

    public void moveZeroes(int[] nums) {
        System.out.println("Before: ");
        print(nums);
        System.out.println();
        // O(N^2) Approach
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[j] == 0 && nums[j + 1] != 0) {
                    swap(nums, j, j + 1);
                }
            }
        }

        System.out.println("After: ");
        print(nums);
        /* 1 4 0 2 0 0 7 0 6 0 1
           1 4 2 0 0 7 0 6 0 1 0
           1 4 2 0 7 0 6 0 1 0 0
           1 4 2 7 0 6 0 1 0 0 0
           1 4 2 7 6 0 1 0 0 0 0
           1 4 2 7 6 1 0 0 0 0 0 */
    }

    void moveZero2(int [] nums){

        List<Integer> nonZero = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            if(nums[i] != 0) {
                nonZero.add(i);
            }
        }

        for(int i = 0; i < nums.length; i++){
            if(i >= nonZero.size()) {
                nums[i] = 0;
            }else {
                nums[i] = nums[nonZero.get(i)];
            }
        }
    }

    private static void swap(int[] values, int a, int b) {
        int temp = values[a];
        values[a] = values[b];
        values[b] = temp;
    }

    private static void print(int[] values) {
        if (values != null && values.length > 0) {
            for (int i = 0; i < values.length; i++) {
                System.out.print(values[i] + " ");
            }
        }
    }

    public static void main(String[] args) {
        //new MoveZeros().moveZeroes(new int [] {0});
        new MoveZeros().moveZero2(new int []{0,1,0,3,12});
    }
}
