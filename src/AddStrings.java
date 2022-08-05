public class AddStrings {

    public String addStrings(String num1, String num2) {
        boolean aStop = false, bStop = false;
        StringBuilder builder = new StringBuilder();
        int a = 0;
        int b = 0;
        int i = num2.length() - 1;
        int j = num1.length() - 1;
        int next = 0;
        while (true) {
            if (i >= 0) {
                a = Integer.parseInt(String.valueOf(num2.charAt(i)));
            } else {
                aStop = true;
                a = 0;
            }
            if (j >= 0) {
                b = Integer.parseInt(String.valueOf(num1.charAt(j)));
            } else {
                bStop = true;
                b = 0;
            }
            if (aStop && bStop) {
                if (next > 0) {
                    builder.append(next);
                }
                break;
            }
            String result = String.valueOf(a + b + next);
            if (result.length() > 1) {
                builder.append(result.charAt(1));
                next = Integer.parseInt(String.valueOf(result.charAt(0)));
            } else {
                builder.append(result);
                next = 0;
            }
            i--;
            j--;
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(5%6);
       /* System.out.println(new AddStrings().addStrings("10500", "500"));
        System.out.println("10405985147604178950");*/
        //"10405985147604178950"
        /*
        * "3876620623801494171"
"6529364523802684779"*/

    }
}
