import java.util.HashMap;
import java.util.Map;

public class CenterGraph {

    public int  findCenter (int [][] edges) {
        int[] nums = new int[edges.length * 2];
        int c = 0;
        for (int i = 0; i < edges.length; i++) {
            nums[c] = edges[i][0];
            c++;
            nums[c] = edges[i][1];
            c++;

        }
        Map<Integer, Integer> freqTable = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (freqTable.containsKey(nums[i])) {
                int value = freqTable.get(nums[i]) + 1;
                freqTable.put(nums[i], value);
            } else {
                freqTable.put(nums[i], 1);
            }

        }
        int max = Integer.MIN_VALUE;
        int element = -1;
        for(Integer i: freqTable.keySet()){
            if (freqTable.get(i) > max){
                max = freqTable.get(i);
                element = i;
            }
        }
        return element;
    }

    public static void main(String[] args) {
        System.out.println(new CenterGraph().findCenter(new int [][]{{1,2},{5,1},{1,3},{1,4}}));
    }
}
