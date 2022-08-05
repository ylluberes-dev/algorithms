import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {

        final Set<Integer> uniques = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            uniques.add(nums[i]);
        }
        int c = 0;
        for (Integer i: uniques){
            nums[c] = i;
            c++;
        }
        Arrays.sort(nums,0,uniques.size());
        return uniques.size();
    }
}
