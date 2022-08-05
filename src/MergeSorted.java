public class MergeSorted {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int [] solve = new int [m + n];
        int left = 0;
        int right = 0;
        int index = 0;
        while((left + right) < solve.length) {
            int x1 = 0;
            int x2 = 0;
            if(nums1.length > 0)
                x1 = nums1[left];
            if(nums2.length > 0)
                x2 = nums2[right];

            if(x1 < x2){
                if(left >= m && x1 == 0) {
                    solve[index] = x2;
                    right++;
                }else {
                    solve[index] = x1;
                    left++;
                }
            }else if(x2 < x1) {
                solve[index] = x2;
                right++;
            }else {
                solve[index] = x1;
                index++;
                solve[index] = x2;
                left++;
                right++;
            }
            index++;
        }

        nums1 = solve;
    }


    public static void main(String[] args) {
        new MergeSorted().merge(new int []{1},1, new int []{},3);
    }
}
