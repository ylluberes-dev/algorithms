public class StringCompression {

    public int compress(char[] chars) {

        StringBuilder builder = new StringBuilder();
        int last = 0;
        for (int i = 0; i < chars.length; i++) {
            int groupSize = 1;
            for (int j = i + 1; j < chars.length; j++) {
                char current = chars[i];
                char next = chars[j];
                if(current != next){
                    builder.append(chars[i]);
                    if(groupSize > 1){
                        builder.append(groupSize);
                    }
                    break;
                }else {
                    groupSize++;
                }
                 i = j;
            }
            last = groupSize; // Last letter
        }
        builder.append(chars[chars.length-1]);
        if(last > 1){
            builder.append(last);
        }

        /*System.out.println();
        for (int i = 0; i < chars.length; i++) {
            int sizeOfGroup = 1;
            boolean out = false;
            for (int j = i; j < chars.length - 1; j++) {
                if (chars[j] != chars[j + 1]) {
                    builder.append(chars[j]);
                    if (sizeOfGroup > 1) {
                        builder.append(sizeOfGroup);
                    }
                    i = j;
                    break;
                } else {
                    sizeOfGroup++;
                }
                if (j == chars.length - 2) {
                    builder.append(chars[j]);
                    if (sizeOfGroup > 1) {
                        builder.append(sizeOfGroup);
                    }
                    out = true;
                    break;
                }
            }

            if (out) {
                break;
            }
        }*/
        String result = builder.toString();
        for (int i = 0; i < builder.toString().length(); i++) {
            chars[i] = result.charAt(i);
        }
        System.out.println(builder);
        return result.length();
    }

    public static void main(String[] args) {
        System.out.println(new StringCompression().compress(new char[]{'a','a','a','b','b','a','a'}));
    }
}
