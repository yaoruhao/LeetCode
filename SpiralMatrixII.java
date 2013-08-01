/**
 * 
 * @author yaoruhao
 *
 */
public class SpiralMatrixII {

    public int[][] generateMatrix(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int [][]result = new int[n][n];
        for (int i = 0; i < result.length; i++) {
			result[i] = new int[n];
		}
        int round = n / 2;
        if (n % 2 == 1) {
			round++;
		}
        int current = 1;
        int bound = n;
        for (int i = 0; i < round; i++) {
			result[i][i] = current++;
			if (bound > 1) {
				for (int j = 1; j < bound; j++) {
					result[i][i+j] = current++;
				}
				for (int j = 1; j < bound; j++) {
					result[i + j][bound - 1 + i] = current++;
				}
				for (int j = bound - 2; j >= 0; j--) {
					result[bound - 1 + i][i + j] = current++;
				}
				for (int j = bound - 2; j > 0; j--) {
					result[i + j][i] = current++;
				}
			}
			bound -= 2;
		}
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
