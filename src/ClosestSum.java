import java.util.Arrays;

public class ClosestSum {
    static class Pair implements Comparable<Pair> {
        int original;
        int distance;

        public Pair(int original, int distance) {
            this.original = original;
            this.distance = distance;
        }

        public int compareTo(Pair other) {
            if (this.distance < other.distance)
                return -1;

            return 1;

        }
    }

    public int threeSumClosest(int[] nums, int target) {

        //Find the 3 closest numbers to N such that n1 + n2 + n3 < target
        // O(N^3)

        // -4 -1 1 2
        //  3  0 0 1
        Pair[] absoluteDistances = new Pair[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int distance = Math.abs(nums[i] - target);
            Pair p = new Pair(nums[i], distance);
            absoluteDistances[i] = p;
        }

        Arrays.sort(absoluteDistances);
        return absoluteDistances[0].original + absoluteDistances[1].original + absoluteDistances[2].original;
    }

    public static void main(String[] args) {
        int result  = new ClosestSum().threeSumClosest(new int []{-1,2,1,-4},1);
        System.out.println("Result: "+result);
    }
}
