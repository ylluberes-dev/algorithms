public class MinimunValueStepByStep {

    public int minStartValue(int[] nums) {

        int ret = 0;
        for (int startPoint = 1; true; startPoint++) {

            if(startPoint == 4){
                System.out.println(":) ");
            }
            int sum = startPoint;
            boolean skipSolution = false;
            for (int i = 0; i < nums.length; i++) {
                sum +=  nums[i];
                if (sum < 1){
                    skipSolution = true;
                    break;
                }
            }
            if(skipSolution){
                continue;
            }else {
                ret = startPoint;
                break;
            }
        }
        return ret;
    }


    public static void main(String[] args) {

        //[-3,6,2,5,8,6]
        System.out.println(new MinimunValueStepByStep().minStartValue(new int[]{1,-2,-3}));
    }
}
