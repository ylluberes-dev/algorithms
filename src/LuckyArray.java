import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LuckyArray {

    public int findLucky(int[] arr) {
        // Create a frequency table
        Map<Integer,Integer> frequencyTable = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];
            if(frequencyTable.containsKey(current)){
                frequencyTable.replace(current,frequencyTable.get(current) + 1);
            }else {
                frequencyTable.put(current,1);
            }
        }
        List<Integer> luckyList = new ArrayList<>();
        for (Integer key: frequencyTable.keySet()){
            if(key == frequencyTable.get(key)){
                luckyList.add(key);
            }
        }
        if(luckyList.size() == 0) return -1;
        if(luckyList.size() > 1) return luckyList.stream().mapToInt(x ->x).max().orElseThrow(null);

        return luckyList.get(0);
    }


    public static void main(String[] args) {
        System.out.println(new LuckyArray().findLucky(new int []{7,7,7,7,7,7,7}));
    }
}
