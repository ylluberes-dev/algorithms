    import java.math.BigInteger;

public class ArraySign {

    public int arraySign(int[] nums) {
        BigInteger product = new BigInteger("1");
        for (int i =0; i < nums.length; i++) {
            product = product.multiply(new BigInteger(String.valueOf(nums[i])));
        }

        // int res = product > 0 ? 1: product < 0 ? -1: 0;
        if (product.compareTo(new BigInteger("0")) == 1){
            return 1;
        } else if (product.compareTo(new BigInteger("0")) == -1  ){
            return -1;
        }
        return 0;
        //return res;
    }

    public static void main(String[] args) {
        System.out.println(new ArraySign().arraySign(new int [] {41,65,14,80,20,10,55,58,24,56,28,86,96,10,3,84,4,41,13,32,42,43,83,78,82,70,15,-41}));
    }
}
