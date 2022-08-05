import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    static List<String > summaryRanges (int [] nums) {
        boolean inRange = false;
        int rangeStart = 0;
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + 1 == nums[i + 1] && !inRange) {
                list.add(nums[i] + "->");
                inRange = true;
                rangeStart = list.size()-1;
                continue;

            } else if (nums[i] + 1 != nums[i + 1] && inRange) {
                list.set(rangeStart,""+list.get(rangeStart) + nums[i]);
                inRange = false;

            }else if (nums[i] + 1 != nums[i + 1] && !inRange) {
                list.add(""+nums[i]);
            }
        }
        if (inRange)
            list.set(rangeStart,""+list.get(rangeStart) + nums[nums.length-1]);
        else
            list.add(""+nums[nums.length-1]);
        return list;

    }

    public static void main(String[] args) {
        List<String> res = summaryRanges(new int [] {0,1,2,4,5,7});
        System.out.println(res);
    }
}