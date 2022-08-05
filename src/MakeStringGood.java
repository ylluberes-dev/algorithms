public class MakeStringGood {

    public String makeGood(String s) {
        System.out.println("");
        while(stillBad(s)){
            s = s.substring(0,pos-1) + s.substring(pos+1);
        }
        return s;
    }

    private int pos;

    private boolean stillBad (String s) {
        for (int i = 1; i < s.length(); i++) {
            char current = s.charAt(i);
            char prev = s.charAt(i - 1);
            if ((Character.isLowerCase(current) && Character.isUpperCase(prev))
                    || (Character.isLowerCase(prev) && Character.isUpperCase(current))) {
                if (String.valueOf(current).toLowerCase().equals(String.valueOf(prev).toLowerCase())) {
                    this.pos = i;
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new MakeStringGood().makeGood("s"));
    }
}
