import com.sun.org.apache.bcel.internal.generic.FSUB;

public class CheckPrefix {


    public boolean isPrefixString(String s, String[] words) {

        int startAt = 0;
        int count = 0;
        final StringBuilder ansBuilder = new StringBuilder();
        for (String word : words) {
            int rem = s.length() - (word.length() + startAt);
            if (rem >= 0) {
                final String sub = s.substring(startAt, word.length() + startAt);
                if (word.equals(sub)) {
                    ansBuilder.append(word);
                    startAt = ansBuilder.length();
                    count++;
                } else {
                    return false;
                }
            }
            if (count > words.length) return false;
            if (ansBuilder.toString().equals(s)) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        /**
         * "aaa"
         * ["aa","aaa","fjaklfj"]
         */
        System.out.println(new CheckPrefix().isPrefixString("aaa", new String[]{"aa", "aaa", "fjaklfj"}));
    }
}
