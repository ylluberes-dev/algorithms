public class IsInAscendingOrder {


    public boolean areNumbersAscending(String s) {
        StringBuilder builder = new StringBuilder();
        int current = 0;
        boolean foundNumber = false;
        int prev = current;
        for(String tokens : s.split(" ")) {
            foundNumber = false;
            for (int i = 0; i < tokens.length(); i++) {
                if(!Character.isDigit(tokens.charAt(i))) {
                    break;
                }else {
                    foundNumber = true;
                    builder.append(tokens.charAt(i));
                }
            }
            if(foundNumber) {
                current = Integer.parseInt(builder.toString());
                if (current <= prev) return false;
                prev = current;
                builder.delete(0,builder.length());
            }


        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(new IsInAscendingOrder().areNumbersAscending("1 box has 3 blue 4 red 6 green and 12 yellow marbles"));
    }
}
