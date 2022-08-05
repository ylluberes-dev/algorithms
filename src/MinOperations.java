public class MinOperations {

    public int[] minOperations(String boxes) {
        if (boxes == null || "".equals(boxes)) return new int []{};

        int operations[] = new int[boxes.length()];
        for (int i = 0; i < boxes.length(); i++) {
            operations[i] = getAccumulatedDistance(i, boxes);
        }
        return operations;
    }

    private static int getAccumulatedDistance(int targetPosition, String boxes) {
        int distances = 0;
        for (int i = 0; i < boxes.length(); i++) {
            if (i == targetPosition) {
                continue;
            } else {
                if (boxes.charAt(i) == '1') { // If the box contains a ball...
                    distances += Math.abs(targetPosition - i);
                }
            }
        }
        return distances;
    }


    private static void printArr (int [] values) {
        for (int i = 0; i < values.length; i++){
            System.out.println(values[i]);
        }
    }
    public static void main(String[] args) {
      /*int [] result = new MinOperations().minOperations("001011");
      printArr(result);*/

        System.out.println("SAVESEARCH_SEARCH".contains("_SEARCH"));
    }
}
