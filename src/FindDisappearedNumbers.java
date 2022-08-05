import sun.java2d.pipe.AAShapePipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindDisappearedNumbers {


    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null) {
            return new ArrayList<Integer>();
        }
        Arrays.sort(nums);

        List<Integer> baseList = new ArrayList<>();
        int base = 0;
        for (int i = 0; i < nums.length; i++) {

            base++;
                if (base - nums[i] != 0) {
                    baseList.add(base);

                }
        }


        return baseList;
    }


    private static void swap(int a, int b, int arr[]) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    public static void main(String[] args) {
        System.out.println(new FindDisappearedNumbers().findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));//1,2,3,4,7,8
       // System.out.println(new FindDisappearedNumbers().findDisappearedNumbers(new int[]{1,1}));
    }
}
