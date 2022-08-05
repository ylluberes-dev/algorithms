import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PowerString {

    public int maxPower(String s) {
        int max = 1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    String subString = s.substring(i, j+1);
                    if (subString.length() > max) {
                        max = subString.length();
                    }
                } else {
                    break;
                }

            }
        }
        return max;
    }


    public static void main(String[] args) {
        //"aabbbbbccccdddddddeffffffggghhhhhiiiiijjjkkkkkllllmmmmmnnnnnoopppqrrrrsssttttuuuuvvvvwwwwwwwxxxxxyyyzzzzzzzz"
        System.out.println("leetcode".length());
        System.out.println(new PowerString().maxPower("aabbbbbccccdddddddeffffffggghhhhhiiiiijjjkkkkkllllmmmmmnnnnnoopppqrrrrsssttttuuuuvvvvwwwwwwwxxxxxyyyzzzzzzzz"));
    }
}
