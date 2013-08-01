/**
 * 
 * @author yaoruhao
 *
 */
public class SearchForRange {

    public int[] searchRange(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	int []result = new int[2];
    	result[0] = -1;
    	result[1] = -1;
    	int left = 0;
    	int right = A.length - 1;
    	int targetIndex = -1;
    	while (left <= right) {
			int mid = (left + right)/2;
			if (A[mid] == target) {
				targetIndex = mid;
				break;
			}
			if (A[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
    	if (targetIndex != -1) {
			for (int i = targetIndex; i < A.length; i++) {
				if (A[i] != target) {
					break;
				}
				result[1] = i;
			}
			for (int i = targetIndex; i >= 0; i--) {
				if (A[i] != target) {
					break;
				}
				result[0] = i;
			}
		}    	
    	return result;        
    }
	public static void main(String[] args) {
		SearchForRange test = new SearchForRange();
		int[] inputs = {1};
		System.out.println(test.searchRange(inputs, 1));

	}

}
