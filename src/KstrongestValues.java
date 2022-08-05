import java.util.Arrays;

public class KstrongestValues {

    public int[] getStrongest(int[] arr, int k) {

        Arrays.sort(arr);
        int median = arr[(arr.length - 1) / 2];

        int[] result = new int[k];
        int index = 0;
        int leftPointer = 0;
        int rightPointer = arr.length - 1;
        int counter = 0;
        while (counter < k) {
            int left = arr[leftPointer];
            int right = arr[rightPointer];

            int leftResult = Math.abs(left - median);
            int rightResult = Math.abs(right - median);

            if (leftResult > rightResult) {
                result[index] = left;
                leftPointer++;

            } else if (rightResult > leftResult) {
                result[index] = right;
                rightPointer--;

            } else {
                if (right > left) {
                    result[index] = right;
                    rightPointer--;

                } else {
                    result[index] = left;
                    leftPointer++;
                }
            }

            index++;
            counter++;

        }
        return result;
    }


    private static void printResult(int[] values) {
        if (values != null && values.length > 0) {
            for (int i = 0; i < values.length; i++) {
                System.out.print(values[i] + " ");
            }
        }else {
            System.out.println("Array input is null or empty"); //Throw an exception
        }
    }

    public static void main(String[] args) {
        printResult(new KstrongestValues().getStrongest(new int []{-7,22,17,3},2));
    }
}
