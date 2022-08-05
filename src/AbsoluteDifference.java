import java.util.Arrays;
public class AbsoluteDifference {

    public int[] getSumAbsoluteDifferences(int[] nums) {
        final int arrSize = nums.length;
        int [] output = new int [arrSize];
        for (int i = 0; i < arrSize; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                if(i!=j){
                    sum += Math.abs(nums[i] - nums[j]);
                }
            }
            output[i] = sum;
        }
        return output;
    }


    private static void printArr(int[] values) {
        if (values != null && values.length > 0)
            for (int i = 0; i < values.length; i++) {
                System.out.print(values[i] + " ");
            }
        else
            throw new IllegalArgumentException("Array input can not bet null and should contains a least one element.");
    }

    public static void main(String[] args) {

        //Testing output
       //printArr(new int []{1,2,3,4,5});

        //Testing getSumAbsoluteDifferences method #Test case #1
        System.out.println("Output test case #1: ");
        printArr(new AbsoluteDifference().getSumAbsoluteDifferences(new int []{2,3,5}));
        System.out.println();

        //Testing getSumAbsoluteDifferences method #Test case #2
        System.out.println("Output test case #2: ");
        printArr(new AbsoluteDifference().getSumAbsoluteDifferences(new int []{1,4,6,8,10}));


    }
}
