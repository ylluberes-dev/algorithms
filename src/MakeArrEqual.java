public class MakeArrEqual {

    public int minOperations(int n) {
        int last = (n - 1) * 2 + 1;
        int mid = (last / 2) + 1;
        int sum = 0;
        for (int i = 1; i < mid; i++) {
            if (i % 2 != 0)
                sum += Math.abs(mid - i);

        }
       return sum;
    }


    public static void main(String[] args) {
        System.out.println(new MakeArrEqual().minOperations(4));
    }
}
