import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AncestralNames {

    static class NameRomanPair implements Comparable<NameRomanPair> {

        String name;
        int decimalValue;
        String romanValue;

        public NameRomanPair (String name, int decimalValue, String romanValue) {
            this.name = name;
            this.decimalValue = decimalValue;
            this.romanValue = romanValue;
        }

        @Override
        public int compareTo(NameRomanPair o) {
            if(this.name.equals(o.name)) {
                if(this.decimalValue > o.decimalValue) {
                    return 1;
                } else if (this.decimalValue < o.decimalValue ) {
                    return -1;
                }else {
                    return 0;
                }
            }
            return this.name.compareTo(o.name);
        }
    }


    private static int fromRoman (final String value) {
        if(value.length() == 1) getMappedValue(value.charAt(0));

        int sum = getMappedValue(value.charAt(value.length() - 1));
        for (int i = value.length() - 1; i > 0; i--) {
            char current = value.charAt(i);
            char left = value.charAt(i-1);

            int curValue = getMappedValue(current);
            int leftValue = getMappedValue(left);
            if(curValue > leftValue) {
                sum -= leftValue;
            } else {
                sum += leftValue;
            }
        }

        return sum;
    }

    public static List<String> sortRoman(List<String> names) {
        // Write your code here
        final List<String> retList = new ArrayList<>();
        final List<NameRomanPair> nameRomanList = new ArrayList<>();
        //We should convert from roman to decimal
        for (String current : names) {

            String [] separatedValue = current.split(" ");
            String name = separatedValue[0];
            int decimalValue  = fromRoman(separatedValue[1]);
            nameRomanList.add(new NameRomanPair(name, decimalValue, separatedValue[1]));
        }

        Collections.sort(nameRomanList);
        for (NameRomanPair nameRomanPair: nameRomanList) {
            retList.add(nameRomanPair.name + " "+ nameRomanPair.romanValue);
        }

        return retList;
    }

    private static int getMappedValue (char symbol){
        switch (symbol) {
            case 'I':
                return 1;

            case 'V':
                return 5;

            case 'X':
                return 10;

            case 'L':
                return 50;
        }

        return 0;
    }


    public static void main(String[] args) {
       sortRoman( Arrays.asList("Francois VI",
                "Francois XXIII",
                "Francois XX",
                "Francois XXV",
                "Petrzlen XXXIV",
                "Paul VIII",
                "Louis XLIII",
                "Philippe XXXVIII",
                "Luka I",
                "Mary XXVIII",
                "Bruce XXVI",
                "Tomek V",
                "Luka XXXVII",
                "Petrzlen I",
                "Paul VI",
                "Mary XXX",
                "Luka XLII",
                "Bruce XLI",
                "Tomek VIII",
                "Luka XXII",
                "Bruce XVIII",
                "Rasto XV",
                "Maru XLI",
                "Francois XXIV",
                "Mary XXIV",
                "Maru XXXIV",
                "Louis XXIX",
                "Francois XL",
                "Philippe L",
                "Bruce XXVII",
                "Maru XXXV",
                "Tomek IX",
                "Paul XLIX",
                "Petrzlen XX",
                "Petrzlen XXXVII",
                "Paul XX",
                "Maru XVIII",
                "Louis XLI",
                "Mary XLII",
                "Luka XVII",
                "Paul XVII",
                "Louis XV",
                "Mary XXXV",
                "Philippe XV",
                "Petrzlen XVI",
                "Mimino XXXVIII",
                "Philippe VII"));

    }
}
