public class MergeString {

    public String mergeAlternately(String word1, String word2) {
        String bigger = word1.length() > word2.length() ? word1 : word2;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < bigger.length(); i++) {
            if (i < word1.length()) {
                builder.append(word1.charAt(i));
            }
            if (i < word2.length()) {
                builder.append(word2.charAt(i));
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new MergeString().mergeAlternately("abcd ", "pq"));
    }
}
