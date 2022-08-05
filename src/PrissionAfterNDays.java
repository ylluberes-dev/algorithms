import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class PrissionAfterNDays {

    public int[] prisonAfterNDays(int[] cells, int n) {

        for (int k = 0; k < n; k++) {

            int prevState [] = copyElements(cells);

            for (int i = 0; i < cells.length; i++) {
                if (i > 0 && i < (cells.length - 1)) {
                    if (prevState[i + 1] == 1 && prevState[i - 1] == 1) {
                        cells[i] = 1;
                    } else if (prevState[i + 1] == 0 && prevState[i - 1] == 0) {
                        cells[i] = 1;
                    } else {
                        cells[i] = 0;
                    }
                } else {
                    cells[i] = 0;
                }
            }
        }
        return cells;
    }

    /**
     *
     * @param arr
     * @return
     */
    static int [] copyElements (int [] arr){
        int copy [] = new int [arr.length];
        for (int i = 0 ; i < arr.length; i ++){
          copy[i] = arr[i];
        }
        return copy;
    }
    static String printArr(int arr[]) {
        StringBuilder builder = new StringBuilder();
        Arrays.stream(arr).forEach(x -> {
            builder.append(x + " ");
        });
        return builder.toString();
    }

    public static void main(String[] args) {
        Instant start = Instant.now();
        System.out.println(printArr(new PrissionAfterNDays().prisonAfterNDays(new int[]{1,0,0,1,0,0,1,0}, 1000000000)));
        Instant after = Instant.now();
        System.out.println("Elapsed time: "+ (Duration.between(start,after)));
    }
}
