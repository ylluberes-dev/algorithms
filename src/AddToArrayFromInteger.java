import java.util.ArrayList;
import java.util.List;

public class AddToArrayFromInteger {

    public List<Integer> addToArrayForm(int[] num, int k) {

        int index = num.length -1;
        int lastDigit = 0;
        int next = 0;
        StringBuilder resultBuilder = new StringBuilder();
        List<Integer> resultList = new ArrayList<>();
        int value = 0;
        while (true){
            lastDigit = k % 10;
            if ( k <= 0 && index < 0){
                if (next > 0) {
                    resultBuilder.append(next);
                }
                break;
            }
            if (k <= 0) {
                lastDigit = 0;
            }
            value = index >= 0 ? num[index] : 0;
            String result = String.valueOf(value+ lastDigit + next);
            if (result.length() > 1){
                resultBuilder.append(result.charAt(1));
                next = Integer.parseInt(String.valueOf(result.charAt(0)));
            }else {
                resultBuilder.append(result);
                next = 0;
            }
            index--;
            k = k / 10;
        }

        String reversed = resultBuilder.reverse().toString();
        for  (Character c : reversed.toCharArray()) {
            resultList.add(Integer.parseInt(String.valueOf(c)));
        }
        return resultList;
    }

    public static void main(String[] args) {
        System.out.println(new AddToArrayFromInteger().addToArrayForm(new int []{9,9,9,9,9,9,9,9,9,9},1));
    }
}

//11,223