public class LeetCodeBank {

    public int totalMoney(int n) {

        int sum = 0;
        int count = 0;
        int weekDays = 1;
        int completedWeeks = 1;
        int endRange = 7;
        while (true) {
            boolean newRange = false;
            if (count == n) {
                break;
            }
            sum += weekDays;

            if (weekDays == endRange) {
                completedWeeks++;
                weekDays = completedWeeks;
                endRange++;
                newRange = true;
                //count--;
            }

            count++;
            if (!newRange) {
                weekDays++;
            }

        }
        return sum;
    }

    private static int getSumRange(int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCodeBank().totalMoney(26));
    }
}
