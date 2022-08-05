public class SumDigits {

    private static int sumDigits(String str) {
        int sum = 0;
        for(Character current: str.toCharArray()) {
            if(Character.isDigit(current)) {
                sum += Integer.parseInt(String.valueOf(current));
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumDigits("aa11b33"));
    }
}
