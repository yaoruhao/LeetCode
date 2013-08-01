/**
 * 
 * @author yaoruhao
 * Referred to https://github.com/yuanx/leetcode/blob/master/JumpGameII.java simple and beautiful solution.
 *
 */
public class JumpGameII {

    public int jump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if (A.length <= 1) {
			return 0;
		}
    	int lastPos = A.length - 1;
    	int count = 0;
    	while (lastPos > 0) {
			for (int i = 0; i < lastPos; i++) {
				if (A[i] + i >= lastPos) {
					lastPos = i;
					count++;
					break;
				}
			}
		}
        
        return count;
    }
	public static void main(String[] args) {
		JumpGameII test = new JumpGameII();
		int []inputs = {};
		System.out.println(test.jump(inputs));

	}

}
