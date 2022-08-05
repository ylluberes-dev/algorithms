public class SquareUp {
    /**
     * Given n>=0, create an array length n*n with the following pattern,
     * shown here for n=3 : {0, 0, 1,    0, 2, 1,    3, 2, 1} (spaces added to show the 3 groups).
     */

    /**
     * Example:
     * squareUp(3) → [0, 0, 1, 0, 2, 1, 3, 2, 1]
     * squareUp(2) → [0, 1, 2, 1]
     * squareUp(4) → [0, 0, 0, 1, 0, 0, 2, 1, 0, 3, 2, 1, 4, 3, 2, 1]
     */

    public int[] squareUp(int n) {
        int groupSize = n;
        final int[] arr = new int[n * n];
        for (int i = arr.length - 1; i >= 0; i -= n) {
            int count = 1;
            for (int j = i; j > (i - n); j--) {
                arr[j] = count > groupSize ? 0 : count;
                count++;
            }
            groupSize--;
        }
        return arr;
    }

    public static void main(String[] args) {

        final int[] result = new SquareUp().squareUp(3);
        System.out.println();
    }

}
