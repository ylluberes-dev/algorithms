import java.util.ArrayList;
import java.util.List;

public class CircularGame {

    public int findTheWinner(int n, int k) {
        List<Integer> players = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            players.add(i);
        }

        int index = 0;
        while(players.size() != 1){
            int removable = ((index + k) % players.size()) - 1;
            if(removable == -1) {
                removable = index;
            }

            players.remove(removable);
            index = removable;
        }

        return players.get(0);
    }

    public static void main(String[] args) {
        System.out.println(new CircularGame().findTheWinner(5,3));
    }
}
