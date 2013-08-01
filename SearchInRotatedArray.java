/**
 * 
 * @author yaoruhao
 *
 */
public class SearchInRotatedArray {

    public int search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int left = 0;
        int right = A.length - 1;
        while (left <= right) {
			int mid = (left + right) / 2;
			if (A[mid] == target) {
				return mid;
			}
			if (A[left] <= A[mid]) {
				if (target >= A[left] && target < A[mid]) {
					right = mid - 1;
					continue;
				} else {
					left = mid + 1;
					continue;
				}
			} else {
				if (target > A[mid] && target <= A[right]) {
					left = mid + 1;
					continue;
				} else {
					right = mid - 1;
					continue;
				}
			}
		}
        return -1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
