import java.util.ArrayList;

/**
 * 
 * @author yaoruhao
 *
 */
public class SpiralMatrix {

    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> resultList = new ArrayList<Integer>();
        if (matrix.length == 0 || matrix[0].length == 0) {
			return resultList;
		}
        if (matrix.length == 1) {
			for (int i = 0; i < matrix[0].length; i++) {
				resultList.add(matrix[0][i]);
			}
			return resultList;
		}
        if (matrix[0].length == 1) {
			for (int j = 0; j < matrix.length; j++) {
				resultList.add(matrix[j][0]);
			}
			return resultList;
		}
        int width = matrix[0].length;
        int height = matrix.length;
        int round = Math.min(width, height)/2;
        if (Math.min(width, height) % 2 == 1) {
			round++;
		}
        for (int i = 0; i < round; i++) {
        	resultList.add(matrix[i][i]);
        	if (width > 1) {
				for (int j = 1; j < width; j++) {
					resultList.add(matrix[i][i+j]);
				}
			}
        	if (height > 1) {
				for (int j = 1; j < height; j++) {
					resultList.add(matrix[i + j][width - 1 + i]);
				}
			} else {
				break;
			}
        	if (width > 1) {
				for (int j = width -2; j >= 0; j--) {
					resultList.add(matrix[height - 1 + i][i + j]);
				}
			} else {
				break;
			}
        	if (height > 1) {
				for (int j = height - 2; j > 0; j--) {
					resultList.add(matrix[i + j][i]);
				}
			}
        	width -= 2;
        	height -= 2;
        }
        return resultList;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]matrix = new int[4][4];
		int count = 1;
		for (int i = 0; i < matrix.length; i++) {
			matrix[i] = new int[4];
			for (int j = 0; j < matrix.length; j++) {
				matrix[i][j] = count++;
			}
		}
		SpiralMatrix test = new SpiralMatrix();
		System.out.println(test.spiralOrder(matrix));
	}

}
