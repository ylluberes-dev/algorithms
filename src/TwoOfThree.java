import java.util.*;

public class TwoOfThree {


    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        final List<Integer> result = new ArrayList<>();
        final Map<Integer,Boolean> tracker = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if(!tracker.containsKey(nums1[i])) {
                tracker.put(nums1[i],true);
            }
        }

        checkAndAdd(result,tracker,nums2);
        checkAndAdd(result,tracker,nums3);

        return result;
    }


    private void checkAndAdd (List<Integer> result, Map<Integer,Boolean> tracker, int [] values ) {
        Set<Integer> distincts = new HashSet<>();
        Arrays.stream(values).forEach(value -> {
            distincts.add(value);
        });
        for (Integer i: distincts) {
            if(tracker.containsKey(i)){
                if(tracker.get(i)) {
                    result.add(i);
                    tracker.replace(i,false);
                }
            } else {
                tracker.put(i,true);
            }
        }
    }
    public static void main(String[] args) {

        new TwoOfThree().twoOutOfThree(new int [] {3,1},new int []{2,3}, new int [] {1,2});
    }

}
