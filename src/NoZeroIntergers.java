
public class NoZeroIntergers {


    public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i <= n; i ++) {
            if(!containsZero(i)){
                int complement = n - i;
                if(!containsZero(complement)){
                    return new int [] {i, complement};
                }
            }
        }
        return null;
    }

    private static boolean containsZero (int n) {
        while(n > 0){
            int digit = n % 10;
            if(digit == 0) return true;
            n/=10;
        }
        return false;
    }

    private static void printArr (int [] values) {
        for (int i = 0; i < values.length; i++) {
            if(i + 1 == values.length){
                System.out.print(values[i]);
            }else {
                System.out.print(values[i] + ", ");
            }
        }
    }
    public static void main(String[] args) {
        printArr(new NoZeroIntergers().getNoZeroIntegers(1010));
    }
}
