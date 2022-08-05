import java.util.Arrays;

public class Shuffle
{

    public int[] shuffle(int[] nums, int n) {

        int [] result = new int [nums.length];

        int index = 0;
        for (int i = 0; i < n; i ++) {
            result[index] = nums[i];
            result[index + 1] = nums[n+i];
            index=index+2;
        }
        return result;
    }

    private static void printArray (final int [] arr) {
        Arrays.stream(arr).forEach(x -> System.out.println(x));
    }

    public static void main(String[] args) {

        final int testCase [] = {1,1,2,2};
        printArray(new Shuffle().shuffle(testCase, 2));

    }
}
