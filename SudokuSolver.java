import java.util.ArrayList;
import java.util.HashSet;

/**
 * 
 * @author yaoruhao
 * 
 */
public class SudokuSolver {

	public void solveSudoku(char[][] board) {
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
		int leftNum = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == '.') {
					leftNum++;
					continue;
				}
				int num = board[i][j] - '0';
				int boxNum = i / 3 * 3 + j / 3;
				rowCache.get(i).add(num);
				columnCache.get(j).add(num);
				boxCache.get(boxNum).add(num);
			}
		}
		validSudoku(board, rowCache, columnCache, boxCache, leftNum);
	}

	public boolean validSudoku(char[][] board,
			ArrayList<HashSet<Integer>> rowCache,
			ArrayList<HashSet<Integer>> columnCache,
			ArrayList<HashSet<Integer>> boxCache, int leftNum) {
		if (leftNum == 0) {
			return true;
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] != '.') {
					continue;
				}
				ArrayList<Integer> availableList = new ArrayList<Integer>();
				for (int num = 1; num <= 9; num++) {
					if (rowCache.get(i).contains(num)) {
						continue;
					}
					if (columnCache.get(j).contains(num)){
						continue;
					}
					int boxNum = i/3 * 3 + j/3;
					if (boxCache.get(boxNum).contains(num)) {
						continue;
					}
					availableList.add(num);
				}
				if (availableList.isEmpty()) {
					return false;
				}
				for (Integer num : availableList) {
					board[i][j] = (char) ('0' + num);
					rowCache.get(i).add(num);
					columnCache.get(j).add(num);
					boxCache.get(i/3 * 3 + j/3).add(num);
					if (validSudoku(board, rowCache, columnCache, boxCache, leftNum - 1)) {
						return true;
					}
					board[i][j] = '.';
					rowCache.get(i).remove(num);
					columnCache.get(j).remove(num);
					boxCache.get(i/3 * 3 + j/3).remove(num);
				}
				return false;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		SudokuSolver test = new SudokuSolver();
		String[] sudoku = {"..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."};

		char[][] inputs = new char[9][9];
		for (int i = 0; i < inputs.length; i++) {
			inputs[i] = sudoku[i].toCharArray();
		}
		test.solveSudoku(inputs);
	}

}
