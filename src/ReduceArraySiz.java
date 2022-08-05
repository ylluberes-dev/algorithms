import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ReduceArraySiz {

    public int minSetSize(int[] arr) {
        Map<Integer, Integer> table = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (table.containsKey(arr[i])) {
                table.replace(arr[i], table.get(arr[i]) + 1);
            } else {
                table.put(arr[i], 1);
            }
        }


        int frequencies = 0;
        int setSize = 0;

        LinkedHashMap<Integer, Integer> reverseSortedMap = new LinkedHashMap<>();

        table.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));

        for (Integer key : reverseSortedMap.keySet()) {
            if(frequencies >= (arr.length / 2)){
                break;
            }
            frequencies += table.get(key);
            setSize++;

        }
        return setSize;
    }

    public static void main(String[] args) {
        System.out.println(new ReduceArraySiz().minSetSize(new int[]{3,3,3,3,5,5,5,2,2,7}));
    }
}
