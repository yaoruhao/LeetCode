import java.util.Arrays;

/**
 * 
 * @author yaoruhao
 *
 */
public class NextPermutation {

    public void nextPermutation(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean flag = false;
        for (int i = num.length - 1; i > 0; i--) {
			if (num[i-1] >= num[i]) {
				continue;
			}
			int tempMin = num[i];
			int index = i;
			for (int j = i; j < num.length; j++) {
				if (num[j] <= num[i-1]) {
					break;
				}
				tempMin = num[j];
				index = j;
			}
			num[index] = num[i-1];
			num[i - 1] = tempMin;
			Arrays.sort(num, i, num.length);
			flag = true;
			break;
		}
        if (!flag) {
			Arrays.sort(num);
		}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
