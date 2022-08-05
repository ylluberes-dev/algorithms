public class GasStation {

    static int canCompleteCircuit(int[] gas, int[] cost) {
        /**
         *  gas = [1, 2, 3, 4, 5]
         *  cost = [3, 4, 5, 1, 2]
         *  test all index`s
          */
        for (int i = 0; i < gas.length; i++) {
            int sum = gas[i];
            boolean found = false;
            int c = 0;
            for (int k = i + 1; true; k++){
                if(k == gas.length){
                    k = 0;
                }
                if (k == 0){
                    sum -= cost[cost.length-1];
                }else {
                    sum -= cost[k - 1];
                }
                if(sum < 0){
                    break;
                }
                if(c == gas.length-1){
                    found = true;
                    break;
                }
                sum += gas[k];

                c++;
            }
            if(found) return i;

        }

        return -1;
    }


    public static void main(String[] args) {
        //System.out.println(canCompleteCircuit(new int []{1, 2, 3, 4, 5}, new int [] {3, 4, 5, 1, 2}));
        System.out.println(canCompleteCircuit(new int []{2,3,4}, new int [] {3,4,3}));
    }
}
