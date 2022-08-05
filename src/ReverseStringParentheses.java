import java.util.Stack;

public class ReverseStringParentheses {

    public String reverseParentheses(String s) {


        Stack<StringBuffer> st = new Stack();
        st.push(new StringBuffer(""));
        for(char ch : s.toCharArray()) {

            if( ch == '(' ) {
                st.push(new StringBuffer(""));
            }
            else if( ch == ')') {
                StringBuffer sb = st.pop();
                sb.reverse();
                StringBuffer temp = st.pop();
                temp.append(sb);
                st.push(temp);
            }
            else {
                st.peek().append(ch);
            }

        }
        return st.pop().toString();
    }

    public static void main(String[] args) {
        System.out.println(new ReverseStringParentheses().reverseParentheses("(u(love)i)"));
    }
}
