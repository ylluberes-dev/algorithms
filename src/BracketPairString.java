import java.util.*;

public class BracketPairString {

    public String evaluate(String s, List<List<String>> knowledge) {

        Map<String, String> map = new HashMap<>();
        for (List<String> keys : knowledge) {
            map.put(keys.get(0), keys.get(1));
        }
        StringBuilder output = new StringBuilder();
        StringBuilder key = new StringBuilder();
        int i = 0;
        boolean open = false;
        while (i < s.length()) {
            char curr = s.charAt(i);
            if (open && curr != ')') {
                key.append(curr);
            }
            if (curr == '(') {
                open = true;
            }
            if (!open) {
                output.append(curr);
            }
            if (curr == ')' && open) {
                open = false;
                if (map.containsKey(key.toString())) {
                    output.append(map.get(key.toString()));
                } else {
                    output.append("?");
                }
                key.setLength(0);
            }
            i++;
        }

        return output.toString();
    }

    static String evaluate2(String s, List<List<String>> knowledge) {

        Map<String, String> map = new HashMap<>();
        for (List<String> keys : knowledge) {
            map.put(keys.get(0), keys.get(1));
        }

        StringBuilder output = new StringBuilder();

        boolean open = false;
        String key = "";
        List<String> notFoundKeys = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char value = s.charAt(i);
            if (open && value != ')') {
                key += value;
            }

            if (value == ')') {
                if (notFoundKeys.contains(key)) {
                    output.append("?");
                    key = "";
                    continue;
                }
                open = false;
                boolean foundKey = false;
                for (List<String> pair : knowledge) {
                    String knowledgeKey = pair.get(0);
                    String knowledgeValue = pair.get(1);
                    if (knowledgeKey.equals(key)) {
                        output.append(knowledgeValue);
                        foundKey = true;
                        break;
                    }
                }
                if (!foundKey) {
                    output.append("?");
                    notFoundKeys.add(key);
                }

                key = "";
            }
            if (value == '(') {
                open = true;
            }
            if (!open && value != ')') {
                output.append(value);
            }
        }
        return output.toString();

    }

    public static void main(String[] args) {

        List<List<String>> pairs = new ArrayList<>();
        List<String> pair1 = new ArrayList<>();
        List<String> pair2 = new ArrayList<>();
        pair1.add("a");
        pair1.add("yes");

        pair2.add("age");
        pair2.add("two");

        pairs.add(pair1);
      //  pairs.add(pair2);
        //?????????nvl??????????
        //?????????nvl?????????

        System.out.println(new BracketPairString().evaluate("(a)(a)(a)aaa", pairs));
    }
}
