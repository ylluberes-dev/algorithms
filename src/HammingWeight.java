public class HammingWeight {

    public int hammingWeight(int n) {

        return 0;
    }


    private static String convertSignedToBinary (int n) {
        StringBuilder result = new StringBuilder();
        while(n > 0){
            if(n == 1) {
                result.append(1);
            }else {
                result.append(n % 2);
            }
            n = n / 2;
        }
        return result.reverse().toString();
    }
    public static void main(String[] args) {

    }
}
