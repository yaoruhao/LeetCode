/**
 * 
 * @author yaoruhao
 *
 */
public class RotateImage {

    public void rotate(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	int len = matrix.length;
        for (int round = 0; round < len / 2; round++) {
        	int i = round;
			for (int j = round; j < len - round - 1; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[len - j - 1][i];
				matrix[len - j - 1][i] = matrix[len - i - 1][len - j - 1];
				matrix[len - i - 1][len - j - 1] = matrix[j][len - i - 1];
				matrix[j][len - i - 1] = temp;				
			}
		}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
