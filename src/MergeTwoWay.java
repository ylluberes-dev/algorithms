public class MergeTwoWay {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int result[] = nums1.clone();
        int count = 0;
        int left = 0, right = 0;
        while (true) {
            if (left == m ) {
                for (int k = right; k < n; k++) {
                    nums1[count] = nums2[k];
                    count++;
                }
                break;
            }
            if (right == n ) {
                for (int k = left; k < m; k++) {
                    nums1[count] = result[k];
                    count++;
                }
                break;
            }
            int leftValue = result[left];
            int rightValue = nums2[right];

            if (leftValue == rightValue) {
                nums1[count] = leftValue;
                count++;
                nums1[count] = rightValue;
                left++;
                right++;
            } else if (leftValue < rightValue) {
                    nums1[count] = leftValue;
                    count++;
                    left++;
            } else if (rightValue < leftValue) {
                    nums1[count] = rightValue;
                    count++;
                    right++;
            }
        }
    }


    public static void main(String[] args) {
//        new MergeTwoWay().merge(
//                new int []{1,2,3,0,0,0},3,
//                new int []{2,5,6},3
//        );
        new MergeTwoWay().merge(
                new int []{2,0},1,
                new int []{1},1
        );
    }
}
