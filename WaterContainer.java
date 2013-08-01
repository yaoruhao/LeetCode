/**
 * 
 * @author yaoruhao
 *
 */
public class WaterContainer {

    public int maxArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int maxArea = 0;
        if (height.length < 2) {
			return 0;
		}
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
			int area = 0;
			if (height[left] < height[right]) {
				area = height[left] * (right - left);
				left++;
			} else {
				area = height[right] * (right - left);
				right--;
			}
			if (area > maxArea) {
				maxArea = area;
			}
		}
        
        return maxArea;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
