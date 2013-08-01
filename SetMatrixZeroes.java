import java.util.HashSet;

/**
 * 
 * @author yaoruhao
 *
 */
public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashSet<Integer> emptyColSet = new HashSet<Integer>();
        HashSet<Integer> emptyRowSet = new HashSet<Integer>();
        for (int i = 0; i < matrix.length; i++) {
			boolean rowSetZero = false;
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					rowSetZero = true;
					emptyColSet.add(j);
				}
			}
			if (rowSetZero) {
				for (int j = 0; j < matrix[i].length; j++) {
					matrix[i][j] = 0;
				}
			}
		}
        for (int i = 0; i < matrix.length; i++) {
			if (emptyRowSet.contains(i)) {
				continue;
			}
			for (int j = 0; j < matrix[i].length; j++) {
				if (emptyColSet.contains(j)) {
					matrix[i][j] = 0;
				}
			}
		}
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
