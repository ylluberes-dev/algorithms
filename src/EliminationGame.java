
public class EliminationGame {


    public int lastRemaining(int n) {
        if(n == 1 || n == 2) return n;
        if(n == 3) return 2;
        if(n % 2 == 0) {
            return n - 2;
        }else {
            return n -3;
        }
    }
}
