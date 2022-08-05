public class RestoreMatrix {

    /**
     * Input: rowSum = [3,8],
     *        colSum = [4,7]
     *
     * Output: [[3,0],
     *          [1,7]]
     *
     * @param rowSum
     * @param colSum
     * @return
     */
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {

        return null;
    }

    private static void printMatrix (int [][] matrix) {
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println("");
        }
    }
    public static void main(String[] args) {


        int [][] values = new RestoreMatrix().restoreMatrix(new int []{3,8}, new int []{4,7});
        System.out.println("Output: ");
        printMatrix(values);

    }
}
