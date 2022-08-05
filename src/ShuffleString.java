public class ShuffleString {

    public String restoreString(String s, int[] indices) {
        char [] ordered = new char[indices.length];

        for (int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            ordered[indices[i]] = curr;
        }
        return new String(ordered);
    }


    public static void main(String[] args) {
        System.out.println(new ShuffleString().restoreString("codeleet", new int []{4,5,6,7,0,2,1,3}));
    }
}
