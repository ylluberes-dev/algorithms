import java.util.HashMap;
import java.util.Map;

public class TopFrequentElement {

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> table = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            table.put(nums[i], table.getOrDefault(nums[i], 0) + 1);
        }
        int[] answer = new int[k];
        for (int i = 1; i <= k; i++) {
            int index = i - 1;
            int removableKey = -1;
            int max = Integer.MIN_VALUE;
            for (Integer key : table.keySet()) {
                if (table.get(key) > max) {
                    max = table.get(key); // O(1)
                    removableKey = key;
                }
            }
            table.remove(removableKey);
            answer[index] = removableKey;
        }
        return answer;
    }

    private static void print(int[] values) {
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i]+ " ");
        }
    }

    public static void main(String[] args) {
        print(new TopFrequentElement().topKFrequent(new int [] {1},1));
    }
}
