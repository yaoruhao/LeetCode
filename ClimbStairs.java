/**
 * 
 * @author yaoruhao
 *
 */
public class ClimbStairs {


    public int climbStairs(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int []cache = new int[n + 1];
        for (int i = 0; i < cache.length; i++) {
			cache[i] = -1;
		}
        cache[n] = 1;
        return searchWays(0, n, cache);
    }
    
    public int searchWays(int current, int n, int []cache) {
    	if (cache[current] != -1) {
			return cache[current];
		}
    	cache[current] = 0;
    	if (current + 1 <= n) {
			cache[current] += searchWays(current + 1, n, cache); 
		}
    	if (current + 2 <= n) {
			cache[current] += searchWays(current + 2, n, cache);
		}
    	return cache[current];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
