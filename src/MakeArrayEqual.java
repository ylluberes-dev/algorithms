public class MakeArrayEqual {

    public int minMoves2(int[] nums) {
        long min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int distances = 0;
            boolean stop = false;
            for (int j = 0; j < nums.length; j++){
                if(distances + (long) Math.abs(nums[i]-nums[j]) > Integer.MAX_VALUE|| distances + (long) Math.abs(nums[i] - nums[j]) < Integer.MIN_VALUE) {
                    stop = true;
                    break;
                }
                distances += Math.abs(nums[i] - nums[j]);
            }
            if(!stop) {
                if (distances < min)
                    min = distances;
            }
        }
       // System.out.println(min);

        return (int) min;
    }

    public static void main(String[] args) {

       // System.out.println(2127271182 > 1650450880);
        System.out.println(new MakeArrayEqual().minMoves2(new int []{1,2,3}));
        System.out.println(new MakeArrayEqual().minMoves2(new int []{1,10,2,9}));
        System.out.println(new MakeArrayEqual().minMoves2(new int []{203125577,-349566234,230332704,48321315,66379082,386516853,50986744,-250908656,-425653504,-212123143}));
    }
}
