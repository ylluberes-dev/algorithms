import java.util.Stack;

public class ValidParenthesesP2 {

    public boolean isValid(String s) {
        final Stack<Character> tracker = new Stack<>();

        int index = 0;
        while (index < s.length()) {
            final char value = s.charAt(index);
            if (value == '(' || value == '{' || value == '[') {
                tracker.push(value);
            } else {
                if (tracker.size() < 1) return false;
                    if (value == ')') {
                        if (tracker.peek() == '(') {
                            tracker.pop();
                        } else {
                            return false;
                        }
                    } else if (value == ']') {
                        if (tracker.peek() == '[') {
                            tracker.pop();
                        } else {
                            return false;
                        }
                    } else if (value == '}') {
                        if (tracker.peek() == '{') {
                            tracker.pop();
                        } else {
                            return false;
                        }
                    }
                }
            }

        return tracker.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new ValidParenthesesP2().isValid("()"));
    }
}
