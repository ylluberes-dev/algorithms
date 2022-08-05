public class CarPooling {


    boolean carPooling(int[][] trips, int capacity) {

        // Find the first trip (minimum start point)
        //Find the end trip (maximum end point)

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < trips.length; i++) {
            if (trips[i][2] > max)
                max = trips[i][2];

            if(trips[i][1] < min)
                min = trips[i][1];
        }
        //sort(trips);
        int passengers = 0;
        for (int i = min; i < max; i++) { //From the start to end
            for (int j = 0; j < trips.length; j++) {
                int[] trip = trips[j];
                if (trip[1] == i) {
                    passengers += trip[0];
                }
                if (passengers > capacity) return false;
                if (trip[2] == i) {
                    passengers -= trip[0];
                }
            }
        }
        return true;
    }

    private static void sort(int[][] trips) {
        for (int i = 0; i < trips.length; i++) {
            for (int j = 0; j < trips.length - 1; j++) {
                if (trips[j + 1][1] < trips[j][1]) {
                    int[] temp = trips[j + 1];
                    trips[j + 1] = trips[j];
                    trips[j] = temp;
                }
            }
        }
    }


    private static int[][] buildTest(String input) {
        int rowSize = 0;
        boolean validInput = false;
        if (input != null && input.length() > 0) {
            for (char ch : input.toCharArray()) {
                if (ch == '[')
                    rowSize++;
            }
            validInput = true;
        }
        int trips[][] = null;
        if (validInput) {
            trips = new int[rowSize - 1][3];
            rowSize = 0;
            for (int i = 0; i < input.length(); i++) {
                char cur = input.charAt(i);
                if (cur == '[') {
                    int count = 0;
                    while (cur != ']') {
                        if (cur != '[' && cur != ',') {
                            trips[rowSize][count] = Integer.parseInt(String.valueOf(cur));
                            count++;
                        }
                        cur = input.charAt(++i);
                    }
                    rowSize++;
                }
            }
        }
        return trips;

    }

    public static void main(String[] args) {


        String testCase1 = "[[2,1,5],[3,3,7]]";
         System.out.println(new CarPooling().carPooling(buildTest(testCase1), 4));
        System.out.println();

        String testCase2 = "[[2,1,5],[3,3,7]]";
         System.out.println(new CarPooling().carPooling(buildTest(testCase2), 5));
        System.out.println();

        String testCase3 = "[[2,1,5],[3,5,7]]";
         System.out.println(new CarPooling().carPooling(buildTest(testCase3), 3));
        System.out.println();

        String testCase4 = "[[3,2,7],[3,7,9],[8,3,9]]";
        System.out.println(new CarPooling().carPooling(buildTest(testCase4), 11));
        System.out.println();


    }
}
