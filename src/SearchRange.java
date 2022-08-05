import java.util.stream.IntStream;

public class SearchRange {

    public int binarySearch (Integer [] values, int target) {
        int size = values.length;
        int mid = size / 2;
        int curr = values[mid];
        if (size == 1  && values[0].intValue() != target) return -1;
        if(curr == target)
             return mid;
        else if (curr > target)
            return binarySearch(IntStream.range(0, mid)
                    .mapToObj(i -> values[i])
                    .toArray(Integer[]::new),target);
        else if (curr < target)
            return binarySearch(IntStream.range(mid, size)
                    .mapToObj(i -> values[i])
                    .toArray(Integer[]::new),target);
        else
            return -1;
    }


    public static void main(String[] args) {
        System.out.println(new SearchRange().binarySearch(new Integer []{1,1,4,5,6,8,9,25,30,32,33},6));
    }
}
