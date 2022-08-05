import java.util.Arrays;
import java.util.Comparator;

public class SortByBits {

    public int[] sortByBits(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                int first = getOnes(arr[j]);
                int second = getOnes(arr[j + 1]);
                if (first > second) {
                    swap(arr, j, j + 1);
                } else if (first == second) {
                    if (arr[j] > arr[j + 1]) {
                        swap(arr, j, j + 1);
                    }
                }
            }
        }

       /* Arrays.sort(Arrays.stream(arr).boxed().toArray(Integer[]::new), new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(countOnes(getBinary(o1.intValue())) > countOnes(getBinary(o2.intValue()))){
                    return 1;
                }else if (countOnes(getBinary(o1.intValue())) == countOnes(getBinary(o2.intValue()))){
                    if(o1.intValue() > o2.intValue()){
                        return 1;
                    }else {
                        return -1;
                    }
                }
                return 0;
            }
        });
        return arr  ;*/
        return arr;
    }

    private static int getOnes(int num){
        //StringBuilder binary = new StringBuilder();
        int ones = 0;
        while(num > 1){
            int candidate = num % 2;
            if(candidate == 1){
                ones++;
            }
           // binary.append(num%2);
            num /=2;
        }
       // binary.append(num);
        return ones;
    }

    private static int countOnes (String binary){
        int ones = 0;
        for(Character c: binary.toCharArray()){
            if(c == '1')
                ones++;
        }
        return ones;
    }

    static void printArr (int [] values){
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }
    }

    private static void swap (int [] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static void main(String[] args) {
        printArr(new SortByBits().sortByBits(new int []{1024,512,256,128,64,32,16,8,4,2,1}));
    }
}
