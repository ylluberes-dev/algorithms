public class FindBitBinaryString {

    public char findKthBit(int n, int k) {
        String base = "0";
        for (int i = 1; i < n; i++) {
            base += "1" + reverse(invert(base));
        }
        return base.charAt(k - 1); // k - 1 ?
    }


    private static String invert(String x) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < x.length(); i++) {
            builder.append(x.charAt(i) == '0' ? '1' : '0');
        }
        return builder.toString();
    }


    private static String reverse(String s) {
        StringBuilder reversed = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            reversed.append(s.charAt(i));
        }
        return reversed.toString();
    }

    public static void main(String[] args) {
        System.out.println(new FindBitBinaryString().findKthBit(20, 1));
    }
}
