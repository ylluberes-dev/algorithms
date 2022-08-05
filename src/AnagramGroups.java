import java.util.*;

public class AnagramGroups {

    /**
     *
     * Given an array of strings, group anagrams together.
     *
     * Example:
     *
     * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
     * Output:
     * [
     *   ["ate","eat","tea"],
     *   ["nat","tan"],
     *   ["bat"]
     * ]
     * Note:
     *
     * All inputs will be in lowercase.
     * The order of your output does not matter.
     *
     * */

    /**
     * Rule: Same size, same characters
     * */

    static String getAnagramCode (String s1) {
        if (s1 == null || "".equals(s1))
            return "";

        char [] elements = s1.toCharArray();
        Arrays.sort(elements);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < elements.length; i++){
            builder.append(elements[i]);
        }
        return builder.toString();
    }
    static int getStringCode (String s1){
        if(s1 == null || "".equals(s1))
            return 0;

        int s1TotalCode = 0;
        for (int i = 0; i < s1.length(); i ++){
            s1TotalCode += s1.charAt(i);

        }
        return s1TotalCode;
    }


    static List<List<String>> groupAnagrams (String [] strs) {

        Map<String, List<String>> groups = new HashMap<>();
        for (String value: strs){
            String code = getAnagramCode(value);
            if(groups.containsKey(code)){
              List<String> currentList = groups.get(code);
              currentList.add(value);
            }else{
                List<String> newList  = new ArrayList<>();
                newList.add(value);
                groups.put(code,newList);
            }
        }

        List<List<String>> ret=  new ArrayList<>(groups.size());

           for (String key: groups.keySet()){
               ret.add(groups.get(key));
           }


        return ret;
    }

    public static void main(String[] args) {

        List<List<String>> anagrams = groupAnagrams(new String [] {"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println();
    }

}
