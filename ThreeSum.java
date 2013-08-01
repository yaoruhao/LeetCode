import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * 
 * @author yaoruhao
 *
 */
public class ThreeSum {

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        int len = num.length;
        HashSet<String> cache = new HashSet<String>();
        if (len < 3 || num[0] > 0 || num[len - 1] < 0) {
			return resultList;
		}
        for (int i = 0; i < num.length - 2; i++) {
			for (int j = i + 1; j < num.length - 1; j++) {
				if (num[i] + num[j] > 0) {
					return resultList;
				}
				int leftNum = 0 - num[i] - num[j];
				if (leftNum < num[j]) {
					continue;
				}
				if (Arrays.binarySearch(num, j + 1, len, leftNum) >= 0) {
					ArrayList<Integer> tempList = new ArrayList<Integer>();
					tempList.add(num[i]);
					tempList.add(num[j]);
					tempList.add(leftNum);
					if (cache.contains(tempList.toString())) {
						continue;
					}
					cache.add(tempList.toString());
					resultList.add(tempList);
				}
			}
		}
        return resultList;
    }
	public static void main(String[] args) {
		ThreeSum test = new ThreeSum();
		int []inputs = {6,-10,3,1,-10,5,0,7,-2,1,5,-6,0,4,-9,-3,3,5,7,3,-7};
		System.out.println(test.threeSum(inputs));

	}

}
