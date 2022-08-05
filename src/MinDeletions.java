import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinDeletions {

    /**
     * A string s is called good if there are no two different characters in s that have the same frequency.
     * <p>
     * Given a string s, return the minimum number of characters you need to delete to make s good.
     * <p>
     * The frequency of a character in a string is the number of times it appears in the string. For example, in the string "aab", the frequency of 'a' is 2, while the frequency of 'b' is 1.
     */

    public int minDeletions(String s) {

        Map<Character, Integer> frequencyTable = new HashMap<>();
        for (Character c : s.toCharArray()) {
            if (frequencyTable.containsKey(c)) {
                frequencyTable.replace(c, frequencyTable.get(c) + 1);
            } else {
                frequencyTable.put(c, 1);
            }
        }
        int frequencies[] = new int[frequencyTable.size()];
        int index = 0;
        for (Character c : frequencyTable.keySet()) {
            frequencies[index] = frequencyTable.get(c);
            index++;
        }
     //   Arrays.sort(frequencies);
        int operations = 0;

        while(true){

            int result = checkDuplicate(frequencies);
            if(result == -1) break;
            frequencies[result]--;
            operations++;
        }

        return operations;
    }

    private int checkDuplicate(int [] values){
        int index = -1;
        boolean foundDuplicate = false;
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values.length; j++){
                if(values[i] == 0 || values[j] == 0) continue;
                if (i != j){
                    if(values[i] == values[j]){
                        foundDuplicate = true;
                        index = i;
                        break;
                    }
                }
            }
            if(foundDuplicate) break;
        }
        return index;
    }

    public static void main(String[] args) {
        /*ceabaacb*/
        /*"abcabc"*/
        /*bbcebab*/

        //1,1,1,4
        //2, 1, 3, 2
        // 3, 3, 2
        //2, 2, 2
        System.out.println(new MinDeletions().minDeletions("bbcebab"));
    }
}
