import com.sun.javaws.exceptions.InvalidArgumentException;

public class SortAnArray {

    public int[] sortArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean swap = false;
            for (int j = 0; j < nums.length - 1; j++) {
                    if (nums[j] > nums[j+1]) {
                        swap(j+1, j, nums);
                        swap = true;
                    }
            }
            if (!swap) return nums; // Is already sorted
        }
        return nums;
    }

    static void swap(int a, int b, int[] arr) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    private static void printArr(int[] values) throws InvalidArgumentException {
        if (values != null && values.length > 0) {
            for (int i = 0; i < values.length; i++) {
                System.out.print(values[i] + " ");
            }
        } else {
            throw new InvalidArgumentException(new String[]{"Param values canot ben NULL"});
        }

    }

    public static void main(String[] args) {
        try {
            System.out.println("Before sort: ");
            int testCase[] = {5, 2, 3, 1};
            printArr(testCase);
            new SortAnArray().sortArray(testCase);
            System.out.println();
            System.out.println("After sort: ");
            printArr(testCase);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
