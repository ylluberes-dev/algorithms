    import java.math.BigInteger;

public class SmallestIntegerDByK {

    public int smallestRepunitDivByK(int k) {

        int rem = k % 10;

        if (rem != 1  && rem != 3 && rem != 7 && rem != 9) return -1;
        StringBuilder builder = new StringBuilder();
        builder.append("1");
        BigInteger bigInteger = new BigInteger(builder.toString());
        BigInteger base = new BigInteger(String.valueOf(k));
        BigInteger zero = new BigInteger("0");
        while (bigInteger.mod(base).compareTo(zero) != 0) {
            builder.append("1");
            bigInteger = new BigInteger(builder.toString());
        }
        return bigInteger.toString().length();
    }

    public static void main(String[] args) {
        System.out.println(new SmallestIntegerDByK().smallestRepunitDivByK(19927));
    }
}
