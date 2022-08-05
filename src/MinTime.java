import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MinTime {

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {

        List<Integer> applesIndex = new ArrayList<>();

        for (int i = 0; i < hasApple.size(); i++) {
            if (hasApple.get(i)) {
                applesIndex.add(i);
            }
        }

        int seconds = 0;
        for (Integer applePos : applesIndex) {

            for (int i = 0; i < n; i++) {
                int left = edges[i][0];
                int right = edges[i][1];

                if(left == applePos){
                    seconds++;
                }
                if(right == applePos){
                    seconds++;
                }

            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Boolean[] apples = {false, false, true, false, true, true, false};
        List<Boolean> applesList = Arrays.stream(apples).collect(Collectors.toList());
        System.out.println(new MinTime().minTime(7, new int[][]{{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}}, applesList));
    }
}
