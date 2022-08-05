import java.util.Arrays;

public class DefuseBomb {

    /**
     *
     * @param code
     * @param k
     * @return defuse bomb`s code
     * Complexity O(n*k)
     */
    public int[] decrypt(int[] code, int k) {
        final int size = code.length;
        int ret [] = new int [size];
        int sum;
        if(k == 0) { //Best case
            return ret;
        } else if (k > 0){
            for (int i = 0; i < size; i++) {
                sum = 0;
               int count = 0;
               int index = i + 1;
               while(count < k){
                   if(index == size)
                       index = 0;
                   sum+= code[index];
                   count++;
                   index++;
               }
               ret[i] = sum;
            }
        }else {
            for (int i = 0; i < size; i++) {
                sum = 0;
                int count = 0;
                int index = i - 1;
                while(count < (k*-1)){
                    if(index == -1)
                        index = size - 1;
                    sum+= code[index];
                    count++;
                    index--;
                }
                ret[i] = sum;
            }
        }
        return ret;
    }

    private static void printArr(int[] values) {
        if (values != null && values.length > 0)
            for (int i = 0; i < values.length; i++) {
                System.out.print(values[i] + " ");
            }
    }

    public static void main(String[] args) {
        int testCase1[] = {5, 7, 1, 4};
        System.out.println("Output of test case #1: ");
        printArr(new DefuseBomb().decrypt(testCase1, 3));
        System.out.println();
        System.out.println();


        int testCase2[] = {1, 2, 3, 4};
        System.out.println("Output of test case #2: ");
        printArr(new DefuseBomb().decrypt(testCase2, 0));
        System.out.println();
        System.out.println();


        int testCase3[] = {2, 4, 9, 3};
        System.out.println("Output of test case #3: ");
        printArr(new DefuseBomb().decrypt(testCase3, -2));
    }
}
