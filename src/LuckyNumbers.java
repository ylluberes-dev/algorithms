import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LuckyNumbers {

    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> luckyNumbers = new ArrayList<>();
        Map<String,Integer> minIndexPair = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            int min = Integer.MAX_VALUE;
            int current = 0;
            int col = -1;
            for (int j = 0; j < matrix[i].length; j++) {
                 current = matrix[i][j];
                if(current < min){
                    min = current;
                    col = j;
                }
            }
            minIndexPair.put(i+","+col,min);
        }

        System.out.println();
        for (String str: minIndexPair.keySet()) {
            int col = Integer.parseInt(str.split(",")[1]);
            boolean max = true;
            for (int i = 0; i < matrix.length; i++) {
                int cur = matrix[i][col];
                if(cur > minIndexPair.get(str)){
                    max = false;
                    break;
                }
            }
            if(max){
                luckyNumbers.add(minIndexPair.get(str));
            }
        }
        return luckyNumbers;
    }



    public static void main(String[] args) {
        System.out.println(new LuckyNumbers().luckyNumbers(new int [][]{{7,8},
                                                                         {1,2}}));
    }
}
