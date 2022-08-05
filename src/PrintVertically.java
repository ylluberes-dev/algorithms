import java.util.ArrayList;
import java.util.List;

public class PrintVertically {

    public List<String> printVertically(String s) {
        String[] divided = s.split(" ");
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < divided.length; i++){
            if(max < divided[i].length()) {
                max = divided[i].length();
            }
        }
        List<String> result = new ArrayList<>();
        int letterCount = 0;
        int index = 0;
        while (letterCount < max) {

            String value = "";
            for (String word : divided) {
                if (index < word.length()) {
                    value+= word.charAt(index);
                } else {
                    value += " ";
                }
            }
            result.add(value.replaceAll("\\s+$", ""));
                letterCount++;
            index++;
        }
        System.out.println();
        return result;
    }

    private static void printList(List<String> list) {
        for (String str : list) {
            System.out.print(str + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printList(new PrintVertically().printVertically("CONTEST IS COMING"));
    }
}
