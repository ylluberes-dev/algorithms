public class CountSegments {

    public int countSegments(String s) {

        String [] delim = s.split("\\s+");

        int segment = 0;
        boolean wordSegment = false;
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == ' ') {
                wordSegment = false;
                continue;
            } else {
                if (!wordSegment) {
                    segment++;
                    wordSegment = true;
                }
            }
        }
        return segment;
    }


    public static void main(String[] args) {
        System.out.println(new CountSegments().countSegments(", , , ,        a, eaefa"));
    }
}
