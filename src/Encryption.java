import java.util.ArrayList;
import java.util.List;

public class Encryption {

    public static String encryption(String s) {

        // Write your code here
        s = s.replaceAll("\\s", ""); // Removing all spaces
        double result = Math.sqrt(s.length());

        System.out.println("Word size: " + s.length());
        int rows = (int) Math.floor(result);
        int cols = (int) Math.ceil(result);

        while (rows * cols < s.length()) {
            rows++;
        }

        char matrix[][] = new char[rows][cols];
        int r = 0, c = 0;
        for (int i = 0; i < s.length(); i++) {
            matrix[r][c] = s.charAt(i);
            if (c == cols - 1) {
                r++;
                c = 0;
            } else {
                c++;
            }

        }
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < cols; i++) {
            int t = 0;
            for (int j = 0; j < matrix.length; j++) {
                if(!(matrix[t][i] == '\u0000')) {
                    ret.append(matrix[t][i]);
                    t++;
                }

            }
            if (i + 1 < cols)
                ret.append(" ");

        }

        return ret.toString().trim();
    }


    public static void main(String[] args) {
        System.out.println(encryption("feedthedog"));

        /**
         * fto ehg ee  dd
         * fto ehg ee  dd
         * fto ehg ee  dd
         * ftoehgee dd
         * ftoehgee dd
         * fto ehg ee  dd
         * fto ehg ee  dd
         * fto ehg ee dd
         */
    }
}
