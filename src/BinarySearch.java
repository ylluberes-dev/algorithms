import com.sun.javaws.exceptions.InvalidArgumentException;
import org.omg.CORBA.DynAnyPackage.Invalid;

import java.util.Arrays;

public class BinarySearch {

    public  int binarySearch(int[] nums, int target) throws InvalidArgumentException {

        if(nums == null || nums.length ==0)
            throw new InvalidArgumentException(new String[]{"Input String cannot be null"});

        int mid = nums.length / 2;
        int lo = 0;
        int hi = nums.length - 1;

        if (nums[mid] == target) {
            return nums[mid];
        } else if (lo == hi ){
             return -1;
        } else if (nums[mid] > target) {
            int[] reduce = Arrays.copyOfRange(nums, lo, mid); //Memory cost, processing cost
            return binarySearch(reduce, target);
        }else if (nums[mid] < target){
            int[] reduce = Arrays.copyOfRange(nums, mid + 1, hi + 1); // Memory cost, processing cost
            return binarySearch(reduce, target);
        }

        return 0;
    }

    public static void main (String [] args){
        int values [] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        try {
            System.out.println(new BinarySearch().binarySearch(values, 8));
        }catch (InvalidArgumentException ex){
            ex.printStackTrace();
        }

        System.out.println("1"+2);

    }


}
