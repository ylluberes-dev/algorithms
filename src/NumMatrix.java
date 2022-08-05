class NumMatrix {

    private int [][] matrix;
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        //  int k = row1;
        int sum = 0;
        for (int r = row1; r <= row2; r++) {

            for (int col = col1; col <= col2; col++){

                sum = sum + matrix[r][col];
            }
            //col = 0;
        }

        return sum;

    }

    public static void main(String[] args) {
        int [][] matrix =  {{3,0,1,4,2},
                            {5,6,3,2,1},
                            {1,2,0,1,5},
                            {4,1,0,1,7},
                            {1,0,3,0,5}};
        NumMatrix mat = new NumMatrix(matrix);

        int res = mat.sumRegion(2,1,4,3);
        System.out.println();
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */