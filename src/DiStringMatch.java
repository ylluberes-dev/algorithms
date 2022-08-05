public class DiStringMatch {

    public int[] diStringMatch(String s) {

        final int [] result = new int [s.length() + 1];
        int index = 0;
        int currentMin = 0;
        int currentMax = result.length -1;
        for (int i = 0; i < s.length(); i++) {
            char currentValue = s.charAt(i);
            switch (currentValue) {
                case 'I':
                    result[index] = currentMin;
                    currentMin++;
                    break;
                case 'D':
                    result[index] = currentMax;
                    currentMax--;
                    break;

            }
            index++;
        }
        result[index] = currentMax;
        return result;
    }

    public static void main(String[] args) {
        new DiStringMatch().diStringMatch("DDI");
    }
}
