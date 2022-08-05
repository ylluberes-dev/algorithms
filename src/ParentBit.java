public class ParentBit {

    public String parenBit(String str) {

        return helper(str,str.length()-1);
    }


    private static String helper (String str, int pos) {

        int start = str.indexOf("(");
        int end = str.indexOf(")");
        if(pos == start - 1) return "";

        if (pos <= end && pos >= start) {
            return helper(str, pos  -1) + str.charAt(pos);
        }
        return helper(str,pos -1);
    }

    public static void main(String[] args) {
        System.out.println(new ParentBit().parenBit("xyz(abc)123"));
    }

}
