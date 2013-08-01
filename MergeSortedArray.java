/**
 * 
 * @author yaoruhao
 *
 */
public class MergeSortedArray {

    public void merge(int A[], int m, int B[], int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (n == 0) {
			return;
		}
        if (m == 0) {
			while (n > 0) {
				n--;
				A[n] = B[n];
			}
			return;
		}
    	int index = m + n - 1;
        int aIndex = m - 1;
        int bIndex = n - 1;
        while (index >= 0) {
			if (bIndex < 0) {
				break;
			}
			if (aIndex < 0) {
				while (bIndex >= 0) {
					A[bIndex] = B[bIndex--];
				}
				break;
			}
			A[index--] = A[aIndex] > B[bIndex] ? A[aIndex--] : B[bIndex--];
		}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
