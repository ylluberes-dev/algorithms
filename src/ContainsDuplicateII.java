import java.util.*;

public class ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        /*final Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) { // It means there are two numbers
                map.get(nums[i]).add(i); // We add the index to the list
            }else {
                map.put(nums[i], new ArrayList<>(Arrays.asList(i)));
            }
        }*/
        final Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) { // It means there are two numbers
                int distance = Math.abs(map.get(nums[i]) - i);
                if(distance <= k) {
                    return true;
                } else {
                    map.replace(nums[i],i);
                }
            }else {
                map.put(nums[i], i);
            }
        }
        // 1 -> {0,3}
        // 2 -> {1}
        // 3 -> {2}
//        for (Integer i: map.keySet()) {
//            if(map.get(i).size() > 1) {
//                List<Integer> indices = map.get(i);
//                for (Integer x : indices) {
//                   for (Integer y: indices) {
//                       if (x != y) {
//                           // int a = Math.abs(x - y);
//                           if (Math.abs(x - y) <= k) {
//                               return true;
//                           }
//                       }
//                   }
//                }
//            }
//        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new ContainsDuplicateII().containsNearbyDuplicate(new int []{1,2,3,1,2,3},2));

    }
}
