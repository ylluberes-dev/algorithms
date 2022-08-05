import java.util.HashMap;
import java.util.Map;

public class SingleNumber {

    public int singleNumber (int [] nums) {
        if(nums == null){
            return -1;
        }
        Map<Integer,Integer> freqMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(freqMap.containsKey(nums[i])){
                int plusOne = freqMap.get(nums[i]);
                freqMap.put(nums[i],++plusOne);
            }else {
                freqMap.put(nums[i],1);
            }
        }

        for (Integer i: freqMap.keySet()){
            if(freqMap.get(i) < 2){
                return freqMap.get(i);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
       int [] values = {4,1,2,1,2 };
       new SingleNumber().singleNumber(values);
        System.out.println("");
    }
}
