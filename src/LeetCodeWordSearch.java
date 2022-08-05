public class LeetCodeWordSearch {


    public boolean exist(char[][] board, String word) {



        return false;
    }

    public String  helper (char [][] board, String word, int i, int j, int wordIndex){
        if (wordIndex == word.length()){
            return word;
        }
        char current = word.charAt(wordIndex);

        if (board[i][j] == current){
            if(i < (board.length - 1)){
                return helper(board,word,i + 1,j,wordIndex + 1);
            }else {
                return helper(board,word,i,j+1,wordIndex+1);
            }
        }

        return null;

    }

    public static void main(String[] args) {
        System.out.println(new LeetCodeWordSearch().exist(new char [][] {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}},"ABCCED"));
    }
}
