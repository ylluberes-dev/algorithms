import java.util.ArrayList;
import java.util.List;

public class MaximunProductSubArray {


    class Pair {
        int x, y;
        public Pair (int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int maxProduct(int[] nums) {

        int maxSubArrayProduct = Integer.MIN_VALUE;
        int maxArrayProduct = Integer.MIN_VALUE;

        List<Integer> products = new ArrayList<>();
        List<Integer> subArrayProducts = new ArrayList<>();
        for (int i = 0; i < nums.length ; i++) {
            int pivot = 1;
            boolean validPivot = false;
            for (int j = 0; j < i; j++) {
               if (i != j) {
                    pivot = pivot * nums[j];
                }
            }

            if(validPivot) {
                subArrayProducts.add(pivot);
            }
            products.add(nums[i]);
        }

        for (int i = 0 ; i < subArrayProducts.size(); i ++){
            if(maxSubArrayProduct < subArrayProducts.get(i)){
                maxSubArrayProduct = subArrayProducts.get(i);
            }
        }

            for (int i = 0; i < products.size(); i++) {
                if (maxArrayProduct < products.get(i)) {
                    maxArrayProduct = products.get(i);
                }
        }
            return maxArrayProduct > maxSubArrayProduct ? maxArrayProduct : maxSubArrayProduct;
    }

    public static void main(String[] args) {

        int x = 5;
        int y = x++ ;
        System.out.println("x: "+x);
        System.out.println("y: "+y);
        System.exit(0);

         int ret = new MaximunProductSubArray().maxProduct(new int [] {2,-5,-2,-4,3});

        //int ret2 = new MaximunProductSubArray().maxProduct(new int [] {0,2});
        System.out.println(ret);
    }
}