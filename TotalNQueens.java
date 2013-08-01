/**
 * 
 * @author yaoruhao
 *
 */
public class TotalNQueens {

    public int totalNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
		boolean[] columnFlag = new boolean[n];
		boolean[] lFlag = new boolean[n*2];
		boolean[] rFlag = new boolean[n*2];
		for (int i = 0; i < columnFlag.length; i++) {
			columnFlag[i] = false;
		}
		for (int i = 0; i < rFlag.length; i++) {
			lFlag[i] = false;
			rFlag[i] = false;
		}
		return searchAllResult(n, 0, columnFlag, lFlag, rFlag);
    }
    
	public int searchAllResult(int n, int row, boolean columnFlag[],
			boolean lFlag[], boolean rFlag[]) {
		if (row == n) {
			return 1;
		}
		int count = 0;
		for (int j = 0; j < n; j++) {
			if (!columnFlag[j] && !lFlag[n + row - j] && !rFlag[row + j]) {
				columnFlag[j] = true;
				lFlag[n+row-j] = true;
				rFlag[row+j] = true;
				count += searchAllResult(n, row + 1, columnFlag, lFlag, rFlag);
				rFlag[row + j] = false;
				lFlag[n + row - j] = false;
				columnFlag[j] = false;
			}
		}
		return count;
	}
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
