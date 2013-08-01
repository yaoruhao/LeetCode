import java.util.HashMap;

/**
 * 
 * @author yaoruhao
 * Referred to solution:http://discuss.leetcode.com/questions/1070/longest-consecutive-sequence/1457
 *
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<Integer, Boolean> cacheMap = new HashMap<Integer, Boolean>();
        for (int i : num) {
			cacheMap.put(i, true);
		}
        int maxLen = 0;
        for (int i : num) {
			if (cacheMap.get(i)) {
				cacheMap.put(i, false);
				int len = 1 + findConsecutive(cacheMap, i + 1, 1);
				len += findConsecutive(cacheMap, i - 1, -1);
				maxLen = Math.max(len, maxLen);
			}
		}
        return maxLen;
    }
    
    public int findConsecutive(HashMap<Integer, Boolean> cacheMap, int num, int step) {
    	int len = 0;
    	while (cacheMap.containsKey(num)) {
			len++;
			cacheMap.put(num, false);
			num += step;
		}
    	return len;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
