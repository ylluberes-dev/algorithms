public class ThousandSeparator {

    public String thousandSeparator(int n) {
        String value = String.valueOf(n);
        int sizeOf = value.length();
        if (sizeOf < 4) return value;

        /*int totalDots;
        if (sizeOf % 3 == 0) {
            totalDots = (sizeOf / 3) - 1;
        } else {
            totalDots = (sizeOf / 3);
        }*/
        StringBuilder builder = new StringBuilder();
        int thousandCount = 0;
        for (int i = value.length() - 1; i >= 0; i--) {

            if (thousandCount == 3) {
                builder.append(".");
                thousandCount = 0;
            }
            builder.append(value.charAt(i));
            thousandCount++;
        }

        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new ThousandSeparator().thousandSeparator(987));
    }
}
