public class LongestSubString {

    public static void main(String[] args) {

    }

    //abcabcbb
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 1;
        int max = Integer.MIN_VALUE;
        int size = 1;
        while(right < s.length()) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if(leftChar != rightChar)
            {
                size++;
                right++;
            }
            if(size > max)
                max = size;


        }
        return 0;
    }
}
