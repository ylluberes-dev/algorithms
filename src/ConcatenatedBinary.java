import java.math.BigInteger;

public class ConcatenatedBinary {

    public int concatenatedBinary(int n) {

        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            builder.append(toBinary(i));
        }
        String result = builder.toString();
        int sum = 0;
        int e = 0;
        int overFlows = 0;
        for (int i = result.length() -1; i >= 0; i--){
            int binaryValue = Integer.parseInt(String.valueOf(result.charAt(i)));
            //2147483647
            //2147483699
            if((sum + Math.pow(2,e) * binaryValue) > Integer.MAX_VALUE) {
                overFlows++;
            }
        }
        System.out.println();

        System.exit(0);
        BigInteger decimal = toDecimal(builder.toString());
        final BigInteger LIMIT = new BigInteger("1000000007");
        if(decimal.compareTo(LIMIT)>=0) {
            return decimal.mod(LIMIT).intValue();
        }
        return decimal.intValue();
    }

    private static String toBinary(int n) {
        StringBuilder builder = new StringBuilder();
        while (n != 0) {
            builder.append(n % 2);
            n /= 2;
        }
        return builder.reverse().toString();
    }

    private static BigInteger pow (int e){
        if(e == 0) return new BigInteger("1");
        BigInteger bigInteger = new BigInteger("2");
        final BigInteger base = new BigInteger("2");
        int count = 1;
        while(count < e) {
            bigInteger = bigInteger.multiply(base);
            count++;
        }
        return bigInteger;
    }
    private static BigInteger toDecimal(String binary) {
        BigInteger sum = new BigInteger("0");
        int count = 0;
        for (int i = binary.length() -1; i >= 0; i--) {
            BigInteger result = pow(count).multiply(new BigInteger(String.valueOf(binary.charAt(i))));
            sum = sum.add(result);
            count++;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(2147483620 + 500 >  Integer.MAX_VALUE);
       // System.out.println(new ConcatenatedBinary().concatenatedBinary(885));
    }
}
