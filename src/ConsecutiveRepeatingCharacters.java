public class ConsecutiveRepeatingCharacters {

    public String modifyString(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < s.length() - 1; i++) {
        }
        return null;
    }

    private static char getNextAlphabet (char left, char right) {
        final char [] alphabet = new char[26];
        int idx = 0;
        for (char c = 'a'; c <= 'z'; ++c) {
            alphabet[idx] = c;
        }
        return '0';
    }

    public static void main(String[] args) {
        System.out.println(new ConsecutiveRepeatingCharacters().modifyString("j?qg??b"));
    }
}
