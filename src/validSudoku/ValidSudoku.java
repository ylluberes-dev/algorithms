package validSudoku;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    /**
     * Solution steps:
     *
     * 1) Iterate the grid and count every row filled cell, add every row filled cell to set<T> structure and then check if set<T> size is equal to the number of filled cell in the row
     * 2) Repeat step 1) with every col
     * 3) Repeat step 1) with sub-boxes
     * */

    /**
     * O(N*M)
     */

     boolean checkSubBox(char[][] grid) {

        Set<Integer> subValues = new HashSet<>();
        int values = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == '.') {
                    continue;
                } else {
                    subValues.add(Integer.parseInt(String.valueOf(grid[i][j])));
                    values++;
                }
            }
        }
        if (values != subValues.size()) {
            return false;
        }

        subValues.clear();
        values = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 3; j < 6; j++) {
                if (grid[i][j] == '.') {
                    continue;
                } else {
                    subValues.add(Integer.parseInt(String.valueOf(grid[i][j])));
                    values++;
                }
            }
        }
        if (values != subValues.size()) {
            return false;
        }

        subValues.clear();
        values = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 6; j < 9; j++) {
                if (grid[i][j] == '.') {
                    continue;
                } else {
                    subValues.add(Integer.parseInt(String.valueOf(grid[i][j])));
                    values++;
                }
            }
        }

        if (values != subValues.size()) {
            return false;
        }

        subValues.clear();
        values = 0;


        for (int i = 3; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == '.') {
                    continue;
                } else {
                    subValues.add(Integer.parseInt(String.valueOf(grid[i][j])));
                    values++;
                }
            }
        }


        if (values != subValues.size()) {
            return false;
        }

         subValues.clear();
         values = 0;
        for (int i = 3; i < 6; i++) {
            for (int j = 3; j < 6; j++) {
                if (grid[i][j] == '.') {
                    continue;
                } else {
                    subValues.add(Integer.parseInt(String.valueOf(grid[i][j])));
                    values++;
                }
            }
        }

        if (values != subValues.size()) {
            return false;
        }

        subValues.clear();
        values = 0;

        for (int i = 3; i < 6; i++) {
            for (int j = 6; j < 9; j++) {
                if (grid[i][j] == '.') {
                    continue;
                } else {
                    subValues.add(Integer.parseInt(String.valueOf(grid[i][j])));
                    values++;
                }
            }
        }

        if (values != subValues.size()) {
            return false;
        }

        subValues.clear();
        values = 0;

        for (int i = 6; i < 9; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == '.') {
                    continue;
                } else {
                    subValues.add(Integer.parseInt(String.valueOf(grid[i][j])));
                    values++;
                }
            }
        }

        if (values != subValues.size()) {
            return false;
        }

        subValues.clear();
        values = 0;

        for (int i = 6; i < 9; i++) {
            for (int j = 3; j < 6; j++) {
                if (grid[i][j] == '.') {
                    continue;
                } else {
                    subValues.add(Integer.parseInt(String.valueOf(grid[i][j])));
                    values++;
                }
            }
        }

        if (values != subValues.size()) {
            return false;
        }

        subValues.clear();
        values = 0;

        for (int i = 6; i < 9; i++) {
            for (int j = 6; j < 9; j++) {
                if (grid[i][j] == '.') {
                    continue;
                } else {
                    subValues.add(Integer.parseInt(String.valueOf(grid[i][j])));
                    values++;
                }
            }
        }

        if (values != subValues.size()) {
            return false;
        }

        return true;
    }

     boolean validSudoku(char[][] grid) {
        if (grid == null) return false;

        int rowFilledCell;
        int colFilledCell;
        Set<Integer> rowValues = new HashSet<>();
        Set<Integer> colValues = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            rowValues.clear();
            colValues.clear();
            rowFilledCell = 0;
            colFilledCell = 0;
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '.') {
                    continue;
                } else {
                    rowValues.add(Integer.parseInt(String.valueOf(grid[i][j])));
                    rowFilledCell++;
                }
            }
            for (int k = 0; k < grid.length; k++) {
                if (grid[k][i] == '.') {
                    continue;
                } else {
                    colValues.add(Integer.parseInt(String.valueOf(grid[k][i])));
                    colFilledCell++;
                }
            }
            if (!(rowFilledCell == rowValues.size())) { //  duplicates
                return false;
            }
            if (!(colFilledCell == colValues.size())) { // duplicates
                return false;
            }

        }
       return checkSubBox(grid);
    }


    public static void main(String[] args) {

      char testCase [][] =  {
                             {'.','.','.','.','6','.','.','1','.'},
                             {'.','8','.','5','.','7','4','.','.'},
                             {'.','.','.','.','.','.','.','.','.'},
                             {'.','.','1','.','.','.','.','.','.'},
                             {'.','.','.','.','.','.','.','8','.'},
                             {'4','1','.','2','.','8','.','7','9'},
                             {'.','.','.','.','.','.','.','9','3'},
                             {'.','6','.','8','3','1','.','.','.'},
                             {'8','.','7','.','.','.','.','.','.'}
      };
        char[][] grid = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(new ValidSudoku().validSudoku(grid));
        System.out.println("Stop");
    }
}
