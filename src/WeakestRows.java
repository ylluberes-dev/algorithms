import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class WeakestRows {
    class ValueComparator implements Comparator<Integer> {
        Map<Integer, Integer> base;

        public ValueComparator(Map<Integer, Integer> base) {
            this.base = base;
        }

        // Note: this comparator imposes orderings that are inconsistent with
        // equals.
        public int compare(Integer a, Integer b) {
            if (base.get(a) == base.get(b)) {
                if (a.intValue() > b.intValue()) {
                    return 1;
                } else {
                    return -1;
                }
            } else if (base.get(a) > base.get(b)) {
                return 1;
            } // returning 0 would merge keys
            else {
                return -1;
            }
        }
    }
        public int[] kWeakestRows(int[][] mat, int k) {
            int weakest[] = new int[k];
            Map<Integer, Integer> soldierMap = new HashMap<>();
            for (int i = 0; i < mat.length; i++) {
                int soldiersAt = 0;
                for (int j = 0; j < mat[i].length; j++) {
                    if (mat[i][j] == 1) {
                        soldiersAt++;
                    }
                }
                soldierMap.put(i, soldiersAt);
            }

            ValueComparator comparator = new ValueComparator(soldierMap);
            TreeMap<Integer,Integer> treeMap = new TreeMap(comparator);
            treeMap.putAll(soldierMap);

            /**
             * 0 -> 2
             * 1 -> 4
             * 2 -> 1
             * 3 -> 2
             * 4 -> 5
             */

            int count = 0;
            for (Integer key: treeMap.keySet()) {
                if(count == k) break;
                weakest[count] = key;
                count++;
            }
            return weakest;
        }


        private static void printArr(int[] values) {
            for (int i = 0; i < values.length; i++) {
                if (i + 1 == values.length) {
                    System.out.print(values[i]);
                } else {
                    System.out.print(values[i] + ", ");
                }
            }
        }

        public static void main(String[] args) {
            printArr(new WeakestRows().kWeakestRows(new int[][]{{1,0,0,0},
                    {1,1,1,1},
                    {1,0,0,0},
                    {1,0,0,0}}, 2));
        }
    }
