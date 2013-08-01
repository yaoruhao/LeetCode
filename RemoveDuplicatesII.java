/**
 * 
 * @author yaoruhao
 *
 */
public class RemoveDuplicatesII {

    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int count = 0;
        for (int i = 0; i < A.length; i++) {
			int number = A[i];
			boolean twiceFlag = false;
			for (int j = i + 1; j < A.length; j++) {
				if (A[j] != number) {
					break;
				}
				i++;
				twiceFlag = true;
			}
			A[count++] = number;
			if (twiceFlag) {
				A[count++] = number;
			}
		}
        return count;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
