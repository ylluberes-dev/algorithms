public class SubArrayPartition {


    //DP PROBLEM ...

    public int maxSumAfterPartitioning(int[] arr, int k) {

        for (int i = 0; i < arr.length; i++) {

        }

        return 0;
    }

    public static void main(String[] args) {

        System.out.println("Test case #1: ");
        System.out.println(new SubArrayPartition().maxSumAfterPartitioning(new int [] {1,15,7,9,2,5,10},3));
        System.out.println();

        System.out.println("Test case #2: ");
        System.out.println(new SubArrayPartition().maxSumAfterPartitioning(new int [] {1,4,1,5,7,3,6,1,9,9,3},4));
        System.out.println();

        System.out.println("Test case #2: ");
        System.out.println(new SubArrayPartition().maxSumAfterPartitioning(new int [] {1},1));
        System.out.println();
    }
}
