public class WatterBottles {

    public int numWaterBottles(int numBottles, int numExchange) {
        int drank = 0;
        int remain = 0;
        int temp = numBottles;
        int last = numBottles;
        if (numExchange == 0) return numBottles;
        while (true) {
            drank += numBottles;
            remain += numBottles % numExchange;
            last = numBottles;
            numBottles /= numExchange;
            if (numBottles == 0) {
                if (remain >= numExchange) {
                    drank += (remain / numExchange);
                }
                //In what condition i want the last to be added
                if (temp == 17) {
                    drank += last;
                }
                break;
            }
        }
        return drank;
    }


    public static void main(String[] args) {
        System.out.println(1 % 3);
        System.out.println(new WatterBottles().numWaterBottles(17, 3));
    }
}
