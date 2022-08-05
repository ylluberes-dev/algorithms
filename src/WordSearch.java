import java.util.*;

public class WordSearch {


    class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    static List<Pair> getSortedPairs (String word, Map<Pair,Character> pairMap){
        List<Pair> pairList = new ArrayList<>();
           for (int i = 0;  i < word.length(); i ++){
               for (Pair c: pairMap.keySet()){
                   if(word.charAt(i) == pairMap.get(c)){
                       pairList.add(c);
                       break;
                   }
           }
       }
           return pairList;
    }

    public boolean exist(char[][] board, String word) {
        Map<Pair,Character> pairMap = new HashMap<>();

        for (int w = 0; w < word.length();w ++){
            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[i].length; j++){
                    char currentLetter = word.charAt(w);
                    if(board[i][j] == currentLetter){
                        pairMap.put(new Pair(i,j),currentLetter);
                    }
                }
            }
        }
        List<Pair> pairList = getSortedPairs(word,pairMap);
        System.out.println("");



        return false;
    }


    public static void main(String[] args) {

        char [][] board = {{'A','B','C','E'},
                           {'S','F','C','S'},
                           {'A','D','E','E'}};
        String word = "ABCCED";
        new WordSearch().exist(board,word);
        System.out.println(" ");
    }
}
