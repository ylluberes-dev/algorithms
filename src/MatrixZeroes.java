import java.util.HashMap;
import java.util.Map;

public class MatrixZeroes {


    static void setZeroes(int[][] matrix) {
        Map<Integer, Integer> fakeZeroCord = new HashMap();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    if (fakeZeroCord.containsKey(i)) {
                        fakeZeroCord.put(i, j);
                    }
                }
            }
        }

        System.out.println("");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (fakeZeroCord.get(i) != null && fakeZeroCord.get(i) == j) {
                    int k = i;
                    for (int q = 0; q < matrix[i].length; q++) {
                        matrix[k][q] = 0;
                    }
                    int h = j;
                    for (int m = 0; m < matrix.length; m++) {
                        matrix[m][h] = 0;
                    }

                }
            }
        }
    }

    static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println(" ");
        }
    }

    static void testSwitch (String value){
        switch (value){
            case "K" : case "adios" :
                System.out.println("KLK manito");
                break;
            case "dimelo":
                System.out.println("Que te digo");
                break;
        }
    }

    public static void main(String[] args) {
        //testSwitch("dimelo");
        //System.exit(0);
        int[][] matrix = {{0,1,2,0},
                          {3,4,5,2},
                          {1,3,1,5}};
        setZeroes(matrix);
        printMatrix(matrix);
    }
}




