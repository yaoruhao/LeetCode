/**
 * 
 * @author yaoruhao
 *
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int result = 0;
        int temp = x;
        if (x < 0) {
			return false;
		}
        while (temp != 0) {
			result *= 10;
			result += temp % 10;
			temp /= 10;
		}
    	return result == x;
    }
	public static void main(String[] args) {
		PalindromeNumber test = new PalindromeNumber();
		System.out.println(test.isPalindrome(12321));
	}

}
