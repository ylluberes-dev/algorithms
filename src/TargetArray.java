public class TargetArray {

    public int[] createTargetArray(int[] nums, int[] index) {
        int size = nums.length;
        int[] target = new int[size];
        boolean[] visited = new boolean[size];
        for (int i = 0; i < index.length; i++) {
            /*
             -> Shift right
            * [1] [2] [3] [4] [5] [] []
            * */
            if (visited[index[i]]) {
                shiftRight(target,index[i]);
                target[index[i]] = nums[i];
                visited[i]= true;
            }else {
                target[index[i]] = nums[i];
                visited[i]= true;
            }

        }

        return target;
    }

    private static void shiftRight(int[] arr, int end) {

        for (int i = arr.length-1; i > end ;i--) {
            arr[i] = arr[i -1];
        }
    }


    public static void main(String[] args) {

        System.out.println(new TargetArray().createTargetArray(new int[]{4,2,4,3,2}, new int[]{0,0,1,3,1}));

        /**
         *
         *[4,2,4,3,2]
         * [0,0,1,3,1]
         */

    }
}
