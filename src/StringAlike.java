public class StringAlike {

    private static final char [] VOWELS = {'a','e','i','o','u'};

    public boolean halvesAreAlike(String s) {
        int midPoint = s.length() / 2;
        String firstHalf = s.substring(0,midPoint);
        String secondHalf = s.substring(s.length() - midPoint);
        return compareVowels(firstHalf,secondHalf);

    }

    /**
     *
     *
     * @param a
     * @param b
     * @return if a and b have the same number of vowels
     */
    private static boolean compareVowels (String a, String b) {
        int aCount = 0, bCount = 0;
        for (int i = 0; i < a.length(); i++){
           for (int j =0; j < VOWELS.length; j++){
               if (a.charAt(i) ==  VOWELS[j] || String.valueOf(a.charAt(i)).toLowerCase().charAt(0) == VOWELS[j]) {
                   aCount++;
               }
               if (b.charAt(i) ==  VOWELS[j] || String.valueOf(b.charAt(i)).toLowerCase().charAt(0) == VOWELS[j]) {
                   bCount++;
               }
           }

        }
        return aCount == bCount;
    }



    public static void main(String[] args) {
        //JEoEOIPthIGeapOkIeO
        //fUIGlIiNAejJEOUoITU
        System.out.println(new StringAlike().halvesAreAlike("JEoEOIPthIGeapOkIeOfUIGlIiNAejJEOUoITU"));
    }
}
