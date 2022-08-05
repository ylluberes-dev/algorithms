public class NearestMatixZero {

    public int[][] updateMatrix(int[][] mat) {
        final int [][] ret = new int [mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if(mat[i][j] == 0){
                    ret[i][j] = 0;
                }else if(mat[i][j] == 1){
                    //Try to find the nearest 0 for cell (i,j)
                    int minDistance = mat.length;
                    for (int k = i; k < mat.length; k++) {
                        for (int p = j; p < mat.length; p++) {
                            if(mat[k][p] == 0){
                                int distance = (Math.abs(k - i) + Math.abs(p - j));
                                if(distance < minDistance){
                                    minDistance = distance;
                                }
                            }
                        }
                    }
                    ret[i][j] = minDistance;
                }
            }
        }
        return ret;
    }


    private static void printMatrix (final int [][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }
    public static void main(String[] args) {
        final int [][] testCase = new int [][] {{0,0,0}, {0,1,0}, {1,1,1}};
        printMatrix(new NearestMatixZero().updateMatrix(testCase));
    }
}
