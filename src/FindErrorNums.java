import java.util.*;
import java.util.stream.Collectors;

public class FindErrorNums {

    public int[] findErrorNums(int[] nums) {
        Map<Integer,Integer> freqTable = new HashMap<>();
        List<Integer> baseList= new ArrayList<>();
        for (int i = 0; i < nums.length;i ++) {
            if (freqTable.containsKey(nums[i])) {
                freqTable.replace(nums[i],freqTable.get(nums[i])+ 1);
            }else {
                freqTable.put(nums[i],1);
            }
            baseList.add(i+1);
        }
        int p = 0;
        int a = 0;
        for (Integer i: freqTable.keySet()) {
            if (freqTable.get(i) == 2) {
                p = i;
            }
        }
       List<Integer> parsed = Arrays.stream(nums).boxed().collect(Collectors.toList());
        for (int i = 0; i < parsed.size(); i++){
            if (! (parsed.contains(baseList.get(i)))){
                a = baseList.get(i);
            }
        }

        System.out.println(a);
        System.out.println(p);

        return new int []{p,a};
    }


    public static void main(String[] args) {
        System.out.println(new FindErrorNums().findErrorNums(new int []{1,2,2,4}));
    }
}
