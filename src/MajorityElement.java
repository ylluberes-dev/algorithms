import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public int majorityElement (int [] nums) {
        Map<Integer,Integer> freqTable = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if(freqTable.containsKey(nums[i])){
                int value = freqTable.get(nums[i]) + 1;
                freqTable.put(nums[i],value);
            }else {
                freqTable.put(nums[i],1);
            }
        }
        int mid = nums.length / 2;
        for (Integer key: freqTable.keySet()){
            if(freqTable.get(key) > mid){
                return key;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new MajorityElement().majorityElement(new int [] {2,2,1,1,1,2,2}));
    }
}
