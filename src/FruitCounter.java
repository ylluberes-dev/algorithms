import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FruitCounter {

    public int totalFruit(int[] tree) {
        //List<Integer> firstBasket = new ArrayList<>();

        Set<Integer> fBasket = new HashSet<>();
        Set<Integer> sBasket = new HashSet<>();

        int max = 0;
        for (int i = 0; i < tree.length; i++) {
            int fCount = 0;
            int sCount = 0;
            for (int j = i; j < tree.length; j++) {
                boolean addedFirst = false;
                boolean addedSecond = false;
                if(fBasket.isEmpty()){
                    fBasket.add(tree[j]);
                    addedFirst = true;
                    fCount++;
                }else {
                    if(fBasket.contains(tree[j])){
                        fCount++;
                        addedFirst = true;
                    }
                }

                if(!addedFirst) {
                    if(sBasket.isEmpty()) {
                        sBasket.add(tree[j]);
                        sCount++;
                        addedSecond = true;

                    }else {
                        if(sBasket.contains(tree[j])) {
                            sCount++;
                            addedSecond = true;
                        }
                    }
                }
                if (!addedFirst && !addedSecond)
                    break;
            }

            if(fCount + sCount > max)
                max = fCount + sCount;

            fBasket.clear();
            sBasket.clear();

        }
        return max;
    }

    public static void main(String[] args) {

        FruitCounter fruitCounter = new FruitCounter();
        System.out.println("Result of test case #1: " + fruitCounter.totalFruit(new int[]{1, 2, 1}));
        System.out.println();

        System.out.println("Result of test case #2: " + fruitCounter.totalFruit(new int[]{0, 1, 2, 2}));
        System.out.println();

        System.out.println("Result of test case #3: " + fruitCounter.totalFruit(new int[]{1, 2, 3, 2, 2}));
        System.out.println();

        System.out.println("Result of test case #3: " + fruitCounter.totalFruit(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}));
        System.out.println();
    }
}
