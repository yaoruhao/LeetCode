/**
 * 
 * @author yaoruhao
 * 
 */
public class AToI {

	public int atoi(String str) {
		// Start typing your Java solution below
		// DO NOT write main() function
		str = str.trim();
		if (str == null || str.isEmpty()) {
			return 0;
		}
		boolean positive = true;
		int result = 0;
		if (str.charAt(0) == '-') {
			positive = false;
			str = str.substring(1);
		} else if (str.charAt(0) == '+') {
			str = str.substring(1);
		}
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))) {
				break;
			}

			if (positive) {
				if (result > Integer.MAX_VALUE / 10) {
					result = Integer.MAX_VALUE;
					break;
				}
				result *= 10;
				if (result > Integer.MAX_VALUE - (str.charAt(i) - '0')) {
					result = Integer.MAX_VALUE;
					break;
				}
				result += str.charAt(i) - '0';

			} else {
				if (result < Integer.MIN_VALUE / 10) {
					result = Integer.MIN_VALUE;
					break;
				}
				result *= 10;
				if (result < Integer.MIN_VALUE + (str.charAt(i) - '0')) {
					result = Integer.MIN_VALUE;
					break;
				}
				result += 0 - (str.charAt(i) - '0');
			}

		}
		return result;
	}

	public static void main(String[] args) {
		AToI test = new AToI();
		System.out.println(test.atoi("    10557266014"));
	}

}
