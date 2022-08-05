import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class BeautySum {

    public int beautySum(String s) {
        final List<String> subStrings = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (Math.abs(i - j) < 3) continue;
                String subString = s.substring(i, j);
                subStrings.add(subString);
            }
        }
        int sum = 0;
        for (String sub : subStrings) {
            int[] currentBeauty = getMaxMinFrequency(sub);
            sum += currentBeauty[0] - currentBeauty[1];
        }

        return sum;
    }

    private static int[] getMaxMinFrequency(String subString) {
        final Map<Character, Integer> frequencyTable = new HashMap<>();
        for (Character c : subString.toCharArray()) {
            if (frequencyTable.containsKey(c)) {
                frequencyTable.replace(c, frequencyTable.get(c) + 1);
            } else {
                frequencyTable.put(c, 0);
            }
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (Character c : frequencyTable.keySet()) {
            int current = frequencyTable.get(c);
            if (current > max) {
                max = current;
            }
            if (current < min) {
                min = current;
            }
        }

        return new int[]{max, min};
    }

    static int beautySum2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        List<String> subStrings = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (Math.abs(i - j) > 2)
                    subStrings.add(s.substring(i, j));
            }
        }
        int sum = 0;
        for (String subString : subStrings) {
            for (int i = 0; i < subString.length(); i++) {
                char key = subString.charAt(i);
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            sum += Collections.max(map.values()) - Collections.min(map.values());
            map.clear();
        }


        return sum;
    }

    static int beautySum3(String s) {
        int beauty= 0;
        for(int i=0; i<s.length(); i++){
            int[] numCountOfFreq= new int[s.length()+1-i];
            int[] charFreq= new int[26];
            charFreq[s.charAt(i)-'a']= 1;
            numCountOfFreq[1]= 1;
            int min= 1, max= 1;
            for(int j=i+1; j<s.length(); j++){
                char c= s.charAt(j);
                charFreq[c-'a']++;
                int freq= charFreq[c-'a'];
                numCountOfFreq[freq-1]--; numCountOfFreq[freq]++;
                if(numCountOfFreq[min] == 0) min++;
                if(min > freq) min= freq;
                if(max < freq) max= freq;
                beauty+= max - min;
            }
        }
        return beauty;
    }

    public static void main(String[] args) {
        //vcdrfffdchvdbhwnvoifkxfchicszovrbeafebxkicbevnmatkkhusxkgytuxopgszuzbqgkoetxjlpyvntvozntxbjumaedmdomqzqiqqlqkxecwptzvzkwddvrrnfjsqbosuxexyiqecexzxwnftqhsqqtcjlokfdglobphkfferqedvuatahxtzyjmgajgmfuvokormpwjagxinwegstolpwsqravzsujnxadyafagibnlwyhutprbepnwppfkaqxrgzkicyplszvhmjwpzcvdojjkzqmdirvuqedltqgilzsfdotumpxyymabqthwipxdnvjidbnbwpcdzxwbqwunlmazstrjnshfajqs
        Instant start = Instant.now();
        System.out.println(new BeautySum().beautySum("vcdrfffdchvdbhwnvoifkxfchicszovrbeafebxkicbevnmatkkhusxkgytuxopgszuzbqgkoetxjlpyvntvozntxbjumaedmdomqzqiqqlqkxecwptzvzkwddvrrnfjsqbosuxexyiqecexzxwnftqhsqqtcjlokfdglobphkfferqedvuatahxtzyjmgajgmfuvokormpwjagxinwegstolpwsqravzsujnxadyafagibnlwyhutprbepnwppfkaqxrgzkicyplszvhmjwpzcvdojjkzqmdirvuqedltqgilzsfdotumpxyymabqthwipxdnvjidbnbwpcdzxwbqwunlmazstrjnshfajqs"));
        Instant end = Instant.now();

        System.out.println("First approach duration: "+ Duration.between(end,start).toMillis());

        start = Instant.now();
        System.out.println(beautySum2("vcdrfffdchvdbhwnvoifkxfchicszovrbeafebxkicbevnmatkkhusxkgytuxopgszuzbqgkoetxjlpyvntvozntxbjumaedmdomqzqiqqlqkxecwptzvzkwddvrrnfjsqbosuxexyiqecexzxwnftqhsqqtcjlokfdglobphkfferqedvuatahxtzyjmgajgmfuvokormpwjagxinwegstolpwsqravzsujnxadyafagibnlwyhutprbepnwppfkaqxrgzkicyplszvhmjwpzcvdojjkzqmdirvuqedltqgilzsfdotumpxyymabqthwipxdnvjidbnbwpcdzxwbqwunlmazstrjnshfajqs"));
        end = Instant.now();

        System.out.println("Second approach duration: "+Duration.between(end,start).toMillis());

        start = Instant.now();
        System.out.println(beautySum3("vcdrfffdchvdbhwnvoifkxfchicszovrbeafebxkicbevnmatkkhusxkgytuxopgszuzbqgkoetxjlpyvntvozntxbjumaedmdomqzqiqqlqkxecwptzvzkwddvrrnfjsqbosuxexyiqecexzxwnftqhsqqtcjlokfdglobphkfferqedvuatahxtzyjmgajgmfuvokormpwjagxinwegstolpwsqravzsujnxadyafagibnlwyhutprbepnwppfkaqxrgzkicyplszvhmjwpzcvdojjkzqmdirvuqedltqgilzsfdotumpxyymabqthwipxdnvjidbnbwpcdzxwbqwunlmazstrjnshfajqs"));
        end = Instant.now();

        System.out.println("Third approach duration: "+Duration.between(end,start).toMillis());


        String str = "xbbacax";

        int [] freq = new int[26]; // Alphabet container
        for (int i = 0; i < str.length(); i++){
            freq[str.charAt(i)-'a'] = 1;
            for (int j = i + 1; j< str.length(); j++) {
                freq[str.charAt(j)-'a']++;
            }
        }
    }
}
