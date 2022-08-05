public class RotateString {

    public boolean rotateStringa(String s, String goal) {
        if(s == null || goal == null) return false;
        if(s.length() != goal.length()) return false;

        int shiftCount = 0;
        while(!s.equals(goal)) {
            if(shiftCount == s.length()) return false;
            s = shift(s);
            shiftCount++;

        }
        return true;
    }

    public boolean rotateString(String A, String B) {
        if (A.length() != B.length())
            return false;
        if (A.length() == 0)
            return true;

        search:
        for (int s = 0; s < A.length(); ++s) {
            for (int i = 0; i < A.length(); ++i) {
                if (A.charAt((s+i) % A.length()) != B.charAt(i))
                    continue search;
            }
            return true;
        }
        return false;
    }

    static String shift (String s) {
        s = s + s.charAt(0);
        s = s.substring(1);
        return s;
    }

   /* static private String shift (final char [] s ) {
        char first = s[0];
        for (int i = 0; i < s.length - 1; i++) {
            s[i] = s[i + 1];
        }
        s[s.length - 1] = first;
        return new String(s);
    }*/

    public static void main(String[] args) {


        //System.out.println(shift("hola".toCharArray()));
        System.out.println("Result: "+ new RotateString().rotateString("abcde","abced"));
        //bcdea
        //cdeab
    }
}
