public class MaximumUnitsTruck {

    public int maximumUnits(int[][] boxTypes, int truckSize) {

        int max = 0;
        sort(boxTypes);
        int boxCount = 0;
        for (int i = 0; i < boxTypes.length; i++) {

            int numOfBoxes = boxTypes[i][0];
            int numberOfUnits = boxTypes[i][1];
            int totalUnits = numOfBoxes * numberOfUnits;
            if (boxCount + numOfBoxes <= truckSize) {
                max += totalUnits;
            } else {
                int remainder = truckSize - boxCount;
                max += remainder * numberOfUnits;
                return max;
            }
            boxCount = boxCount + numOfBoxes;

        }
        return max;
    }

        private void sort(int[][] elements) {

            for (int i = 0; i < elements.length; i++) {
                for (int j = 0; j < elements.length - 1; j++) {
                    int units = elements[j][1]; //Number of units
                    int nextUnit = elements[j + 1][1];
                    if (nextUnit > units) {
                        swap(elements, j, j + 1);
                    }
                }
            }
        }

    private static void swap(int[][] values, int a, int b) {
        int[] temp = values[a];
        values[a] = values[b];
        values[b] = temp;
    }

    public static void main(String[] args) {
        int testCase[][] = {{1, 3}, {2, 2}, {3, 1}};
        int result = new MaximumUnitsTruck().maximumUnits(testCase, 4);
        System.out.println(result);
    }
}
