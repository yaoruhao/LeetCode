import java.util.HashMap;
import java.util.HashSet;

/**
 * 
 * @author yaoruhao
 * Java solution can not pass large test.
 *
 */
public class SurroundedRegions {

    public void solve(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if (board.length == 0) {
			return;
		}
    	if (board[0].length == 0) {
			return;
		}
        HashMap<String, Boolean> cacheMap = new HashMap<String, Boolean>();
        HashSet<String> visitSet = new HashSet<String>();
        for (int i = 0; i < board.length; i++) {
			preCalculateCache(i, 0, board, cacheMap);
			preCalculateCache(i, board[i].length - 1, board, cacheMap);
		}
        for (int j = 0; j < board[0].length; j++) {
			preCalculateCache(0, j, board, cacheMap);
			preCalculateCache(board.length - 1, j, board, cacheMap);
		}
        for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 'O') {
					isTransformable(i, j, board, cacheMap, visitSet);
					visitSet.clear();
				}
			}
		}
    }
    
    //This pre calculate is not necessary, just to speed up the solution a little bit.
    public void preCalculateCache(int i, int j, char[][] board, HashMap<String, Boolean> cacheMap) {
    	String cacheKey = i + ":" + j;
    	if (i < 0 || i >= board.length || j < 0 || j >= board[i].length) {
			return;
		}
    	if (board[i][j] == 'X') {
			return;
		}
    	if (cacheMap.containsKey(cacheKey)) {
			return;
		}
    	if (board[i][j] == 'O') {
			cacheMap.put(cacheKey, false);
		}
    	preCalculateCache(i + 1, j, board, cacheMap);
    	preCalculateCache(i - 1, j, board, cacheMap);
    	preCalculateCache(i, j + 1, board, cacheMap);
    	preCalculateCache(i, j - 1, board, cacheMap);
    }
    
    public boolean isTransformable(int i, int j, char [][] board, HashMap<String, Boolean> cacheMap, HashSet<String> visitSet) {
    	String cacheKey = i + ":" + j;
    	if (visitSet.contains(cacheKey)) {
			return true;
		}
    	visitSet.add(cacheKey);
    	if (board[i][j] == 'X') {
			return true;
		}
    	if (i == 0 || i == board.length - 1 || j == 0 || j == board[i].length - 1) {
			return false;
		}    	
    	if (cacheMap.containsKey(cacheKey)) {
			return cacheMap.get(cacheKey);
		}
    	if (isTransformable(i + 1, j, board, cacheMap, visitSet) && isTransformable(i - 1, j, board, cacheMap, visitSet) 
    			&& isTransformable(i, j + 1, board, cacheMap, visitSet) && isTransformable(i, j - 1, board, cacheMap, visitSet)) {
			board[i][j] = 'X';
			cacheMap.put(cacheKey, true);
			return true;
		} else {
			cacheMap.put(cacheKey, false);
			return false;
		}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
