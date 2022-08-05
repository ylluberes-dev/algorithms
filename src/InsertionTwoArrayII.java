import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InsertionTwoArrayII {

    public int[] intersect(int[] nums1, int[] nums2) {

        if (nums1 == null || nums2 ==null)
            return new int []{};
        List<Integer> interList = new ArrayList<>();
        Map<Integer,Integer> visitedInd = new HashMap();
            for (int i = 0; i < nums1.length; i++) {
                for (int j = 0; j < nums2.length; j++) {
                    if (nums1[i] == nums2[j]) {
                        if (visitedInd.containsKey(j)){
                            continue;
                        }else {
                            interList.add(nums2[j]);
                            visitedInd.put(j, nums2[j]);
                            break;
                        }
                    }
                }

            }

        if (interList.size() == 0)
            return new int [] {};
        int [] ret = new int [interList.size()];
        for (int i = 0; i < interList.size(); i++) {
            ret[i] = interList.get(i);
        }
        return ret;
    }


    public static void main(String[] args) {
        /*int [] ret = (new InsertionTwoArrayII().intersect(new int[]{1,2,2,1}, new int []{2,2}));
        for (int i=  0; i < ret.length; i++) {
            System.out.println(ret[i]);
        }*/

        System.out.println("In main function");
    }

    public static void main (char []args ){
        new InsertionTwoArrayII();
        System.out.println('a');
    }
}
