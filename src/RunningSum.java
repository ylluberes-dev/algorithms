public class RunningSum {

    public int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= i; j++) {
                sum += nums[j];
            }
            result[i] = sum;
            sum = 0;
        }
        return result;
    }


    private static void printResult(int[] values) {
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i] + " ");
        }
    }

    public static void main(String[] args) {
        int testCase[] = {1, 2, 3, 4};
        printResult(new RunningSum().runningSum(testCase));
    }
}
