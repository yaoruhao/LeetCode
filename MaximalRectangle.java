/**
 * 
 * @author yaoruhao
 *
 */
public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int result = 0;
        for (int rowStart = 0; rowStart < matrix.length; rowStart++) {
			boolean []rowFlag = new boolean[matrix[0].length];
			boolean needToFind = false;
			int oneCount = 0;
			for (int j = 0; j < matrix[rowStart].length; j++) {
				if (matrix[rowStart][j] == '0') {
					rowFlag[j] = false;
				} else {
					rowFlag[j] = true;
					needToFind = true;
					oneCount++;
				}
			}
			if (!needToFind) {
				continue;
			}
			result = Math.max(result, getMaxArea(rowFlag, 1));
			for (int rowEnd = rowStart + 1; rowEnd < matrix.length; rowEnd++) {
				for (int j = 0; j < rowFlag.length; j++) {
					if (rowFlag[j] && matrix[rowEnd][j] == '0') {
						rowFlag[j] = false;
						oneCount--;
					}
				}
				if (oneCount == 0) {
					break;
				}
				result = Math.max(result, getMaxArea(rowFlag, rowEnd - rowStart + 1));
			}
		}
        return result;
    }
    
    public int getMaxArea(boolean []rowFlag, int height) {
		int maxArea = 0;
		for (int i = 0; i < rowFlag.length; i++) {
			if (!rowFlag[i]) {
				continue;
			}
			int count = 1;
			for (int j = i + 1; j < rowFlag.length; j++) {
				if (!rowFlag[j]) {
					i = j;
					break;
				}
				count++;
			}
			if (maxArea < count * height) {
				maxArea = count * height;
			}
		}
		return maxArea;
    }
	public static void main(String[] args) {
		MaximalRectangle test = new MaximalRectangle();
		char [][]matrix = {{'0', '1'}};
		System.out.println(test.maximalRectangle(matrix));

	}

}
