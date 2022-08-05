import java.util.Arrays;
import java.util.stream.Collectors;

public class ArrayStringEquals {


    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
       /*StringBuilder firstSequence = new StringBuilder();
        StringBuilder secondSequence = new StringBuilder();*/

       return Arrays.stream(word1).collect(Collectors.joining()).equals(Arrays.stream(word2).collect(Collectors.joining()));
       /* Arrays.stream(word1).forEach(x->{
            firstSequence.append(x);
        });
        Arrays.stream(word2).forEach(y ->{
            secondSequence.append(y);
        });*/
       // return firstSequence.toString().equals(secondSequence.toString());

    }

    public static void main(String[] args) {
        System.out.println(new ArrayStringEquals().arrayStringsAreEqual(new String []{"abc", "d", "defg"},new String[]{"abcddefg"}));
    }
}
