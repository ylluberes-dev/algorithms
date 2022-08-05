public class ReverseVowels {

    public String reverseVowels(String s) {
        final char[] values = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char leftChar = values[left];
            char rightChar = values[right];
            if (isVowel(leftChar) && !isVowel(rightChar)) {
                right--;
            } else if (!isVowel(leftChar) && isVowel(rightChar)) {
                left++;
            } else if (isVowel(leftChar) && isVowel(rightChar)) {
                swap(values, left, right);
                left++;
                right--;
            } else {
                left++;
                right--;
            }
        }
        return String.valueOf(values);

    }


    public static void main(String[] args) {
        String result = new ReverseVowels().reverseVowels("leetcode");
        System.out.println(result);

    }

    private void swap(final char[] values, int x, int y) {
        char temp = values[x];
        values[x] = values[y];
        values[y] = temp;
    }

    static final char alphabet[] = {'a', 'e', 'i', 'o', 'u', 'A','E','I','O','U'};

    boolean isVowel(char value) {
        for (int i = 0; i < alphabet.length; i++) {
            if (value == alphabet[i]) return true;
        }
        return false;
    }


}
