import java.util.Arrays;

public class KthSmallest {
    public int kthSmallest(int[][] matrix, int k) {
     /*
     1  5  9
     10 11 13
     12 13 15
     */

        //
        int N = matrix.length;
        int [] ret = new int [N*N];
        int pointer = 0;
        for (int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                ret[pointer] = matrix[i][j];
                pointer++;
            }
        }

        Arrays.sort(ret);
        return ret[k -1];
    }

    public static void main(String[] args) {

        System.out.println(new KthSmallest().kthSmallest(new int [][]{{1,5,9}, {10,11,13}, {12,13,1}},8));
    }
}
