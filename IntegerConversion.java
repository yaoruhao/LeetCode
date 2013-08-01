/**
 * 
 * @author yaoruhao
 *
 */
public class IntegerConversion {

    public int reverse(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int result = 0;
        boolean positive = true;
        if (x < 0) {
			positive = false;
		}
        x = Math.abs(x);
        while (x != 0) {
        	result *= 10;
			int temp = x % 10;
			result += temp;
			x /= 10;
		}
        if (!positive) {
			result = 0 - result;
		}
        return result;
    }
	public static void main(String[] args) {
		IntegerConversion test = new IntegerConversion();
		System.out.println(test.reverse(0));
	}

}
