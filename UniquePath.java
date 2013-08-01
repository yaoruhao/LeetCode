/**
 * 
 * @author yaoruhao
 *
 */
public class UniquePath {

    public int uniquePaths(int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int [][]cache = new int[m][n];
        for (int i = 0; i < cache.length; i++) {
			cache[i] = new int[n];
			for (int j = 0; j < cache[i].length; j++) {
				cache[i][j] = -1;
			}
		}
        cache[m-1][n-1] = 1;
        
        return search(0, 0, m - 1, n - 1, cache);
    }
    
    public int search(int i, int j, int m, int n, int[][] cache) {
    	if (cache[i][j] != -1) {
			return cache[i][j];
		}
    	int result = 0;
    	if (i < m) {
			result += search(i + 1, j, m, n, cache);
		}
    	if (j < n) {
			result += search(i, j + 1, m, n, cache);
		}
    	cache[i][j] = result;
    	return cache[i][j];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
