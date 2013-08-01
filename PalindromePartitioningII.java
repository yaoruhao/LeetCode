import java.util.HashMap;

/**
 * 
 * @author yaoruhao
 * Can pass small test. But the main idea of this solution is okay.
 *
 */
public class PalindromePartitioningII {

    public int minCut(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s.isEmpty() || s.equals(new StringBuilder(s).reverse().toString())) {
			return 0;
		}
        HashMap<String, Integer> cacheMap = new HashMap<String, Integer>();
        minStep = Integer.MAX_VALUE;
        searchMinCut(s, cacheMap, 0);
        return minStep;
    }
    
    public int minStep;

    
    public int searchMinCut(String s, HashMap<String, Integer> cacheMap, int step) {
    	if (s.isEmpty() || s.equals(new StringBuilder(s).reverse().toString())) {
    		minStep = Math.min(step, minStep);
			return 0;
		}
    	if (step > minStep) {
			return s.length() - 1;
		}
    	if (cacheMap.containsKey(s)) {
			return cacheMap.get(s);
		}
    	int min = Integer.MAX_VALUE;
    	for (int i = s.length(); i >= 1; i--) {
			String subStr = s.substring(0, i);
			if (subStr.equals(new StringBuilder(subStr).reverse().toString())) {
				min = Math.min(searchMinCut(s.substring(i), cacheMap, step + 1) + 1, min);
			}
		}
    	if (min == Integer.MAX_VALUE) {
			min = s.length() - 1;
		}
    	cacheMap.put(s, min);
    	return min;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromePartitioningII test = new PalindromePartitioningII();
		System.out.println(test.minCut("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
	}

}
