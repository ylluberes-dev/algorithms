public class leftMostIndex {

    public int findMiddleIndex(int[] nums) {

        int leftSum = 0;
        int rightSum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++){
            for (int r = i + 1; r < nums.length; r++) {
                rightSum+= nums[r];
            }

            for (int l = i -1; l >= 0; l--) {
                leftSum+= nums[l];
            }
            if(leftSum == rightSum) {
                if(min > i){
                    min = i;
                }
            }
            rightSum = 0;
            leftSum = 0;
        }

      if(min == Integer.MAX_VALUE) return -1;
      return min;
    }

    public static void main(String[] args) {
        System.out.println(new leftMostIndex().findMiddleIndex(new int []{2,5}));
    }
}
