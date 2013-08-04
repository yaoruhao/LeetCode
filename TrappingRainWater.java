/**
 * 
 * @author yaoruhao
 * Referred to the github simple and beautiful solution.
 *
 */
public class TrappingRainWater {

    public int trap(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int sumWater = 0;
        if (A.length == 0) {
			return 0;
		}
        int []left = new int [A.length];
        int []right = new int [A.length];
        int max = 0;
        left[0] = 0;
        for (int i = 0; i < left.length; i++) {
        	left[i] = max;
			if (A[i] > max) {
				max = A[i];
			}
		}
        max = 0;
        for (int i = right.length - 1; i >= 0; i--) {
			right[i] = max;
			if (A[i] > max) {
				max = A[i];
			}
		}
        for (int i = 0; i < A.length; i++) {
			int min = Math.min(left[i], right[i]);
			int water = Math.max(min - A[i], 0);
			sumWater += water;
		}
    	return sumWater;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
