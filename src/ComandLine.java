import java.util.ArrayList;
import java.util.List;

public class ComandLine {

    private static String toBinaryString (int N) {
        StringBuilder builder = new StringBuilder();
        while(true) {
            int binValue = N % 2;
            builder.append(binValue);
            N /= 2;
            if (N == 1) {
                builder.append(N);
                break;
            }
        }
    return builder.toString(); // Reverse

    }
    public static void main(String[] args) {


        int sum = 0;
        for (int i = 1; i < 1000; i++)
            for (int j = 0; j < i; j++)
                sum++;
        System.out.println(sum);

        System.out.println(toBinaryString(158));

        /* System.out.println('b');
         System.out.println('b' + 'c');
         System.out.println((char) ('a' + 4));*/

        /*int f = 0;
        int g = 1;
        for (int i = 0; i <= 15; i++)
        {
            System.out.println(f);
            f = f + g; //1 1 2
            g = f - g; //0 0
        }*/
       /* double x = Double.parseDouble(args[0]);

        double y = Double.parseDouble(args[1]);

        if (x < 0 || x > 1 || y < 0 || y > 1) {
            System.out.println(false);
        } else {
            System.out.println(true);
        }*/


      //  int value = Integer.parseInt(args[0]);

      /*  if (value == 3) {
            System.out.println("Equal");
        } else {
            System.out.println("Not equal");
        }*/
    }
}
