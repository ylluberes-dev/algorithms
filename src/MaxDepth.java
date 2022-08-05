public class MaxDepth {


    public int maxDepth(String s) {
        int counter = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if(cur == '('){
                counter++;
            }
            if(cur == ')'){
                counter--;
            }
            if(counter > max)
                max = counter;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaxDepth().maxDepth("1"));
    }

}
