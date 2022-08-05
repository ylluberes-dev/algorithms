public class ConsecutiveOne {
    public int findMaxConsecutiveOnes(int[] nums) {
        int consecutiveOnes = 0;
        if (nums.length <= 2) {
            for (int i = 0; i < nums.length; i++) {if(nums[i] == 1) consecutiveOnes++;  } return consecutiveOnes;
        }
        int max = 0;
        boolean sequenceStart = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 1) {
                if (!sequenceStart) {
                    consecutiveOnes++;
                }
                if (nums[i + 1] == 1) {
                    consecutiveOnes++;
                    sequenceStart = true;
                } else {
                    if (sequenceStart) {
                        sequenceStart = false;
                    }
                }
            } else {
                consecutiveOnes = 0;
            }
            if (max < consecutiveOnes) {
                max = consecutiveOnes;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println(new ConsecutiveOne().findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
    }
}
