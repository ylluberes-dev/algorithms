public class ExcelSheetColumnTitle {

    //1-BASED
    static final char [] ALPHABET = {'@','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    static final int BASE = 26;
    public String convertToTitle (int n) {

        if (n <= 26) {
            return String.valueOf(ALPHABET[n]);
        }else {
            int q = n;
            StringBuilder builder = new StringBuilder();
            while (true){

                if(n <= 26){
                        int letter = q % BASE;
                        builder.append(ALPHABET[letter]);
                        break;
                }else {

                    n = n / BASE;
                    if (n > 26) {

                    }
                    //System.out.println(n);
                    builder.append(ALPHABET[n]);
                }
                }


            return builder.toString();
        }

    }

    public static void main(String[] args) {
        System.out.println(new ExcelSheetColumnTitle().convertToTitle(2600));
    }
}
