import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * 
 * @author yaoruhao
 *
 */
public class FourSum {

    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
    	Arrays.sort(num);
    	HashSet<String> resultCache = new HashSet<String>();
    	int len = num.length;
    	if (len < 4) {
			return resultList;
		}
    	if (num[0] + num[1] + num[2] + num[3] > target) {
			return resultList;
		}
    	if (num[len-1] + num[len-2] + num[len-3] + num[len-4] < target) {
			return resultList;
		}
    	for (int i = 0; i < num.length - 3; i++) {
			for (int j = i + 1; j < num.length - 2; j++) {
				int tempMinSum = num[i] + num[j] + num[j+1] + num[j+2];
				int tempMaxSum = num[i] + num[j] + num[len-2] + num[len - 1];
				if (target >= tempMinSum && target <= tempMaxSum) {
					int left = j + 1;
					int right = len - 1;
					while (left < right) {
						int tempSum = num[i] + num[j] + num[left] + num[right];
						if (tempSum == target) {
							ArrayList<Integer> tempList = new ArrayList<Integer>();
							tempList.add(num[i]);
							tempList.add(num[j]);
							tempList.add(num[left]);
							tempList.add(num[right]);
							if (!resultCache.contains(tempList.toString())) {
								resultList.add(tempList);
								resultCache.add(tempList.toString());
							}
							left++;
							right--;
						} else if (tempSum < target) {
							left++;
						} else {
							right--;
						}
					}
				}
				if (tempMinSum > target) {
					break;
				}
			}
		}
    	return resultList;
        
    }
	public static void main(String[] args) {
		FourSum test = new FourSum();
		int[] inputs = {0, 0, 0, 0};
		System.out.println(test.fourSum(inputs, 0));
	}

}
