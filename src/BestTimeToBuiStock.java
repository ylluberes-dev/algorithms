import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BestTimeToBuiStock {

    public int maxProfit(int[] prices) {
      if (prices == null){
          return 0;
      }

      if(prices.length < 2 ){
          return 0;
      }
        List<Integer> profits = new ArrayList<>();
      //  int sum = 0;
       for  (int i = 0; i < prices.length; i++){
           int sum = 0;
           for (int j = i + 1; j <prices.length; j++) {
               if (prices[j] > prices[i]) {
                   if (sum < Math.abs((prices[i] - prices[j]))) {
                       sum = Math.abs(prices[i] - prices[j]);
                   }
               }
           }
         //  System.out.println(sum);
           profits.add(sum);
       }
       return Collections.max(profits);
    }


    public static void main(String[] args) {
        System.out.println("Ount: "+new BestTimeToBuiStock().maxProfit(new int []{3,2,6,5,0,3}));
    }
}
