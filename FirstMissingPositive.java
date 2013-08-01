/**
 * 
 * @author yaoruhao
 * Space can be reduced by using bit manipulation.
 *
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A.length == 0) {
			return 1;
		}
        int max = 0;
        for (int i = 0; i < A.length; i++) {
			max = Math.max(max, A[i]);
		}
        int[] array = new int[max];
        for (int i = 0; i < A.length; i++) {
			if (A[i] > 0) {
				array[A[i] - 1] = 1;
			}
		}
        for (int i = 0; i < max; i++) {
			if (array[i] == 0) {
				return i+1;
			}
		}
        return max + 1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
