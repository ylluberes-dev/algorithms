import java.util.HashMap;
import java.util.Map;

public class MakeArrayEquals {

    public boolean canBeEqual(int[] target, int[] arr) {

        Map<Integer,Integer> originalMap = mapToTable(arr);
        Map<Integer,Integer> targetMap = mapToTable(target);

        for (Integer key: originalMap.keySet()){
            if (originalMap.get(key) != targetMap.get(key)){
                return false;
            }
        }
        return true;
    }

    private static Map<Integer, Integer> mapToTable(int[] values) {
        final Map<Integer, Integer> table = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            int current = values[i];
            if (table.containsKey(current)) {
                table.replace(current, table.get(current) + 1);
            } else {
                table.put(current, 1);
            }
        }
        return table;
    }


    public static void main(String[] args) {
        System.out.println(new MakeArrayEquals().canBeEqual(new int[]{1, 2, 3, 4}, new int[]{2, 4, 1, 3}));
    }
}
