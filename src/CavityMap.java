public class CavityMap {


    static String[] cavityMap(String[] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                if (i == 0 || j == 0) {
                    continue;
                }

                int current = Integer.parseInt(String.valueOf(grid[i].charAt(j)));
                int top=-1, bottom=-1, left=-1, right =-1;
                boolean allowTop = false, allowBottom = false, allowLeft = false, allowRight = false;


                if (i-1 >=0) {
                    if (grid[i - 1].charAt(j) != 'X') {
                        top = Integer.parseInt(String.valueOf(grid[i - 1].charAt(j)));
                        allowTop = true;
                    }
                }
                if (i+1 < grid.length) {
                    if (grid[i + 1].charAt(j) != 'X') {
                        bottom = Integer.parseInt(String.valueOf(grid[i + 1].charAt(j)));
                        allowBottom = true;
                    }
                }
                if (j-1 >= 0) {
                    if (grid[i].charAt(j - 1) != 'X') {
                        left = Integer.parseInt(String.valueOf(grid[i].charAt(j - 1)));
                        allowLeft = true;
                    }
                }
                if (j + 1 < grid[i].length()) {
                    if (grid[i].charAt(j + 1) != 'X') {
                        right = Integer.parseInt(String.valueOf(grid[i].charAt(j + 1)));
                        allowRight = true;
                    }
                }

                if (allowTop && current > top) {
                    if (allowBottom && current > bottom) {
                        if (allowLeft && current > left) {
                            if (allowRight && current > right) {
                              //  char value = grid[i].charAt(j);
                                grid[i] = replaceCharAt(grid[i],j,'X');
                            }
                        }
                    }
                }
            }
        }


        return grid;
    }
    private static String replaceCharAt(String s, int pos, char c) {
        return s.substring(0,pos) + c + s.substring(pos+1);
    }

    public static void main(String[] args) {
        String ret[] = cavityMap(new String[]{"462664", "669722", "297288", "796928","584497","357431"});
        for (int i = 0; i < ret.length; i++) {
            System.out.println(ret[i]);
        }
    }
}
