import java.util.Arrays;

/**
 * 
 * @author yaoruhao
 *
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int minDistance = Integer.MAX_VALUE;
        int resultSum = 0;
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
        	int left = i + 1;
        	int right = num.length - 1;
        	while (left < right) {
				int sum = num[i] + num[left] + num[right];
				if (minDistance > Math.abs(sum - target)) {
					minDistance = Math.abs(sum - target);
					resultSum = sum;
				}
				if (sum == target) {
					break;
				}
				if (sum > target) {
					right--;
				} else {
					left++;
				}
			}
		}
        return resultSum;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
