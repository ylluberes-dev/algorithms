public class GetLucky {

    public int getLucky(String s, int k) {
        int result = transform(s);
        k--;
        while (k > 0) {
            result = sumDigits(String.valueOf(result));
            k--;
        }
        return result;
    }


    private static int transform(final String t) {
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < t.length(); i++) {
            builder.append((int) t.charAt(i) - 96);
        }
        return sumDigits(builder.toString());
    }


    private static int sumDigits (final String value){
        int sum = 0;
      for (int i = 0; i < value.length(); i++) {
          sum += Integer.parseInt(String.valueOf(value.charAt(i)));
      }
      return sum;
    }


    static String testFinallyBlock () {

        try {
            System.out.println("Hello");
            return null;

        }catch (Exception ex) {
            System.out.println("Error");
        }
        finally {
            System.out.println("Finally block");
        }
        return "Hello world";
    }


    public static void main(String[] args) {
        //System.out.println(new GetLucky().getLucky("leetcode",2));
        testFinallyBlock();
    }
}
