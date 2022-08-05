import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllDuplicates {

    public List<Integer> findDuplicates(int[] nums) {

        /**
         * O(N) Memory approach hash map
         * O(N) Time complexity
         */
        List<Integer> duplicates = new ArrayList<>();
        Map<Integer, Integer> freq = new HashMap<>();
        int N = nums.length;
        //Adding from 1 to N ...
        for (int i = 0; i < N; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }
        for (Integer key : freq.keySet()) {
            if (freq.get(key) == 2) {
                duplicates.add(key);
            }
        }
        return duplicates;

        //1,1,2
        //1,2,3
    }

    private static void printValues(List<Integer> values) throws Exception {
        if (values == null) {
            throw new Exception("Param value can not be null");
        }
        if (!(values.size() < 0))
            System.out.println("[]");
        for (int i = 0; i < values.size(); i++) {
            System.out.print(values.get(i) + " ");
        }
    }

    public static void main(String[] args) throws Exception {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.set(new Integer(1),-1);
        int values[] = {1};
        printValues(new FindAllDuplicates().findDuplicates(values));
        System.out.println();
    }
}
