public class CheckZeroOnes {

    public boolean checkZeroOnes(String s) {

        return findConsecutive(s,'1') > findConsecutive(s,'0');
    }

    private static int findConsecutive (String values, char target){
        int count = 0;
        int max = 0;
        for (int i = 0; i < values.length() ; i++) {
            if(values.charAt(i) == target){
               count++;
            }else {
                if(count > max){
                    max = count;
                }
                count = 0;
            }

        }
        if(count > max){
            max = count;
        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println(new CheckZeroOnes().checkZeroOnes("111000"));
    }
}
