public class KLengthAppart {

    public boolean kLengthApart(int[] nums, int k) {

        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==1) {
                int steps = -1;
                for (int j = i + 1; j < nums.length; j++) {
                    steps++;
                    if(nums[j] == 1) {
                        if(steps < k) return false;
                    }
                    if(steps > k){
                        break;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        //[1,0,0,1,0,1]
        //2
        //
        System.out.println(new KLengthAppart().kLengthApart(new int []{1,1,1,1,1},0));
    }
}
