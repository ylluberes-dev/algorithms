import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Set<List<Integer>> combinations = new HashSet<>();

        return null;
    }

    private static void printAllComb (List<List<Integer>> combinations) {

        for (List<Integer> list: combinations) {
            for (Integer i: list){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {

        List<List<Integer>> result = new CombinationSumII().combinationSum2(new int []{10,1,2,7,6,1,5}, 8);
    }
}
