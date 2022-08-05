import java.util.*;

public class UniqueProduct {


    public static String firstUniqueProduct(String[] products) {
        final Map<String, Integer> table = new LinkedHashMap();

        for (String product : products) {
            if(table.containsKey(product)) {
                table.put(product,table.get(product) + 1);
            }else {
                table.put(product,1);
            }
        }
        for(String key: table.keySet()){
            if(table.get(key) == 1) {
                return key;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        //System.out.println(firstUniqueProduct(new String[]{"Apple", "Computer", "Apple", "Bag"}));
        String s = "foo";
        Object o = (Object)s;
        if (s.equals(o))
        {
            System.out.print("AAA");
        }
        else
        {
            System.out.print("BBB");
        }
        if (o.equals(s))
        {
            System.out.print("CCC");
        }
        else
        {
            System.out.print("DDD");
        }
    }
}
