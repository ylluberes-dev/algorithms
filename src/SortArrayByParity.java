public class SortArrayByParity {

    static int[] sortArrayByParityII(int[] nums) {
        int ret[] = new int[nums.length];
        int index = 0;
        int odd = 1;
        for (int i = 0; i < nums.length; i++) {
            if (isEven(nums[i])) {
                ret[index] = nums[i];
                index += 2;
            }else {
                ret[odd] = nums[i];
                odd +=2;
            }
        }

        return ret;
    }

    private static boolean isEven(int n) {
        return n % 2 == 0;
    }

    private static void printArr(int[] values) {
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i]);
        }
    }

    public static void main(String[] args) {
        printArr(sortArrayByParityII(new int[]{2,3}));
    }
}
