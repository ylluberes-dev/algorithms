import java.util.ArrayList;
import java.util.List;

public class PrisonAfterN {

    public int[] prisonAfterNDays(int[] cells, int n) {
        List<Integer> changes = new ArrayList<>(8);
        for (int i = 0; i <= n; i++) {
            //System.out.print("Day: " + i);
           // System.out.println();

            if(i > 0) {
                cells[0] = cells[0] == 1 && cells[1] == 0 ? 0 : 0;
                cells[cells.length - 1] = cells[cells.length - 1] == 1 && cells[cells.length - 2] == 0 ? 0 : 0;
            }

            if (changes.size() > 0) {
                for (Integer change : changes) {
                    cells[change] = cells[change] == 1 ? 0 : 1;
                }

                changes.clear();
            }
            //print(cells);
            for (int j = 1; j < cells.length - 1; j++) {
                if ((cells[j - 1] == 1 && cells[j + 1] == 1) || (cells[j - 1] == 0 && cells[j + 1] == 0)) {
                    if (cells[j] == 0)
                        changes.add(j); // Make occupied
                } else {
                    if (cells[j] == 1)
                        changes.add(j); // Make vacant
                }
            }
           // System.out.println();
        }
        return cells;
    }

    public static void main(String[] args) {
        int test[] = {1,0,0,1,0,0,1,0};
        print(new PrisonAfterN().prisonAfterNDays(test, 1000000000));

    }

    static void print(int[] values) {
        if (values != null && values.length > 0) {
            for (int i = 0; i < values.length; i++)
                System.out.print(values[i] + " ");
        }
    }
}
