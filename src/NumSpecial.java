import java.util.*;

public class NumSpecial {

    static class Pair {
        private int x;
        private int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x || y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public int numSpecial(int[][] mat) {
        List<Pair> candidates = new ArrayList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if(mat[i][j] == 1) {
                    candidates.add(new Pair(i,j));
                }
            }
        }
        int disposable = 0;
        for (int i = 0; i < candidates.size(); i++){
            for (int j = 0; j <candidates.size(); j++) {
                if(i != j){
                    if(candidates.get(i).equals(candidates.get(j))){
                        disposable++;
                        break;
                    }
                }
            }
        }
        return candidates.size() - disposable;
    }

    public static void main(String[] args) {
        System.out.println("Output Test case #3: ");
        System.out.println(new NumSpecial().numSpecial(new int [][]{{0,0,0,0,0},
                {1,0,0,0,0},
                {0,1,0,0,0},
                {0,0,1,0,0},
                {0,0,0,1,1}}));
    }
}
