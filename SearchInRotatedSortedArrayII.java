/**
 * 
 * @author yaoruhao
 * 
 */
public class SearchInRotatedSortedArrayII {

	public boolean search(int[] A, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		return search(A, 0, A.length - 1, target);

	}

	public boolean search(int[] A, int left, int right, int target) {
		if (left > right) {
			return false;
		}
		int mid = (left + right) / 2;
		if (A[mid] == target) {
			return true;
		}
		if (A[left] < A[mid]) {
			if (target >= A[left] && target < A[mid]) {
				right = mid - 1;
				return search(A, left, right, target);
			} else {
				left = mid + 1;
				return search(A, left, right, target);
			}
		} else if (A[left] > A[mid]) {
			if (target > A[mid] && target <= A[right]) {
				left = mid + 1;
				return search(A, left, right, target);
			} else {
				right = mid - 1;
				return search(A, left, right, target);
			}
		} else {
			if (A[right] != A[mid]) {
				left = mid + 1;
				return search(A, left, right, target);
			} else {
				if (search(A, left, mid - 1, target)) {
					return true;
				}
				return search(A, mid + 1, right, target);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
