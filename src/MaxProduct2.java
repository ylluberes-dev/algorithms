public class MaxProduct2 {


    public int maxProduct(int[] nums) {
        String values [] = findMaxAndSecondMax(nums).split("\\|");
        return (Integer.parseInt(values[0])-1) * (Integer.parseInt(values[1]) - 1);
    }

    private static String findMaxAndSecondMax (int [] values) {
        int max = values[0];
        int prevMax = values[1];
        int maxIndex = 0;
        for (int i = 0; i < values.length; i++) {
            if(values[i] > max) {
                maxIndex = i;
                prevMax = max;
                max = values[i];
            }
            if(values[i] > prevMax && values[i] <= max && i != maxIndex) {
                prevMax = values[i];
            }
        }
        return max+"|"+prevMax;
    }

    public static void main(String[] args) {
        //System.out.println(findMaxAndSecondMax(new int [] {4,4}));
        System.out.println(new MaxProduct2().maxProduct(new int []{10,2,5,2}));
    }
}

