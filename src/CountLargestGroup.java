import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountLargestGroup {

    public int countLargestGroup(int n) {
        Map<Integer,List<Integer>> counter = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int key = sumDigits(i);
            if(counter.containsKey(key)) {
                List<Integer> existingGroup = counter.get(key);
                existingGroup.add(i);
                counter.replace(key,existingGroup);
            }else {
                List<Integer> newGroup = new ArrayList<>();
                newGroup.add(i);
                counter.put(key,newGroup);
            }
        }
        int max = Integer.MIN_VALUE;
        for(Integer key: counter.keySet()){
            if(counter.get(key).size() > max)
                max = counter.get(key).size();
        }
        int maxCounter = 0;
        for (Integer key: counter.keySet()) {
            if(counter.get(key).size() == max) {
                maxCounter++;
            }
        }
        return maxCounter;
    }

    private static int sumDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n = n / 10;
        }
        return sum;
    }

    private static void printList(List<Integer> groups) {

        for (int i = 0; i < groups.size(); i++) {
            System.out.print(groups.get(i) + ", ");
        }
        if (!(groups.size() == 0)) {
            System.out.println();
        }
    }


    public static void main(String[] args) {
        //System.out.println(sumDigits(355));
        System.out.println(new CountLargestGroup().countLargestGroup(24));
    }
}
