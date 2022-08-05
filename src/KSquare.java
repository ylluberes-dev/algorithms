import java.util.Arrays;

public class KSquare {

    public static void main(String[] args) {

        System.out.println(isPalindrome("A man, a plan, a cat, a ham, a yak, a yam, a hat, a canal-Panama!"));
        System.out.println(solution(new int []{-1,-3}));
    }


    //Input String
    //Output Es palíndromo
    //EJ:A man, a plan, a cat, a ham, a yak, a yam, a hat, a canal-Panama!
    //l ,
    //r a
    private static boolean isPalindrome (final String input) {

        int left = 0;
        int right = input.length() -1;

        while(right > left) {
            char leftChar = input.charAt(left);
            char rightChar = input.charAt(right);
            if(!Character.isLetter(leftChar)){
                left++;
                continue;
            }
            if(!Character.isLetter(rightChar)) {
                right--;
                continue;
            }
            if(Character.toLowerCase(leftChar) == Character.toLowerCase(rightChar)){
                left++;
                right--;
            }else {
                return false;
            }

        }
        return true;
    }

    public static int solution(int[] A) {
        // write your code in Java SE 8

        Arrays.sort(A);
        for(int i = 0; i < A.length - 1; i ++) {
            if(A[i]  == A[i + 1]) continue;
            if(A[i] + 1 != A[i+1]) { //
                if(A[i] + 1 <=0) return 1;
                return A[i] + 1;
            }
        }
        return A[A.length-1] +1;
    }
}
