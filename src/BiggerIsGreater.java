import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BiggerIsGreater {


    public String biggerIsGreater(String w) {

        //hefg
        int right = w.length() - 1;
        char[] elements = w.toCharArray();
        boolean aLeastOneSwap = false;
        int startPoint = 0;
        while (right > 0) {
            char cur = elements[right]; // -> g
            char left = elements[right - 1]; // -> f
            if (left < cur) {
                //Find the min from cur to arrSize - 1
                startPoint = right - 1;
                aLeastOneSwap = true;
                break;
            }
            right--;
        }
        if(!aLeastOneSwap) return "no answer";
        char min = 'z';
        int minPos = -1;
        for (int i = startPoint + 1; i < elements.length; i++) {
            if (elements[i] < min) {
                min = elements[i];
                minPos = i;
            }
        }
        swap(elements, startPoint, minPos);
        List<Character> charList = new ArrayList<>();
        for (int i = startPoint + 1; i < elements.length; i++) {
            charList.add(elements[i]);
        }

        Collections.sort(charList);
        StringBuilder result = new StringBuilder();
        int listCount = 0;
        for (int i = 0; i < elements.length; i++) {
            if (i <= startPoint) {
                result.append(elements[i]);
            } else {
                result.append(charList.get(listCount));
                listCount++;
            }
        }

        return result.toString();
    }

    static void swap(char[] values, int a, int b) {
        char temp = values[a];
        values[a] = values[b];
        values[b] = temp;
    }


    public static void main(String[] args) {
        System.out.println(2 % 5);
        System.out.println(new BiggerIsGreater().biggerIsGreater("ecdigf"));
    }
}
