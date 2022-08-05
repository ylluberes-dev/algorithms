import java.util.*;

public class DisappearedNumbers {

    /**
     * @param nums
     * @return disappeared numbers in @nums
     * <p>
     * complexity (n log(n))
     * </p>
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new ArrayList<>();

        Map<Integer,Integer> freq = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (freq.containsKey(nums[i])) {
                freq.replace(nums[i], freq.get(nums[i]) + 1);
            } else {
                freq.put(nums[i], 1);
            }
        }
        System.out.println();
            for (int i = 1; i <= nums.length; i++){
                if(!freq.containsKey(i)) {
                    ret.add(i);
                }
            }

        return  ret;
    }


    private static void print(List<Integer> values) {
        if (values != null && values.size() > 0) {
            for (int i = 0; i < values.size(); i++) {
                System.out.println(values.get(i) + " ");
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("Result of test case #1: ");
        print(new DisappearedNumbers().findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        System.out.println();


        System.out.println("Result of test case #2: ");
        print(new DisappearedNumbers().findDisappearedNumbers(new int[]{1,1}));
        System.out.println();
    }
}
