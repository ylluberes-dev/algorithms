import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MostCompetitiveSubsequence {

    public int[] mostCompetitive(int[] nums, int k) {

        return null;
    }


    public Set<List<Integer>> getAllSubSequence(int[] nums, int k) {
        Set<List<Integer>> subSequences = new HashSet<>();
        int startPoint = 0;
        for (int i = 0; i < nums.length; i++) {
            startPoint = i + 1;
            while (true) {
                List<Integer> increasingSub = new ArrayList<>();
                List<Integer> decreasingSub = new ArrayList<>();
                increasingSub.add(nums[i]);
                decreasingSub.add(nums[i]);
                int curMax = nums[i];
                int curMin = nums[i];
                if (startPoint == nums.length) break;
                for (int j = startPoint; j < nums.length; j++) {
                    if(nums[j] >= curMax) {
                        increasingSub.add(nums[j]);
                        curMax = nums[j];
                    }
                    if (increasingSub.size() == k) {
                        subSequences.add(increasingSub);
                        break;
                    }
                }

                for (int j = startPoint; j < nums.length; j++) {
                    if(nums[j] < curMin) {
                        decreasingSub.add(nums[j]);
                        curMin = nums[j];
                    }
                    if (decreasingSub.size() == k) {
                        subSequences.add(decreasingSub);
                        break;
                    }
                }
                startPoint++;

            }
        }
        return subSequences;
    }


    private static void printSubsequences (Set<List<Integer>> sequences){
        for(List<Integer> subsequences: sequences){
            System.out.print("{ ");
            for (Integer i : subsequences){
                System.out.print("["+i+"] ");
            }
            System.out.print("} ");
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Set<List<Integer>> subsequences = new MostCompetitiveSubsequence().getAllSubSequence(new int[]{2,4,3,3,5,4,9,6}, 4);
        printSubsequences(subsequences);
    }
}
