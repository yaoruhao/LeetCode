import java.util.ArrayList;

/**
 * 
 * @author yaoruhao
 *
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> resultList = new ArrayList<Integer>();
        boolean carry = false;
        for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] != 9) {
				resultList.add(digits[i] + 1);
				carry = false;
				for (int j = i - 1; j >= 0; j--) {
					resultList.add(digits[j]);
				}
				break;
			}
			resultList.add(0);
			carry = true;
		}
        if (carry) {
			resultList.add(1);
		}
        int []results = new int[resultList.size()];
        int index = 0;
        for (int i = resultList.size() - 1; i >= 0; i--) {
			results[index++] = resultList.get(i);
		}
        return results;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
