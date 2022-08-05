public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int left = 0, right = 0;
        int ret [] = new int [m + n];
        int index = 0;
        while(index < (m + n)) {
            int a = nums1[left];
            int b = nums2[right];

            if(left == m){
                ret[index] = b;
                right++;
                index++;
                continue;
            }else if( right == n){
                ret[index] = a;
                left++;
                index++;
                continue;
            }
            if(a <= b){
                nums1[index] = a;
                left++;
            }else {
                nums1[index] = b;
                right++;
            }
            index++;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        new MergeSortedArray().merge(new int [] {1,2,3,0,0,0}, 3, new int []{2,5,6},3);
    }
}
