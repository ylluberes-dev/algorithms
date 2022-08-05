import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MinimumIndexSumList {


    public String[] findRestaurant(String[] list1, String[] list2) {
        final List<String> results = new ArrayList<>();
        final Map<String, Integer> restaurantOptions = new HashMap<>();
        int index = 0;
        for (String restaurant : list1) {
            restaurantOptions.put(restaurant, index);
            index++;
        }
        index = 0;
        int min = Integer.MAX_VALUE;
        for (String restaurant : list2) {
            if (restaurantOptions.containsKey(restaurant)) {
                if((restaurantOptions.get(restaurant) + index) < min) {
                    min = restaurantOptions.get(restaurant) + index;
                }
                results.add(restaurant+"|"+(restaurantOptions.get(restaurant) + index));
            }
            index++;
        }
        final int a = min;

        String [] output =
                results.stream()
                        .filter(restaurant -> Integer.parseInt(restaurant.split("\\|")[1]) == a)
                        .map(restaurant -> restaurant.split("\\|")[0])
                        .toArray(String[]::new);

        return output;
    }

    public static void main(String[] args) {

        for (String result : new MinimumIndexSumList().findRestaurant(
                new String[]{"Shogun","Tapioca Express","Burger King","KFC"},
                new String[]{"KFC","Shogun","Burger King"}
        )) {
            System.out.println(result);
        };
    }
}
