import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {

        int rowCount = 0;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> row = new ArrayList<>(i);
            for (int n = 0; n < i; n++)
                row.add(1);
            if (i >= 3) {
                List<Integer> prev = result.get(rowCount - 1); // Prev row
                int pointer = 1;
                for (int k = 0; k < prev.size() - 1; k++) {
                    int element = prev.get(k) + prev.get(k + 1);
                    row.set(pointer, element);
                    pointer++;
                }
            }
            rowCount++;
            result.add(row);
        }
        return result;
    }

    public static void main(String[] args) {
       /* List<List<Integer>> values = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        first.add(1);
        second.add(1);
        second.add(1);
        values.add(first);
        values.add(second);
        List<Integer> prev= values.get(0);*/

        new PascalTriangle().generate(5);
    }
}
