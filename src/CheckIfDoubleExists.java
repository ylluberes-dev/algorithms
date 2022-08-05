public class CheckIfDoubleExists {

    public boolean checkIfExist(int[] arr) {

        //O(N^2) Two loops in the array
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i != j){
                    if (arr[i] == arr[j] * 2){
                        return true;
                    }
                }
            }
        }


        return false;
    }

    public static void main(String[] args) {
        System.out.println(new CheckIfDoubleExists().checkIfExist(new int []{3,1,7,11}));
    }
}
