public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int wordSize = s.length();
        int count = 0;
        for (int i = 0; i < s.length(); i++){
            char letter = s.charAt(i);
            for (int j = 0; j < t.length();j++){
                char soup = t.charAt(j);
                if (letter == soup){
                    count++;
                    if (j == 0){
                        t = t.substring(1);
                    }else if (j == t.length() - 1){
                        t = t.substring(0,t.length()-1);
                    }else {
                      String temp = t.substring(0,j) + t.substring(j+1);
                      t = temp;
                    }
                    break;
                }
            }
        }
        //System.out.println("");
        return count == wordSize;
    }

    public static void main(String[] args) {
        System.out.println(new ValidAnagram().isAnagram("anagram","nagaram"));

        /*
        * "aacc"
          "ccac"
* */
    }
}
