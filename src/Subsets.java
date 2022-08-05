import java.util.ArrayList;
import java.util.List;

public class Subsets {

    /**
     * Iterar sobre el arreglo N veces
     *
     * */
    static List<List<Integer>> subsets (int [] nums) {

        List<List<Integer>> subs = new ArrayList<>();
        List<Integer> subCandidate = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            subCandidate = new ArrayList<>();
            subCandidate.add(nums[i]);
        }

        if (!subs.contains(subCandidate)){
            subs.add(subCandidate);
        }
        return null;
    }
}
