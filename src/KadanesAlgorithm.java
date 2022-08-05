public class KadanesAlgorithm {


    public int maxSubarray (int [] values){
        int max = Integer.MIN_VALUE;
        int current = 0;
        for(int i = 0; i < values.length; i++){
            current = current + values[i];
            if(current > max){
                max = current;
            }
            if(current < 0)
                current = 0;

        }
        return max;
    }
    public static void main(String[] args) {
        int [] testCase = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(new KadanesAlgorithm().maxSubarray(testCase));

        String input = "dkhc";
        int container [] = new int [input.length()];
        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            container[i] = c - 'a';
        }

         // hefg -> hegf
        // dhck -> dhkc
        // dkhc -> hcdk
//3 10 7 2
        System.out.println();

    }
}
