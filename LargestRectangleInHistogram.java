import java.util.Stack;

/**
 * 
 * @author yaoruhao
 *
 */
public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < height.length; i++) {
			if (stack.isEmpty() || height[stack.peek()] < height[i]) {
				stack.push(i);
			} else {
				int start = stack.pop();
				int width = stack.isEmpty() ? i : i - stack.peek() - 1;
				max = Math.max(max, height[start] * width);
				i--;
			}
		}
        while (!stack.isEmpty()) {
			int start = stack.pop();
			int width = stack.isEmpty() ? height.length : height.length - stack.peek() - 1;
			max = Math.max(max, height[start] * width);
		}
        return max;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
