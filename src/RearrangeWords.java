public class RearrangeWords {

    public String arrangeWords(String text) {
        StringBuilder builder = new StringBuilder();
        String[] words = text.split(" ");
        for (int i = 0; i < words.length; i++) {
            int min = Integer.MAX_VALUE;
            String currMin = "";
            int k = -1;
            for (int j = 0; j < words.length; j++) {
                if(!"".equals(words[j])) {
                    if (min > words[j].length()) {
                        currMin = words[j];
                        min = words[j].length();
                        k = j;
                    }
                }
            }
            words[k] = "";
            builder.append(currMin);
            if(!(i + 1 == words.length)){
                builder.append(" ");
            }
        }

        String result = builder.toString();
        String ret = result.substring(0,1).toUpperCase() + result.substring(1).toLowerCase();

        return ret;
    }



    public static void main(String[] args) {
        System.out.println(new RearrangeWords().arrangeWords("Leetcode is cool"));
    }
}
