import java.util.Arrays;

public class SortingSentence {

    public String sortSentence(String s) {
        String[] sentence = s.split(" ");

        for (int i = 0; i < sentence.length; i++) {
            int pos = Integer.parseInt(String.valueOf(sentence[i].charAt(sentence[i].length() - 1)));
            String current = "";
            for (int j = i + 1; j < sentence.length; j++) {
                int nestedPos = Integer.parseInt(String.valueOf(sentence[j].charAt(sentence[j].length() - 1)));
                if (nestedPos < pos) {
                    pos = nestedPos;
                    current = sentence[j];
                    String temp = sentence[i];
                    sentence[i] = current;
                    sentence[j] = temp;
                }
            }
        }

        StringBuilder builder = new StringBuilder();
        int index = 0;
        for (String word : sentence) {
            word = word.replaceAll("\\d","");
            if(index == (sentence.length - 1)){
                builder.append(word);
            }else {
                builder.append(word).append(" ");
            }
            index++;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new SortingSentence().sortSentence("is2 sentence4 This1 a3"));
    }
}
