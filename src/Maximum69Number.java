public class Maximum69Number {


    public int maximum69Number (int num) {
        String converted = String.valueOf(num);
        int max = num;
        for (int i = 0; i < converted.length(); i++) {

            String changed = replace(converted,i);
            int changedNumber = Integer.parseInt(changed);
            if(changedNumber > max){
                max = changedNumber;
            }
        }

        return max;
    }

    private static String replace (String value, int pos) {
        char [] charSeq = value.toCharArray();
        if(charSeq[pos] == '6') {
            charSeq[pos] = '9';
        }else {
            charSeq[pos] = '6';
        }
        return new String(charSeq);
    }

    public static void main(String[] args) {
        System.out.println(new Maximum69Number().maximum69Number(9999));
    }
}
