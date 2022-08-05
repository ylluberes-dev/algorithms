public class SameEnds {


    private static String sameEnds(String string) {
        if(string == null || string.isEmpty()) return "";
            final StringBuilder builder = new StringBuilder();
            final int size = string.length();
            int left = (size % 2 != 0) ? ((size - 1) / 2) - 1 : (size - 1) / 2;
            int right = string.length() - 1;
            while (left >= 0) {
                char leftChar = string.charAt(left);
                char rightChar = string.charAt(right);
                if (leftChar != rightChar) {
                    if (right < (size - 1) ) return "";
                    left--;
                } else {
                    left--;
                    right--;
                    builder.append(rightChar);
                }
            }
            return builder
                    .reverse()
                    .toString();
    }

    public static void main(String[] args) {
        System.out.println(sameEnds("xavaXYZjava"));
    }
}
