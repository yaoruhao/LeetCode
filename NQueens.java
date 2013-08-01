import java.util.ArrayList;

/**
 * 
 * @author yaoruhao
 * 
 */
public class NQueens {

	public ArrayList<String[]> solveNQueens(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<String[]> resultList = new ArrayList<String[]>();
		boolean[] columnFlag = new boolean[n];
		boolean[] lFlag = new boolean[n*2];
		boolean[] rFlag = new boolean[n*2];
		int []pos = new int[n];
		for (int i = 0; i < columnFlag.length; i++) {
			columnFlag[i] = false;
			pos[i] = -1;
		}
		for (int i = 0; i < rFlag.length; i++) {
			lFlag[i] = false;
			rFlag[i] = false;
		}
		searchAllResult(n, 0, columnFlag, lFlag, rFlag, pos, resultList);
		return resultList;
	}

	public void searchAllResult(int n, int row, boolean columnFlag[],
			boolean lFlag[], boolean rFlag[], int[] pos,
			ArrayList<String[]> resultList) {
		if (row == n) {
			String[] results = new String[n];
			for (int i = 0; i < n; i++) {
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < n; j++) {
					if (pos[i] != j) {
						sb.append(".");
					} else {
						sb.append("Q");
					}
				}
				results[i] = sb.toString();
			}
			resultList.add(results);
			return;
		}
		for (int j = 0; j < n; j++) {
			if (!columnFlag[j] && !lFlag[n + row - j] && !rFlag[row + j]) {
				columnFlag[j] = true;
				lFlag[n+row-j] = true;
				rFlag[row+j] = true;
				pos[row] = j;
				searchAllResult(n, row + 1, columnFlag, lFlag, rFlag, pos, resultList);
				rFlag[row + j] = false;
				lFlag[n + row - j] = false;
				columnFlag[j] = false;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NQueens test = new NQueens();
		System.out.println(test.solveNQueens(8));
	}

}
