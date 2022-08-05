public class DiagonalSum {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int colCount = mat.length - 1;
        int rowCont = 0;
        if (mat.length % 2 != 0) {
            sum -= mat[mat.length/2][mat.length/2];
        }
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (i == j) { //Same diagonal (principal)
                    sum += mat[i][j];
                }
            }
            sum += mat[rowCont][colCount];
            rowCont++;
            colCount--;
        }
        return sum;
    }


    public static void main(String[] args) {
        System.out.println(new DiagonalSum().diagonalSum(new int[][]{{5}}));
    }
}
