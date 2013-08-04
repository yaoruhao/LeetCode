/**
 * 
 * @author yaoruhao
 *
 */
public class DistinctSubsequences {
	
    public int numDistinct(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if (T.isEmpty() || S.isEmpty()) {
			return 0;
		}
    	int [][]cache = new int[S.length()][T.length()];
    	for (int i = 0; i < cache.length; i++) {
			cache[i] = new int [T.length()];
			for (int j = 0; j < cache[i].length; j++) {
				cache[i][j] = -1;
			}
		}
        return searchAllDistinct(S, T, 0, 0, cache);
    }
    
    public int searchAllDistinct(String s, String t, int sIndex, int tIndex, int[][] cache) {
    	if (tIndex >= t.length()) {
			return 1;
		}
    	if (sIndex >= s.length()) {
			return 0;
		}
    	if (cache[sIndex][tIndex] != -1) {
			return cache[sIndex][tIndex];
		}
    	int result = 0;
    	for (int i = sIndex; i < s.length(); i++) {
			if (s.charAt(i) == t.charAt(tIndex)) {
				result += searchAllDistinct(s, t, i + 1, tIndex + 1, cache);
				result += searchAllDistinct(s, t, i + 1, tIndex, cache);
				break;
			}
		}
    	cache[sIndex][tIndex] = result;
    	return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
