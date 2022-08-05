public class GameOfLife {

    public void gameOfLife(int[][] board) {
        /**
         * Any live cell with fewer than two live neighbors dies as if caused by under-population.
         * Any live cell with two or three live neighbors lives on to the next generation.
         * Any live cell with more than three live neighbors dies, as if by over-population.X
         * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.X
         */

        if (board.length == 1 && board[0].length == 1) {
            board[0][0] = 0;
            return;
        }else if(board.length == 1 && board[0].length == 2) {
            board[0][0] = 0;
            board[0][1] = 0;
            return;
        } else if( board.length == 1 && board[0].length > 2){
            board[0][0] = 0;
            board[0][board[0].length-1] = 0;
           for(int i = 1; i < board[0].length - 1; i++){
               if(isAlive(board,0,i) && !isAlive(board,0,i-1) && !isAlive(board,0,i+1)){
                   board[0][i] = 0;
               }

           }
            return;
        }else if(board.length  == 2 && board[0].length == 1){
            board[0][0] = 0;
            board[0][1] = 0;
            return;
        }else if(board.length > 2 && board[0].length == 1) {
            board[0][0] = 0;
            board[board.length-1][0] = 0;
            for(int i = 1; i < board.length -1; i++) {
                if(isAlive(board,i,0) && !isAlive(board,i-1,0) && !isAlive(board,i + 1, 0)) {
                    board[i][0] = 0;
                }
            }
            return;
        }
        int[][] initialState = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            initialState[i] = board[i].clone();
        }


        for (int row = 0; row < initialState.length; row++) {
            for (int col = 0; col < initialState[row].length; col++) {
                int aliveSize = countAliveNeighbors(initialState, row, col);
                if (isAlive(initialState, row, col)) {
                    if (aliveSize < 2) {
                        board[row][col] = 0;
                    } else if (aliveSize > 3) {
                        board[row][col] = 0;
                    }
                } else {
                    if (aliveSize == 3) {
                        board[row][col] = 1;
                    }
                }
            }
        }
        printMatrix(board);

    }


    private static void printMatrix(int[][] values) {
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[i].length; j++) {
                System.out.print(values[i][j]);
            }
            System.out.println("");
        }
    }

    private static int countAliveNeighbors(int[][] matrix, int row, int col) {
        if (topLeftCorner(row, col)) {
            return leftTopCornerSum(matrix, row, col);

        } else if (topRightCorner(matrix, row, col)) {
            return rightTopCornerSum(matrix, row, col);

        } else if (bottomLeftCorner(matrix, row, col)) {
            return bottomLeftCornerSum(matrix, row, col);

        } else if (bottomRightCorner(matrix, row, col)) {
            return bottomRightSum(matrix, row, col);

        }

        if (leftWall(matrix, row, col)) {
            return matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row][col + 1] + matrix[row - 1][col + 1] + matrix[row - 1][col];
        } else if (rightWall(matrix, row, col)) {
            return matrix[row + 1][col] + matrix[row + 1][col - 1] + matrix[row][col - 1] + matrix[row - 1][col - 1] + matrix[row - 1][col];
        } else if (topWall(matrix, row, col)) {
            return matrix[row][col - 1] + matrix[row + 1][col - 1] + matrix[row + 1][col] + matrix[row][col + 1] + matrix[row + 1][col + 1];
        } else if (bottomWall(matrix, row, col)) {
            return matrix[row][col - 1] + matrix[row - 1][col - 1] + matrix[row - 1][col] + matrix[row - 1][col + 1] + matrix[row][col + 1];
        }

        return matrix[row + 1][col - 1] + matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row][col - 1] + matrix[row][col + 1] + matrix[row - 1][col - 1] + matrix[row - 1][col] + matrix[row - 1][col + 1];

    }

    private static int leftTopCornerSum(int matrix[][], int row, int col) {
        return matrix[row][col + 1] + matrix[row + 1][col] + matrix[row + 1][col + 1];
    }

    private static int rightTopCornerSum(int[][] matrix, int row, int col) {
        return matrix[row][col - 1] + matrix[row + 1][col] + matrix[row + 1][col - 1];
    }

    private static int bottomLeftCornerSum(int[][] matrix, int row, int col) {
        return matrix[row - 1][col] + matrix[row - 1][col + 1] + matrix[row][col + 1];
    }

    private static int bottomRightSum(int[][] matrix, int row, int col) {
        return matrix[row][col - 1] + matrix[row - 1][col - 1] + matrix[row - 1][col];
    }

    //Edge cases
    private static boolean topLeftCorner(int row, int col) {
        return row == 0 && col == 0;
    }

    private static boolean topRightCorner(int[][] matrix, int row, int col) {
        return row == 0 && col == matrix[row].length - 1;
    }

    private static boolean bottomLeftCorner(int[][] matrix, int row, int col) {
        return row == matrix.length - 1 && col == 0;
    }

    private static boolean bottomRightCorner(int[][] matrix, int row, int col) {
        return row == matrix.length - 1 && col == matrix[row].length - 1;
    }
    //Edge cases

    private static boolean leftWall(int matrix[][], int row, int col) {
        return col == 0 && !topLeftCorner(row, col) && !bottomLeftCorner(matrix, row, col);
    }

    private static boolean rightWall(int[][] matrix, int row, int col) {
        return col == matrix[row].length - 1 && !topRightCorner(matrix, row, col) && !bottomRightCorner(matrix, row, col);
    }

    private static boolean topWall(int matrix[][], int row, int col) {
        return row == 0 && !topLeftCorner(row, col) && !topRightCorner(matrix, row, col);
    }

    private static boolean bottomWall(int[][] matrix, int row, int col) {
        return row == matrix.length - 1 && !bottomRightCorner(matrix, row, col) && !bottomLeftCorner(matrix, row, col);
    }

    private static boolean isAlive(int[][] matrix, int row, int col) {
        return matrix[row][col] == 1;
    }


    public static void main(String[] args) {
       // int matrix[][] = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        int [][]matrix = {{1,0,0,1}};
        new GameOfLife().gameOfLife(matrix);


    }
}
