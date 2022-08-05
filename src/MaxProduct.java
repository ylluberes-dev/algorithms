import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxProduct {

    public int maxProduct(String[] words) {

        int max = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length;j++) {

                if (!shareLetter(words[i],words[j])){
                    int fWordSize = words[i].length();
                    int sWordSize = words[j].length();
                    int productLength = fWordSize * sWordSize;
                    if(productLength > max){
                        max = productLength;
                        break;
                    }else {
                        continue;
                    }
                }
            }
        }
        return max;
    }

    static boolean shareLetter (String firstWord, String secondWord){
        Map<Character,Integer> aCounter = new HashMap();
        for (int i = 0; i < firstWord.length(); i++) {
            aCounter.put(firstWord.charAt(i),1);
        }

        Map<Character,Integer> bCounter = new HashMap();
        for (int i = 0; i < secondWord.length(); i++) {
            bCounter.put(secondWord.charAt(i),1);
        }
        for(Character key: aCounter.keySet()){
            if(bCounter.containsKey(key)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String words [] = {"eae","ea","aaf","bda","fcf","dc","ac","ce","cefde","dabae"};

        System.out.println(new MaxProduct().maxProduct(words));


    }
}
