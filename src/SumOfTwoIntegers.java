public class SumOfTwoIntegers {

    public int getSum(int a, int b) {
        int k = 0;
        if (a < 0) {
            for (int i = a; i <0; i++) {
                k--;
            }
        }else {
            for (int i = 0; i < a; i++) {
                k++;
            }
        }

        if (b < 0) {
            for (int i = b; i <0; i++) {
                k--;
            }
        }else {
            for (int i = 0; i < b; i++) {
                k++;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        System.out.println(new SumOfTwoIntegers().getSum(-1,1));
    }
}
