import java.util.HashSet;

/**
 * 
 * @author yaoruhao
 *
 */
public class WordSearch {

    public boolean exist(char[][] board, String word) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashSet<String> cache = new HashSet<String>();
        for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0)) {
					cache.clear();
					cache.add(i + "-" + j);
					if (findWord(board, i, j, word.substring(1), cache)) {
						return true;
					}
				}
			}
		}
    	
    	return false;
    }
    
    public boolean findWord(char[][]board, int i, int j, String word, HashSet<String> cache){
    	if (word.isEmpty()) {
			return true;
		}
    	String key = (i+1) + "-" + j;
    	if (i + 1 < board.length && !cache.contains(key) && word.charAt(0) == board[i+1][j]) {
			cache.add(key);
			if (findWord(board, i + 1, j, word.substring(1), cache)) {
				return true;
			}
			cache.remove(key);
		}
    	key = (i-1) + "-" + j;
    	if (i > 0 && !cache.contains(key) && word.charAt(0) == board[i-1][j]) {
			cache.add(key);
			if (findWord(board, i - 1, j, word.substring(1), cache)) {
				return true;
			}
			cache.remove(key);
		}
    	key = i + "-" + (j + 1);
    	if (j + 1 < board[0].length && !cache.contains(key) && word.charAt(0) == board[i][j+1]) {
			cache.add(key);
			if (findWord(board, i, j + 1, word.substring(1), cache)) {
				return true;
			}
			cache.remove(key);
		}
    	key = i + "-" + (j - 1);
    	if (j > 0 && !cache.contains(key) && word.charAt(0) == board[i][j - 1]) {
			cache.add(key);
			if (findWord(board, i, j - 1, word.substring(1), cache)) {
				return true;
			}
			cache.remove(key);
		}    	
    	return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
