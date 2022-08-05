import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindUserActivity {

    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int [] answer = new int [k];
        Map<Integer, HashSet<Integer>> userActionsPair = new HashMap<>();
        for (int i = 0; i < logs.length; i ++) {
            if (userActionsPair.containsKey(logs[i][0])) {
                userActionsPair.get(logs[i][0]).add(logs[i][1]);
            }else {
                HashSet<Integer> minuteList = new HashSet<>();
                minuteList.add(logs[i][1]);
                userActionsPair.put(logs[i][0],minuteList);
            }
        }
        for (Integer i: userActionsPair.keySet()) {
            answer[userActionsPair.get(i).size()-1]++;
        }

        return answer;
    }

    private static void print (int [] nums) {
        for (int i = 0; i < nums.length; i++){
            System.out.print("["+nums[i]+ "] ");
        }
    }

    public static void main(String[] args) {
        print(new FindUserActivity().findingUsersActiveMinutes(new int [][] {{1,1},{2,2},{2,3}},4));
    }
}
