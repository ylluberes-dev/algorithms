public class PowerOfThreeSum {


    private static final int BASE = 3;

    public boolean checkPowersOfThree(int n) {

        int closestExponent = findClosestExponent(n);
        int result = (int) Math.pow(BASE, closestExponent);
        int sum = result;
        while (closestExponent >= 0) {
            result = (int) Math.pow(BASE, --closestExponent);
            sum += result;
            if (sum > n) {
                sum -= result;
                continue;
            }
            if (sum == n) {
                return true;
            }
        }
        return false;
    }

    private static int findClosestExponent(int n) {
        double r;
        for (int i = 0; i <= n; i++) {
            r = Math.pow(BASE, i);
            if ((int) r == n) {
                return i;
            } else if ((int) r > n) {
                return i - 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {

       /* System.out.println("Unit testing [findClosestExponent] function");
        int closest = findClosestExponent(27);
        System.out.println(closest);*/

        int n = 3; // True
        boolean result = new PowerOfThreeSum().checkPowersOfThree(n);
        System.out.println("Result: " + result);
    }
}
