/**
 * 
 * @author yaoruhao
 *
 */
public class MaximumSubarray {

    public int maxSubArray(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int max = Integer.MIN_VALUE;
        int current = 0;
        for (int i = 0; i < A.length; i++) {
			if (current < 0) {
				current = 0;
			}
			current += A[i];
			if (max < current) {
				max = current;
			}
		}
        return max;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
