/**
 * 
 * @author yaoruhao
 *
 */
public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int height = matrix.length;
        int width = matrix[0].length;
        int rowUp = 0;
        int rowDown = height - 1;
        while (rowUp <= rowDown) {
			int midRow = (rowUp + rowDown) / 2;
			if (target < matrix[midRow][0]) {
				rowDown = midRow - 1;
				continue;
			}
			if (target > matrix[midRow][width - 1]) {
				rowUp = midRow + 1;
				continue;
			}
			int left = 0;
			int right = width - 1;
			while (left <= right) {
				int mid = (left + right)/2;
				if (matrix[midRow][mid] == target) {
					return true;
				}
				if (matrix[midRow][mid] < target) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
			return false;
		}        
        return false;
    }
	public static void main(String[] args) {
		SearchMatrix test = new SearchMatrix();
		int [][]matrix = {{1,3}};
		System.out.println(test.searchMatrix(matrix, 2));

	}

}
