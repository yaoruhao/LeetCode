/**
 * 
 * @author yaoruhao
 * Referred to the github solution:https://github.com/yuanx/leetcode/blob/master/Sqrt.java
 *
 */
public class SQRT {

    public int sqrt(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if (x <= 1) {
			return x;
		}
    	int mid = x/2;
    	while (mid * mid > x || mid > 46340) {
			mid = (mid + x/mid)/2;
		}
    	return mid;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
