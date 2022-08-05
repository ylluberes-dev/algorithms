public class MinCostDeletion {

    public int minCost(String s, int[] cost) {
        int minCost = 0;

        for (int i = 0; i < s.length(); i++) {
           // System.out.println("String value: "+s + " MinCost: -> "+ minCost + " Cost state: "+printArr(cost));

            boolean removeRight = false;
            boolean removeFirst = false;
            boolean remove = false;
            for (int j = i + 1; j < s.length(); j++) {
                char current = s.charAt(i);
                char next = s.charAt(j);
                if (current == next) {
                    //Consecutive same characters
                    int left = cost[i];
                    int right = cost[j];

                    if (left < right) {
                        minCost += left;

                    } else {
                        minCost += right;
                        removeRight = true;
                    }
                    remove = true;

                }
                break;
            }

            if (!removeRight && remove) {
                if (i == 0) {
                    s = s.substring(i + 1);
                    removeFirst = true;
                }
            }
            if (!removeFirst && remove) {
                s = s.substring(0, i) + s.substring(i + 1);
            }

            if(remove) {
                cost = removeElement(cost, removeRight ? i + 1 : i);
               i--;
            }
        }
        return minCost;
    }

    private static int[] removeElement(int[] values, int index) {
        int ret[] = new int[values.length - 1];

        for (int i = index; i < values.length - 1; i++) {
            ret[i] = values[i + 1];
        }

        if (index != 0) {
            for (int j = 0; j < index; j++) {
                ret[j] = values[j];
            }
        }

        return ret;
    }


    private static String printArr (int [] values){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < values.length; i++ ){
            builder.append(values[i] + " ");
        }
        return builder.toString();
    }
    public static void main(String[] args) {


        System.out.println("Test case #1: ");
        System.out.println(new MinCostDeletion().minCost("abaac", new int [] {1,2,3,4,5}));
        System.out.println();

        System.out.println("Test case #2: ");
        System.out.println(new MinCostDeletion().minCost("abc",new int [] {1,2,3}));
        System.out.println();

        System.out.println("Test case #3: ");
        System.out.println(new MinCostDeletion().minCost("aabaa",new int []{1,2,3,4,1}));
        System.out.println();

        System.out.println("Test case #4: ");
        System.out.println(new MinCostDeletion().minCost("aaabbbabbbb", new int[]{3, 5, 10, 7, 5, 3, 5, 5, 4, 8, 1}));
        System.out.println();

        /**
         * aa -> 3  | 3
         * aa -> 5  | 8
         * bb -> 5  | 13
         * bb -> 3  | 16
         * bb -> 4  | 20
         * bb -> 4  | 24
         * bb -> 1  | 25
         *
         */

        /**
         * aaabbbabbbb [ORIGIN] 3,5,10,7,5,3,5,5,4,8,1
         * aabbbabbbb -> 3      5,10,7,5,3,5,5,4,8,1
         * abbbabbbb  -> 5      10,7,5,3,5,5,4,8,1
         * abbabbbb  ->  5      10,7,3,5,5,4,8,1
         * ababbbb   ->  3      10,7,5,5,4,8,1
         * ababbb    ->  4      10,7,5,5,8,1
         * ababb     ->  5      10,7,5,8,1
         * abab      ->  1      10,7,5,8
         */

        /**
         * aabbbabbbb            5,10,7,5,3,5,5,4,8,1]
         *
         */
    }
}
