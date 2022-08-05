import java.util.Arrays;

public class ProcessQueries {

    public int[] processQueries(int[] queries, int m) {
        int [] P = new int [m];
        for (int i = 0; i < m; i++){
            P[i] = i + 1;
        }
        int [] ret = new int [queries.length];
        for (int i = 0; i < queries.length; i++) {
            int value = queries[i];
            int pos = -1;
            // Find the pos of value in P array
            for (int j =0; j < P.length; j++) {
                if (P[j] == value) {
                    pos = j;
                    break;
                }
            }
            shiftLeft(P,pos);
            ret[i] = pos;
            }


        return ret;
    }


    private static void shiftLeft (int [] values, int startPoint) {
      for (int i = startPoint; i > 0; i--) {
          int temp = values[i-1];
          values[i-1] = values[i];
          values[i] = temp;
      }
    }


    private static void printArr (int [] values) {
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i]+ " ");
        }
    }

    public static void main(String[] args) {
        //int [] test = {1,2,3,4,5};
        //shiftLeft(test,3);
       // printArr(test);
        printArr(new ProcessQueries().processQueries(new int [] {7,5,5,8,3},8));
    }
}
