import java.util.*;

public class ArithmeticProgression {

    public boolean canMakeArithmeticProgression(int[] arr) {
        if(arr.length < 3) return true;
        Arrays.sort(arr);
        Set<Integer> distances = new HashSet<>();
        for (int i = 0; i < arr.length -1; i++) {
            System.out.println(arr[i] - arr[i+1]);
          distances.add(arr[i] - arr[i+1]);
        }

       return distances.size() == 1;
    }

    public static void main(String[] args) {

        System.out.println(new ArithmeticProgression().canMakeArithmeticProgression(new int []{1,2,4}));
    }
}
