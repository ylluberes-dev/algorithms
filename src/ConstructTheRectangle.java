import java.util.ArrayList;
import java.util.List;

public class ConstructTheRectangle {


    public int[] constructRectangle(int area) {
        final List<Integer> factors = new ArrayList<>();
        for (int i = 1; i <= area; i++) {
            if (area % i == 0) {
                factors.add(i);
            }
        }
        int min = Integer.MAX_VALUE;
        int length = 0, with = 0;
        for (int i = 0; i < factors.size(); i++) {
            for (int j = 0; j < factors.size(); j++) {
                    int L = factors.get(i);
                    int W = factors.get(j);
                    if(L == 2 && W == 2) {
                        System.out.println("");
                    }
                    if (L >= W) {
                        if (L * W == area) {
                            if (Math.abs(L - W) < min) {
                                min = Math.abs(L - W);
                                length = L;
                                with = W;
                            }
                        }
                    }
                }
        }
        return new int[]{length, with};
    }

    public static void main(String[] args) {
        final int[] result = new ConstructTheRectangle().constructRectangle(4);
        System.out.println("L: " + result[0]);
        System.out.println("W: " + result[1]);
    }
}
