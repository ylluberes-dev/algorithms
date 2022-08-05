import java.util.Arrays;
import java.util.concurrent.Semaphore;

public class ProductArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] ret = new int[n];
        Arrays.fill(ret, 1);
        int productFromLeft = 1, productFromRight = 1;

        for (int i = 0; i < n; i++) {
            ret[i] = ret[i] * productFromLeft;
            ret[n - i - 1] = ret[n - i - 1] * productFromRight;
            productFromLeft = productFromLeft * nums[i];
            productFromRight = productFromRight * nums[n - i - 1];
        }

        return ret;
    }

    private Semaphore semaphore;

    static final void printArr(final int[] values) {
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + ", ");
        }
    }

    public static void main(String[] args) {
       // System.out.println(findNumber(2, 24));
        printArr(new ProductArrayExceptSelf().productExceptSelf(new int[]{5,9,2,-9,-9,-7,-8,7,-9,10}));
    }
}
