public class BackspaceStringCompare {

    public boolean backspaceCompare(String s, String t) {
        final StringBuilder sBuilder = getProcessedString(s);
        final StringBuilder tBuilder = getProcessedString(t);
        return sBuilder.toString().equals(tBuilder.toString());
    }

    private static StringBuilder getProcessedString(final String str) {
        final StringBuilder builder = new StringBuilder();
        final char BACKSPACE = '#';

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            if (current == BACKSPACE) {

                if (count >= 1) {
                    builder.deleteCharAt(count - 1);
                    count--;
                }
            } else {
                builder.append(current);
                count++;
            }
        }
        return builder;
    }

    //ac


    public static void main(String[] args) {
        System.out.println(new BackspaceStringCompare().backspaceCompare("a##c", "#a#c"));
    }
}

/**
 "a##c"
 "#a#c"
 */
