import java.util.Arrays;

public class RelativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        int [] ret = new int [arr1.length];
        int added = 0;
        for (int i = 0; i < arr2.length; i++){
           int target = arr2[i];
           for (int j = 0; j < arr1.length; j++) {
               if(arr1[j] == target){
                   ret[added] = target;
                   added++;
                   arr1[j]=-1;
               }
           }

        }

        Arrays.sort(arr1);
        for (int i = 0 ; i < arr1.length; i++) {
            if(arr1[i] != -1){
                ret[added] = arr1[i];
                added++;
            }
        }
        //Elements in arr1 marked as -1 was the elements that were found
        return ret;
    }

    public static void main(String[] args) {
        System.out.println("Test case #1: ");
        printArr(new RelativeSortArray().relativeSortArray(new int []{2,3,1,3,2,4,6,7,9,2,19},new int []{2,1,4,3,9,6}));
    }

    private static void printArr (int [] values)
    {
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] +  " ");
        }
    }
}
