import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindClosestElements {

    static class PosDistance implements Comparable<PosDistance>{

        enum SortCriteria {
            POSITION,
            DISTANCE
        }
        int pos;
        int distance;
        int value;

        public PosDistance(int pos, int distance, int value) {
            this.pos = pos;
            this.distance = distance;
            this.value = value;
        }

        @Override
        public int compareTo(PosDistance other) {

            if(this.distance < other.distance) {
                return -1;
            }else if (this.distance == other.distance){
                if(this.pos < other.pos) {
                    return -1;
                }else {
                    return 1;
                }
            }
            return 1;
        }
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<PosDistance> values = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            values.add(new PosDistance(i,Math.abs(x - arr[i]), arr[i]));
        }

        Collections.sort(values);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(values.get(i).value);
        }

        Collections.sort(result);
        return result;
    }

    private static void printList (List<Integer> list) {
        for (Integer i: list) {
            System.out.print(i + " ");
        }
    }
    public static void main(String[] args) {
        printList(new FindClosestElements().findClosestElements(new int []{1,2,3,4,5},4,-1));
    }
}
