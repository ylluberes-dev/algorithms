public class FindKthPositive {

    public int findKthPositive(int[] arr, int k) {
        int diff = Math.abs(arr[0] - 1);
        if(diff >= k) return k;
        for (int i = 1; i < arr.length; i++) {
            int prev = diff;
            diff += Math.abs(arr[i] - arr[i - 1] - 1);
            if(diff >= k)
                return arr[i-1] + k - prev;
        }
        return arr[arr.length-1] + k - diff;
    }


    public static void main(String[] args) {
        System.out.println(new FindKthPositive().findKthPositive(new int[]{5,6,7,8,9}, 9));
    }
}
