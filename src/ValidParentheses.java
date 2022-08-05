import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        // The next close bracket should be the last that entry

        // (([][]))
        Stack<Character> tracker = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char value = s.charAt(i);
            if (value == '{' || value == '(' || value == '[') {
                tracker.push(value);
            } else {
                if (value == '}') {
                    if (tracker.size() > 0) {
                        if (tracker.peek() != '{') {
                            return false;
                        } else {
                            tracker.pop();
                        }
                    }else {
                        return false;
                    }
                } else if (value == ']') {
                    if (tracker.size() > 0) {
                        if (tracker.peek() != '[') {
                            return false;
                        } else {
                            tracker.pop();
                        }
                    }else {
                        return false;
                    }
                } else {
                    if (tracker.size() > 0) {
                        if (tracker.peek() != '(') {
                            return false;
                        } else {
                            tracker.pop();
                        }
                    }else {
                        return false;
                    }
                }
            }

        }

        return tracker.size() == 0;
    }


    public static void main(String[] args) {
        String input = "([)]";
        System.out.println(new ValidParentheses().isValid(input));
    }
}
