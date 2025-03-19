import javafx.geometry.Pos;

import java.util.HashMap;
import java.util.Map;

public class MaxOperations {

    static class Position {
        int pos;
        boolean used;

        public Position(int pos, boolean used) {
            this.pos = pos;
            this.used = used;
        }

        static class Key {
            int key;

        }

    }

    public int maxOperations(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap(); // HashMap for keeping a track of the occurence of the elements in the array
        int count=0; // for the final answer
        for(int i=0;i<nums.length;i++){ // loop through each element of the array
            int an=k-nums[i]; // given condition in the question
            if(map.containsKey(an)){ // if there is a number to satisfy the condition
                count++; // update the answer
                if(map.get(an)==1) // if there is only 1 ouccerence of the element
                    {
                        map.remove(an);
                    }
                else
                    {
                        map.put(an,map.get(an)-1);
                    } // or decrease its value
            }
            else
                {
                    map.put(nums[i],map.getOrDefault(nums[i],0)+1);
                }// if element not present then add it in map
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new MaxOperations().maxOperations(new int[]{2, 5, 4, 4, 1, 3, 4, 4, 1, 4, 4, 1, 2, 1, 2, 2, 3, 2, 4, 2}, 3));
        HashMap<String,Integer> map = new HashMap<>();
        System.out.println();

    }
}
