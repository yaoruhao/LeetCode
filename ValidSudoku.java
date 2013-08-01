import java.util.ArrayList;
import java.util.HashSet;

/**
 * 
 * @author yaoruhao
 *
 */
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<HashSet<Integer>> rowCache = new ArrayList<HashSet<Integer>>();
        ArrayList<HashSet<Integer>> columnCache = new ArrayList<HashSet<Integer>>();
        ArrayList<HashSet<Integer>> boxCache = new ArrayList<HashSet<Integer>>();
    	for (int i = 0; i < 9; i++) {
			rowCache.add(new HashSet<Integer>());
			columnCache.add(new HashSet<Integer>());
			boxCache.add(new HashSet<Integer>());
		}
    	for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == '.')
					continue;
				int num = board[i][j] - '0';
				if (rowCache.get(i).contains(num)) {
					return false;
				}
				if (columnCache.get(j).contains(num)){
					return false;
				}
				int boxNum = i/3 * 3 + j/3;
				if (boxCache.get(boxNum).contains(num)) {
					return false;
				}
				rowCache.get(i).add(num);
				columnCache.get(j).add(num);
				boxCache.get(boxNum).add(num);
			}
		}
    	return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
