/**
 * 
 * @author yaoruhao
 *
 */
public class UniquePathII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	int m = obstacleGrid.length;
    	int n = obstacleGrid[0].length;
        int [][]cache = new int[m][n];
        for (int i = 0; i < cache.length; i++) {
			cache[i] = new int[n];
			for (int j = 0; j < cache[i].length; j++) {
				cache[i][j] = -1;
			}
		}
        cache[m-1][n-1] = 1;
        
        return search(0, 0, m - 1, n - 1, cache, obstacleGrid);
    }
    
    public int search(int i, int j, int m, int n, int[][] cache, int [][] obstacle) {
    	if (obstacle[i][j] == 1) {
			return 0;
		}
    	if (cache[i][j] != -1) {
			return cache[i][j];
		}
    	int result = 0;
    	if (i < m && obstacle[i + 1][j] != 1) {
			result += search(i + 1, j, m, n, cache, obstacle);
		}
    	if (j < n && obstacle[i][j + 1] != 1) {
			result += search(i, j + 1, m, n, cache, obstacle);
		}
    	cache[i][j] = result;
    	return cache[i][j];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
