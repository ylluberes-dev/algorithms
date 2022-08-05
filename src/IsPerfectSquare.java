public class IsPerfectSquare {

    public boolean isPerfectSquare(int value) {

        double res = Math.pow(value, 0.5);


        return (int) res == res;
    }

    private static double pow(double base, double exponent) {

        if (exponent <= 0) {
            return base;

        }

        return base * pow(base, exponent -1);
    }

    public static void main(String[] args) {
        System.out.println(new IsPerfectSquare().isPerfectSquare(14));
    }
}
