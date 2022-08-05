import javax.smartcardio.Card;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CardinalitySort {
    static class NumPair implements Comparable<NumPair> {

         int decimalValue;
         int cardinalityValue;

         public NumPair (int decimalValue, int cardinalityValue) {
             this.cardinalityValue = cardinalityValue;
             this.decimalValue = decimalValue;
         }
        @Override
        public int compareTo(NumPair o) {
            if(this.cardinalityValue == o.cardinalityValue) {
                if(this.decimalValue > o.decimalValue) {
                    return 1;
                } else if (this.decimalValue < o.decimalValue ) {
                    return -1;
                }else {
                    return 0;
                }
            }
            if(this.cardinalityValue > o.cardinalityValue) {
                return 1;
            } else if(this.cardinalityValue < o.cardinalityValue) {
                return -1;
            }
            return 0;
        }
    }

    public static List<Integer> cardinalitySort(List<Integer> nums) {
        // Write your code here
        List<NumPair> pairList = new ArrayList<>();
        final List<Integer> retList = new ArrayList<>();
        for (Integer i: nums){
            int cardinalityNumber = getCardinality(i);
            pairList.add(new NumPair(i,cardinalityNumber));
        }
        Collections.sort(pairList);
        for (int i = 0; i < pairList.size(); i++) {
            retList.add(pairList.get(i).decimalValue);
        }
        return retList;
    }


    private static int getCardinality (int num) {
        int count = 0;
        while(num > 0) {
            int res = num % 2;
            if(res == 1) count++;
            num = num / 2;
        }
        return count;
    }

    public static void main(String[] args) {
       // System.out.println(getCardinality(7));
        printList(cardinalitySort(Arrays.asList(1,2,3,4,5)));
    }


    private static void printList (final List<Integer> values) {
        values.forEach(x -> System.out.println(x));
    }
}
