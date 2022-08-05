import java.util.ArrayList;
import java.util.List;

public class SlidingWindow {


    static int maxSum  (int [] nums,int n, int target) {

        int max = Integer.MIN_VALUE;
        int l = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if(i - l + 1 == target) {
                if(sum > max){
                    max = sum;
                }
                sum -= nums[l];
                l++;
            }

        }

        return max;
    }
    public static void main(String[] args) {

        int arr[] = { 1, 4, 2, 10, 2, 3, 1, 0, 20 };
        int k = 4;
        int n = arr.length;
        System.out.println(maxSum(arr, n, k));
    }
}
