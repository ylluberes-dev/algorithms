public class RomanToInteger {


    public int romanToInt(String s) {
        if(s.length() == 1) return getMappedValue(s.charAt(0));

        int sum = getMappedValue(s.charAt(s.length()-1));
        for(int i = s.length() - 1; i > 0; i--) {
            char cur = s.charAt(i);
            char left = s.charAt(i - 1);

            int curValue  = getMappedValue(cur);
            int leftValue = getMappedValue(left);
            if(curValue >  leftValue){
                sum -= leftValue;
            }else {
                sum += leftValue;
            }
        }

        return sum;
    }
    //XLV

    private static int getMappedValue(char symbol) {
        switch (symbol) {

            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return 0;
    }


    public static void main(String[] args) {
        System.out.println(new RomanToInteger().romanToInt("MCMXCIV"));
    }
}
