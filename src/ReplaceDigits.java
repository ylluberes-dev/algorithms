public class ReplaceDigits {

    public String replaceDigits(String s) {
        StringBuilder result = new StringBuilder();
        result.append(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if(i % 2 != 0) {
                char before = s.charAt(i-1);
                char shifted = (char)(before + Integer.parseInt(String.valueOf(s.charAt(i))));
                result.append(shifted);
            }else {
                result.append(s.charAt(i));
            }

        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println("Test case 1: " + new ReplaceDigits().replaceDigits("a1c1e1"));
        System.out.println();
        System.out.println("Test case 2: " + new ReplaceDigits().replaceDigits("a1b2c3d4e"));
        System.out.println();

        char a = 'a' + 5;
        System.out.println(a);
    }
}
