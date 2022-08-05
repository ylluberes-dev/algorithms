import java.util.HashMap;
import java.util.Map;

public class UniqueElements {

    public int sumOfUnique(int[] nums) {
        Map<Integer,Integer> freqTable = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            if (freqTable.containsKey(value)){
                freqTable.replace(value,freqTable.get(value) + 1);
            }else {
                freqTable.put(value,1);
            }
        }
        int sum = 0;
        for (Integer i: freqTable.keySet()) {
            if (freqTable.get(i) == 1){
                sum += i.intValue();
            }
        }

        return sum;
    }


    public static void main(String[] args) {
      int result =  new UniqueElements().sumOfUnique(new int [] {1,2,3,4,5});
        System.out.println("Output: "+result);
    }
}
