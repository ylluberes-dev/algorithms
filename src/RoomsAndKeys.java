import java.util.*;

public class RoomsAndKeys {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        //[[6,7,8],[5,4,9],[],[8],[4],[],[1,9,2,3],[7],[6,5],[2,3,1]]

        if(rooms.size() == 1 ) return true;
        List<Integer> keys = rooms.get(0);
        if (keys.size() == 0 && rooms.size() > 0) return false;
        int room = 0;
        boolean[] visited = new boolean[rooms.size()];
        visited[room] = true;
        while (!keys.isEmpty()) {
            room = keys.get(0);
            keys.remove(0);
            if(visited[room]) continue;
            visited[room] = true;

            List<Integer> currentKeys = rooms.get(room);
            for (Integer key : currentKeys) {
                if (key != 0) {
                    keys.add(key);
                }
            }
        }
        for (room = 0; room < visited.length; room++) {
            if (!visited[room]) return false;
        }
        return true;
    }

    static List<List<Integer>> convert(String input) {
        List<List<Integer>> resultList = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            List<Integer> keys = null;
            char cur = input.charAt(i);
            if (cur == '[') {
                keys = new ArrayList<>();
                while (cur != ']') {
                    if (cur != '[' && cur != ',')
                        keys.add(Integer.parseInt(String.valueOf(cur)));
                    i++;
                    cur = input.charAt(i);
                }
            }
            if (keys != null)
                resultList.add(keys);
        }
        return resultList;
    }

    public static void main(String[] args) {
        String input = "[[6,7,8],[5,4,9],[],[8],[4],[],[1,9,2,3],[7],[6,5],[2,3,1]]";
        String input2 = "[[]]";
        List<List<Integer>> room = convert(input2);
        System.out.println();
        System.out.println("Result of test case: " + new RoomsAndKeys().canVisitAllRooms(room));
    }
}
