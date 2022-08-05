public class CountOdds {

    public int countOdds(int low, int high) {

        int odd =  (high - low) / 2;
        return !isOdd(low) && !isOdd (high) ? odd : odd + 1;
    }

    private static boolean isOdd (int n){
        return n % 2 != 0;
    }

    public static void main(String[] args) {
        System.out.println(new CountOdds().countOdds(8,10));
    }
}
