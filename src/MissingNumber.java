import com.sun.deploy.util.OrderedHashSet;

import java.util.*;

public class MissingNumber {


    /*
     * Complete the 'missingNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER_ARRAY brr
     */

    public static List<Integer> missingNumbers(final List<Integer> arr,
                                               final List<Integer> brr) {
        final Map<Integer, Integer> targetTable = buildFreqTable(arr); // O(N) Time | O(distinct M) Space
        final Map<Integer, Integer> baseTable = buildFreqTable(brr);   // O(N) Time | O(distinct M) Space
        final Set<Integer> missingNumbers = new TreeSet<>(); //
        final List<Integer> resultMissing = new ArrayList<>();

        for (Integer key : baseTable.keySet()) {
            if (!targetTable.containsKey(key)) {
                missingNumbers.add(key);
            } else {
                if (baseTable.get(key)  > targetTable.get(key)) // If they do not share the same frequency
                    missingNumbers.add(key);
            }
        }

        missingNumbers.forEach(missing -> {
            resultMissing.add(missing);
        });
        return resultMissing;
    }

    /**
     * @param elements given elements to create the frequency table
     * @return A frequency table of the given elements
     */
    private static Map<Integer, Integer> buildFreqTable(final List<Integer> elements) {
        final Map<Integer, Integer> frequencyTable = new HashMap<>();
        elements.forEach(element -> {
            frequencyTable
                    .put(element, frequencyTable
                            .getOrDefault(element,0)+1);
        });
        return frequencyTable;
    }


    private static void printOutput (final List<Integer> output){
        output.forEach(element -> {
            System.out.print(element +" ");
        });
    }

    public static void main(String[] args) {
        final List<Integer> A = Arrays.asList(203, 204, 205, 206, 207, 208, 203, 204, 205, 206);
        final List<Integer> B = Arrays.asList(203, 204, 204, 205, 206, 207, 205, 208, 203, 206, 205, 206, 204);
        printOutput(missingNumbers(A,B));
    }
}
