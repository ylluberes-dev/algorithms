public class TimeToBuyTickets {

    /**
     *
     * @param tickets
     * @param k
     * @return
     *
     * Algorithm
     * K -> Target person
     * sum(k) -> Number of tickets to buy of target
     * sum(i) -> Number of tickets to buy of person i \\ where i != K
     *
     * time = sum(K)  +
     *       ( if sum(i) > sum(k) then sum(k) else sum(i))
     *
     *   Time Complexity O(N)
     *   Space Complexity O(1)
     */
    public int timeRequiredToBuy(int[] tickets, int k) {
        final int sumK = tickets[k]; // The number of ticket that the candidate needs to buy
        int time = 0;
        for (int i = 0; i < tickets.length; i++) {
            if(tickets[i] > sumK) {
                time+= sumK;
            }else {
                time+= tickets[i];
            }
        }
        return time;
    }





    public static void main(String[] args) {
        System.out.println(new TimeToBuyTickets().timeRequiredToBuy(new int []{84,49,5,24,70,77,87,8}, 3));
    }

    
}
