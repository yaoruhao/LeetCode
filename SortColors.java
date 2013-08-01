/**
 * 
 * @author yaoruhao
 * Referred to the github solution: https://github.com/yuanx/leetcode/blob/master/SortColors.java
 *
 */
public class SortColors {

    public void sortColors(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int left = 0;
        int len = A.length - 1;
        int i = 0;
        while (i <= len) {
			if (A[i] == 1) {
				i++;
			} else if (A[i] == 0) {
				A[i] = A[left];
				A[left] = 0;
				i++;
				left++;
			} else {
				A[i] = A[len];
				A[len] = 2;
				len--;
			}
		}        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
