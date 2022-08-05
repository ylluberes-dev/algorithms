
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class AverageWaitingTime {

    /**
     *
     * There is a restaurant with a single chef. You are given an array customers, where customers[i] = [arrivali, timei]:
     *
     * arrivali is the arrival time of the ith customer. The arrival times are sorted in non-decreasing order.
     * timei is the time needed to prepare the order of the ith customer.
     * When a customer arrives, he gives the chef his order, and the chef starts preparing it once he is idle. The customer waits till the chef finishes preparing his order. The chef does not prepare food for more than one customer at a time. The chef prepares food for customers in the order they were given in the input.
     *
     * Return the average waiting time of all customers. Solutions within 10-5 from the actual answer are considered accepted.
     */

    /**
     * @param customers
     * @return average waiting time of each customer
     */

    /**
     * 1 <= customers.length <= 10^5
     * 1 <= arrivali, timei <= 10^4
     * ARRAIVAL(i) <= ARRIVAL(i)+1
     */
    public double averageWaitingTime(int[][] customers) {
        long timesExpend = 0;
        int lastFinish = 0;
        for (int i = 0; i < customers.length; i++) {
            int arrival = customers[i][0];
            int time = customers[i][1];
            //If is not the firs customer
            if (i > 0) {
                if (lastFinish < arrival) {
                    lastFinish = arrival + time;
                } else {
                    lastFinish = lastFinish + time;
                }
            } else {
                lastFinish = arrival + time;
            }
            timesExpend += lastFinish - arrival;

        }
        return (double) timesExpend / customers.length;
    }

    /**
     * Example 1:
     * <p>
     * Input: customers = [[1,2],[2,5],[4,3]]
     * Output: 5.00000
     * Explanation:
     * 1) The first customer arrives at time 1, the chef takes his order and starts preparing it immediately at time 1, and finishes at time 3, so the waiting time of the first customer is 3 - 1 = 2.
     * 2) The second customer arrives at time 2, the chef takes his order and starts preparing it at time 3, and finishes at time 8, so the waiting time of the second customer is 8 - 2 = 6.
     * 3) The third customer arrives at time 4, the chef takes his order and starts preparing it at time 8, and finishes at time 11, so the waiting time of the third customer is 11 - 4 = 7.
     * So the average waiting time = (2 + 6 + 7) / 3 = 5.
     * Example 2:
     * <p>
     * Input: customers = [[5,2],[5,4],[10,3],[20,1]]
     * Output: 3.25000
     * Explanation:
     * 1) The first customer arrives at time 5, the chef takes his order and starts preparing it immediately at time 5, and finishes at time 7, so the waiting time of the first customer is 7 - 5 = 2.
     * 2) The second customer arrives at time 5, the chef takes his order and starts preparing it at time 7, and finishes at time 11, so the waiting time of the second customer is 11 - 5 = 6.
     * 3) The third customer arrives at time 10, the chef takes his order and starts preparing it at time 11, and finishes at time 14, so the waiting time of the third customer is 14 - 10 = 4.
     * 4) The fourth customer arrives at time 20, the chef takes his order and starts preparing it immediately at time 20, and finishes at time 21, so the waiting time of the fourth customer is 21 - 20 = 1.
     * So the average waiting time = (2 + 6 + 4 + 1) / 4 = 3.25.
     */

    List<String> readTestCase() throws URISyntaxException, IOException {
        List<String> alist = Files.lines(Paths.get("C:/Users/ylluberes/Desktop/average-wt-tc3.txt"))
                .collect(Collectors.toList());
        return alist;
    }

    int[][] generateCustomers(List<String> inputs) {
        int customerSize = 0;
        String input = inputs.get(0); //Just one line
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '{') {
                customerSize++;
            }
        }

        int[][] customers = new int[customerSize][2];
        int counter = -1;
        for (int i = 0; i < input.length(); i++) {
            int arrival = -1;
            int time = -1;
            boolean foundCustomer = false;

            if (input.charAt(i) == '{') {
                int k = i;
                StringBuilder builder = new StringBuilder();
                while (input.charAt(k) != '}') {
                    if (input.charAt(k) == ',') {
                        arrival = Integer.parseInt(builder.toString());
                        builder.delete(0, builder.length());
                    }
                    if (Character.isDigit(input.charAt(k))) {
                        builder.append(input.charAt(k));
                    }
                    k++;

                }
                foundCustomer = true;
                time = Integer.parseInt(builder.toString());
                counter++;
            }

            if (foundCustomer) {
                customers[counter][0] = arrival;
                customers[counter][1] = time;
            }

        }
        return customers;
    }

    public static void main(String[] args) throws URISyntaxException, IOException {
        AverageWaitingTime averageWaitingTime = new AverageWaitingTime();


        int testCase1[][] = {{1, 2}, {2, 5}, {4, 3}};
        System.out.println("Result of TC #1: ");
        double r1 = averageWaitingTime.averageWaitingTime(testCase1);
        System.out.println(r1);

        System.out.println();
        int testCase2[][] = {{5, 2}, {5, 4}, {10, 3}, {20, 1}};
        System.out.println("Result of TC #2: ");
        double r2 = averageWaitingTime.averageWaitingTime(testCase2);
        System.out.println(r2);

        System.out.println();
        //int tesCase3 [][] = {{1,496},{2,8112},{6,1395},{7,7068},{7,9388}};
        System.out.println("Result of TC #3: ");
        int[][] testCase3 = averageWaitingTime.generateCustomers(averageWaitingTime.readTestCase());
        double r3 = avgTime(testCase3);
        System.out.println(r3);

        System.out.println();
        System.out.println("Other result: ");
        System.out.println(new AverageWaitingTime().averageWaitingTime(testCase3));


    }

    public static double avgTime(int[][] customers) {
        int done_time = customers[0][0] + customers[0][1];
        long w_t = customers[0][1];
        //System.out.println("w_t"+w_t);
        for (int i = 1; i < customers.length; i++) {
            if (customers[i][0] <= done_time) {
                done_time += customers[i][1];
                w_t += (done_time - customers[i][0]);
            } else {
                done_time = customers[i][0] + customers[i][1];
                w_t += (customers[i][1]);
            }
            //System.out.println("w_t"+w_t);
        }
        double wt = (double) w_t;
        double len = (double) customers.length;
        double ans = wt / len;
        return ans;
    }

}
