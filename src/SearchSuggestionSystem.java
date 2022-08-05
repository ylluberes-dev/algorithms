import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SearchSuggestionSystem {
    /**
     * Given an array of strings products and a string searchWord. We want to design a system that
     * suggests at most three product names from products after each character of
     * searchWord is typed. Suggested products should have common prefix with the searchWord.
     * If there are more than three products with a common prefix return the three lexicographically minimums products.
     * <p>
     * Return list of lists of the suggested products after each character of searchWord is typed.
     */

    private static final int PRODUCT_LIMIT = 3;

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> suggested = new ArrayList<>();
        Arrays.sort(products);
        for (int i = 0; i <searchWord.length(); i++) {
            List<String> currentSuggested = new ArrayList<>();
            for (String product : products) {
                if(i >= product.length()) continue;
                if (searchWord.substring(0, i+1).equals(product.substring(0, i+1))) {
                    currentSuggested.add(product);
                }
                if (currentSuggested.size() == PRODUCT_LIMIT) {
                    break; // Top three words is guaranteed because products is already sorted
                }
            }
            suggested.add(currentSuggested);

        }
        return suggested;
    }

    private static void printLists(List<List<String>> values) {
        if (values == null)
            System.out.println("values param cannot be null");
        else
            for (List<String> list : values) {
                int wordCount = 0;
                System.out.print("[");
                for (String str : list) {
                    if (wordCount + 1 == list.size()) {
                        System.out.print(str);
                    } else {
                        System.out.print(str + ", ");
                    }
                    wordCount++;

                }
                System.out.print("]");
                System.out.println();
            }
    }

    private static void printArr(String[] products) {
        for (String product : products) {
            System.out.println(product);
        }
    }

    public static void main(String[] args) {
        /**
             * ["bags","baggage","banner","box","cloths"]
         * "bags"
         */
        List<List<String>> suggested = new ArrayList<>();
        List<String> a = new ArrayList<>();
        a.add("Product 1 ");
        a.add("Product 2 ");
        a.add("Product 3 ");

        List<String> b = new ArrayList<>();
        b.add("Product b1 ");
        b.add("Product b2 ");
        b.add("Product b3 ");

        suggested.add(a);
        suggested.add(b);
        // printLists(suggested);
       /* String [] products = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        System.out.println("Before sort: ");
        System.out.println();
        printArr(products);
        System.out.println("After sort: ");
        System.out.println();
        Arrays.sort(products);
        printArr(products);*/

        printLists(new SearchSuggestionSystem()
                .suggestedProducts(
                        new String[]{"bags","baggage","banner","box","cloths"}
                        , "mouse"));
    }
}
