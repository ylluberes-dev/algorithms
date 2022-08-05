import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArithmeticSubArrays {

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int m = l.length;
        List<Boolean> results = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            //  printArr(extractSubArray(nums,l[i],r[i]));
            results.add(isRearranged(extractSubArray(nums,l[i],r[i])));
        }
        return results;
    }

    private static void printArr (int [] values) {
        for (int i = 0; i < values.length; i++){
            System.out.print(values[i] + " ");
        }
        System.out.println();
    }
    private static int [] extractSubArray (int [] nums, int start, int end) {
        int ret[] = new int [end - start + 1];
        int index  = 0;
        for (int i = start; i <= end; i++){
            ret[index++] = nums[i];
        }
        return ret;
    }

    /**
     *
     * @param values
     * @return true if the param values can be rearranged in an arithmetic progression, false otherwise
     */
    private static boolean isRearranged (int [] values){
        Arrays.sort(values);
        int distance = values[1] - values[0];
        for (int i = 1; i < values.length; i++) {
            if(values[i] - values[i-1] != distance) return false;
        }
        return true;
    }
    public static void main(String[] args) {
       List<Boolean> results = new ArithmeticSubArrays().checkArithmeticSubarrays(new int []{-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10}, new int []{0,1,6,4,8,7}, new int []{4,4,9,7,9,10});
       for (Boolean b: results){
           System.out.println(b);
       }
    }
}
