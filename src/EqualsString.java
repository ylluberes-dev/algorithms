public class EqualsString {

    public boolean areAlmostEqual(String s1, String s2) {
        if (s1 != null && s2 != null) {
            if (s1.equals(s2)) {
                return true;
            }
            if (!check(s1, s2)) {
                return check(s2,s1);
            } else {
                return true;
            }

        }

        return false;
    }

    private static boolean check(String s1, String s2) {
        /*Checking if s2 is mutable to form @s1*/
        for (int i = 0; i < s2.length(); i++) {
            for (int j = i + 1; j < s2.length(); j++) {
                String candidate = swap(s2, i, j);
                if (candidate.equals(s1))
                    return true;
            }
        }

        return false;
    }

    private static String swap(String s, int a, int b) {
        char[] values = s.toCharArray();
        char temp = s.charAt(a);
        values[a] = values[b];
        values[b] = temp;
        String result = new String(values);
        return result;
    }


    public static void main(String[] args) {
         //Input: s1 = "bank", s2 = "kanb"
        //Input: s1 = "attack", s2 = "defend"
        System.out.println(new EqualsString().areAlmostEqual("abcd","dcba"));
    }

}
