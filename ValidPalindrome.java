/**
 * 
 * @author yaoruhao
 *
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s.isEmpty() || s.length() == 1) {
			return true;
		}
        int begin = 0;
        int end = s.length() - 1;
        s = s.toLowerCase();
        while (begin < end) {
			char beginChar = s.charAt(begin);
			while (!Character.isLetterOrDigit(beginChar)) {
				begin++;
				if (begin >= s.length()) {
					return true;
				}
				beginChar = s.charAt(begin);
			}
			char endChar = s.charAt(end);
			while (!Character.isLetterOrDigit(endChar)) {
				end--;
				endChar = s.charAt(end);
			}
			if (beginChar != endChar) {
				return false;
			}
			begin++;
			end--;
		}
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidPalindrome test = new ValidPalindrome();
		test.isPalindrome("a.");
	}

}
