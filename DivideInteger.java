/**
 * 
 * @author yaoruhao
 *
 */
public class DivideInteger {

    public int divide(int dividend, int divisor) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if (divisor == 0) {
			return Integer.MAX_VALUE;
		}
    	if (dividend > Integer.MIN_VALUE && divisor > Integer.MIN_VALUE) {
    		int flag = 1;
    		if (dividend < 0) {
    			dividend = 0 - dividend;
    			flag = 0 - flag;
    		}
    		if (divisor < 0) {
    			divisor = 0 - divisor;
    			flag = 0 - flag;
    		}
    		if (dividend < divisor) {
				return 0;
			}
    		if (dividend == divisor) {
    			return flag;
    		}
    		int originalDivisor = divisor;
    		int lastCount = 1;
    		int lastDivisor = divisor;
    		int count = 1;
    		while (dividend > divisor && divisor > 0) {
				lastCount = count;
				lastDivisor = divisor;
				divisor += divisor;
				count += count;
			}
    		int remainder = dividend - lastDivisor;
    		if (remainder >= originalDivisor) {
				return flag == 1 ? (lastCount + divide(remainder, originalDivisor)) : (0 - (lastCount + divide(remainder, originalDivisor)));
			} else {
				return flag == 1 ? lastCount : (0 - lastCount);
			}
			
		} else if (divisor == Integer.MIN_VALUE) {
			if (dividend == divisor) {
				return 1;
			} else {
				return 0;
			}
		} else {
			if (divisor < 0) {
				return 1 + divide(dividend - divisor, divisor);
			} else {
				return -1 + divide(dividend + divisor, divisor);
			}
		}
    }
	public static void main(String[] args) {
		DivideInteger test = new DivideInteger();
		System.out.println(test.divide(2147483647, 1));
	}

}
