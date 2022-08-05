public class NoOfStrings {

    public int numOfStrings(String[] patterns, String word) {
        if(patterns.length < 1 || word == null || word.length() < 1) return 0;
        int count = 0;
        for(String value : patterns) {
            if(value.length() <= word.length()) {
                int startAt = word.indexOf(value);

                if(word.startsWith(value,startAt)) {
                    count++;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
       int result =  new NoOfStrings().numOfStrings(new String []{"a","abc","bc","d"}, "abc");
        System.out.println(result);
    }
}
