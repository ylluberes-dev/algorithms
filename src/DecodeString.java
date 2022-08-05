import java.util.Collections;

public class DecodeString {

    public String decodeString(String s) {

        int index = s.length() - 1;
        StringBuilder result = new StringBuilder();
        StringBuilder reversedNumber = new StringBuilder();
        while (index >= 0) {
            char value = s.charAt(index);
            if (value == ']') {
                int point = 1;
                index--;
                StringBuilder duplicatedBuilder = new StringBuilder();
                while (point > 0) {
                    char left = s.charAt(index);
                    if (left == ']') {
                        point++;
                    } else if (left == '[') { // Always there is a number at left
                        point--;
                        // Find the number
                        int l = index - 1;
                        while (l > -1 && Character.isDigit(s.charAt(l))) {
                            reversedNumber.append(s.charAt(l));
                            l--;
                        }
                        int copies = Integer.parseInt(reversedNumber.reverse().toString());
                        String afterCopy = String.join("", Collections.nCopies(copies, duplicatedBuilder.toString()));
                        duplicatedBuilder.setLength(0);
                        duplicatedBuilder.append(afterCopy);
                        reversedNumber.setLength(0);

                    } else if (!Character.isDigit(left)) {
                        duplicatedBuilder.insert(0, left); // If found a letter
                    }
                    index--;
                }
                result.insert(0, duplicatedBuilder.toString());
            /*} else if (Character.isDigit(value)) { // This condition never happen ?
                String afterCopy = String.join("", Collections.nCopies(Integer.parseInt(String.valueOf(value)), result.toString()));
                result.setLength(0);
                result.append(afterCopy);*/
            } else if (!Character.isDigit(value)) {
                result.insert(0, value);
            }
            index--;
        }
        return result.toString();
    }

    //abc3[cd]xyz -> xyz
    //Expected: abccdcdcdxyz
    public static void main(String[] args) {
        System.out.println(new DecodeString().decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
        //abcabccdcdcdef
        //abcabccdcdcdef


        //zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef
        //ypqjkefjkefjkefjkefjkefjkefjkefjkefypqjkefjkefjkefjkefjkefjkefjkefjkef
    }
}
