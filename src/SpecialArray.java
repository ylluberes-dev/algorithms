public class SpecialArray {

    public int specialArray(int[] nums) {

        for (int x = 1; x < 1_000; x++) {
            int counter = 0;
            for (int i = 0; i < nums.length; i++) {
                if(nums[i] >= x){
                    counter++;
                }
            }
            if(counter == x)
                return x;

        }
        return -1;
    }


    public static void main(String[] args) {
        System.out.println(new SpecialArray().specialArray(new int[]{3,6,7,7,0}));
    }
}
