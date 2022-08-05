public class MinPathSum {

    public int minPathSum(int[][] grid) {

        //Greedy

        int rowMove = 0;
        int colMove = 0;
        int sum = 0;
        int down = 0;
        int right = 0;
        while (true) {
            if (rowMove == grid.length && colMove == grid[rowMove].length)
                break; //  If we reach the bottom right corner

            int current = grid[rowMove][colMove];
            sum += current;
            if (rowMove + 1 < grid.length)
                down = grid[rowMove + 1][colMove];

            if (colMove + 1 < grid[rowMove].length)
                right = grid[rowMove][colMove + 1];

            if (down < right) {
                rowMove++;
            } else {
                colMove++;
            }

        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("Test case #1: ");
        System.out.println(new MinPathSum().minPathSum(new int[][]{{1, 3, 1},
                                                                   {1, 5, 1},
                                                                   {4, 2, 1}}));
        System.out.println();


        System.out.println("Test case #2: ");
        System.out.println(new MinPathSum().minPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}}));
        System.out.println();
    }
}
