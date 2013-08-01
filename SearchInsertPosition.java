/**
 * 
 * @author yaoruhao
 *
 */
public class SearchInsertPosition {

    public int searchInsert(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int left = 0;
        int right = A.length - 1;
        while (left <= right) {
			int mid = (left + right) / 2;
			if (A[mid] == target) {
				return mid;
			}
			if (A[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
        return left;
    }
	public static void main(String[] args) {
		SearchInsertPosition test = new SearchInsertPosition();
		int []inputs = {1};
		System.out.println(test.searchInsert(inputs, 2));

	}

}
