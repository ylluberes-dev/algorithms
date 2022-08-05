public class ModifyString {

   private static final char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public String modifyString(String s) {

        // a???b
        String result = "";
        result += 'a' + 'b';
        System.out.println(result);

        return new String();
    }

    public static void main(String[] args) {
        System.out.println(new ModifyString().modifyString("a"));
    }

}
